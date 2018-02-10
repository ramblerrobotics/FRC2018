package org.usfirst.frc.team6066.robot;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SampleRobot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends SampleRobot {
	AHRS ahrs;
	Joystick stick;
	Timer t;
	DriveTrain drive;
	SolenoidController solenoid;
	Arm arm;
	Compressor c;
	
	
	public Robot() {
		try {
			ahrs = new AHRS(SPI.Port.kMXP);
			stick = new Joystick(0);
			drive = new DriveTrain();
			solenoid = new SolenoidController();
			c = new Compressor();
			arm = new Arm();
		} catch(RuntimeException e) {
			DriverStation.reportError("fix this: " + e.getMessage(), true);
			
		}
		
	}
	
	public void operatorControl() {
		c.setClosedLoopControl(true);
		while(isOperatorControl() && isEnabled()) {
			t.delay(0.020);
			drive.setMotorSpeeds(stick.getRawAxis(1), stick.getRawAxis(5), stick.getRawButton(3), stick.getRawButton(2), stick.getRawAxis(3) / 1.5);
			
			if (stick.getRawButton(4)) solenoid.forward();
			if (stick.getRawButton(1)) solenoid.reverse();
			if (stick.getRawButton(2)) arm.forward(0.2);
			if (stick.getRawButton(3)) arm.reverse(0.2);
			
			
			if (!stick.getRawButton(4) && !stick.getRawButton(1)) solenoid.off();
			SmartDashboard.putString("Solenoid Value", solenoid.getValue());
			SmartDashboard.putBoolean("revBlacklist", solenoid.getRevBlacklist());
			SmartDashboard.putBoolean("fwdBlacklist", solenoid.getFwdBlacklist());
		}
							
	}

}

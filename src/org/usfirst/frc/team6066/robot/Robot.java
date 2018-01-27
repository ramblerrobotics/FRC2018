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
	Compressor c;
	DoubleSolenoid n;
	Timer t;
	DriveTrain drive;
	
	
	public Robot() {
		try {
			ahrs = new AHRS(SPI.Port.kMXP);
			stick = new Joystick(0);
			c = new Compressor(0);
			n = new DoubleSolenoid(0, 3);
			drive = new DriveTrain();
		} catch(RuntimeException e) {
			DriverStation.reportError("fix this: " + e.getMessage(), true);
			
		}
		
	}
	
	public void operatorControl() {
		c.setClosedLoopControl(true);
		while(isOperatorControl() && isEnabled()) {
			t.delay(0.020);
			if (stick.getRawButton(5)) n.set(DoubleSolenoid.Value.kForward);
			if (stick.getRawButton(6)) n.set(DoubleSolenoid.Value.kReverse);
			drive.setMotorSpeeds(stick.getRawAxis(1), stick.getRawAxis(3), 0);
		}
							
	}

}

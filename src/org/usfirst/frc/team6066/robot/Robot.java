package org.usfirst.frc.team6066.robot;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SampleRobot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends SampleRobot {
	AHRS ahrs;
	RobotDrive drive;
	Joystick stick;
	Compressor c;
	DoubleSolenoid n;
	Timer t;
	
	public Robot() {
		try {
			ahrs = new AHRS(SPI.Port.kMXP);
			drive = new RobotDrive(0, 1, 2, 3);
			stick = new Joystick(0);
			c = new Compressor(0);
			n = new DoubleSolenoid(0, 3);
		} catch(RuntimeException e) {
			DriverStation.reportError("fix this: " + e.getMessage(), true);
			
		}
		
	}
	
	public void operatorControl() {
		c.setClosedLoopControl(true);
		while(isOperatorControl() && isEnabled()) {
			t.delay(0.020);
			drive.tankDrive(stick.getRawAxis(1) / 1.5, stick.getRawAxis(3) / 1.5);
			if(stick.getRawButton(3)) n.set(DoubleSolenoid.Value.kForward);
			if(stick.getRawButton(4)) n.set(DoubleSolenoid.Value.kReverse);
			
			SmartDashboard.putBoolean("Compressor Status", c.enabled());
			SmartDashboard.putBoolean("Pressure Switch", c.getPressureSwitchValue());
			SmartDashboard.putDouble("Compressor Current", c.getCompressorCurrent());
		}
	}

}

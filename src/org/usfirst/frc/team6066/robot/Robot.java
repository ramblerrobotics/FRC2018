package org.usfirst.frc.team6066.robot;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SampleRobot;

import java.io.IOException;

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
	Climber climber;
	Compressor c;
	Arm arm;
	AutoController write;
	CommonAuto read;
	boolean grab;
	
	public Robot() {
		try {
			ahrs = new AHRS(SPI.Port.kMXP);
			stick = new Joystick(0);
			drive = new DriveTrain();
			solenoid = new SolenoidController();
			c = new Compressor();
			climber = new Climber();
			arm = new Arm();
		} catch(RuntimeException e) {
			DriverStation.reportError("fix this: " + e.getMessage(), true);
			
		}
		
	}
	
	public void teleopInit() {
		read = new CommonAuto();
	}
	
	public void teleopPeriodic() {
		String file = read.getFile();
		String inst = read.getCharArray(file);
		for(int i = 0; i < inst.length() - 1; i++) {
			if (inst.charAt(i) == 0) drive.mecanumDrive(1, 1, false, false, 0.2);
		}
	}
	
	public void operatorControl() {
		c.setClosedLoopControl(true);
		while(isOperatorControl() && isEnabled()) {
			t.delay(0.020);
			drive.mecanumDrive(stick.getRawAxis(1), stick.getRawAxis(5), stick.getRawButton(3), stick.getRawButton(2), stick.getRawAxis(3) / 1.5);
			
			while(stick.getRawAxis(2) > 0) {
				if (stick.getRawButton(4)) arm.forward(stick.getRawAxis(2));
				if (stick.getRawButton(1)) arm.reverse(stick.getRawAxis(2));
				if (!stick.getRawButton(4) && !stick.getRawButton(1)) arm.stop();
				if (stick.getRawAxis(2) == 0) {
					arm.stop();
					climber.stop();
					break;
				}
				if (stick.getPOV() == 0) climber.forward(stick.getRawAxis(2));
				if (stick.getPOV() == 180) climber.reverse(stick.getRawAxis(2));
				if (stick.getPOV() == -1) climber.stop();
			}

			if (stick.getRawButton(5)) grab = true;
			if (grab) {
				t.delay(0.020);
				solenoid.forward();
				if (stick.getRawButton(5)) grab = false;
			}
			
			if (!grab) solenoid.off();

			SmartDashboard.putString("Solenoid Value", solenoid.getValue());
		}
							
	}
	
	public void test() {
		write = new AutoController();
		String file = write.getFile();
		while(isTest() && isEnabled()) {
			t.delay(0.020);
			write.writeFile(file, stick.getPOV());
		}

	}

}

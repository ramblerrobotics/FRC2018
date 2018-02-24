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
	CommonAuto auto;
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
			write = new AutoController();
			try {
				auto = new CommonAuto();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch(RuntimeException e) {
			DriverStation.reportError("fix this: " + e.getMessage(), true);
			
		}
		
	}
	
	public void teleopPeriodic() {
		String a = auto.getCharArray();
		for(int i = 0; i < auto.getCharArray().length() - 1; i++) {
			t.delay(0.020);
			if(a.charAt(i) == '0') drive.mecanumDrive(1, 1, false, false, 0.2);
			if(a.charAt(i) == '1') drive.mecanumDrive(-1, -1, false, false, 0.2);
			if(a.charAt(i) == '2') drive.mecanumDrive(0, 0, true, false, 0.2);
			if(a.charAt(i) == '3') drive.mecanumDrive(0, 0, false, true, 0.2);
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
			SmartDashboard.putBoolean("revBlacklist", solenoid.getRevBlacklist());
			SmartDashboard.putBoolean("fwdBlacklist", solenoid.getFwdBlacklist());
		}
							
	}
	
	public void test() {
		try {
			System.out.println(auto.getCharArray());
		} catch (IOException e1) {
			System.out.println("Failed to get string");
		} 
		while(isTest() && isEnabled()) {
			t.delay(0.020);
			try {
				write.writeDrive(stick.getPOV());
				System.out.println(stick.getPOV());
				write.writeGrab(stick.getRawButton(1));
				write.writeRaiseArm(stick.getRawButton(2));
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(stick.getPOV() == 0) drive.tankDrive(1, 1, 0.3);
			if(stick.getPOV() == 180) drive.tankDrive(-1, -1, 0.3);
			if(stick.getPOV() == -1) drive.tankDrive(1, 1, 0);
 			if(stick.getPOV() == 90) drive.mecanumDrive(0, 0, false, true, 0.6);
			if(stick.getPOV() == 180 + 90) drive.mecanumDrive(0, 0, true, false, 0.6);
			if(stick.getPOV() == -1) drive.mecanumDrive(1, 1, false, false, 0);
		}
	}

}

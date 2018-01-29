package org.usfirst.frc.team6066.robot;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;

public class CommonAuto {

	DriveTrain drive = new DriveTrain();
	Timer t = new Timer();
	
	public void driveForward(double speed, int time) { //Drives forward for time at speed
		t.reset();
		t.start();
		if(t.get() < time) {
			drive.setMotorSpeeds(speed, speed, 0);
		}
	}
	public void driveBackward(double speed, int time) {
		t.reset();
		t.start();
		if(t.get() < time) {
			drive.setMotorSpeeds(-speed, -speed, 0);
		}
	}
	public void driveLeft( double speed, int time) {
		t.reset();
		t.start();
		if(t.get() < time) {
			drive.mecanumLeft(0.5);
			
		}
	}
	public void driveRight( double speed, int time) {
		t.reset();
		t.start();
		if(t.get() < time) {
			drive.mecanumRight(0.5);
		}
	}
}

package org.usfirst.frc.team6066.robot;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;

public class CommonAuto {

	DriveTrain drive;
	Timer timer;
	
	public CommonAuto() {
		drive = new DriveTrain();
		timer = new Timer();
	}
	
	public void driveForwardUntil(double speed, double time) {
		timer.reset();
		timer.start();
		while(timer.get() <= time) {
		drive.tankDrive(1, 1, speed);
		}
	}
	
	
	
}

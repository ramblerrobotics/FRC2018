package org.usfirst.frc.team6066.robot;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;

public class CommonAuto {
	static Timer t = new Timer();
	static RobotDrive drive = new RobotDrive(0, 1, 2, 3);
	 
	public static void crossLine() { 
		t.reset();
		t.start();
		if (!t.hasPeriodPassed(5)) {
			drive.tankDrive(.2,.2);
		} else {
			t.stop();
		}
	}
	
	public static void trackScale() { //Code using vision to track scale LEDs and drive the robot there
		
	}
	
	public static void positionScale() { //Code to manually position the robot after vision
		
	}
}

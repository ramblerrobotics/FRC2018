package org.usfirst.frc.team6066.robot;

import edu.wpi.first.wpilibj.Timer;

public class CommonAuto {
	 
	public static void crossLine() { 
		Timer t = new Timer();
		t.reset();
		t.start();
		if (!t.hasPeriodPassed(5)) {
			
		} else {
			t.stop();
		}
	}
	
	public static void trackScale() { //Code using vision to track scale LEDs and drive the robot there
		
	}
	
	public static void positionScale() { //Code to manually position the robot after vision
		
	}
}

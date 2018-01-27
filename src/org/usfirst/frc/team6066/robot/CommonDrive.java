package org.usfirst.frc.team6066.robot;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;

public class CommonDrive {
	Talon r2 = new Talon(2);
	Talon r4 = new Talon(4);
	
	Talon l1 = new Talon(1);
	Talon l3 = new Talon(3);
	
	public void driveRight() {
		r2.set(-0.5);
		r4.set(0.5);
	}
	
	public void driveLeft() {
		l1.set(-0.5);
		l3.set(0.5);
	}

}

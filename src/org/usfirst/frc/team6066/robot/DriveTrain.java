package org.usfirst.frc.team6066.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {

	Talon[] left = new Talon[2];
	Talon[] right = new Talon[2];
	Joystick stick;
	
	public DriveTrain() {
		left[0] = new Talon(0);
		left[1] = new Talon(3);
		
		right[0] = new Talon(1);
		right[1] = new Talon(2);
		
		Joystick stick = new Joystick(0);
	}

	
	
	

}

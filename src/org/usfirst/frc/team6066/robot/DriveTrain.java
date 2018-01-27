package org.usfirst.frc.team6066.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {

	Talon[] left = new Talon[2];
	Talon[] right = new Talon[2];
	Joystick stick;
	
	public DriveTrain() {
		left[0] = new Talon(0); //front left
		left[1] = new Talon(3); //back left
		
		right[0] = new Talon(1); //front right
		right[1] = new Talon(2); //back right
		
		Joystick stick = new Joystick(0);
	}

	public void setMotorSpeeds(double xIn, double yIn, double rotation) {
		left[0].set(xIn + yIn + rotation);
		right[0].set(-(-xIn + yIn - rotation));
		left[1].set((-xIn + yIn + rotation));
		right[1].set(-(xIn + yIn - rotation));
	}
	
	public void mecanumRight(double speed) {
		right[0].set(-speed);
		right[1].set(speed);
	}
	
	public void mecanumLeft(double speed) {
		left[0].set(-speed);
		left[1].set(speed);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

	


	
	

}

package org.usfirst.frc.team6066.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {

	Talon[] left = new Talon[2];
	Talon[] right = new Talon[2];
	Joystick stick;
	public double speed;
	
	public DriveTrain() {
		left[0] = new Talon(0); //front left
		left[1] = new Talon(2); //back left
		
		right[0] = new Talon(1); //front right
		right[1] = new Talon(3); //back right
		
		Joystick stick = new Joystick(0);	
	}

	public void setMotorSpeeds(double xIn, double yIn, Boolean mL, Boolean mR, double speed) {
		if(xIn > 0 && yIn > 0) {
			left[0].set(-speed);
			left[1].set(-speed);
			right[0].set(speed);
			right[1].set(speed);
		}
		if(xIn < 0 && yIn < 0) {
			left[0].set(speed);
			left[1].set(speed);
			right[0].set(-speed);
			right[1].set(-speed);
		}
		
		if(xIn > 0 && yIn < 0) {
			left[0].set(speed);
			left[1].set(speed);
			right[0].set(speed);
			right[1].set(speed);
		}
		
		if (xIn < 0 && yIn > 0) {
			left[0].set(-speed);
			left[1].set(-speed);
			right[0].set(-speed);
			right[1].set(-speed);
		}
		
		if (mR) {
			left[0].set(speed);
			left[1].set(-speed);
			right[0].set(speed);
			right[1].set(-speed);
		}
		
		if (mL) {
			left[0].set(-speed);
			left[1].set(speed);
			right[0].set(-speed);
			right[1].set(speed);
		}
	}
	
	public double getMotorSpeeds() {
		return speed;
	}


	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

	


	
	

}

package org.usfirst.frc.team6066.robot;

import edu.wpi.first.wpilibj.Talon;

public class Arm {
	Talon arm1;
	
	Arm() {
		arm1 = new Talon(4);
	}
	
	public void forward(double speed) {
		arm1.set(speed);
	}
	
	public void reverse(double speed) {
		arm1.set(-speed);
	}
	

}

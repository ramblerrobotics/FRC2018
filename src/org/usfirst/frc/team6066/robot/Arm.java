package org.usfirst.frc.team6066.robot;

import edu.wpi.first.wpilibj.Talon;

public class Arm {
	
	Talon arm1;
	
	public Arm() {
		arm1 = new Talon(5);
	}
	
	public void forward(double speed) {
		arm1.set(speed);
	}
	
	public void reverse(double speed) {
		arm1.set(-speed);
	}

	public void stop() {
		arm1.set(0);
	}
}

package org.usfirst.frc.team6066.robot;

import edu.wpi.first.wpilibj.Talon;

public class Climber {
	Talon climber1;
	
	Climber() {
		climber1 = new Talon(4);
	}
	
	public void forward(double speed) {
		climber1.set(speed);
	}
	
	public void reverse(double speed) {
		climber1.set(-speed);
	}
	
	public void stop() {
		climber1.set(0);
	}
	

}

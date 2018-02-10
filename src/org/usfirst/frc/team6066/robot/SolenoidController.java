package org.usfirst.frc.team6066.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.NamedSendable;

public class SolenoidController {
	Compressor compressor;
	DoubleSolenoid n;

	public SolenoidController() {
		compressor = new Compressor(0);
		n = new DoubleSolenoid(0, 1);
	}
	
	public void forward() {
		n.set(DoubleSolenoid.Value.kForward);
	}
	
	public void reverse() {
		n.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void off() {
		n.set(DoubleSolenoid.Value.kOff);
	}
	
	public String getValue() {
		String val = n.get().toString();
		return val;
	}
	
	public boolean getRevBlacklist() {
		return n.isRevSolenoidBlackListed();
	}
	
	public boolean getFwdBlacklist() {
		return n.isFwdSolenoidBlackListed();
	}
}

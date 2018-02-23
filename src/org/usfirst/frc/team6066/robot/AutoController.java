package org.usfirst.frc.team6066.robot;
import java.io.*;
import edu.wpi.first.wpilibj.smartdashboard.*;

import edu.wpi.first.wpilibj.Joystick;

public class AutoController {

	CommonAuto drive;
	char flag;
	File auto;
	PrintWriter f;
	byte[] commands;
	
	public AutoController() {
		try {
			auto = new File("/home/lvuser/auto.txt");
			System.out.println("asasas");
			f = new PrintWriter(auto, "utf-8");
			System.out.println(auto.getAbsolutePath());
			flag = '\0';
		} catch(IOException e) {
			SmartDashboard.putString("test", e.toString());
			System.out.println(e.toString());
			System.out.println(auto.getAbsolutePath());
		}
	}
	
	public void writeDrive(double dir) throws IOException{
		if(dir == 0) f.write("0");
		if(dir == 90) f.write("3");
		if(dir == 180) f.write("1");
		if (dir == 180 + 90) f.write("2");
		f.flush();
	}
	
	public void writeRaiseArm(boolean b) throws IOException {
		if (b) f.write(4);
		f.flush();
	}
	
	public void writeGrab(boolean b) throws IOException {
		if (b) f.write(5);
		f.flush();
	}
	
	
}

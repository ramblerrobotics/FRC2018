package org.usfirst.frc.team6066.robot;
import java.io.*;
import edu.wpi.first.wpilibj.smartdashboard.*;

import edu.wpi.first.wpilibj.Joystick;

public class AutoController {

	File auto;
	PrintWriter writer;
	
	public AutoController() {
		SmartDashboard.putString("auto write", "");
	}
	
	public String getFile() {
		auto = new File("/home/lvuser/auto/" + SmartDashboard.getString("auto write") + ".txt");
		try {
		auto.createNewFile();
		if(auto.exists()) {
			System.out.println(auto.getAbsolutePath() + "Created");
		}
		} catch(IOException e) {
			System.out.println("Failed to create file: " + e.getMessage());
		}
		return auto.getAbsolutePath();
	}
	
	public void writeFile(String file, int dir) throws FileNotFoundException, UnsupportedEncodingException {
		writer = new PrintWriter(file, "utf-8");
		if (dir == 0) writer.write("0");
		if (dir == 180) writer.write("1");
		if (dir == 2) writer.write("2");
		if (dir == 3) writer.write("3");
	}
	
}

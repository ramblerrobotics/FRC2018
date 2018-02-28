package org.usfirst.frc.team6066.robot;

import java.io.*;
import java.util.ArrayList;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class CommonAuto {

	Reader r;
	AutoController auto;
	ArrayList data;
	
	public CommonAuto() throws IOException {
		data = new ArrayList();
	}
	
	public String getFile() {
		try {
			r = new FileReader("/home/lvuser/auto/" + SmartDashboard.getString("auto reader") + ".txt");
			data = new ArrayList();
		} catch(IOException e) {
			System.out.println("Failed to open file: " + e.getMessage());
		}
		return r.toString();
	}
	
	 public String getCharArray(String file) throws IOException {
		 do {
			 data.add(r.read());
		 } while(r.read() != -1);
		 String a = data.toString();
		 return a;
	} 

	
	
	
	
}

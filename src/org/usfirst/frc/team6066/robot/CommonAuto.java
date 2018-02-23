package org.usfirst.frc.team6066.robot;

import java.io.*;
import java.util.ArrayList;

public class CommonAuto {

	Reader r;
	AutoController auto;
	ArrayList data;
	
	public CommonAuto() throws IOException {
		try {
			r = new FileReader("/home/lvuser/auto.txt");
			data = new ArrayList();
		} catch(IOException e) {
			System.out.println("Failed to open file");
		}
	}
	
	 public String getCharArray() throws IOException {
		 char t = (char) r.read();
		 for (int i = 0; r.read() == -1; i++) {
			 data.add(r.read())
		 }
		 String a = new String(data);
		return a;
		
	} 
	
	public int readDrive() throws IOException {
		int ins = 9;
		r.close();
		return ins;
	}
	
	
	
	
}

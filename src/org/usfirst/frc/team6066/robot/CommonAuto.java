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
		 do {
			 data.add(r.read());
		 } while(r.read() != -1);
		 String a = data.toString();
		 return a;
	} 

	
	
	
	
}

package org.usfirst.frc.team6066.robot;

import java.io.*;

public class CommonAuto {

	Reader r;
	AutoController auto;
	char[] data;
	
	public CommonAuto() throws IOException {
		try {
			r = new FileReader("/home/lvuser/auto.txt");
			auto = new AutoController();
		} catch(IOException e) {
			System.out.println("Failed to open file");
		}
		for (int i = 0; i == -1; i++) {
			data[i] = (char) r.read();
		}
	}
	
	public int readDrive() throws IOException {
		int ins = 9;
		for(int i = 0; i < data.length; i++) {
			if(data[i] == '0') ins = 0;
			if(data[i] == '1') ins = 1;
			if(data[i] == '2') ins = 2;
			if(data[i] == '3') ins = 3;
		}
		r.close();
		return ins;
	}
	
	
	
	
}

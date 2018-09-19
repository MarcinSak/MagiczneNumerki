package com.sakMarcin.logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ExtensionChecker
{
	int value = 0;
	String realExtension="", declaredExtension="";
	public String getRealExtension(File file) throws IOException{
		MapExtension map = new MapExtension();
		InputStream is = new FileInputStream(file);
		
		StringBuilder hexExtension = new StringBuilder();

		for(int i=0; i<1000; i++){
//		while(value != -1){
			value = is.read();
			if(value == -1)
				break;
			hexExtension.append(String.format("%02X ", value));
		}
		is.close();
		
		realExtension = map.getExtension(String.valueOf(hexExtension));
		declaredExtension = file.getName().substring(file.getName().lastIndexOf(".")+1);
		
		if(declaredExtension.equals(realExtension))
			return "Correct, it's " + realExtension;
		else
			return "Extension is " + declaredExtension + ", while actually it’s a " + realExtension + ".";
	}	
		
}

package com.sakMarcin.logic;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MapExtension
{
	private Map<String,String> map = new HashMap<String,String>();
	private String key;
	
	public MapExtension() {
		this.map.put("47 49 46 38 37 61", "gif");
		this.map.put("47 49 46 38 39 61", "gif");

		this.map.put("FF D8 FF E0 00 10 4A 46 49 46 00 01", "jpg");
		this.map.put("FF D8 FF DB", "jpg");
		this.map.put("FF D8 FF E1 ?? ?? 45 78 69 66 00 00", "jpg");
		
		this.map.put("CA FE BA BE", "class");
		
		
		this.map.put("25 50 44 46", "pdf");

		this.map.put("FF FB", "mp3");
		this.map.put("49 44 33", "mp3");
		this.map.put("3c 3f 78 6d 6c 20", "xml");
		this.map.put("00 00 01 BA", "mpg/mpeg");
		this.map.put("00 00 01 B3", "mpg/mpeg");
		this.map.put("D0 CF 11 E0 A1 B1 1A E1", "xls");
		this.map.put("89 50 4E 47 0D 0A 1A 0A", "png");
		this.map.put("52 61 72 21 1A 07 01 00", "rar");
		this.map.put("52 61 72 21 1A 07 00", "rar");
		this.map.put("4D 5A", "exe");
		this.map.put("53 50 30 31", "bin");
		this.map.put("50 4B 03 04 14 00 06 00 08 00 00 00 21 00", "docx");
	}
//	50 4B 03 04 14 00 06 00 08 00 00 00 21 00  
	public String getExtension(String ext){
		// txt files do not contains anything greater than 7F(hex)
		Pattern pattern = Pattern.compile("\\s[A-Z]|\\s[8-9]");
		Matcher match = pattern.matcher(ext);
		
//		System.out.println("ext.length(): " + ext.length());
		
		for(Map.Entry<String,String> mapElement : map.entrySet()){
			key = mapElement.getKey();
			// file should be 
			if(ext.length()>key.length() && match.find() && ext.substring(0, key.length()).equals(key))
				return mapElement.getValue();
		}
		
		if(match.find())
			return "not found";

		return "text file";
	}

}




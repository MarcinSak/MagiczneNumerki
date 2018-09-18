package com.sakMarcin.logic;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;

public class PickFile
{
	JFileChooser fileChooser = new JFileChooser();
	File file;
	
	public File pickFile() throws FileNotFoundException{
		if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
			file = fileChooser.getSelectedFile();
		}
		return file;
	}
	
	
}

package com.joust.site.util;

import java.io.*;


public class TextFileWriter {

	final String FILE_NAME = System.getProperty("user.dir") + "/output/results.txt";
	private FileWriter writer;
	private BufferedWriter bufferedWriter;
	private boolean isOpen = false;

	public boolean Delete() {
		File file = new File(FILE_NAME); 
        return file.delete(); 
	}
	
	public boolean Open() {
		try {
			writer = new FileWriter(FILE_NAME, true);
			bufferedWriter = new BufferedWriter(writer);
			isOpen = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.isOpen;
	}

	public boolean Write(String sLine) {
		try {
			bufferedWriter.write(sLine);
			bufferedWriter.newLine();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void Close() {
		if (isOpen) {
			try {
				isOpen = false;
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
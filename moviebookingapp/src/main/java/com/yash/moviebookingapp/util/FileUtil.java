package com.yash.moviebookingapp.util;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.yash.moviebookingapp.exception.FileDoesNotExistException;
import com.yash.moviebookingapp.exception.FileNameNotGivenException;
import com.yash.moviebookingapp.exception.JsonTextNotGivenException;

public class FileUtil {

	public boolean writeInFile(String fileName, String jsonText) {
		if(jsonText == null || jsonText.isEmpty())
			throw new JsonTextNotGivenException("Give Json text to write in the file");
		if(fileName == null || fileName.isEmpty())
			throw new FileNameNotGivenException("Give a file name");
		try {
			BufferedWriter fileWriter = new BufferedWriter(new FileWriter("src/main/resources/"+fileName+".json",true));
			fileWriter.append(jsonText);
			fileWriter.newLine();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> readFile(String fileName, Type type) {
		List<T> objects = new ArrayList<T>();
		File fileToRead = getFile(fileName);
		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(fileToRead));
			
			String currentline;
			
			while ((currentline = fileReader.readLine()) != null) {
				objects.add((T) JSONUtil.convertJSONToObject(currentline, type));
			}
			
			fileReader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	
	private File getFile(String fileName){
		ClassLoader classLoader = getClass().getClassLoader();
		try {
			File file = new File(classLoader.getResource(fileName).getFile());
			return file;
		} catch (Exception exception) {
			throw new FileDoesNotExistException("File does not exist");
		}
	  }

	

	
	
		

}

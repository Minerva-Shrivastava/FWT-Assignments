package com.yash.moviebookingapp.util;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.reflect.TypeToken;
import com.yash.moviebookingapp.exception.FileDoesNotExistException;
import com.yash.moviebookingapp.exception.FileNameNotGivenException;
import com.yash.moviebookingapp.exception.JsonTextNotGivenException;
import com.yash.moviebookingapp.model.Screen;

public class FileUtilTest {

	private FileUtil fileUtil;
	
	@Before
	public void setUpBeforeClass() throws Exception {
		fileUtil = new FileUtil();
	}

	@Test(expected = JsonTextNotGivenException.class)
	public void writeInFile_JsonTextNotGiven_ThrowsJsonTextNotGivenException() throws Exception {
		String JsonText = null;
		fileUtil.writeInFile("fileName", JsonText);
	}
	
	
	@Test(expected = FileNameNotGivenException.class)
	public void writeInFile_FileNameNotGiven_ThrowsFileNameNotGivenException() throws Exception {
		String fileName = null;
		fileUtil.writeInFile(fileName, "JsonText");
	}
	
	@Test
	public void writeInFile_GivenFileNameAndJsonText_ShouldReturnTrueWhenJsonContentIsSaved() {
		Screen screen = new Screen(103, "Audi-1");
		String jsonText = JSONUtil.convertObjectToJSON(screen);
		boolean writeStatus = fileUtil.writeInFile("screens", jsonText);
		
		assertTrue(writeStatus);
	}
	
	@Test(expected = FileDoesNotExistException.class)
	public void readFile_ThrowsFileDoesNotExistException_WhenFileIsAbsent() throws Exception {
		fileUtil.readFile("examples.json", new TypeToken<Screen>() {}.getType());
	}
	
	@Test
	public void readFile_GivenFileNameAndTypeOfObject_ShouldReturnFileContentsInList() {
		List<Object> objects = fileUtil.readFile("screens.json", new TypeToken<Screen>() {}.getType());
		assertEquals(3, objects.size());
	}
	
	

}

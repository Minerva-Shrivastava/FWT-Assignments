package com.yash.moviebookingapp.daoimpl;

import java.lang.reflect.Type;
import java.util.List;
import java.util.logging.Logger;

import com.google.gson.reflect.TypeToken;
import com.yash.moviebookingapp.dao.ScreenDAO;
import com.yash.moviebookingapp.exception.DuplicateScreenNameException;
import com.yash.moviebookingapp.exception.ScreenNotFoundException;
import com.yash.moviebookingapp.model.Screen;
import com.yash.moviebookingapp.util.FileUtil;
import com.yash.moviebookingapp.util.JSONUtil;

public class ScreenDAOImpl implements ScreenDAO {

	private FileUtil fileUtil;
	private String fileName = "screens";
	private Type  typeForJson = new TypeToken<Screen>() {}.getType();
	private Logger logger = Logger.getLogger("ScreenDAOImpl.class");
	
	public ScreenDAOImpl() {
		this.fileUtil = new FileUtil();
	}
	
	public int insert(Screen screen) {
		logger.info("Adding screen :"+screen);
		String screenJsonInString = JSONUtil.convertObjectToJSON(screen);
		if(fileUtil.writeInFile(fileName, screenJsonInString))
			return 1;
		else
			return 0;
	}

	public Screen getScreenByName(String screenName) {
		logger.info("Getting screen "+screenName);
		if(screenName == null || screenName.isEmpty())
			throw new DuplicateScreenNameException("This screen is already present, add another screen");
		List<Screen> fileContents = fileUtil.readFile(fileName, typeForJson);
		for (Screen screen : fileContents) {
			if(screen.getName().equalsIgnoreCase(screenName))
				return screen;
		}
		throw new ScreenNotFoundException("This screen does not exist");
	}

	public List<Screen> getAllScreens() {
		logger.info("Getting the list of screens");
		return fileUtil.readFile("screens.json", new TypeToken<Screen>() {}.getType());
	}

}

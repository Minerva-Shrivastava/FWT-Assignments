package com.yash.moviebookingapp.daoimpl;

import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.yash.moviebookingapp.dao.ScreenDAO;
import com.yash.moviebookingapp.model.Screen;
import com.yash.moviebookingapp.util.FileUtil;
import com.yash.moviebookingapp.util.JSONUtil;

public class ScreenDAOImpl implements ScreenDAO {

	private FileUtil fileUtil;
	
	public ScreenDAOImpl() {
		this.fileUtil = new FileUtil();
	}
	
	public int insert(Screen screen) {
		String jsonInString = JSONUtil.convertObjectToJSON(screen);
		if(fileUtil.writeInFile("screens.json", jsonInString))
			return 1;
		else
			return 0;
	}

	public Screen getScreenByName(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Screen> getAllScreens() {
		// TODO Auto-generated method stub
		return null;
	}

}

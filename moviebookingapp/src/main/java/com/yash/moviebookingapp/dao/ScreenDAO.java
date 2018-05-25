package com.yash.moviebookingapp.dao;

import java.util.List;

import com.yash.moviebookingapp.model.Screen;

public interface ScreenDAO {

	int insert(Screen screen);


	Screen getScreenByName(String string);


	List<Screen> getAllScreens();

}

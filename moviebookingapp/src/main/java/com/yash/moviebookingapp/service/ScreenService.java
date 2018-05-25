package com.yash.moviebookingapp.service;

import java.util.List;

import com.yash.moviebookingapp.model.Screen;

public interface ScreenService {

	int addScreen(Screen screen);

	Screen getScreenByName(String screenName);

	List<Screen> getAllScreens();

}

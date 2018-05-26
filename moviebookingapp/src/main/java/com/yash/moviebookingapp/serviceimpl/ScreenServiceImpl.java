package com.yash.moviebookingapp.serviceimpl;

import java.util.List;

import com.yash.moviebookingapp.dao.ScreenDAO;
import com.yash.moviebookingapp.exception.EmptyObjectException;
import com.yash.moviebookingapp.exception.ObjectNotGivenException;
import com.yash.moviebookingapp.exception.ScreensNotMoreThanThreeException;
import com.yash.moviebookingapp.model.Screen;
import com.yash.moviebookingapp.service.ScreenService;

/**
 * This class is the implementation of Screen Service It provides services
 * related to Screen
 * 
 * @author minerva.shrivastava
 *
 */
public class ScreenServiceImpl implements ScreenService {

	/**
	 * dependency over ScreenDAO
	 */
	private ScreenDAO screenDAO;

	/**
	 * Constructor to initialize ScreenDAO dependency
	 * 
	 * @param screenDAO
	 */
	public ScreenServiceImpl(ScreenDAO screenDAO) {
		this.screenDAO = screenDAO;
	}

	/**
	 * This method adds screen to the repository by calling ScreenDAO's insert
	 * method
	 * 
	 * @param screen
	 *            of type Screen as provided
	 * @return 1 when a screen is added
	 */

	public int addScreen(Screen screen) {
		if (screen == null)
			throw new ObjectNotGivenException("Screen should not be null");
		if (screen.getId() < 0 || screen.getName() == null || screen.getName().equals(""))
			throw new EmptyObjectException("Screen should have some data");
		if(screenDAO.getAllScreens().size()>=3)
			throw new ScreensNotMoreThanThreeException("Screen should not be more than three");
		return screenDAO.insert(screen);
	}

	/**
	 * This method fetches the screen object when the screen name is given
	 * 
	 * @param screenName
	 *            is the name of the screen
	 * @return the Screen object
	 */
	public Screen getScreenByName(String screenName) {
		return screenDAO.getScreenByName(screenName);
	}

	public List<Screen> getAllScreens() {
		return screenDAO.getAllScreens();
	}

}

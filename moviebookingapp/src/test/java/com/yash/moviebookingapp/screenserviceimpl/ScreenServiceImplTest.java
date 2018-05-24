package com.yash.moviebookingapp.screenserviceimpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.yash.moviebookingapp.exception.DuplicateScreenNameException;
import com.yash.moviebookingapp.exception.EmptyObjectException;
import com.yash.moviebookingapp.exception.ScreenNotGivenException;
import com.yash.moviebookingapp.exception.ScreenRepositoryEmptyException;
import com.yash.moviebookingapp.exception.ScreensNotMoreThanThreeException;
import com.yash.moviebookingapp.model.Screen;
import com.yash.moviebookingapp.screendao.ScreenDAO;
import com.yash.moviebookingapp.screenservice.ScreenService;

public class ScreenServiceImplTest {

	@Mock
	private ScreenDAO screenDAO;

	private ScreenService screenService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		screenService = new ScreenServiceImpl(screenDAO);
	}

	@Test(expected = ScreenNotGivenException.class)
	public void addScreen_ScreenObjectNotGiven_ThrowScreenNotGivenException() {
		Screen screen = null;
		screenService.addScreen(screen);
	}

	@Test(expected = EmptyObjectException.class)
	public void addScreen_ScreenDataNotGiven_ThrowEmptyObjectException() {
		Screen screen = new Screen(0, null);
		screenService.addScreen(screen);
	}

	@Test
	public void addScreen_ScreenObjectGiven_ShouldReturnOne() {
		Screen screen = new Screen(101, "Audi-1");
		when(screenDAO.insert(screen)).thenReturn(1);
		int rowAffected = screenService.addScreen(screen);
		assertEquals(1, rowAffected);
	}

	@Test(expected = ScreensNotMoreThanThreeException.class)
	public void addScreen_ScreenObjectGivenAfterThirdScreenAdded_ThrowScreensNotMoreThanThreeException() {
		Screen screen = new Screen(102, "Audi-2");
		when(screenDAO.insert(screen))
				.thenThrow(new ScreensNotMoreThanThreeException("Screens should not be more than three"));
		screenService.addScreen(screen);
	}

	@Test(expected = DuplicateScreenNameException.class)
	public void addScreen_DuplicateScreenNameGiven_ThrowDuplicateScreenNameException() {
		Screen screen = new Screen(101, "Audi-1");
		when(screenDAO.insert(screen)).thenReturn(1);
		when(screenDAO.getScreenByName("Audi-1")).thenReturn(screen);
		when(screenDAO.insert(screen))
				.thenThrow(new DuplicateScreenNameException("Screens should not be more than three"));
		screenService.addScreen(screen);
	}

	@Test
	public void getScreenByName_ScreenNameGiven_ShouldReturnScreen() {
		Screen screen = new Screen(101, "Audi-1");
		when(screenDAO.getScreenByName("Audi-1")).thenReturn(screen);
		Screen resultScreen = screenService.getScreenByName("Audi-1");
		assertEquals(screen, resultScreen);

	}

	@Test
	public void getAllScreens_ThreeScreensGiven_ShouldReturnListOfScreens() {

		List<Screen> screens = new ArrayList<Screen>();
		screens.add(new Screen(101, "Audi-1"));
		screens.add(new Screen(102, "Audi-2"));
		screens.add(new Screen(103, "Audi-3"));
		when(screenDAO.getAllScreens()).thenReturn(screens);

		List<Screen> actualScreens = screenService.getAllScreens();

		assertEquals(screens, actualScreens);
	}

	@Test(expected = ScreenRepositoryEmptyException.class)
	public void getAllScreens_NoScreensAdded_throwsScreenRepositoryEmptyException() {

		when(screenDAO.getAllScreens())
				.thenThrow(new ScreenRepositoryEmptyException("No screens added to the repository"));

		List<Screen> actualScreens = screenService.getAllScreens();

	}
}

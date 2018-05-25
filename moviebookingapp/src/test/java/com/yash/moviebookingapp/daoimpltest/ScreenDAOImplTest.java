package com.yash.moviebookingapp.daoimpltest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.yash.moviebookingapp.dao.ScreenDAO;
import com.yash.moviebookingapp.daoimpl.ScreenDAOImpl;
import com.yash.moviebookingapp.model.Screen;

public class ScreenDAOImplTest {

	private ScreenDAO screenDAO;
	
	@Before
	public void setUp() {
		screenDAO = new ScreenDAOImpl();
	}

	@Test
	public void insert_ScreenObjectGiven_ShouldReturnOne() {
		Screen screen = new Screen(101, "Audi-1");
		int rowAffected = screenDAO.insert(screen);
		assertEquals(1, rowAffected);
	}
	
	@Test
	public void getAllScreens_ShouldReturnListOfScreens() throws Exception {
		List<Screen> screens = screenDAO.getAllScreens();
		assertEquals(3, screens.size());
	}

}

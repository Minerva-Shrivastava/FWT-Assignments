package com.yash.moviebookingapp.daoimpltest;

import static org.junit.Assert.assertEquals;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.yash.moviebookingapp.dao.MovieDAO;
import com.yash.moviebookingapp.daoimpl.MovieDAOImpl;
import com.yash.moviebookingapp.model.Movie;

public class MovieDAOImplTest {

	private MovieDAO movieDAO;
	private List<String> actors = new ArrayList<String>();
	private Movie movie;
	
	@Before
	public void setUp() {
		movieDAO = new MovieDAOImpl();
		actors.add("Amir Khan");
		movie = new Movie(1, "Dangal", Time.valueOf("02:00:00"), "Amir Khan Productions", actors, null);
		
	}

	@Test
	public void insert_MovieObjectAndScreenNameGiven_ShouldReturnOne() {
		int rowAffected = movieDAO.insert(movie);
		assertEquals(1, rowAffected);
	}

}

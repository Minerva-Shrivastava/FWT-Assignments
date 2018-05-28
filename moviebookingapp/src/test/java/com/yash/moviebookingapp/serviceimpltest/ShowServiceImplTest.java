package com.yash.moviebookingapp.serviceimpltest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.sql.Time;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.yash.moviebookingapp.dao.ShowDAO;
import com.yash.moviebookingapp.exception.EmptyObjectException;
import com.yash.moviebookingapp.exception.IdNotGivenException;
import com.yash.moviebookingapp.exception.ObjectNotGivenException;
import com.yash.moviebookingapp.exception.ParametersNotGivenException;
import com.yash.moviebookingapp.exception.ShowsRepositoryEmptyException;
import com.yash.moviebookingapp.model.Movie;
import com.yash.moviebookingapp.model.Show;
import com.yash.moviebookingapp.service.ShowService;
import com.yash.moviebookingapp.serviceimpl.ShowServiceImpl;

public class ShowServiceImplTest {

	@Mock
	private ShowDAO showDAO;

	private ShowService showService;
	private Movie movie;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		showService = new ShowServiceImpl(showDAO);
		movie = new Movie(1, "Dangal", Time.valueOf("02:00:00"), "Amir Khan Productions", Arrays.asList("Amir Khan"), "Audi-1");
	}

	@Test(expected = ObjectNotGivenException.class)
	public void addShow_ShowObjectNotGiven_ThrowObjectNotGivenException() {
		Show show = null;
		showService.addShow(show);
	}
	
	@Test(expected = EmptyObjectException.class)
	public void addShow_ShowDataNotGiven_ThrowEmptyObjectException() {
		Show show = new Show(-1, "", Date.valueOf("2018-5-26"), Time.valueOf("11:00:00"), movie);
		showService.addShow(show);
	}
	
	@Test
	public void addShow_ShowObjectGiven_ShouldReturnOne() {
		Show show = new Show(1,"Show-1",Date.valueOf("2018-5-25"),Time.valueOf("09:00:00"),movie);
		when(showDAO.insert(show)).thenReturn(1);
		int rowAffetcted = showService.addShow(show);
		assertEquals(1, rowAffetcted);
	}
	
	@Test(expected = IdNotGivenException.class)
	public void getShowById_ShowIdNotGiven_ThrowsIdNotGivenException() throws Exception {
		int showID = 0;
		showService.getShowById(showID);
	}
	
	@Test
	public void getShowById_ShowIdGiven_ShouldReturnShowObject() throws Exception {
		Show show = new Show(101, "Show-1", Date.valueOf("2018-5-25"), Time.valueOf("09:00:00"),movie);
		when(showDAO.getShowById(101)).thenReturn(show);
		Show resultshow = showService.getShowById(101);
		assertEquals(show, resultshow);
	}

	@Test(expected = ShowsRepositoryEmptyException.class)
	public void getAllShows_NoShowsAdded_ThrowsShowsRepositoryEmptyException() {
		when(showDAO.getAllShows().isEmpty()).thenThrow(new ShowsRepositoryEmptyException("No shows added into the repository"));
		showService.getAllShows();
	}
	
	@Test
	public void getAllShows_ShouldReturnListOfShows() {
		when(showDAO.getAllShows()).thenReturn(Arrays.asList(new Show(101, "Show-1", Date.valueOf("2018-5-25"), Time.valueOf("09:00:00"),movie)));
		List<Show> shows = showService.getAllShows();
		assertEquals(1, shows.size());
	}
	
	@Test
	public void makeShows_NoOfShowsAndDurationAndStartTimeAndMovieGiven_ShouldReturnListOfShows() {
		int noOfShows = 3;
		Time duration = Time.valueOf("00:30:00");
		Time startTime = Time.valueOf("09:00:00");
		List<Show> shows = Arrays.asList(new Show(4, "Show-4", Date.valueOf("2018-5-25"), Time.valueOf("09:00:00"), movie),
										 new Show(5, "Show-5", Date.valueOf("2018-5-25"), Time.valueOf("11:00:00"), movie));
		//when(showDAO.insertShows(shows)).thenReturn(shows.size());
		List<Show> actualShows = showService.makeShows(noOfShows,duration,startTime,movie);
		assertEquals(3, actualShows.size());
	}

	@Test(expected = ParametersNotGivenException.class)
	public void makeShows_NoOfShowsAndDurationAndStartTimeAndMovieGiven_throwsParametersNotGivenException() throws Exception {
		Movie movie = new Movie();
		showService.makeShows(0,Time.valueOf("00:00:00"),Time.valueOf("00:00:00"),movie);
	}
	
}


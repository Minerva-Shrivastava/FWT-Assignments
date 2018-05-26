package com.yash.moviebookingapp.serviceimpltest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.yash.moviebookingapp.dao.MovieDAO;
import com.yash.moviebookingapp.exception.EmptyObjectException;
import com.yash.moviebookingapp.exception.MovieNameNotGivenException;
import com.yash.moviebookingapp.exception.MovieRepositoryEmptyException;
import com.yash.moviebookingapp.exception.ObjectNotGivenException;
import com.yash.moviebookingapp.model.Movie;
import com.yash.moviebookingapp.service.MovieService;
import com.yash.moviebookingapp.serviceimpl.MovieServiceImpl;

public class MovieServiceImplTest {

	
	
	@Mock
	private MovieDAO movieDAO;
	
	private MovieService movieService;
	private String screenName;
	private List<String> actors = new ArrayList<String>();
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		movieService = new MovieServiceImpl(movieDAO);
		screenName = "Audi-1";
		actors.add("Amir Khan");
	}
	
	@Test(expected = ObjectNotGivenException.class)
	public void addMovie_MovieObjectNotGiven_ThrowObjectNotGivenException() {
		Movie movie = null;
		movieService.addMovie(movie);
	}
	
	@Test(expected = EmptyObjectException.class)
	public void addMovie_MovieDataNotGiven_ThrowEmptyObjectException() {
		Movie movie = new Movie(0, "", Time.valueOf("00:00:00"), "", Arrays.asList(""),"");
		movieService.addMovie(movie);
	}

	@Test
	public void addMovie_MovieObjectGiven_ShouldReturnOne() {
		Movie movie = new Movie(1, "Dangal", Time.valueOf("02:00:00"), "Amir Khan Productions", actors, screenName);
		when(movieDAO.insert(movie)).thenReturn(1);
		int rowAffected = movieService.addMovie(movie);
		assertEquals(1, rowAffected);
	}
	
	@Test(expected = MovieRepositoryEmptyException.class)
	public void getAllMovies_NoMoviesAdded_throwsMovieRepositoryEmptyException() {

		when(movieDAO.getAllMovies().isEmpty())
				.thenThrow(new MovieRepositoryEmptyException("No movies added to the repository"));

		movieService.getAllMovies();

	}
	
	@Test
	public void getAllMovies_TwoMoviesGiven_ShouldReturnListOfMovies() {
		
		List<Movie> movies = new ArrayList<Movie>();
		movies.add(new Movie(1, "Dangal", Time.valueOf("02:00:00"), "Amir Khan Productions", Arrays.asList("Amir Khan"), screenName));
		movies.add(new  Movie(3, "Secret Superstar", Time.valueOf("02:30:00"), "Amir Khan Productions", Arrays.asList("Amir Khan","Zaira Wasim"), screenName));

		when(movieDAO.getAllMovies()).thenReturn(movies);
		List<Movie> actualMovies = movieService.getAllMovies();
		assertEquals(2, actualMovies.size());
	}
	
	@Test
	public void getMovieByName_MovieNameGiven_ShouldReturnMovie() throws Exception {
		Movie movie = new Movie(1, "Dangal", Time.valueOf("02:00:00"), "Amir Khan Producations", Arrays.asList("Amir Khan"), screenName);
		when(movieDAO.getMovieByName("Dangal")).thenReturn(movie);
		Movie resultMovie = movieService.getMovieByName("Dangal");
		assertEquals(movie, resultMovie);

	}

	@Test(expected = MovieNameNotGivenException.class)
	public void getMovieByName_MovieNameNotGiven_Throws() throws Exception {
		String movieName = null;
		movieService.getMovieByName(movieName);
	}
}

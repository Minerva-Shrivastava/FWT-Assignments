package com.yash.moviebookingapp.serviceimpl;

import java.sql.Time;
import java.util.List;

import com.yash.moviebookingapp.dao.MovieDAO;
import com.yash.moviebookingapp.exception.EmptyObjectException;
import com.yash.moviebookingapp.exception.MovieNameNotGivenException;
import com.yash.moviebookingapp.exception.ObjectNotGivenException;
import com.yash.moviebookingapp.model.Movie;
import com.yash.moviebookingapp.service.MovieService;

public class MovieServiceImpl implements MovieService {

	private MovieDAO movieDAO;
	
	public MovieServiceImpl(MovieDAO movieDAO) {
		this.movieDAO = movieDAO;
	}

	public int addMovie(Movie movie) {
		
		isMovieGiven(movie);
		
		isMovieObjectEmpty(movie);
		
		return movieDAO.insert(movie);
	}
	
	public List<Movie> getAllMovies() {
		return movieDAO.getAllMovies();
	}

	public Movie getMovieByName(String movieName) {
		
		isMovieNameGiven(movieName);
		
		return movieDAO.getMovieByName(movieName);
	}

	private void isMovieNameGiven(String movieName) {
		if(movieName == null || movieName.isEmpty())
			throw new MovieNameNotGivenException("Give a movie name");
	}

	private void isMovieObjectEmpty(Movie movie) {
		if(movie.getId() <= 0 || movie.getTitle() == null ||movie.getTitle().isEmpty() || 
			movie.getDuration() == Time.valueOf("00:00:00") || movie.getProduction() == null ||
			movie.getProduction().isEmpty() || movie.getActors() == null )
			throw new EmptyObjectException("Add data into the object");
	}

	private void isMovieGiven(Movie movie) {
		if(movie == null)
			throw new ObjectNotGivenException("The object is not given");
	}


}

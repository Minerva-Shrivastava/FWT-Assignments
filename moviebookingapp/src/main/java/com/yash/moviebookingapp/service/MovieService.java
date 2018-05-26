package com.yash.moviebookingapp.service;

import java.util.List;

import com.yash.moviebookingapp.model.Movie;

public interface MovieService {

	int addMovie(Movie movie);

	List<Movie> getAllMovies();

	Movie getMovieByName(String string);

}

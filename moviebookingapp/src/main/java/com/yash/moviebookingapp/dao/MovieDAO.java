package com.yash.moviebookingapp.dao;

import java.util.List;

import com.yash.moviebookingapp.model.Movie;

public interface MovieDAO {

	int insert(Movie movie);

	List<Movie> getAllMovies();

	Movie getMovieByName(String string);

}

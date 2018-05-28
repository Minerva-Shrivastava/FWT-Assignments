package com.yash.moviebookingapp.service;

import java.sql.Time;
import java.util.List;

import com.yash.moviebookingapp.model.Movie;
import com.yash.moviebookingapp.model.Show;

public interface ShowService {

	int addShow(Show show);

	Show getShowById(int i);

	List<Show> getAllShows();

	List<Show> makeShows(int noOfShows, Time duration, Time startTime, Movie movie);

}

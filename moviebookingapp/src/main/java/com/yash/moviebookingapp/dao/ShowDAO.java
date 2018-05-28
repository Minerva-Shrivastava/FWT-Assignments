package com.yash.moviebookingapp.dao;

import java.util.List;

import com.yash.moviebookingapp.model.Show;

public interface ShowDAO {

	int insert(Show show);

	Show getShowById(int i);

	List<Show> getAllShows();

	int insertShows(List<Show> shows);

}

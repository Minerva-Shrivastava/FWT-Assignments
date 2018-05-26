package com.yash.moviebookingapp.daoimpl;

import java.util.List;

import com.yash.moviebookingapp.dao.MovieDAO;
import com.yash.moviebookingapp.model.Movie;
import com.yash.moviebookingapp.util.FileUtil;
import com.yash.moviebookingapp.util.JSONUtil;

public class MovieDAOImpl implements MovieDAO {

	private FileUtil fileUtil;
	
	public MovieDAOImpl() {
		this.fileUtil = new FileUtil();
	}
	
	public int insert(Movie movie) {
		
		String movieJsonInString = JSONUtil.convertObjectToJSON(movie);
		if(fileUtil.writeInFile("movie", movieJsonInString))
			return 1;
		else
			return 0;
	}

	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		return null;
	}

	public Movie getMovieByName(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.yash.moviebookingapp.daoimpl;

import java.util.List;
import java.util.logging.Logger;

import com.yash.moviebookingapp.dao.MovieDAO;
import com.yash.moviebookingapp.model.Movie;
import com.yash.moviebookingapp.util.FileUtil;
import com.yash.moviebookingapp.util.JSONUtil;

public class MovieDAOImpl implements MovieDAO {

	private FileUtil fileUtil;
	private Logger logger = Logger.getLogger("MovieDAOImpl.class");
	
	public MovieDAOImpl() {
		this.fileUtil = new FileUtil();
	}
	
	public int insert(Movie movie) {
		logger.info("adding movie"+movie);
		String movieJsonInString = JSONUtil.convertObjectToJSON(movie);
		if(fileUtil.writeInFile("movie", movieJsonInString))
			return 1;
		else
			return 0;
	}

	public List<Movie> getAllMovies() {
		logger.info("Getting all movies");
		return null;
	}

	public Movie getMovieByName(String movieName) {
		logger.info("Getting movie by Name"+movieName);
		return null;
	}

}

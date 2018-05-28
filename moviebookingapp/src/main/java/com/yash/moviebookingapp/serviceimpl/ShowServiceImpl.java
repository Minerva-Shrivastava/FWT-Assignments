package com.yash.moviebookingapp.serviceimpl;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.yash.moviebookingapp.dao.ShowDAO;
import com.yash.moviebookingapp.exception.EmptyObjectException;
import com.yash.moviebookingapp.exception.IdNotGivenException;
import com.yash.moviebookingapp.exception.ObjectNotGivenException;
import com.yash.moviebookingapp.exception.ParametersNotGivenException;
import com.yash.moviebookingapp.model.Movie;
import com.yash.moviebookingapp.model.Show;
import com.yash.moviebookingapp.service.ShowService;

public class ShowServiceImpl implements ShowService {

	private ShowDAO showDAO;
	private Logger logger = Logger.getLogger("ScreenServiceImpl.class");
	
	public ShowServiceImpl(ShowDAO showDAO) {
		this.showDAO = showDAO;
	}

	public int addShow(Show show) {
		logger.info("Adding show :"+show);
		if (show == null)
			throw new ObjectNotGivenException("show should not be null");
		if (show.getId() <= 0 || show.getName() == null || show.getName().equals("") ||
				show.getMovie() == null || show.getShowDate()==Date.valueOf("2018-5-25") ||
				show.getShowTime() == Time.valueOf("00:00:00"))
			throw new EmptyObjectException("Show should have some data");
		return showDAO.insert(show);
	}

	public Show getShowById(int id) {
		if(id <= 0)
			throw new IdNotGivenException("Give a valid id");
		return showDAO.getShowById(id);
	}

	public List<Show> getAllShows() {
		return showDAO.getAllShows();
	}

	public List<Show> makeShows(int noOfShows, Time duration, Time startTime, Movie movie) {
		if(noOfShows <=0 || startTime==Time.valueOf("00:00:00") || duration==Time.valueOf("00:00:00")
				|| movie == null)
			throw new ParametersNotGivenException("Give valid parameters");
		List<Show> shows = new ArrayList<Show>();
		LocalTime nextLocalTime = startTime.toLocalTime();
		Time sqlTime = startTime;
		for(int i = 1; i<=noOfShows; i++) {
			Show show = new Show(i, "Show-"+i, new java.util.Date(), sqlTime, movie);
			nextLocalTime = sqlTime.toLocalTime().plusHours(duration.getHours());
			nextLocalTime = nextLocalTime.plusMinutes(duration.getMinutes());
			nextLocalTime = nextLocalTime.plusSeconds(duration.getSeconds());
			nextLocalTime = nextLocalTime.plusHours(movie.getDuration().getHours());
			nextLocalTime = nextLocalTime.plusMinutes(movie.getDuration().getMinutes());
			nextLocalTime = nextLocalTime.plusSeconds(movie.getDuration().getSeconds());
			
			sqlTime = java.sql.Time.valueOf(nextLocalTime);
			shows.add(show);
		}
		for (Show show : shows) {
			logger.info("The shows are "+show);
		}
		int rowAffected = showDAO.insertShows(shows);
		return shows;
	}

	

}

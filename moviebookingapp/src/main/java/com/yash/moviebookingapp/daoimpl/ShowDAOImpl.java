package com.yash.moviebookingapp.daoimpl;

import java.util.List;

import com.yash.moviebookingapp.dao.ShowDAO;
import com.yash.moviebookingapp.model.Show;
import com.yash.moviebookingapp.util.FileUtil;
import com.yash.moviebookingapp.util.JSONUtil;

public class ShowDAOImpl implements ShowDAO {
	
	private FileUtil fileUtil;
	
	public ShowDAOImpl() {
		fileUtil = new FileUtil();
	}

	public int insert(Show show) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Show getShowById(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Show> getAllShows() {
		// TODO Auto-generated method stub
		return null;
	}

	public int insertShows(List<Show> shows) {
		int countRows = 0;
		for (Show show : shows) {
			String showJsonInString = JSONUtil.convertObjectToJSON(show);
			if(fileUtil.writeInFile("shows", showJsonInString))
				countRows++;
		}
		return countRows;
	}

	

}

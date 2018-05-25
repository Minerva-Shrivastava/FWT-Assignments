package com.yash.moviebookingapp.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class JSONUtil {

	public String convertObjectToJSON(Object object) {
		Gson gson = new Gson();
		return gson.toJson(object);
	}
	
	
}

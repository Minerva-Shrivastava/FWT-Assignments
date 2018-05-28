package com.yash.moviebookingapp.util;

import java.lang.reflect.Type;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.yash.moviebookingapp.exception.EmptyObjectException;
import com.yash.moviebookingapp.exception.JsonTextNotGivenException;
import com.yash.moviebookingapp.exception.JsonTypeNotGivenException;

public class JSONUtil {

	private static Logger logger = Logger.getLogger("JSONUtil.class");
	
	public static String convertObjectToJSON(Object object) {
		logger.info("Converting  Object To JSON");
		isObjectGiven(object);
		Gson gson = new Gson();
		return gson.toJson(object);
	}

	private static void isObjectGiven(Object object) {
		if(object == null)
			throw new EmptyObjectException("An object should be given");
	}
	
	public static <T> T convertJSONToObject(String jsonText,Type typeOfObject) {
		logger.info("converting JSON To Object");
		isJSONTextGiven(jsonText);
		isJSONTypeOfObjectGiven(typeOfObject);
		Gson gson = new Gson();
		return gson.fromJson(jsonText, typeOfObject);
	}

	private static void isJSONTypeOfObjectGiven(Type typeOfObject) {
		if(typeOfObject == null)
			throw new JsonTypeNotGivenException("Type of object should be specified");
	}

	private static void isJSONTextGiven(String jsonText) {
		if(jsonText == null || jsonText.isEmpty())
			throw new JsonTextNotGivenException("JSOn should be given");
	}
}

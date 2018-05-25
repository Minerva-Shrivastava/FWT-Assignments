package com.yash.moviebookingapp.util;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.yash.moviebookingapp.exception.EmptyObjectException;
import com.yash.moviebookingapp.exception.JsonTextNotGivenException;
import com.yash.moviebookingapp.exception.JsonTypeNotGivenException;
import com.yash.moviebookingapp.model.Screen;

public class JSONUtil {

	public static String convertObjectToJSON(Object object) {
		isObjectGiven(object);
		Gson gson = new Gson();
		return gson.toJson(object);
	}

	private static void isObjectGiven(Object object) {
		if(object == null)
			throw new EmptyObjectException("An object should be given");
	}
	
	public static Object convertJSONToObject(String jsonText,Type typeOfObject) {
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

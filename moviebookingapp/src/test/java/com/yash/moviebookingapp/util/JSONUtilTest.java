package com.yash.moviebookingapp.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Type;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.reflect.TypeToken;
import com.yash.moviebookingapp.exception.EmptyObjectException;
import com.yash.moviebookingapp.exception.JsonTextNotGivenException;
import com.yash.moviebookingapp.exception.JsonTypeNotGivenException;
import com.yash.moviebookingapp.model.Movie;
import com.yash.moviebookingapp.model.Screen;

public class JSONUtilTest {

	
	@Before
	public void setUp() throws Exception {
	}

	@Test(expected = EmptyObjectException.class)
	public void convertObjectToJSON_ObjectNotGiven_ThrowsEmptyObjectException() throws Exception {
		Screen screen = null;
		JSONUtil.convertObjectToJSON(screen);
	}
	
	@Test
	public void convertObjectToJSON_ObjectGiven_ShouldReturnJSONFormatOfGivenObject() {
		String  jsonInString = JSONUtil.convertObjectToJSON(new Screen(101, "Audi-1"));
		assertEquals("{\"id\":101,\"name\":\"Audi-1\"}", jsonInString);
	}

	@Test(expected = JsonTextNotGivenException.class)
	public void convertJSONToObject_JSONFormatNotGiven_ShouldReturnObject() {
		JSONUtil.convertJSONToObject("", new TypeToken<Screen>() {}.getType());
	}
	
	@Test(expected = JsonTypeNotGivenException.class)
	public void convertJSONToObject_JSONTypeNotGiven_ShouldReturnObject() {
		Type type  = null;
		JSONUtil.convertJSONToObject("{\"id\":101,\"name\":\"Audi-1\"}", type);
	}
	
	@Test
	public void convertScreenJSONToObject_JSONFormatAndTypeOfObjectGiven_ShouldReturnObject() {
		Object screen = JSONUtil.convertJSONToObject("{\"id\":101,\"name\":\"Audi-1\"}", new TypeToken<Screen>() {}.getType());
		System.out.println(screen);
		assertTrue( screen instanceof Screen );
	}
	
	@Test
	public void convertMovieJSONToObject_JSONFormatAndTypeOfObjectGiven_ShouldReturnObject() {
		Object movie = JSONUtil.convertJSONToObject("{\"id\":1,\"title\":\"Raazi\",\"duration\":\"02:00:00 AM\",\"production\":\"pata ni\",\"actors\":[\"Alia Bhatt\"]}", new TypeToken<Movie>() {}.getType());
		System.out.println(movie);
		assertTrue( movie instanceof Movie);
	}
}

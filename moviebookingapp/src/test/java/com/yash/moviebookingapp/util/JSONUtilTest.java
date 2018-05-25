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
	public void convertJSONToObject_JSONFormatAndTypeOfObjectGiven_ShouldReturnObject() {
		Screen screen = (Screen) JSONUtil.convertJSONToObject("{\"id\":101,\"name\":\"Audi-1\"}", new TypeToken<Screen>() {}.getType());
		assertTrue( screen instanceof Screen );
	}
}

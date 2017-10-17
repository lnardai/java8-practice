package com.practice.stream;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BasicStreamTransformationsServiceTest {

	private static Map<Integer, String> namesWithDots = new HashMap<>();
	private BasicStreamTransformationsService service =  new BasicStreamTransformationsService();

	@BeforeClass
	public static void setUp() throws Exception {
		fillMap();
	}

	@Test
	public void removeDots() throws Exception {
		List<String> result = service.removeDots(namesWithDots);
		assertEquals("leaia organa", result.get(0));
		assertEquals("anakin skywalker", result.get(1));
		assertEquals("luke skywalker", result.get(4));
	}

	public static void fillMap() {
		namesWithDots.put(1, "leaia.organa");
		namesWithDots.put(2, "anakin.skywalker");
		namesWithDots.put(3, "han.solo");
		namesWithDots.put(4, "kylo.ren");
		namesWithDots.put(5, "luke.skywalker");
	}

}
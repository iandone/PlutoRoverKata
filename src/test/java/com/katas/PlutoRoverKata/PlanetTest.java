package com.katas.PlutoRoverKata;

import org.junit.After;
import org.junit.Test;

/**
 * Testing Planet class instructions.
 * 
 * @author Ioana Andone
 */
public class PlanetTest {
	
	private Planet planet = null;
	
	@After
	public void runAfterTests() {
		planet = null;
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void whenGivenPlanetNameIsNull() {
		planet = new Planet(null, 100);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void whenGivenGridSizeIsNegative() {
		planet = new Planet("Venus", -100);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void whenGivenGridSizeIsZero() {
		planet = new Planet("Pluto", 0);
	}
	
	@Test
	public void whenExploringWithNoRovers() {
		planet = new Planet("Pluto", 500);
		planet.explore();
	}
}
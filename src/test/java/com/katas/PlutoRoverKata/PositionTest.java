package com.katas.PlutoRoverKata;

import org.junit.After;
import org.junit.Test;

/**
 * Testing the Position class instructions.
 * 
 * Every position to have an (x, y) pair of coordinates, accompanied by a letter
 * which is a cardinal compass point (N, E, S, W).
 * 
 * @author Ioana Andone
 */
public class PositionTest {

	@SuppressWarnings("unused")
	private Position position = null;
	
	@After
	public void runAfterTests() {
		position = null;
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void whenPositionCoordinateIsNegativeIllegalArgumentExceptionThrown() {
		position = new Position(-2, 0, 'E');
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void whenPositionDirectionIsNotAValidCardinalDirection() {
		position = new Position(5, 3, 'A');
	}
	
	@Test
	public void whenPositionCoordinatesAreValidConstructor1() {
		position = new Position(10, 23, 'W');
	}
}

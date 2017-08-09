package com.katas.PlutoRoverKata;

import static org.junit.Assert.assertEquals;

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
	
	@Test
	public void whenPositionCoordinatesAreValidConstructor2() {
		position = new Position(10, 23);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void whenPositionsMergeWithOneBeingNull() {
		position = new Position(40, 55, 'E');
		position.merge(null);
	}
	
	@Test
	public void 
	whenPositionsMergeWithOneBeingZeroZeroCoordinatesDoNotChangeChange() {
		position = new Position(40, 55);
		position.merge(new Position(0, 0));
		assertEquals(new Position(40, 55), position);
	}
	
//	@Test
	public void whenDifferentNonZeroPositionsMergeCoordinatesChange() {
//		position = new Position(40, 55, 'E');
//		position.merge(new Position(10, 5));
//		assertEquals(new Position(50, 0), position);
	}
}
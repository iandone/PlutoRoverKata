package com.katas.PlutoRoverKata;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Test;

/**
 * Testing the Rover class instructions.
 * 
 * A rover must have receive arguments in the form of:
 *  - a position (not null, positive coordinates)
 *  - a move instructions string
 *  - a list of obstacles, if applicable.
 *  
 * @author Ioana Andone
 */
public class RoverTest {

	@SuppressWarnings("unused")
	private Rover rover = null;
	
	@After
	public void runAfterTests() {
		rover = null;
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void whenRoverArgumentPositionIsNull() {
		rover = new Rover(null, "FBRRF", null);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void whenRoverArgumentInstructionsAreNull() {
		rover = new Rover(new Position(0, 45, 'N'), null, null);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void whenRoverArgumentPositionHasNegativeCoordinates() {
		rover = new Rover(new Position(-10, 45, 'W'), null, null);
	}
	
	@Test
	public void whenRoverArgumentsAreValid() {
		rover = new Rover(
					new Position(60, 95, 'E'), 
					"FRFFFFRBBBF", 
					new ArrayList<Obstacle>());
	}
}
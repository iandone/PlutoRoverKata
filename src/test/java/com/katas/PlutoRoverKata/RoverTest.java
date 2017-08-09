package com.katas.PlutoRoverKata;

import static org.junit.Assert.assertEquals;

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
	
	@Test (expected = IllegalArgumentException.class)
	public void whenRoverReceivesUnexpectedInstructions() {
		rover = new Rover(
    				new Position(60, 95, 'E'), 
    				"AFRFRBBBF", 
    				new ArrayList<Obstacle>());
		
		rover.executeInstructions(100, false);
	}
	
	@Test
	public void whenRoverReceivesValidInstructions() {
		rover = new Rover(
    				new Position(0, 0, 'E'), 
    				"FRFRRFFFF", 
    				new ArrayList<Obstacle>());
		
		rover.executeInstructions(200, false);
		assertEquals(rover.getPosition(), new Position(1, 3, 'N'));
	}
}
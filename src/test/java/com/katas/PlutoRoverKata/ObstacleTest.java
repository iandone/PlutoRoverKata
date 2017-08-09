package com.katas.PlutoRoverKata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.After;
import org.junit.Test;

/**
 * Testing the Position class instructions.
 * 
 * As opposed to a rover, an obstacle is described by a position and lacks any
 * direction/heading information.
 * 
 * @author Ioana Andone
 */
public class ObstacleTest {
	
	private Obstacle obstacle = null;
	
	@After
	public void runAfterTests() {
		obstacle = null;
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void whenGivenPositionIsNull() {
		obstacle = new Obstacle(null);
	}
	
	@Test
	public void whenGivenPositionIsValid() {
		obstacle = new Obstacle(new Position(0, 23));
	}
	
	@Test
	public void whenObstaclesAreEqualTestEquals() {
		obstacle = new Obstacle(new Position(33, 54));
		assertEquals(obstacle, new Obstacle(new Position(33, 54)));
	}
	
	@Test
	public void whenObstaclesAreNotEqualTestEquals() {
		obstacle = new Obstacle(new Position(33, 54));
		assertNotEquals(obstacle, new Obstacle(new Position(33, 84)));
	}
}

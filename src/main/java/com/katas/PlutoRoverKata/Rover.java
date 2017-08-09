package com.katas.PlutoRoverKata;

import java.util.List;

/**
 * In order to control a rover, NASA sends a simple string of letters. 
 * The only commands that can be given to the rover are: 'F', 'B, 'L', 'R'.
 *   - 'F' and 'B' are the commands that moves the rover forward and backward, 
 *      respectively. The rover may only move one point on the grid and must
 *      maintain the same heading.
 *   - 'L' and 'R' are the commands to turn left and right, respectively. They
 *   	spin the rover 90 degrees left or right, but do not move the rover from
 *   	its current spot.
 *   - implement wrapping from one edge of the grid to another 
 *     (Pluto is a sphere)
 *   - implement obstacle detection before each move to a new square. If a given
 *   	sequence of commands encounters an obstacle, the rover moves up to the 
 *   	last possible point and reports the obstacle.
 * 
 * @author Ioana Andone
 */
public class Rover {

	private Position position = null;
	
	private String instructions = null;
	
	private List<Obstacle> obstacles = null;
	
	public Rover(
			Position position,
			String instructions,
			List<Obstacle> obstacles) {
		
		if(position == null) {
			throw new IllegalArgumentException(
						"Rover given an invalid position.");
		} else if(null == instructions || instructions.isEmpty()) {
			throw new IllegalArgumentException(
						"Rover given invalid instructions.");
		} else {
    		this.setPosition(position);
    		this.setInstructions(instructions);
    		this.setObstacles(obstacles);
		}
	}

	public Position getPosition() {
		return position;
	}

	private void setPosition(Position position) {
		this.position = position;
	}

	public String getInstructions() {
		return instructions;
	}

	private void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public List<Obstacle> getObstacles() {
		return obstacles;
	}

	private void setObstacles(List<Obstacle> obstacles) {
		this.obstacles = obstacles;
	}
}
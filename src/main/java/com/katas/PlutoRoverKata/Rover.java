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
	
	private boolean isObstacleFound = false; 
	
	private boolean isPositionChanged = false;
	
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
	
	public void executeInstructions(
			final int gridSize,
			boolean showSequenceMovement) {
		
		System.out.print("  - Initial Position: ");
		printPosition(true);
		
		for(char instruction : instructions.toCharArray()) {
			
			if(!isObstacleFound()) {
				
				setPositionChanged(false);
    			
				switch(Character.toUpperCase(instruction)) {
            		case 'L': 
            			moveLeft();
            			break;
            		case 'R':
            			moveRight();
            			break;
            		case 'F':
            			moveForward(gridSize);
            			break;
            		case 'B':
            			moveBackward(gridSize);
            			break;
            		
            		default:
            			throw 
            				new IllegalArgumentException(
            						String.format(
            								"Unexpected instruction '%c' found", 
            								instruction));
        		}
				
				if(showSequenceMovement) {
					System.out.print("  - Moving ");
					System.out.printf(
							"%s --> ", 
							Character.toUpperCase(instruction));
					printPosition(false);
    			}
			}
		}
			
		if(isObstacleFound()) {
			System.out.println(
					"    [!] Rover run terminated early (obstacle found)");
		}
		
		System.out.print("  - Final position: ");
		printPosition(false);
	}

	private void moveLeft() {

		for(Direction dir : Direction.values()) {
			
			if(isPositionChanged) {
				break;
				
			} else if(dir.getDirection() == position.getDirection()) {
				
				position.setDirection(
						dir.left().getDirection());
				
				isPositionChanged = true;
			}
		}
	}
	
	private void moveRight() {
		
		for(Direction dir : Direction.values()) {
			
			if(isPositionChanged) {
				break;
				
			} else if(dir.getDirection() == position.getDirection()) {
				
				position.setDirection(
						dir.right().getDirection());
				
				isPositionChanged = true;
			}
		}
	}
	
	private void moveForward(final int gridSize) {
		
		for(Direction dir : Direction.values()) {
			
			if(isPositionChanged) {
				break;
			
			} else if(dir.getDirection() == position.getDirection()) {
				position.merge(dir.forward(), gridSize);
				
				if(obstacles != null
						&& obstacles.contains(
								new Obstacle(position))) {
					moveBackward(gridSize);
					setObstacleFound(true);
				} else {
					setPositionChanged(true);
				}
			}
		}
	}
	
	private void moveBackward(final int gridSize) {
		
		for(Direction dir : Direction.values()) {
			
			if(isPositionChanged) {
				break;
				
			} else if(dir.getDirection() == position.getDirection()) {
				position.merge(dir.backward(), gridSize);
				
				if(obstacles != null
						&& obstacles.contains(
								new Obstacle(position))) {
					moveForward(gridSize);
					setObstacleFound(true);
				} else {
					setPositionChanged(true);
				}				
			}
		}
	}
	
	public void printPosition(boolean printInstructions) {
		
		if(printInstructions) {
        	System.out.printf(
        			"%s with instructions: %s\n", 
        			position.toString(), 
        			instructions);
		} else {
			System.out.printf(
					"%s \n", 
					position.toString());
		}
	}

	public Position getPosition() {
		return position;
	}

	private void setPosition(Position position) {
		this.position = position;
	}

	private void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	private void setObstacles(List<Obstacle> obstacles) {
		this.obstacles = obstacles;
	}

	public boolean isObstacleFound() {
		return isObstacleFound;
	}

	private void setObstacleFound(boolean isObstacleFound) {
		this.isObstacleFound = isObstacleFound;
	}

	public boolean isPositionChanged() {
		return isPositionChanged;
	}

	private void setPositionChanged(boolean isPositionChanged) {
		this.isPositionChanged = isPositionChanged;
	}
}
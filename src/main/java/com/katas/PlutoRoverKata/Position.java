package com.katas.PlutoRoverKata;

/**
 * To simplify navigation, the planet has been divided up into a grid.
 * The rover's position and location are represented by a combination of x and y
 * coordinates and a letter, representing one of the four cardinal compass 
 * points. 
 * An example position: 0, 0, N - meaning rover is in bottom left corner and
 * facing North. Assume that the square directly North from (x, y) is 
 * (x, y + 1).
 * 
 * @author Ioana Andone
 */
public class Position {
	private int x;
	
	private int y;
	
	private char direction; 
	
	public Position(int x, int y) {
		this.setX(x);
		this.setY(y);
	}
	
	public Position(int x, int y, char direction) {
		if(x < 0 || y < 0) {
			throw new IllegalArgumentException(
					"Rover position coordinates expected to be positive.");
		} else if(!"NSWE".contains(
						 Character.toString(direction).toUpperCase())) {
			throw new IllegalArgumentException(
					"Rover direction expected as a cardinal compass point.");
		} else {
			this.setX(x);
			this.setY(y);
			this.setDirection(
					Character.toUpperCase(direction));
		}
	}
	
	@Override
	public String toString() {
		return String.format("%d %d %c", x, y, direction);
	}
	
	public void merge(Position gridPosition) {
		
		if(gridPosition == null) {
			throw new IllegalArgumentException(
					"Given merge coordinates position cannot be null.");
		} else {
    		this.x += gridPosition.getX();
    		this.y += gridPosition.getY();
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		
		boolean isEqual = false;
		
		if (obj != null) {

			if (getClass() == obj.getClass()) {

				Position other = (Position) obj;
				
				if (x == other.x && y == other.y) {
					isEqual = true;
				}
    		}
		}
		
		return isEqual;
	}
	
	public int getX() {
		return x;
	}

	private void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	private void setY(int y) {
		this.y = y;
	}

	public char getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}
}
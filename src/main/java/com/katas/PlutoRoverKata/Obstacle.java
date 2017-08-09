package com.katas.PlutoRoverKata;

/**
 * Obstacle class - considered to only have (x, y) pair of coordinates
 * (heading / direction not applicable)
 * 
 * @author Ioana Andone
 */
public class Obstacle {

	private Position position = null;
	
	public Obstacle(Position position) {
		if(position == null) {
			throw new IllegalArgumentException(
						"Obstacle argument not expected to be null");
		} else {
			this.setPosition(position);
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		
		boolean isEqual = false;
		
		if (obj != null) {

			if (getClass() == obj.getClass()) {

				Obstacle other = (Obstacle) obj;

				if (position.equals(other.position)) {
        			isEqual = true;
        		}
    		}
		}
		
		return isEqual;
	}

	private void setPosition(Position position) {
		this.position = position;
	}
}

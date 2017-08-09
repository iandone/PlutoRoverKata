package com.katas.PlutoRoverKata;

/**
 * Obstacle class - considered to only have (x, y) pair of coordinates
 * (heading / direction not applicable)
 * 
 * @author Ioana Andone
 */
public class Obstacle {

	@SuppressWarnings("unused")
	private Position position = null;
	
	public Obstacle(Position position) {
		if(position == null) {
			throw new IllegalArgumentException(
						"Obstacle argument not expected to be null");
		} else {
			this.setPosition(position);
		}
	}

	private void setPosition(Position position) {
		this.position = position;
	}
}

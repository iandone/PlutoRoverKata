package com.katas.PlutoRoverKata;

import java.util.ArrayList;
import java.util.List;

/**
 * Pluto is a Planet - implemented in case we want to explore other planets with
 * these little guys in future :-)
 * 
 * @author Ioana Andone
 */
public class Planet {
	
	private String name = null;
	
	@SuppressWarnings("unused")
	private int size = 0;

	private List<Rover> rovers = null;

	public Planet(String name, int size) {
		
		if(null != name && !name.isEmpty()) {
			this.setName(name);
		} else {
			throw new IllegalArgumentException(
						"The planet name cannot be null");
		}
		
		if(size > 0) {
			this.setSize(size);
		} else {
			throw new IllegalArgumentException(
						"The grid size must be positive and cannot be zero :)");
		}
		
		this.setRovers(new ArrayList<Rover>());
	}
	
	public void explore(boolean showSequenceMovement) {
		if(!this.rovers.isEmpty()) {
			System.out.printf("Exploring %s...\n", name);
			
			for(int i = 1; i <= rovers.size(); i++) {
    			
    			System.out.printf("\nRover %d: \n",i);
    			
    			rovers.get(i-1)
    				  .executeInstructions(showSequenceMovement);
    		}
		} else {
			System.out.println("No rovers are available for exploring :(");
		}
	}

	public void addRover(Rover rover) {
		rovers.add(rover);
	}
	
	private void setName(String name) {
		this.name = name;
	}

	private void setSize(int size) {
		this.size = size;
	}

	private void setRovers(List<Rover> rovers) {
		this.rovers = rovers;
	}	
}

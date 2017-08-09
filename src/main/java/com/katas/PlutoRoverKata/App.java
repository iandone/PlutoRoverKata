package com.katas.PlutoRoverKata;

import java.util.ArrayList;
import java.util.List;

/**
 * Pluto Rover Kata
 * This application aims to provide a solution to the below described kata.
 * 
 * After NASA's New Horizon successfully flew past Pluto, they now plan to land
 * a Pluto Rover to further investigate the surface.
 * Develop a TDD-based API that will allow the rover to move around the planet.
 * 
 * To simplify navigation, the planet has been divided up into a grid.
 * The rover's position and location are represented by a combination of x and y
 * coordinates and a letter, representing one of the four cardinal compass 
 * points.
 * 
 * In order to control a rover, NASA sends a simple string of letters. 
 * The only commands that can be given to the rover are: 'F', 'B, 'L', 'R'.
 * The API must implement edge wrapping and obstacle detection.
 * 
 * The following assumptions have been made (not necessarily confirmed by spec):
 *  - it is assumed that the grid length and width are of equal size. Thus, a
 *    max grid size of 100 will yield a 100 x 100 grid.
 *  - it is assumed that, regardless of the number of rovers, movement is 
 *    sequential, in that one rover has to move and carry on until the 
 *    instruction sequence has been completed before the next rover can move.
 *  - it is assumed that rovers will share the same list of obstacles.
 *  - it is assumed that if a rover has landed in a certain final position, the
 *    next rover that moves will not consider the first rover an obstacle when
 *    passing through the same spot :-)
 *    
 * @author Ioana Andone
 */
public class App {
	
	private static final int MAX_GRID_SIZE = 100;
	
    public static void main(String[] args ) {
    	
    	final Planet pluto = 
    			new Planet("Pluto", MAX_GRID_SIZE);
    	
    	final Position obstaclePosition =
				new Position(99, 2);
    	final List<Obstacle> obstacles =
    			new ArrayList<Obstacle>();
    	obstacles.add(
				new Obstacle(
						obstaclePosition));
    	
    	final Position rover1Position =
				new Position(1, 2, 'N');
    	final Position rover2Position =
				new Position(50, 25, 'E');
    	final Position rover3Position =
				new Position(30, 27, 'S');
    	
    	pluto.addRover(
				new Rover(
						rover1Position,
						"LFFRBLFRFRBBLBB", 
						obstacles));
    	
    	pluto.addRover(
				new Rover(
						rover2Position,
						"FFFFRRLRBLFRFLBBB",
						obstacles));
    	
    	pluto.addRover(
				new Rover(
						rover3Position,
						"FLLFFRFFFAFF",
						obstacles));
    	
    	pluto.explore(true);
    }
}
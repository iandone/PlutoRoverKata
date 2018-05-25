### date: 9 August, 2017

# Pluto Rover Kata
This application aims to provide a solution to the below described kata. The solution was implemented in just over 2 hours. **Specs:**
 * After NASA's New Horizon successfully flew past Pluto, they now plan to land a Pluto Rover to further investigate the surface.
 * Develop a TDD-based API that will allow the rover to move around the planet.
 * To simplify navigation, the planet has been divided up into a grid.
 * The rover's position and location are represented by a combination of x and y coordinates and a letter, representing one of the four cardinal compass points.
 * In order to control a rover, NASA sends a simple string of letters. 
 * The only commands that can be given to the rover are: 'F', 'B, 'L', 'R'.
 * The API must implement edge wrapping and obstacle detection.

**The following assumptions have been made** (not necessarily confirmed by spec):
 *  it is assumed that the grid length and width are of equal size. Thus, a max grid size of 100 will yield a 100 x 100 grid.
 *  it is assumed that, regardless of the number of rovers, movement is sequential, in that one rover has to move and carry on until the instruction sequence has been completed before the next rover can move.
 *  it is assumed that rovers will share the same list of obstacles.
 *  it is assumed that if a rover has landed in a certain final position, the next rover that moves will not consider the first rover an obstacle when passing through the same spot :-)
    
**Example output when show movement flag is (on):**

### Exploring Pluto...

### Rover 1: 
  - Initial Position: 1 2 N with instructions: `LFFRBLFRFRBBLBB`
  - Moving L --> 1 2 W 
  - Moving F --> 0 2 W 
  - Moving F --> 0 2 W 
    [!] Rover run terminated early (obstacle found)
  - Final position: 0 2 W 

### Rover 2: 
  - Initial Position: 50 25 E with instructions: `FFFFRRLRBLFRFLBBB`
  - Moving F --> 51 25 E 
  - Moving F --> 52 25 E 
  - Moving F --> 53 25 E 
  - Moving F --> 54 25 E 
  - Moving R --> 54 25 S 
  - Moving R --> 54 25 W 
  - Moving L --> 54 25 S 
  - Moving R --> 54 25 W 
  - Moving B --> 55 25 W 
  - Moving L --> 55 25 S 
  - Moving F --> 55 24 S 
  - Moving R --> 55 24 W 
  - Moving F --> 54 24 W 
  - Moving L --> 54 24 S 
  - Moving B --> 54 25 S 
  - Moving B --> 54 26 S 
  - Moving B --> 54 27 S 
  - Final position: 54 27 S 

### Rover 3: 
  - Initial Position: 30 27 S with instructions: `FLLFFRFFFAFF`
  - Moving F --> 30 26 S 
  - Moving L --> 30 26 E 
  - Moving L --> 30 26 N 
  - Moving F --> 30 27 N 
  - Moving F --> 30 28 N 
  - Moving R --> 30 28 E 
  - Moving F --> 31 28 E 
  - Moving F --> 32 28 E 
  - Moving F --> 33 28 E 
```
Exception in thread "main" java.lang.IllegalArgumentException: Unexpected instruction 'A' found
	at com.katas.PlutoRoverKata.Rover.executeInstructions(Rover.java:81)
	at com.katas.PlutoRoverKata.Planet.explore(Planet.java:49)
	at com.katas.PlutoRoverKata.App.main(App.java:78)
```

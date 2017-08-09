package com.katas.PlutoRoverKata;

/**
 * We need a logical way to map out the links between the four cardinal point
 * directions. Contains all the logical associations:
 *  - left direction, relative to each
 *  - right direction, relative to each
 *  - forward coordinates change, relative to each
 *  - backward coordinates change, relative to each
 * 
 * @author Ioana Andone
 */
enum Direction {
	
   NORTH('N') {
      public Direction left() {
    	  return WEST;
      }
      
      public Direction right() {
    	  return EAST; 
      }
      
      public Position forward() {
    	  return new Position(0, 1);
      }
      
      public Position backward() {
    	  return new Position(0, -1);
      }
   },
   
   WEST('W') {
	   public Direction left() {
		   return SOUTH;
       }
      
       public Direction right() {
    	   return NORTH; 
       }
       
       public Position forward() {
    	   return new Position(-1, 0);
       }
       
       public Position backward() {
    	   return new Position(1, 0);
       }
   },
   
   SOUTH('S') {
	   public Direction left() {
		   return EAST;
       }
      
       public Direction right() {
    	   return WEST; 
       }
       
       public Position forward() {
    	   return new Position(0, -1);
       }
       
       public Position backward() {
    	   return new Position(0, 1);
       }
   },
   
   EAST('E') {
	   public Direction left() {
		   return NORTH;
       }
      
       public Direction right() {
    	   return SOUTH; 
       }
       
       public Position forward() {
    	   return new Position(1, 0);
       }
       
       public Position backward() {
    	   return new Position(-1, 0);
       }
   };
 
   public abstract Direction left();
   
   public abstract Direction right();
   
   public abstract Position forward();
   
   public abstract Position backward();
   
   private final char direction;
 
   Direction(char direction) {
      this.direction = 
    		  Character.toUpperCase(direction);
   }
 
   char getDirection() {
      return direction;
   }
}
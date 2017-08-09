package com.katas.PlutoRoverKata;

/**
 * We need a logical way to map out the links between the four cardinal point
 * directions...
 * 
 * @author Ioana Andone
 */
public enum Direction {
	
  NORTH('N') {
	      public Direction left() {
	    	  return WEST;
	      }
	      
	      public Direction right() {
	    	  return EAST; 
	      }
	   },
   
   WEST('W') {
	   public Direction left() {
		   return SOUTH;
       }
      
       public Direction right() {
    	   return NORTH; 
       }
   },
   
   SOUTH('S') {
	   public Direction left() {
		   return EAST;
       }
      
       public Direction right() {
    	   return WEST; 
       }
   },
   
   EAST('E') {
	   public Direction left() {
		   return NORTH;
       }
      
       public Direction right() {
    	   return SOUTH; 
       }
   };
 
   public abstract Direction left();
   
   public abstract Direction right();
   
   private final char direction;
 
   Direction(char direction) {
      this.direction = 
    		  Character.toUpperCase(direction);
   }
 
   char getDirection() {
      return direction;
   }
}
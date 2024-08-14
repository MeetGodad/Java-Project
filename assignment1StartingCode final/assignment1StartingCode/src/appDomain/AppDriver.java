package appDomain;

/**
 * AppDriver.java
 *
 * @author Nishit Patel, Meet Patel, Shubham Patil, Yash Hingu
 * @version 1.1 Class Description: This class launches the application.
 */
public class AppDriver {

    public static void main(String[] args) {
    	
    	ShapeManager sm = new ShapeManager();
    	sm.shapesList(args);
    	 
        long startTime = System.currentTimeMillis();
        sm.compareBy();
        long endTime = System.currentTimeMillis();
        //Calculate the time required to sort the Shape using start time and end time.
        long duration = endTime - startTime;
        //prints the duration required for sorting the shapes.
        System.out.println("Sorting took " + duration + " milliseconds.");
        System.out.println("\nSorted shapes:");
        //Print function for shorted list.
        sm.shortedList();
    }
}
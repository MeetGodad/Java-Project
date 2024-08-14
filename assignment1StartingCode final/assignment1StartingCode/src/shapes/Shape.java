package shapes;

import java.util.Comparator;

/**
 * Shape.java
 *
 * @author Nishit Patel, Meet Patel, Shubham Patil, Yash Hingu
 * @version 1.1 Class Description: This class is Shapes abstract class which content height, base area and volume as base method.
 */
public abstract class Shape implements Comparable<Shape> {
	
	//Attributes
	private double height;
	
	
	// Constructors
    //The above constructor Provides  a Shape with a specified height.//
    public Shape(double height) {
        this.height = height;
    }
    
    /**
     * Getter method to retrieve the height of the shape and 
     * return The height of the shape.
     */
    public double getHeight() {
        return height;
    }
    //This is abstract method to calculate shapes area and is implemented by sub-classes
    public abstract double calcBaseArea();
    
    //This is abstract method to calculate shapes volume and is implemented by sub-classes
    public abstract double calcVolume();

    //compares height of two shapes.
    @Override
    public int compareTo(Shape other) {
        if (this.getHeight() > other.getHeight()) {
            return -1;
        } else if (this.getHeight() < other.getHeight()) {
            return 1;
        } else {
            return 0;
        }
    }
    
  // Compare shapes based on height, area, volume.
    public static Comparator<Shape> getComparator(String comparisonType) {
        switch (comparisonType) {
            case "height":
                return Comparator.comparing(Shape::getHeight);
            case "baseArea":
                return Comparator.comparing(Shape::calcBaseArea);
            case "volume":
                return Comparator.comparing(Shape::calcVolume);
            default:
                throw new IllegalArgumentException("Invalid comparison type");
        }
    }
}

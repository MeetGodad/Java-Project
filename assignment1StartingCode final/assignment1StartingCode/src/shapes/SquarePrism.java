package shapes;

/**
 * SquarePrism.java
 * @author Nishit Patel, Meet Patel, Shubham Patil, Yash Hingu
 * @version 1.1
 * Class description: This class contains the formula for base area and volume of SquarePrism, and extends the abstract class shape.
 */
public class SquarePrism extends shapes.Shape {
	//Attributes
    private double sideLength;
    private double height;

    /*Constructors
     *Constructor Provides a SquarePrism specified height and sideLength. 
     */
    public SquarePrism(double sideLength, double height) {
    	super(height);
        this.sideLength = sideLength;
        this.height = height;
    }
    
  //Getter method to retrieve the height of the SquarePrism and return height of the SquarePrism.//
    public double getHeight() {
        return height;
    }
  
  //Method calculates the volume of SquarePrism
    public double calcVolume() {
        return sideLength * sideLength * height;
    }
    
  
    //Method calculates the Base area of SquarePrism
	@Override
	public double calcBaseArea() {
		return 4 * sideLength * sideLength;
	}
	
	// ToString method provides the formated string with height, sideLength, base Area , volume of SquarePrism
	@Override
	public String toString() {
		return String.format("%s [Height: %.2f, SideLength: %.2f, BaseArea: %.2f, Volume: %.2f];", getClass().getSimpleName(), height, sideLength, calcBaseArea(), calcVolume() );
	}
}
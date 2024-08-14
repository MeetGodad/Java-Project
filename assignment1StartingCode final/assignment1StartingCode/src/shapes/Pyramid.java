package shapes;

/**
 * Pyramid.java
 * @author Nishit Patel, Meet Patel, Shubham Patil, Yash Hingu
 * @version 1.1
 * Class description: This class contains the formula for base area and volume of Pyramid, and extends the abstract class shape.
 */
public class Pyramid extends shapes.Shape {
	//Attributes
    private double baseSideLength;
    private double height;

    /*Constructors
     *Constructor Provides a Pyramid specified height and sidelength. 
     */
    public Pyramid( double height, double baseSideLength) {
    	super(height);
        this.baseSideLength = baseSideLength;
        this.height = height;
    }
    
    //Getter method to retrieve the height of the Pyramid and return height of the Pyramid.//
    public double getHeight() {
        return height;
    }
    
    //Method calculates the volume of Pyramid
    public double calcVolume() {
        return (1.0 / 3.0) * Math.sqrt(2) * baseSideLength * baseSideLength * height;
    }

	
    //Method calculates the Base area of Pyramid
	public double calcBaseArea() {
		 return Math.sqrt(2) * baseSideLength * baseSideLength;
	}
	
	// ToString method provides the formated string with height, sidelength , base Area , volume of Pyramid
	@Override
	public String toString() {
		return String.format("%s [Height: %.2f, BaseSideLength: %.2f, BaseArea: %.2f, Volume: %.2f];", getClass().getSimpleName(), height, baseSideLength, calcBaseArea(), calcVolume() );
	}
}
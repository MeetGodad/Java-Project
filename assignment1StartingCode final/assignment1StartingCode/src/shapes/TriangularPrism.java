package shapes;

/**
 * TriangularPrism.java
 * @author Nishit Patel, Meet Patel, Shubham Patil, Yash Hingu
 * @version 1.1
 * Class description: This class contains the formula for base area and volume of TriangularPrism, and extends the abstract class shape.
 */
public class TriangularPrism extends shapes.Shape {
	//Attributes
    private double sideLength;
    private double height;

    /*Constructors
     *Constructor Provides a TriangularPrism specified height and sideLength. 
     */
    public TriangularPrism(double sideLength, double height) {
    	super(height);
        this.sideLength = sideLength;
        this.height = height;
    }
  //Getter method to retrieve the height of the TriangularPrism and return height of the TriangularPrism.//

  	public double getHeight() {
  		return height;
  	}
  	
  //Method calculates the volume of TriangularPrism
    public double calcVolume() {
        return calcBaseArea() * height;
    }
  //Method calculates the Base area of TriangularPrism
	
    public double calcBaseArea() {
		return 0.5 * sideLength * height;
	}
    
    // ToString method provides the formated string with height, sideLength, base Area , volume of TriangularPrism.

    @Override
    public String toString() {
		return String.format("%s [Height: %.2f, SideLength: %.2f, BaseArea: %.2f, Volume: %.2f];", getClass().getSimpleName(), height, sideLength, calcBaseArea(), calcVolume() );
	}
	
}

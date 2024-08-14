package shapes;

/**
 * PentagonalPrism.java
 * @author Nishit Patel, Meet Patel, Shubham Patil, Yash Hingu
 * @version 1.1
 * Class description: This class contains the formula for base area and volume of PentagonalPrism, and extends the abstract class shape.
 */
public class PentagonalPrism extends shapes.Shape {
	//Attributes
    private double sideLength;
    private double height;

    /*Constructors
     *Constructor Provides a PentagonalPrism specified height and sideLength. 
     */
    public PentagonalPrism(double sideLength, double height) {
    	super(height);
        this.sideLength = sideLength;
        this.height = height;
    }

  //Method calculates the volume of PentagonalPrism
    public double calcVolume() {
        return (1.0 / 6.0) * Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) * sideLength * sideLength * height;
    }
  //Getter method to retrieve the height of the PentagonalPrism and return height of the PentagonalPrism.//

    public double getHeight() {
        return height;
    }
  //Method calculates the Base area of PentagonalPrism
	@Override
	public double calcBaseArea() {
		return 0.5 * Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) * sideLength * sideLength;
	}
	// ToString method provides the formated string with height, sideLength, base Area , volume of PentagonalPrism
	
	@Override
	public String toString() {
		return String.format("%s [Height: %.2f, SideLength: %.2f, BaseArea: %.2f, Volume: %.2f];", getClass().getSimpleName(), height, sideLength, calcBaseArea(), calcVolume() );
	}
	
}

package shapes;

/**
 * OctagonalPrism.java
 * @author Nishit Patel, Meet Patel, Shubham Patil, Yash Hingu
 * @version 1.1
 * Class description: This class contains the formula for base area and volume of OctagonalPrism, and extends the abstract class shape.
 */
public class OctagonalPrism extends shapes.Shape {
	//Attributes
	private double sideLength;
    private double height;

    /*Constructors
     *Constructor Provides a OctagonalPrism specified height and sideLength. 
     */
    public OctagonalPrism(double sideLength, double height) {
    	super(height);
        this.sideLength = sideLength;
        this.height = height;
    }
  //Getter method to retrieve the height and return height of the OctagonalPrism.//

    public double getHeight() {
        return height;
    }
  //Method calculates the volume
    public double calcVolume() {
        return sideLength * sideLength * height;
    }

   
  //Method calculates the Base area
	@Override
	public double calcBaseArea() {
		return 2 * (1 + Math.sqrt(2)) * sideLength * sideLength;
    }
	// ToString method provides the formated string with height, sideLength, base Area , volume OctagonalPrism.
	
	@Override
	public String toString() {
		return String.format("%s [Height: %.2f, SideLength: %.2f, BaseArea: %.2f, Volume: %.2f];", getClass().getSimpleName(), height, sideLength , calcBaseArea(), calcVolume() );
	}
	
}

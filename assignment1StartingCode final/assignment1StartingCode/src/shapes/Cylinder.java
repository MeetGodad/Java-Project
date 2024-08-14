package shapes;

/**
 * Cylinder.java
 * @author Nishit Patel, Meet Patel, Shubham Patil, Yash Hingu
 * @version 1.1 
 * Class description: This class contains the formula for base area and volume of cylinder, and extends the abstract class shape.
 */
public class Cylinder extends shapes.Shape {
	//Attributes
    private double radius;
    private double height;

    /*Constructors
     *Constructor Provides a Cylinder specified height and radius. 
     */
    public Cylinder(double radius, double height) {
    	super(height);
        this.radius = radius;
        this.height = height;
    }

  //Getter method to retrieve the height of the Cylinder and return height.//

    public double getHeight() {
        return height;
    }
  //Method calculates the volume.
    public double calcVolume() {
        return Math.PI * radius * radius * height;
    }
  //Method calculates the Base area
	@Override
	public double calcBaseArea() {
		return 2 * Math.PI * radius * (radius + height);
	}
	// ToString method provides the formated string with height, radius, base Area , volume of cone
	
	@Override
	public String toString() {
		return String.format("%s [Height: %.2f, Radius: %.2f, BaseArea: %.2f, Volume: %.2f];", getClass().getSimpleName(), height, radius , calcBaseArea(), calcVolume() );
	}
}

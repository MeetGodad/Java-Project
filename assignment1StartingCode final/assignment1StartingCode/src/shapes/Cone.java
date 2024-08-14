package shapes;


/**
 * Cone.java
 * @author Nishit Patel, Meet Patel, Shubham Patil, Yash Hingu
 * @version 1.1
 * Class description: This class contains the formula for base area and volume of cone, and extends the abstract class shape.
 */
public class Cone extends shapes.Shape {
	//Attributes
	private double radius;
	private double height;
	
	/*Constructors
    *Constructor Provides a cone specified height and radius. 
    */
	public Cone(double height, double radius) {
		super(height);
		this.height = height;
		this.radius = radius;
	}
	
	//Getter method to retrieve the height of the cone and return height of the cone.//

	public double getHeight() {
		return height;
	}
	
	//Method calculates the volume of cone
	public double calcVolume() {
		return (1.0 / 3.0) * Math.PI * radius * radius * height;
	}
	//Method calculates the Base area of cone
	@Override
	public double calcBaseArea() {
		return Math.PI * radius * (radius + Math.sqrt(height * height + radius * radius));
	}
	
	// ToString method provides the formated string with height, radius, base Area , volume of cone
	
	@Override
	public String toString() {
		return String.format("%s [Height: %.2f, Radius: %.2f, BaseArea: %.2f, Volume: %.2f];", getClass().getSimpleName(), height, radius , calcBaseArea(), calcVolume() );
	}
}

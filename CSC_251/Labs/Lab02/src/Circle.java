/**
 * A simple class which models a circle by its one defining characteristic, which is its radius.
 * 
 * @author Stephen_Wagstaff
 *
 */
public class Circle {
	private double radius;

	/**
	 * Default constructor
	 * @param radius
	 */
	public Circle() {
		super();
		this.radius = 1;
	}

	/**
	 * Public getter for radius
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * Private mutator for the radius, checks the new value that it is still >0
	 * @param radius the radius to set
	 */
	private void setRadius(double radius) {
		if( radius>0 ){
			this.radius = radius;
		}
	}
	
	/**
	 * Public method for modifying the radius of the calling circle's radius
	 * @param newRadius
	 */
	public void resize(double newRadius){
		this.setRadius(newRadius);
	}
	

	/** 
	 * Public method to create and return a reference to a copy of the calling Circle object
	 * @return Circle object that is in the same state as the client
	 */
	public Circle clone(){
		Circle clone = new Circle();
		clone.setRadius(this.getRadius());
		return clone;
	}
	
	/**
	 * Public comparison method to compare two circle's radius
	 * @param guest
	 * @return the boolean result of the comparison of the two circle's radius 
	 */
	public boolean equals(Circle guest){
		return this.getRadius() == guest.getRadius();
	}
	
	/**
	 * Simple print method for the radius for the circle
	 */
	public void print(){
		System.out.print("Radius: " + this.getRadius());
	}
	
}

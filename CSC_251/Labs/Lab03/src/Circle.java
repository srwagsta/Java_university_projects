/**
 * Modified version of the given Circle class
 * 
 * @author Stephen_Wagstaff
 *
 */

public class Circle
{
// Class variables	
	private double radius;
	private static int instanceCounter = 0; 
	  
// Constructors
    /**
     * Default constructor for Circle object 
     */
	public Circle(){
	    instanceCounter ++;
	    this. radius = 1.0; 
    }
    
	/**
	 * Specifying constructor, sets radius to the passed double
	 * Parameters for the passed value are checked in the setter
	 * Once the value is set the counter is incremented   
	 * 
	 * @param radius
	 */
    public Circle(double radius){ 
    	this.setRadius(radius);
    	instanceCounter ++;
    }
    
    /**
     * Copy constructor, all data is set form the passed class object.
     * 
     * @param copy
     */
    public Circle(Circle copy){
    	this.setRadius(copy.radius);
    	instanceCounter++;
    }

// Setters and getters
    public static int getCount(){
    	return Circle.instanceCounter;
    }
    
    public double getRadius()
    {
        return this.radius;
    }

    public static void setCount(int newCount){
    	Circle.instanceCounter = newCount; 
    }
    
    private void setRadius(double radius)
    {
        if (radius >= 0)
            this.radius = radius;
        else
            this.radius = 0;
    }
    
// Instance methods
    public void resize(double newRadius)
    {
        this.setRadius(newRadius);
    }

    /**
     * Copy method, uses the copy constructor. 
     * 
     * @return new Circle object, that is in the same state as the current object
     */
    public Circle clone()
    {
        return new Circle(this);
    }

    public boolean equals(Circle guest)
    {
        return guest.getRadius() == this.getRadius();
    }
  
    public void print()
    {
        System.out.print("The circle\'s radius is " +
        this.getRadius());
    }
}

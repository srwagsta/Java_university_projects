/**
 * 
 */

/**
 * @author wagstaff
 *
 */
public class Principle extends Person{

// Instance variables
	private double salary;
	
// Constructors
	/**
	 * Default constructor
	 */
	public Principle() {
		this("",Double.NaN);
	}

	/**
	 * specifying constructor only using name
	 * @param name
	 */
	public Principle(String name) {
		this(name,Double.NaN);
		
	}
	
	/**
	 * Full specifying constructor 
	 * @param String name, double salary
	 */
	public Principle(String name, double salary) {
		super(name);
		this.setSalary(salary);
		
	}

// Accessors and mutators
	public double getSalary() {
		return salary;
	}

	private void setSalary(double salary) {
		this.salary = salary;
	}

// Instance methods	
	@Override
	public String toString() {
		return super.toString() + " - " + String.format("$%.2f", this.getSalary()) + " Yearly";
	}
	


}

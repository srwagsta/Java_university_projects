/**
 * Simple class to model a person with only a name
 *
 * @author Stephen_Wagstaff
 */
public class Person {

// Instance variables
    private String name;

// Constructors

    public Person() { this(""); }

    public Person(String name) { this.setName(name); }

// Accessors and mutators

    /**
     * Sets a person's name
     * @param a new name
     */
    private void setName(String name) { this.name = name; }

    /**
     * Returns the person's current name
     * @return name
     */
    public String getName() { return this.name; }

// Instance methods

    /**
     * Person's toString method
     * @return a person's name with no formatting
     */
    public String toString() { return this.getName(); }

} // class close

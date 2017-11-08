/**
 * A class that extends person and add
 * a unique Id value that is set when the Member
 * is instantiated based on previously active Id values.
 * @author Stephen_Wagstaff
 */
public class Member extends Person{

// Class variables
    private static int nextId = 1;

// Instance variables
    private int id;

// Constructors

    /**
     * Default constructor
     */
    public Member()
    {
        super();
        this.setId();
    }

    /**
     * Specifying constructor
     * @param name
     */
    public Member(String name)
    {
        super(name);
        this.setId();
    }

    /** You could add another constructor that you could
     *  set the id value in. YOu would just add another setter
     *  to make sure the id isn't already in use. But you
     *  would also have to have a static ArrayList to hold all
     *  the currently assigned id values.
     */

// Accessors and Mutators

    /**
     *  Sets the id to the next available id value
     *  and then increments the nextId value.
     */
    private void setId()
    {
        this.id = Member.nextId;
        Member.nextId++;
    }

    /**
     * Returns the Member's id
     * @return id value
     */
    public int getId() { return this.id; }

// Instance methods

    /**
     * Standard equals method
     * @param guest Member
     * @return the boolean result of id and name comparisons
     */
    public boolean equals(Member guest){
        return this.getId() == guest.getId() &&
                this.getName().equals(guest.getName());
    }

// Override methods

    /**
     * Returns the string representation of the Member model.
     * @return <name> \n\tID: <id>
     */
    @Override
    public String toString()
    {
        return super.toString() + "\n\tID: " + this.getId();
    }

} // Class close

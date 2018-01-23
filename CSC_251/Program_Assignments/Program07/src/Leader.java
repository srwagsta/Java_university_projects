/**
 * Class Leader extends the Member class but
 * adds a Term value that is <= the max term length
 * defined by the class.
 * @author Stephen_Wagstaff
 */
public class Leader extends Member{

// Class variables
    public static final int MAX_TERM = 2;

// Instance variables
    private boolean OrgLeader;
    private int term;

// Constructors

    /**
     * Default constructor
     */
    public Leader()
    {
        super();
        this.setTerm(0);
    }

    /**
     * Specifying constructor with only the name
     * The term length is default to 0
     * @param name
     */
    public Leader(String name)
    {
        this(name,0);
    }

    /**
     * Specifying constructor
     * @param name and term length
     */
    public Leader(String name, int term)
    {
        super(name);
        this.setTerm(term);
    }

// Accessors and Mutators

    /**
     * Getter for the term value
     * @return term value
     */
    public int getTerm() { return this.term; }

    /**
     * Sets the term value if it is <= the MAX_TERM
     * else it is set to 0
     * @param term value
     */
    private void setTerm(int term) {
        this.term = term<=Leader.MAX_TERM ? term : 0;
    }

    public boolean getLead(){ return this.OrgLeader; }

    protected void setLead() { this.OrgLeader = !this.OrgLeader; }

// Override methods

    /**
     * Returns the string representation of a Leader
     * @return <name> \n\tID: <id> \n\tTerm Year: <term>
     */
    @Override
    public String toString(){
        return super.toString() + "\n\tTermYear: " + this.getTerm();
    }

} // Close class

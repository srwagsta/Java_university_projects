/**
 * Short class that defines the framework of a bit object
 * to be used later as a full implementation.
 * @author Stephen_Wagstaff
 */
public abstract class AbstractBit {
// Instance variables
    private boolean bit;

// Constructors

    /**
     * Default constructor. Will set the bit value
     * to false by default
     */
    public AbstractBit() { this(false); }

    /*
     * Specifying constructor, use the set method for
     * validation.
     */
    public AbstractBit(boolean value) { this.setBit(value);}

    /**
     * Copy constructor, also relies on the specifying constructor
     * and is implemented within the clone method.
     * @param guest
     */
    public AbstractBit(AbstractBit guest) { this(guest.getBit());}

// Accessors and mutators

    /**
     * Standard mutator for the bit value with no validation
     * @param value
     */
    protected void setBit(boolean value){ this.bit = value;}

    /**
     * Standard accessor for the bit value
     * @return this objects bit value
     */
    public boolean getBit() { return bit; }

// Override methods
    public String toString(){
        return "Bit: " + this.getBit();
    }

// Instance methods
    public boolean equals(AbstractBit guest){
        return this.getBit() == guest.getBit();
    }

// Abstract methods
    public abstract AbstractBit clone();
    public abstract AbstractBit addBits(AbstractBit guest);
    public abstract AbstractBit addBits(AbstractBit guest1, AbstractBit guest2);
    public abstract AbstractBit carryBit(AbstractBit guest);
    public abstract AbstractBit carryBit(AbstractBit guest1, AbstractBit guest2);




}

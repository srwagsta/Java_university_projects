/**
 * Simple extended implementation of a Bit class
 * Added functions for addition and subtraction of bit values
 * @author Stephen_Wagstaff
 */
public class BinaryBit extends AbstractBit{
// Class variables
    public static final BinaryBit zero = new BinaryBit(false);
    public static final BinaryBit one = new BinaryBit(true);

// Constructors

    /**
     * Default constructor called from the super class
     */
    public BinaryBit(){ super(); }

    /**
     * Specifying constructor implemented using the super class
     * @param bit
     */
    public BinaryBit(boolean bit) { super(bit); }

    /**
     * Clone constructor implemented using the specifying
     * constructor from the super class.
     * @param guest
     */
    public BinaryBit(BinaryBit guest) { super(guest.getBit()); }

    /**
     * Specifying constructor accepting an int param.
     * The int value is expected to be a one (true) or zero (false)
     * For validation if it is a one it is set to true else it is
     * set to the default value of False
     * @param bit - the int representation of a binary bit value
     */
    public BinaryBit(int bit){ super(bit != 1); }

// Instance methods

    /**
     * Returns the bit result of adding two BinaryBits while
     * ignoring the carry bit of the result
     * @param guest
     * @return BinaryBit hold the result of the addition with no
     * carry bit
     */
    public AbstractBit addBits(AbstractBit guest){
        return new BinaryBit( Boolean.logicalOr(
                this.getBit(),guest.getBit()));
    }


    public AbstractBit addBits(AbstractBit guest1, AbstractBit guest2){
        return new BinaryBit(Boolean.logicalOr(Boolean.logicalOr(
                this.getBit(),guest1.getBit()),
                guest2.getBit()));
    }

    public AbstractBit carryBit(AbstractBit guest){
        return new BinaryBit( Boolean.logicalAnd(
                this.getBit(),guest.getBit()));
    }

    public AbstractBit carryBit(AbstractBit guest1, AbstractBit guest2){
        return new BinaryBit(Boolean.logicalAnd(Boolean.logicalAnd(
                this.getBit(),guest1.getBit()),
                guest2.getBit()));
    }

    public boolean equals(BinaryBit guest){
        return super.equals(guest);
    }

    public BinaryBit clone(){ return new BinaryBit(this); }

// Override and implemented methods

    @Override
    public String toString(){ return super.toString(); }
}

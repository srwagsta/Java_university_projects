/**
 * Simple extended implementation of a Bit class
 * Added functions for addition and subtraction of bit values
 * @author Stephen_Wagstaff
 */
public class BinaryBit extends AbstractBit{
    public static final BinaryBit zero = new BinaryBit(false);
    public static final BinaryBit one = new BinaryBit(true);
    public BinaryBit()
    public BinaryBit(boolean bit)
    public BinaryBit(int bit)
    public BinaryBit(BinaryBit guest)
    public BinaryBit clone()
    public boolean equals(BinaryBit guest)
    public String toString()
    public AbstractBit addBits(AbstractBit guest)
    public AbstractBit addBits(AbstractBit guest1, AbstractBit guest2)
    public AbstractBit carryBit(AbstractBit guest)
    public AbstractBit carryBit(AbstractBit guest1, AbstractBit guest2)
}

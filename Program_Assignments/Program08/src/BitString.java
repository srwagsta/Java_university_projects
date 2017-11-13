/**
 * Class to declare and hold an ArrayList od AbstractBit
 * object to model a binary number.
 * @author Stephen_Wagstaff
 */
import java.util.ArrayList;

public class BitString {
// Instance variables
    private ArrayList<AbstractBit> bitString;

// Constructor
    public BitString(){
        this(new ArrayList<>());
        this.addBit(new BinaryBit());
    }

    protected BitString(ArrayList<AbstractBit> bitList){
        this.setAbstractBitList(bitList);
    }

    public BitString(BitString guest){
        this(guest.getAbstractBitList());
    }

// Accessor and mutator

    /**
     * Sets the bitString to a safe instance of the passed bitString
     * @param bitList
     */
    private void setAbstractBitList(ArrayList<AbstractBit> bitList){
        this.bitString = new ArrayList<>(bitList);
    }

    /**
     * Returns a safe instance of the bitString
     * @return a safe ArryList representation of the bitString
     */
    protected ArrayList<AbstractBit> getAbstractBitList(){
        return new ArrayList<>(this.bitString);
    }

    /**
     * Adds the passed AbstractBit to the current bitString
     * @param AbstractBit bit
     */
    public void addBit(AbstractBit bit){ this.bitString.add(bit); }

    /**
     * Returns a safe copy of the BinaryBit at the
     * passed index
     * @param loc
     * @return a safe copy of the BinaryBit
     */
    public AbstractBit bitAt(int loc) {
        return new BinaryBit((BinaryBit)this.bitString.get(loc));
    }

// Instance methods
    public boolean isEmpty(){
        return this.getAbstractBitList().isEmpty();
    }

    /**
     * Returns an int of the number of elements
     * currently in the list
     * @return int of the elements in the list
     */
    public int length(){
        return this.getAbstractBitList().size();
    }

    /**
     * Standard clone method. Safely copies the ArrayList
     * and returns a new BitString object
     * @return a Safe BitString object clone
     */
    public BitString clone(){
        return new BitString(this.getAbstractBitList());
    }

    /**
     * Safely compares BitStrings based on their BitLists
     * @param guest
     * @return the boolean result of the comparison
     */
    public boolean equals(BitString guest){
        return this.getAbstractBitList().equals(guest.getAbstractBitList());
    }

    public String toString(){
        StringBuilder returnString = new StringBuilder();
        for(AbstractBit i : this.getAbstractBitList()){
               returnString.insert(0,i);
        }
        return returnString.toString();
    }
}

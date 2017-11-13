import java.util.ArrayList;

public class Binary extends BitString{
// Constructors

    /**
     * Default constructor implementing the super constructor
     */
    public Binary(){ super(); }

    /**
     * Constructors implements the copy constructor for the super
     * @param guest
     */
    public Binary(BitString guest){ super(guest); }


    public Binary(long val){
        this();
        this.encode(val);
    }

    public Binary(Binary guest){
        super(guest.getAbstractBitList());
    }

// Instance methods
    public Binary clone(){
        return new Binary(super.clone());
    }

    private void encode(long val){
        char[] valArray = Long.toBinaryString(val).toCharArray();
        for (char bit : valArray){
            this.addBit(new BinaryBit(Integer.parseInt(String.valueOf(bit),10)));
        }
    }

    public Binary addition(Binary guest){
        ArrayList<AbstractBit> binaryNum = new ArrayList<>();


        return new Binary(new BitString(binaryNum));

    }
}

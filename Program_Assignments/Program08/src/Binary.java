import java.math.BigInteger;
import java.util.ArrayList;

public class Binary extends BitString{
// Constructors

    /**
     * Default constructor implementing the super constructor
     */
    public Binary(){
        super();
        this.addBit(new BinaryBit(0));
    }

    /**
     * Constructors implements the copy constructor for the super
     * @param guest
     */
    public Binary(BitString guest){ super(guest); }


    public Binary(long val){
        super();
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
        int mod =0;
        while(val != 0){
            mod = (int)val % 2;
            val =(val-mod)/2;
            this.addBit(new BinaryBit(mod));
        }
    }

    /**
     * Adds two Binary objects by converting the BitString ArrayList
     * to a string and then to a BigInteger, then the addition is performed
     * and the Binary representation is safely returned.
     *
     * BigInteger was used her because the parseLong cold throw a number format
     * exception when large numbers were used. BigInteger doesn't
     * suffer from this.
     * @param guest Binary object
     * @return Binary object representation of the sum
     */
    public Binary addition(Binary guest){
        BigInteger num1 = new BigInteger(this.toString(), 2);
        BigInteger num2 = new BigInteger(guest.toString(), 2);
        String sum = num1.add(num2).toString(2);
        ArrayList <AbstractBit> binaryAns = new ArrayList();
        for (String i : sum.split("")){
            int x = Integer.parseInt(i);
            binaryAns.add(0,new BinaryBit(x));
        }
        return new Binary(new BitString(binaryAns));
    }
}

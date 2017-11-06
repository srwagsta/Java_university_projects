/**
 * @author Stpehen Wagstaff
 * Call Oct extends on the Natural number call and extends the functionallity
 * to only include a cyclic set of natural numbers 0 - 7.
 */
public class Oct extends Nat implements Mod8 {

// Constructors
    public Oct(){
        this(0);
    }

    public Oct(int n){
        super();
        this.setN(n);
    }

    public Oct(Oct guest){
        this(guest.getN());
    }

// Override methods
    @Override
    protected void setN(int n){
        super.setN(n%8);
    }

    @Override
    public Object clone(){ return new Oct(this);}

    @Override
    public boolean equals(Object guest){
        return guest instanceof Oct && super.equals(guest);
    }

    @Override
    public void increment(){
        this.setN(this.getN()+1 % Mod8.MODULUS);
    }

    @Override
    protected void decrement(){
        if (this.getN() != 0)
            this.setN(this.getN() - 1);
        else
            this.setN(Mod8.MODULUS - 1);
    }

    @Override
    public Nat addition(Nat guest){
        return new Nat(
                (this.getN() + guest.getN()) % Mod8.MODULUS
        );
    }

// Implemented methods
    
    public Nat inverse(){
        return new Nat(Mod8.MODULUS-this.getN());
    }

} // Class close

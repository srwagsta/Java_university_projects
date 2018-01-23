public class MyInteger extends Number
{
// Instance variables
    private int data;

// Constructors
    public MyInteger(){
        super();

    }

    public MyInteger(int data){
        super();
        this.setSet(true);
        this.setData(data);
    }

// Accessors and Mutators
    public int getData(){
        return this.data;
    }

    private void setData(int data){
        this.data = data;
    }

// Instance methods

    /**
     * In order to be a true override it must take a guest
     * of the Number class
     *
     * @param client of number class
     * @return The boolean result of a comparison
     * of guest in that they hold the same value and
     * and are both equal by the Number class definition
     */
    @Override
    public boolean equals(Number guest){
        return guest instanceof MyInteger &&
                this.getData() == ((MyInteger)guest).getData() &&
                super.equals(guest);
    }

    /**
     *
     * @return a String representation of an Integer
     */
    @Override
    public String toString(){
        if (isSet())
            return super.toString() + this.getData();
        else
            return super.toString();
    }

    /**
     *
     * @param guest on type Number base class
     * @return the result of the division operation
     */
    @Override
    public Number division(Number guest){

        if (guest instanceof MyInteger) {
            return new MyInteger(this.getData() /
                    ((MyInteger) guest).getData());
        }
        else
            return new MyDouble(this.getData() /
                ((MyDouble)guest).getData());

    }
} // CLass close

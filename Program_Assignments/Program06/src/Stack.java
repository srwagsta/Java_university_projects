/*
* @author Stephen Wagstaff
*
* Create a Stack model extend from the
* Dynamic Array model. The Stack operates on
* the FIFO principle.
*/
public class Stack extends DynArray{

// Constructor
    public Stack(){
        super();
    }

// Accessors
    /*
    * Accessor for the number of item on the Stack
    * @returns int number of items
    */
    public int size(){
        return super.elements();
    }

    /*
    * Determines if the stack has no values
    * @return boolean value of empty
    */
    public boolean isEmpty(){
        return super.elements() == 0;
    }

    /*
    * Print the stack in the Stack order
    */
    public void stackDump(){
        for(int i=super.elements(); i>=0; i--)
            System.out.println("array.at(" +i +") = " +this.at(i));
    }

// Instance methods
    /*
    * Adds value to the top of the stack
    * @param double to be pushed
    */
    public void push(double value){
        super.insert(value);
    }
    /*
    * If the stack in not empty remove and return
    * the most recently pushed value. If there
    * are no values then NaN is returned.
    * @return The last pushed value or NaN
    */
    public double pop(){
        if(!this.isEmpty()){
            return super.remove();
        } else return Double.NaN;
    }

} // Close class

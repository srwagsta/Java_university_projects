/*
* @author Stephen Wagstaff
*
* Create Queue model based on the FILO
* principe
*/
public class Queue extends DynArray{
// Constructor
    public Queue(){
        super();
    }

// Accessors
    /*
    * Accessor for the number of item int Queue
    * @returns int number of items
    */
    public int size(){
        return super.elements();
    }

    /*
    * Determines if the queue has no values
    * @return boolean value of empty
    */
    public boolean isEmpty(){
        return super.elements() == 0;
    }

    /*
    * Print the queue in the queue order
    */
    public void queueDump(){
        super.printArray();
    }

// Instance methods
    /*
    * Adds value to the end of the queue
    * @param double to be queued
    */
    public void que(double value){
        super.insert(value);
    }
    /*
    * If the queue is not empty remove and return
    * the last value in the queue. If there
    * are no values then NaN is returned.
    * @return The last pushed value or NaN
    */
    public double deQue(){
        if(!this.isEmpty()){
            return super.removeAt(0);
        } else return Double.NaN;
    }

} // Close class

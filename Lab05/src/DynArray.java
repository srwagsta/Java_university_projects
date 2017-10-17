/**
 * @author Stephen Wagstaff
 *
 */
public class DynArray
{
// Instance Variables
  private double[] array;
  private int size;
  private int nextIndex;
  
//Constructor
  public DynArray()
  {
	  this.size = 1;
	  this.array = new double[1];
	  this.nextIndex = 0;
	  
  }
  
// Accessors
  public int arraySize()
  {
    	return this.size;
  }
  
  public int elements()
  {
	  return this.nextIndex;
  }
  
// Instance methods
  /**
   * Double the size of the array and copy the existing values.
   * Adjust the size value accordingly.
   */
  private void grow()
  {
	  double[] return_arr = new double[(this.arraySize()*2)];
	  int index =0;
	  for(double value:this.array) {
		  return_arr[index] = value;
		  ++index;
	  }
	  this.size = this.arraySize()*2;
	  this.array = return_arr;
  }
  
  /**
   * Cut the array size in half if the nextIndex is less than half of the current size. 
   * Also check to make sure that the current size is greater than 1 (so it can be /2)
   * Else do nothing. 
   */
  private void shrink()
  {
	  if((this.elements()*2) <= (this.arraySize()) && this.arraySize() > 1){
		  double[] return_arr = new double[(this.arraySize()/2)];
		  for(int i=0;i<this.elements();i++){
			  return_arr[i] = this.array[i];
		  }
		  this.array = return_arr;
		  this.size = this.size/2;
	  }else return;
  }
}
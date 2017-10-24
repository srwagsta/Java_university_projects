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
	  this.array = Arrays.copyOf(this.array,this.arraySize*2);
	  this.size = this.arraySize()*2;
  }
  
  /**
   * Cut the array size in half if the nextIndex is less than half of the current size. 
   * Also check to make sure that the current size is greater than 1 (so it can be /2)
   * Else do nothing. 
   */
  private void shrink()
  {
	  if((this.elements()*2) <= (this.arraySize()) && this.arraySize() > 1){
		  this.array = Arrays.copyOf(this.array,this.arraySize/2);
		  this.size = this.size/2;
	  }else return;
  }
}
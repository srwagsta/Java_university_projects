/**
 * @author Stephen Wagstaff
 *
 */
import java.util.Arrays;

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
  
  public double at(int index)
  {
        if(0 <= index && index < this.elements())
            return array[index];
        else
            return Double.NaN;
  }
  
  public void printArray(){
	  System.out.print(Arrays.toString(this.array));
  }
  
// Mutators
  public void insertAt(int index,double value){
	  if(0 <= index && index < this.elements()){
          double [] returnArr = Arrays.copyOf(this.array,this.arraySize()+1);
          for(int i=index; i<returnArr.length-1; i++){
        	  double tempVal = returnArr[i];
        	  returnArr[i] = value;
        	  value = returnArr[i+1];
        	  returnArr[i+1] = tempVal;
          }
          this.array = returnArr;
          this.nextIndex++; 
	  }
	  else
		  return;
	  if(this.elements()-1 == this.arraySize())
		  this.grow();
  }
  
  public void insert(double value){
	  this.insertAt(this.elements(), value);
  }
  
  public double removeAt(int index){
	  double returnVal = 0;
	  if(0 <= index && index < this.elements()){
		  returnVal = this.array[index];
          this.array = Arrays.copyOf(this.array,this.arraySize());
          for(int i=index; i<this.arraySize()-1; i++){
        	  this.array[i] = this.array[i++];
          }
          this.array[this.arraySize()-1] = 0;
          this.nextIndex--;
	  }
	  else
		  return returnVal;
	  if(this.elements()-1 == this.arraySize()/2)
		  this.shrink();
	  return returnVal;
  }
  
  public double remove(){
	  return this.removeAt(this.elements()-1);
  }
  
// Instance methods
  /**
   * Double the size of the array and copy the existing values.
   * Adjust the size value accordingly.
   */
  private void grow()
  {
	  this.array = Arrays.copyOf(this.array,this.arraySize()*2);
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
		  this.array = Arrays.copyOf(this.array,this.arraySize()/2);
		  this.size = this.size/2;
	  }else return;
  }
  
  
} // End class 
/*
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
	 // System.out.print(Arrays.toString(this.array));
	 // This is fast and simple, and can be parsed easily later. 
	for(int i=0; i<this.elements(); i++)
		System.out.println("array.at(" +i +") = " +this.at(i));
  }
  
// Mutators
  public void insertAt(int index,double value){
	  if(this.elements() == this.arraySize())
		  this.grow();
	  if(0 <= index && index <= this.elements()){
	  	  double tempVal = this.array[index];
	  	  this.array[index] = value;
		  for(int i=index+1; i<this.arraySize(); i++){
        	  value = this.array[i];
        	  this.array[i] = tempVal;
        	  tempVal = value;
          }
          this.nextIndex++; 
	  }
	  else
		  return;
	  
  }
  
  public void insert(double value){
	  this.insertAt(this.elements(), value);
  }
  
  public double removeAt(int index){
	  if(index >= this.elements()) return Double.NaN;        
	  //Checks that the index to be removed is not beyond the current next index
	  double returnVal = this.at(index);
	  if(0 <= index && index <= this.elements()){
		  returnVal = this.at(index);                   
          for(int i=index; i<this.arraySize()-1; i++){
        	  this.array[i] = this.array[i+1];
          }
          this.array[this.arraySize()-1] = Double.NaN;
          this.nextIndex--;         
          
	  }
	  if((this.elements()) < (this.arraySize()/2)){
		  this.shrink();
	  } 
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
	  if((((this.elements()-1)*2) <= this.arraySize()) && (this.arraySize() > 1)){
		  this.array = Arrays.copyOf(this.array,this.arraySize()/2);
		  this.size = this.size/2;
	  }
  }
  
  
} // End class 
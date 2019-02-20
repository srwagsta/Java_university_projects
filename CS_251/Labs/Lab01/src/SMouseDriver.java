import java.util.Scanner;

public class SMouseDriver
{
  public static void main(String[] args) 
  {
    Scanner stdIn = new Scanner(System.in);
	
    SMouse mighty = new SMouse();  
    SMouse mickey = new SMouse();
    int newAge; 

    
    System.out.print("What is Mighty Mouse's age? ");
    newAge = stdIn.nextInt();
    for(int i = 0; i<newAge; i++){
    	mighty.grow();
    }
    mighty.display();
    
    
    System.out.print("What is Mickey Mouse's age? ");
    newAge = stdIn.nextInt();
    for(int i = 0; i<newAge; i++){
    	mickey.grow();
    }
    mickey.display();

    
    stdIn.close();
  }
}

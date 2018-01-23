import java.util.NoSuchElementException;
import java.util.Scanner;

public class TestScore
{
  public static void main(String[] args)
  {
     Scanner stdIn = new Scanner(System.in);
     float score = -1;

// Start of infinite do while loop
     do {
         try {
             System.out.print("\nPlease enter a test score [0, 100] : ");
             score = Float.parseFloat(stdIn.nextLine());
// Exit condition
             if(score <= 100 && score >= 0){ break; }
             System.out.println("Please provide a number within [0,100].");
         }
         catch (NoSuchElementException D){ System.out.println("Please provide input."); }
         catch (IllegalStateException G){ System.out.println("Sorry the scanner has been closed."); }
         catch (NumberFormatException A){ System.out.println("Please provide a valid number.");}
     }while(true);

     System.out.println("The valid score entered was " + score);
     stdIn.close();
  }
}


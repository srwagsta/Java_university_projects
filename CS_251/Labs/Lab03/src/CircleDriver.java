import java.util.Scanner;

public class CircleDriver
{
  public static void main(String[] args) 
  {
    Scanner stdIn = new Scanner(System.in);
	
    Circle big = new Circle();  
    Circle small = new Circle();

    System.out.println("");
    System.out.print("Big : ");
    big.print();

    System.out.println("");
    System.out.print("Small : ");
    small.print();

    System.out.println("\n");
    
    double bigRadius;
    System.out.print("Enter the radius of a big circle : ");
    bigRadius = stdIn.nextDouble();
    big.resize(bigRadius);

    double smallRadius;
    System.out.print("Enter the radius of small circle : ");
    smallRadius = stdIn.nextDouble();
    small.resize(smallRadius);

    System.out.println("");
    System.out.print("Big : ");
    big.print();

    System.out.println("");
    System.out.print("Small : ");
    small.print();

    System.out.println("");
    if (big.equals(small))
      System.out.println(" big equals small ");
    else
      System.out.println(" big does not equals small ");

    System.out.println("");
    Circle bigCopy = new Circle(big);    
    System.out.print("BigCopy : ");
    bigCopy.print();

    System.out.println("");
    if (bigCopy.equals(big))
      System.out.println("- bigCopy equals big (the copy constructor works) ");
    else
      System.out.println("- bigCopy does not equals big (copy constructor is broken ...) ");
  
    System.out.println("Now we change the copy and check that they are two different object");
    bigCopy.resize(10);
    System.out.println("");
    if (bigCopy.equals(big))
      System.out.println("- bigCopy equals big (They are pointing to the same thing!! ) ");
    else
      System.out.println("- bigCopy does not equals big (These objects are pointing to different places) ");
    
    System.out.println("\nCircle count: " + Circle.getCount());  
    System.out.println("Count changed to 12");
    Circle.setCount(12);
    System.out.println("Confirm count change: " + Circle.getCount()); 
    
    stdIn.close();
    
  }
}

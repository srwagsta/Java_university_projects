public class Driver
{
  public static void main(String[] args)
  {
    MyInteger num1 = new MyInteger();
    System.out.println("num1 = " + num1);
    num1 = new MyInteger(-4);
    MyInteger num2 = new MyInteger(8);

    MyDouble val1 = new MyDouble();
    System.out.println("val1 = " + val1);
    val1 = new MyDouble(2.4);
    MyDouble val2 = new MyDouble(3.6);

    System.out.println("num1 = " + num1);
    System.out.println("num2 = " + num2);
    System.out.println("val1 = " + val1);
    System.out.println("val2 = " + val2);

    Number gen1 = num2.division(num1);
    Number gen2 = num1.division(val1);
    Number gen3 = val1.division(num1);
    Number gen4 = val2.division(val1);

    System.out.println("gen1 = " + gen1);
    System.out.println("gen2 = " + gen2);
    System.out.println("gen3 = " + gen3);
    System.out.println("gen4 = " + gen4);
  }
}

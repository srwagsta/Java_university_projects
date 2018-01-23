public class MyDouble extends Number
{
  private double data;
  
  public MyDouble()
  {
    super();
  }

  public MyDouble(double value)
  {
    super();
    this.setData(value);
  }
  
  protected void setData(double value)
  {
    this.data = value;
    super.setSet(true);
  }
  
  public double getData()
  {
    return this.data;
  }
  
  public boolean equals(MyDouble guest)
  {
    return this.getData() == guest.getData();
  }

  public String toString()
  {
    if (isSet())
      return super.toString() + this.getData();
    else
      return super.toString();
  }

  public Number division(Number guest)
  {
    double val;

    if (guest instanceof MyInteger)
      val = this.getData() / ((MyInteger)guest).getData();
    else
      val = this.getData() / ((MyDouble)guest).getData();

    return new MyDouble(val);
  }
}

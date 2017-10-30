public abstract class Number
{
  public static final String unSet = "Undefined";
  private boolean set;

  public Number()
  {
  this.setSet(false);
  }

  protected final void setSet(boolean value)
  {
  this.set = value;
  }

  public final boolean isSet()
  {
  return this.set;
  }

  public boolean equals(Number guest)
  {
  return this == guest;
  }

  public String toString()
  {
    if (this.isSet())
      return "";
    else
      return Number.unSet;
  }

  public abstract Number division(Number guest);
}

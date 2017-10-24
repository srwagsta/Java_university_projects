
public class Student extends Person
{
  private double gpa;
  
  public Student()
  {
    super();
    this.setGPA(0);
  }

  public Student(String name, double gpa)
  {
    super(name);
    this.setGPA(gpa);
  }
  
  private void setGPA(double gpa)
  {
    this.gpa = gpa;
  }
  
  public double getGPA()
  {
    return this.gpa;
  }
  
  public String toString()
  {
    return super.toString() + " - GPA - " + this.getGPA();
  }
}

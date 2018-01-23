import java.util.ArrayList;

public class School
{
  private String name;
  private Principle principle;
  private ArrayList<Student> students;
  
  public School()
  {
    this("", "", 0.0);
  }
  
  public School(String sName, String pName, double salary)
  {
    this.setName(sName);
    this.principle = new Principle(pName, salary);
    this.students = new ArrayList<Student>();
  }
  
  private void setName(String name)
  {
    this.name = name;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void addStudent(Student student)
  {
    this.students.add(student);
  }
  
  public void schoolAudit()
  {
    System.out.println("School\'s Name: " + this.getName());
    System.out.println("\tPrinciple\'s Name: " + this.principle.toString());
    for ( Student student : students )
      System.out.println("\t\t" + student.toString());
  }
}

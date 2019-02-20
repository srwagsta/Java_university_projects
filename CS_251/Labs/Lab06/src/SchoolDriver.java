/**
 * @author wagstaff
 *
 */
public class SchoolDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		School east = new School("Somewhere East", "John Hawlks", 35000);
		School west = new School("Somewhere West", "Amy Hope", 48000);
		east.addStudent(new Student("Jimmy",3.5));
		west.addStudent(new Student("Billy",3.8));
		Student jenny = new Student("Jenny", 3.8);
		east.addStudent(jenny);
		west.addStudent(jenny);
		east.schoolAudit();
		System.out.println("\n");
		west.schoolAudit();
		
	}

}

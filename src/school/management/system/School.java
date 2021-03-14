package school.management.system;

import java.util.ArrayList;

/**
 * 
 * @author Biyas
 * school has many teachers and many students
 * create arraylist for teachers and students
 */
public class School {

	private ArrayList<Teacher> teachers = new ArrayList<Teacher>();
	private ArrayList<Student> students = new ArrayList<Student>();

	private static double totalMoneyEarned=0;
	private static double totalMoneySpent=0;
	
	public School(ArrayList<Teacher> teachers, ArrayList<Student> students) {
		this.teachers = teachers;
		this.students = students;
	}
/**
 * setter for teacher
 * @return list of teachers of the school
 */
	public ArrayList<Teacher> getTeacher() {
		return teachers;
	}
	
	/**
	 * 
	 * @param teacher add multiple teachers to school
	 */
	public void addTeacher(Teacher teacher) {
		teachers.add(teacher);
	}

	/**
	 * 
	 * @return  list of students of the school
	 */
	
	public ArrayList<Student> getStudent() {
		return students;
	}
 /**
  * 
  * @param student
  * add multiple students for the school
  */
	public void addStudent(Student student) {
		students.add(student);
	}

	public double getTotalMoneyEarned() {
		return totalMoneyEarned;
	}

	/**
	 * 
	 * @param MoneyEarned
	 * add the total money earned by the school
	 */
	
	public static void updateTotalMoneyEarned(double MoneyEarned) {
		totalMoneyEarned += MoneyEarned;
	}
/**
 * 
 * @return total money spent by the school
 */
	public double getTotalMoneySpent() {
		return totalMoneySpent;
	}

	/**
	 * 
	 * @param totalMoneySpent
	 * update the money spent by the school
	 * salary by the school to the teachers
	 */
	
	public static void updateTotalMoneySpent(double moneySpent) {
		totalMoneyEarned -= moneySpent;
	}
		
}

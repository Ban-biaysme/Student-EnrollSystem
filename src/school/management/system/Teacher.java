package school.management.system;
/**
 * 
 * School Management System
 * @author Biyas
 *This class is responsible to keep track of 
 *teacherID, teacherName and salary
 */

public class Teacher {

	private String teacherID;
	private String teacherName;
	private double teacherSalary;
	private double salaryEarned;
	/**
	 * 
	 * @param teacherID
	 * @param teacherName
	 * @param teacherSalary
	 */
	
	public Teacher(String teacherID, String teacherName, double teacherSalary) {
		this.teacherID =teacherID;
		this.teacherName = teacherName;
		this.teacherSalary = teacherSalary;
		this.salaryEarned=0;
	}
	
/**
 * 
 * @return teacherID, name and salary 
 */
	public String getTeacherID() {
		return teacherID;
	}

	public String getTeacherName() {
		return teacherName;
	}
	
	
	public double getTeacherSalary() {
		return teacherSalary;
	}
	
	public void setTeacherSalary(double teacherSalary) {
		this.teacherSalary = teacherSalary;
	}
	
	public void receiveSalary(double salary) {
		salaryEarned+=salary;
		School.updateTotalMoneySpent(salaryEarned);
	}
}

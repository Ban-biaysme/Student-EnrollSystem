package school.management.system;

/**
 * School Management System
 * @author Biyas
 * Student class is responsible to get student id, name, grade, fees paid and fees total.
 */
class Student {
	private String studentID;
	private String studentName;
	private int grade;
	private double feesPaid;
	private double feesTotal;
	
/**
 * 
 * @param studentID - Unique
 * @param studentName
 * @param grade
 * Fees for each student is $36000 per year
 * @param feesPaid
 * @param feesTotal
 */
	
	public Student(String studentID, String studentName, int grade) {
		this.studentID = studentID;
		this.studentName = studentName;
		this.grade = grade;
		this.feesPaid = 0;
		this.feesTotal = 36000;
	}
//student ID and Name will not chage.
// so no set method needed for ID and Name.
	
	public String getStudentID() {
		return studentID;
	}

	public String getStudentName() {
		return studentName;
	}
/**
 * 
 * @param grade new grade for a student
 * @param fees - keep adding fees to feesPaid
 * add the fees to feesPaid
 * update totalFees
 */
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public double feesPaid() {
		return feesPaid;
	}

	public void feesPaid(int fees) {
		feesPaid += fees;
		School.updateTotalMoneyEarned(feesPaid);
	}

	public double getFeesTotal() {
		return feesTotal;
	}

	public double getFeesPaid() {
		return feesPaid;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void setFeesTotal(double feesTotal) {
		this.feesTotal = feesTotal;
	}
	
	public double getRemainingFees(double fees) {
		return feesTotal-feesPaid;
	}
}

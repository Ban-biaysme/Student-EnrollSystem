package EnrollmentProcess;

public class Course {

	private String code;
	private String name;
		
	public Course(String code, String courseName) {	
		this.code=code;
		this.name = courseName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCourseName() {
		return name;
	}

	public void setCourseName(String courseName) {
		this.name = courseName;
	}	

	public String toString(){	
		return  code + " " + "\t" + name;				
	}
}
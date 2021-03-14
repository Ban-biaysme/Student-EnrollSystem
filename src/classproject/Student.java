package classproject;
import ecs100.UI;

public class Student {
	
	private String studentName;
	private static String  id;
	private String  studentType;
	double accomodationCost;
	private double courseCost; 
	
	//Student constructor
	public Student(String id, String name, String type, double courseCost) {
		
		this.studentName=name;
		Student.id=id;
		this.studentType=type;
		this.courseCost = courseCost;
		//this.accomodationCost = accomodationCost;
		
		if(this.studentType.equals("international")) {
			this.accomodationCost = 2500;
		}else if(this.studentType.equals("domestic")) {
			this.accomodationCost = 500;
		}else {
			UI.println("NO accomodation charges !!");
		}
	}
	 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		Student.id = id;
	}
	public String getName() {
		return studentName;
	}
	
	public void setName(String name) {
		this.studentName = name;
	}
	
	public String getStudentType() {		
		return studentType;		
	}
	
	public void setStudentType(String type) {
		this.studentType = type;
	}

	public double getCost() {
		return courseCost;
	}

	public void setCourseCost(double courseCost) {
		this.courseCost = courseCost;
	}	
			
}

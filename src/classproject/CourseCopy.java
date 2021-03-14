package classproject;
import java.util.ArrayList;
import ecs100.UI;

public class CourseCopy {
	//Declare variables
	private String courseName;
	private String courseID;
	private int coursePoints;
	private String lecturers;
	
	private ArrayList<Student> stdList= new ArrayList<Student>();
//	private ArrayList<Lecturers> lecList= new ArrayList<Lecturers>();
	
	
	//Constructor methods are used to build objects
	public CourseCopy(String courseID) {
		this.courseID=courseID;	
	}
	
	public String getCourseID() {
		return courseID;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}	
	
	public void enrollStudents(Student stu) {
		stdList.add(stu);	
	}
	
	public ArrayList<Student> getStudent(){
		return stdList;	
	}
	
	
	public void getCourseDetalis() {
		if(this.courseID.equalsIgnoreCase("SW501")) {
			courseName= "JAVA";
			coursePoints= 15;	
			lecturers= "Micheal";
			
		}
		else if(this.courseID.equalsIgnoreCase("SW502")) {
			courseName= "DATA STRUCTURE";
			coursePoints= 20;	
			lecturers= "Micheal";
			lecturers= "Ali";
			
		}else if(this.courseID.equalsIgnoreCase("SW503")) {
			courseName= "SECURITY";
			coursePoints= 30;
			lecturers= "Ali";
			lecturers= "Micheal";
		}
		else if(this.courseID.equalsIgnoreCase("SW504")) {
			courseName= "WEB APP";
			coursePoints= 40;
			lecturers= "Sadhia";
		}
		
		UI.println("COURSE ID :: " + this.getCourseID());
		UI.println("COURSE NAME :: " + courseName);
		UI.println("COURSE POINTS :: " + coursePoints);
		UI.println("LECTURER :: " + lecturers);
	}
	
}













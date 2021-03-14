package classproject;
import java.util.ArrayList;
import ecs100.UI;

public class Course {
	
	//Declare variables
	private String courseName;
	private String courseID;
	private int coursePoints;
	private double roomCost;
	
	private ArrayList<Student> stdList= new ArrayList<Student>();
	private ArrayList<Lecturer> lecList= new ArrayList<Lecturer>();
		
	//Constructor methods are used to build objects
	public Course(String courseID,String courseName, int coursePoints, double roomCost) {
		
		this.courseID=courseID;	
		this.courseName = courseName;
		this.coursePoints = coursePoints;
		this.roomCost = roomCost;
	}
	
	public String getCourseID() {
		return courseID;
	}
	
	public double getRoomCost() {
		return roomCost;
	}

	public void setRoomCost(double roomCost) {
		this.roomCost = roomCost;
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
	
	public void addLecturer(Lecturer l) {
		lecList.add(l);
	}
	
	public ArrayList<Student> getStudent(){
		return stdList;	
	}
	
	public ArrayList<Lecturer> getLecturers(){
		return lecList;	
	}
	
	public int getCoursePoints() {
		return coursePoints;
	}

	public void setCoursePoints(int coursePoints) {
		this.coursePoints = coursePoints;
	}

	public void getCourseDetalis() {
		UI.println("COURSE ID :: " + this.getCourseID());
		UI.println("COURSE NAME :: " + courseName);
		UI.println("COURSE POINTS :: " + coursePoints);
		UI.println("ROOM COST :: " + roomCost);
	}
	
}













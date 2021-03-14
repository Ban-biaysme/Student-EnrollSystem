package classproject;
import java.util.ArrayList;
import ecs100.UI;

public class MainClass {
	ArrayList<Course> crsList= new ArrayList<Course>();
	ArrayList<Department> departmentList= new ArrayList<Department>();
	
	public MainClass() {
		UI.initialise();
		UI.setDivider(1);
		UI.clearPanes();
		
		UI.addButton("ENTER COURSE ID ", this::addCourse);
		UI.addButton("DISPLAY COURSES", this::dispCourse);
		UI.addButton("ADD STUDENTS", this::addStudent);	
		UI.addButton("DISPLAY STUDENT", this::dispStudent);
		UI.addButton("ADD LECTURER", this::addLecturer);
		UI.addButton("DISPLAY LECTURER", this::dispLecturer);
		UI.addButton("DISPLAY DEPARTMENT", this::dispDepartment);
		UI.addButton("DISPLAY DEPARTMENT", this::calculateProfit);
		UI.addButton("Quit", UI::quit );	
	}
	
	public void addCourse() {
		String cID = UI.askString("Enter Course ID : SW501 / SW502/ SW503 / SW504::").toUpperCase().trim();
		if(cID.equals("SW501") || cID.equals("SW502") || cID.equals("SW503") || cID.equals("SW504")) {
			UI.println("Course added");
			
			String name= UI.askString("Enter course name:" );
			int points= UI.askInt("Enter course point: 15/ 20/ 30/ 40/ 45 / 60" );
				if(points== 15 || points== 20|| points== 30|| points== 40||points== 45 || points== 60) {
					double cost = UI.askDouble("Enter room cost:" );				
					Course cobj=new Course(cID, name, points, cost);
					crsList.add(cobj);
				}else {
					UI.println("Invalid Course point !!");
				}
			
		 }else {
			UI.println("Invalid Course ID !!");
		}
		
	}
	
	public void dispCourse() {
		UI.clearText();
		for(Course c:crsList) {
			c.getCourseDetalis();
			for(Lecturer l : c.getLecturers()) {
				UI.println("\t LECTURER NAME :: " + l.getLecturerName());
			}
		}
	}
	
	public void addStudent() {	
		double coursePrice=0;
		String reply= UI.askString("Do you want to enroll for the course- yes /no !!").toLowerCase();
		
		if(reply.equals("yes")){
			String cname= UI.askString("Enter the course name::");
			for(Course c:crsList) {				
				 if(c.getCourseName().equalsIgnoreCase(cname)) {
					String sID = UI.askString("Enter Student ID::").toLowerCase().trim();
					String sName = UI.askString("Enter Student Name::").toLowerCase().trim();
					String sType = UI.askString("Enter Student Type::international/ domestic/ fees free:: ").trim().toLowerCase();
					
					if(sType.contentEquals("international")) {
						coursePrice = 35000;
					}else if(sType.contentEquals("domestic")) {
						coursePrice = 14000;
					}else if(sType.contentEquals("fees-free")) {
						coursePrice = 5000;
					}else {
						UI.println("Invalid data");
					}
					//Add student to the students list in the course object				 
					 Student sobj = new Student(sID, sName, sType, coursePrice); 	
					 c.enrollStudents(sobj);
				  	}					
				}				
		}else {
			UI.quit();			
		}
	}	
	
	public void dispStudent() {
		
		for(Course c:crsList) {
			UI.println("Course ID :: "+ c.getCourseID());
			for(Student s: c.getStudent()) {
				UI.println("\t STUDENT NAME :: " + s.getName());
				UI.println("\t STUDENT ID:"+ s.getId());
				UI.println("\t STUDENT TYPE :" + s.getStudentType());
				UI.println("\t  ACCOMODATION COST: $"+ s.accomodationCost);
				UI.println("\t COURSE NAME :: " + c.getCourseName());
				UI.println("\t  COURSE COST : $" + s.getCost());				
				UI.println("\t  LECTURER NAME : $" + c.getLecturers());
			}
		}
	}
	
	
	public void addLecturer() {
		String cname= UI.askString("Enter the course name::");
		
		for(Course c:crsList) {				
			 if(c.getCourseName().equalsIgnoreCase(cname)) {
				 String lName = UI.askString("Enter Lecturer Name::").toLowerCase().trim(); 
				 double teachingCost = UI.askDouble("Enter the teaching cost : ");
				 int teachingDuration = UI.askInt("Enter the teaching duration : ");
				 
				 Lecturer lobj = new Lecturer(lName, teachingCost, teachingDuration);
				 c.addLecturer(lobj);
			 }
		}
	}
	
	public void dispLecturer() {
		for(Course c:crsList) {
			UI.println("Course ID :: "+ c.getCourseID());
			for(Lecturer l: c.getLecturers()) {
				UI.println("\t LECTURER NAME :: " + l.getLecturerName());
				UI.println("\t  TEACHING COST: $"+ l.getTeachingCost());
				UI.println("\t  TEACHING DURATION : $" + l.getTeachingDuration());
			}
		}
	}
	
	public void dispDepartment() {
		UI.clearText();
		Department dp=new Department();
		dp.getDepartment();
		departmentList.add(dp);
		for(Department d:departmentList) {
			d.getDepartment();
		}

	}
	
	
	public void calculateProfit() {
		double totalExpenditure =0;
		double roomCost=0;
		double courseCost =0;
		double teachingCost=0;
		double profit = 0;
		
		for(Course c:crsList) {
			for(Student s: c.getStudent()) {
				courseCost+= s.getCost();				
			}
			
		}
		
		for(Course c:crsList) {
			for(Lecturer l : c.getLecturers()) {
				teachingCost += l.getTeachingCost();
				roomCost += c.getRoomCost();
				totalExpenditure = totalExpenditure +(teachingCost + roomCost);
			}
		}
		
		profit =Math.abs(courseCost - totalExpenditure);
		UI.println("Total amount from  Course :: " + courseCost);
		UI.println("Total Expenditure::  " + totalExpenditure);
		UI.println("Profit ::  " + profit);
	}
	
	public static void main(String[] args) {
		new MainClass();
	}
}

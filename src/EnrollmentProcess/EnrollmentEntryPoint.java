package EnrollmentProcess;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import java.util.Scanner;
import ecs100.UI;

public class EnrollmentEntryPoint {
	
	Map<Integer, Student> students = new HashMap<>();	
	Map<String, Course> courses = new HashMap<>();
	
	Map<String, String> grade = new HashMap<>();
	ArrayList<PairStudent<String, String>> pairlist = new ArrayList<>();
	
	ArrayList<Student> orderedName = new ArrayList<>();
	ArrayList<Course> orderedCourses = new ArrayList<>();
	
	Scanner scan = new Scanner(System.in);
	
	public EnrollmentEntryPoint() {
		UI.initialise();
		UI.setDivider(1);
		UI.addButton("Clear",UI::clearText);
		UI.addButton("Load Data", this::loadDatabases);
		
		UI.addButton("Display Students", this::dispStudent);
		UI.addButton("Display Courses", this::dispCourses);
		UI.addButton("Search By Student ID" , this::searchStudentByID);
		UI.addButton("Display Students By course" , this::dispStudentByCourse);
		UI.addButton("Search Course" , this::searchCourseByName);
		UI.addButton("Search Student By Name" , this::searchStudentByName);
		UI.addButton("List Course details for a Student" , this::dispCourseForStudent);
		UI.addButton("Enroll a Student:", this::enrollStudent);
		UI.addButton("Get Student Grade:", this::getGrade);	
		UI.addButton("Sort Students:", this::sortStudents);	
		UI.addButton("Sort Courses:", this::sortCourses);
		UI.addButton("Show grades of all Students:", this::showGrades);
		UI.addButton("Add new course:", this::addNewCourse);
		UI.addButton("Pair Course and Students:", this::pairCourseStudents);
		UI.addButton("QUIT", UI::quit);	
	}
	
	public void loadDatabases() {
		File studentDb = new File("Students.txt");

		if (studentDb.exists()) {
			try {
				Scanner scan = new Scanner(studentDb);
				while (scan.hasNext()) {
					String sign = "-";
					String grade = null;
					String cname = null;

					String courseCode = scan.next();

					String gr = scan.next();

					if (gr.equals(sign)) {
						grade = "NIL";
					} else {
						grade = gr;
					}
					String stName = scan.nextLine().trim();

					if (courseCode.equalsIgnoreCase("COMP202")) {
						cname = "Computer Science";
					} else if (courseCode.equalsIgnoreCase("ENGL215")) {
						cname = "English";
					} else if (courseCode.equalsIgnoreCase("MATH324")) {
						cname = "Math";
					} else if (courseCode.equalsIgnoreCase("WRIT101")) {
						cname = "Writing";
					} else if (courseCode.equalsIgnoreCase("RELI226")) {
						cname = "Science";
					} else if (courseCode.equalsIgnoreCase("SPAN213")) {
						cname = "Spanish";
					}

					Course c = new Course(courseCode, cname);
					if (students.isEmpty()) {
						Student student = new Student(stName, grade, courseCode);
						orderedName.add(student);
						
						student.enroll(courseCode, c);
						students.put(student.getStID(), student);
					} else {
						int duplicateCout = 0;
						for (Student stu : students.values()) {
							if (stName.equals(stu.getName())) {
								stu.addGrade(courseCode, grade);
								stu.enroll(courseCode, c);
								duplicateCout++;
							}
						}

						if (duplicateCout == 0) {
							Student student = new Student(stName, grade, courseCode);							
							orderedName.add(student);
							student.enroll(courseCode, c);
							students.put(student.getStID(), student);
						}
					}

					courses.put(courseCode, c);	
					
				}
				UI.println("Data loaed from - " + studentDb + " to the Maps");
				scan.close();
			} catch (IOException e) {
				UI.println("Error: " + e);
			}

		} else {
			UI.println("Could not open" + studentDb);
		}
	}

	// Display Student from the Student Map.
	public void dispStudent() {
		UI.clearText();
		UI.setDivider(1);
		UI.println("\t Name\t\t -- Grade -- \t\t -- Course code ");
		UI.println("===========================================");

		for (Map.Entry<Integer, Student> e : students.entrySet()) {
			UI.println(e.getKey() + "--" + e.getValue());
		}
	}

	// Display Course to Course map
	public void dispCourses() {
		UI.setDivider(1);
		UI.clearText();
		UI.println("\t Course code \t  Course name ");
		UI.println("===========================================");

		for (Map.Entry<String, Course> e : courses.entrySet()) {
			UI.println(e.getKey() + "--" + e.getValue());
		}
	}


	// Search student by id
	public void searchStudentByID() {
		UI.setDivider(1);
		int id = UI.askInt("Enter Student ID :: ");

		for (Map.Entry<Integer, Student> s : students.entrySet()) {
			if ((s.getValue()).getStID() == id)
				UI.println("ID :: " + id + "\t Name : " + (s.getValue()).getName());
		}

	}
	
	//Display Students for a particular course	
	public void dispStudentByCourse() {
		UI.setDivider(1);
		String cid = UI.askString("Enter Course ID :: ");
		int ctr=0;
			
		for (Map.Entry<Integer, Student> m : students.entrySet()) {
			if (m.getValue().getCourse().containsKey(cid)) {
				ctr++;
				UI.println(m.getValue().getStID() + " -- " + m.getValue().getName());
			}
		}
			UI.println("Total number of Students enroll for - " + cid + " is :: " +ctr);
	}
	
	// Search course by name
	public void searchCourseByName() {
		UI.setDivider(1);		
		String userInput = UI.askString("Enter Course name :: ");
		
		for (Map.Entry<String, Course> m : courses.entrySet()) {
			if ((m.getValue()).getCourseName().equalsIgnoreCase(userInput))
				UI.println(m.getValue().getCourseName() +  "--" + m );
		}

	}
	
	
	// Search student details by  student name
	public void searchStudentByName() {
		UI.setDivider(1);
		String userInput = UI.askString("Enter Student name :");

		for (Map.Entry<Integer, Student> m : students.entrySet()) {
			if ((m.getValue()).getName().equalsIgnoreCase(userInput)) {
				//grade = m.getValue().getEnrollgrade();
			UI.println("Name : " + m.getValue().getName());
			UI.println("Grade :" + m.getValue().getEnrollgrade());
			}
		}

	}
	
	// Search course details for a particular student
	public void dispCourseForStudent() {
		UI.setDivider(1);
		String stName = UI.askString("Enter Student name :");

		for (Map.Entry<Integer, Student> m : students.entrySet()) {
			if (m.getValue().getName().equalsIgnoreCase(stName)) {
				Map<String, Course> courses = m.getValue().getCourse();
				for (Course c : courses.values()) {
					UI.println(c);
				}
			}
		}
	}
	
	//Enroll a Student
	public void enrollStudent() {
		UI.setDivider(1);
		int stuID = UI.askInt("Enter student ID to enroll :: ");		
		String courseCode = UI.askString("Enter course code to enroll: ");

		Student stu = students.get(stuID);
		Course co = courses.get(courseCode);
		
		if(!courses.containsKey(courseCode)) {
			UI.println("Course does not exist");
			return;
		}	
		
		if(!students.containsKey(stuID)) {
			UI.println("Course does not exist");
			return;
		}
		
		stu.enroll(courseCode, co);
		
		UI.println(stu.getInfo());
	}
	
	//Add new Course 
	public void addNewCourse() {
		UI.setDivider(1);
		
		String cid = UI.askString("Enter Course code :: ");
			if(courses.containsKey(cid)) {
				UI.println("Course already exist");
				return;
			}

				String name = UI.askString("Enter course name :: ");
				Course c1= new Course(cid, name);
				courses.put(cid,c1);

		UI.println("Course added to the list");
		dispCourses();
	}
	
	
	//Grade Student
	public void getGrade() {
		
		UI.setDivider(1);
		int stuID = UI.askInt("Enter student ID to grade :: ");
		String cCode = UI.askString("Enter course code to grade: ");

		for (Student stu : students.values()) {
			if (stuID == stu.getStID()) {
				for(Course c: courses.values()) {
					if(c.getCode().equalsIgnoreCase(cCode)) {
						UI.println(cCode + " --> " + stu.getEnrollgrade().get(cCode));						
						}
					}
				}
				
			}
		}

	//Display Students in order
	
	public void sortStudents() {
		CpmparatorStudentName cs = new CpmparatorStudentName();
		Collections.sort(orderedName, cs);

		UI.println("Students Names in order");

		for (Student s : orderedName) {
			UI.println("ID : " + s.getStID() + " " + "--" + s.getName());
		}
	}

	//Add course to the array list
	public void addCourses() {
		for (Map.Entry<String, Course> m : courses.entrySet()) {
			 Course c = new Course(m.getValue().getCode(), m.getValue().getCourseName());
			 orderedCourses.add(c);
		}
	}
	
	//Display courses in order	
	public void sortCourses() {
		addCourses();
		ComparatorCourseName cc= new ComparatorCourseName();
		Collections.sort(orderedCourses,cc);
		UI.println("---Course Name in Order---");
		
		for (Course c : orderedCourses) {
			UI.println("Code : " + c.getCode() + " " + "--" + c.getCourseName());
		}
		
		//following code will clear the list after display 
		//orderedCourses.clear();
	}
	
	//Show all student grade for a course	
	public void showGrades() {
		UI.setDivider(1);
		String cid = UI.askString("Enter Course ID :: ");
		int ctr=0;
			
		for (Map.Entry<Integer, Student> m : students.entrySet()) {
			if (m.getValue().getCourse().containsKey(cid)) {				
				grade = m.getValue().getEnrollgrade();
				UI.println(m.getValue().getName() + "  -->  " + grade.get(cid));
				if(!(grade.get(cid).equalsIgnoreCase("NIL"))) {
					ctr++;
				}
			}
		}
			UI.println("Total number of Students enroll for - " + cid + " is :: " + ctr);
	}
	

	//pair course and students
	public void pairCourseStudents() {
		for (Map.Entry<Integer, Student> m : students.entrySet()) {			
				for (Course c : courses.values()) {
					pairlist.add(new PairStudent<String, String>(m.getValue().getName(), c.getCourseName()));
				}
		}
		
		UI.println("Pair value of  Student and courses");		
		for(PairStudent<String, String> p: pairlist) {
			UI.println(p.getD1() +" : "+p.getD2());
		}

	}
	
	
	public static void main(String[] args) {
		new EnrollmentEntryPoint();
	}

}

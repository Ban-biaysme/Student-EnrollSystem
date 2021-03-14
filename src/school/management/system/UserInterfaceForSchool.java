package school.management.system;
import java.util.ArrayList;

import ecs100.UI;

public class UserInterfaceForSchool {
	
	private ArrayList<Teacher> teachers = new ArrayList<Teacher>();
	private ArrayList<Student> students = new ArrayList<Student>();

	
	public UserInterfaceForSchool() {
		UI.initialise();
		UI.setDivider(1);
		UI.clearPanes();
		
		UI.addButton("ADD TEACHER ", this::addTeacher);
		UI.addButton("ADD STUDENTS", this::addStudent);
		
		UI.addButton("DISPLAY TEACHERS", this::dispTeachers);			
		UI.addButton("DISPLAY STUDENT", this::dispStudent);
		UI.addButton("TOTAL MONEY EARNED", this::totalMoneyEarned);
		UI.addButton("TOTAL MONEY SPENT", this::totalMoneySpent);
//		UI.addButton("DISPLAY DEPARTMENT", this::calculateProfit);
		UI.addButton("Quit", UI::quit );	
	}
	
	public void addTeacher() {
		Teacher t1= new Teacher("T001", "Michael", 1000);		
		Teacher t2= new Teacher("T002", "Ali", 900);
		Teacher t3= new Teacher("T003", "Chathura", 700);
		teachers.add(t1);
		teachers.add(t2);
		teachers.add(t3);
		
		UI.println("Teacher added to the list");
		UI.println("=======================");
		School s= new School(teachers,students);
		t1.receiveSalary(t1.getTeacherSalary());
		t2.receiveSalary(t2.getTeacherSalary());
	}
	
	public void addStudent() {
		Student t1= new Student("S001", "Biyas", 4);
		Student t2= new Student("S002", "James", 9);
		Student t3= new Student("S003", "Reuben", 4);
		students.add(t1);
		students.add(t2);
		students.add(t3);
		
		t1.feesPaid(5000);
		t2.feesPaid(6000);
		t3.feesPaid(7000);
		
		UI.println("Student added to the list");
		UI.println("=======================");
		School s= new School(teachers,students);
	}
	
	
	public void dispTeachers() {
		UI.println("ID\tName\tSalary");
		UI.println("=======================");
		for(Teacher t: teachers) {
			UI.println(t.getTeacherID() + "\t" + t.getTeacherName()+"\t\t"+ t.getTeacherSalary()+ "\n");
		}
	}
	
	
	public void dispStudent() {
		UI.println("ID\t Name\tGrade");
		UI.println("=======================");
		for(Student s: students) {
			UI.println(s.getStudentID()+ "\t" + s.getStudentName()+"\t\t"+ s.getGrade()+"\t" + s.getFeesPaid()+ "\n");
		}
	}
	
	public void totalMoneyEarned() {
		School s= new School(teachers,students);
		UI.println("Total money earned :: " + s.getTotalMoneyEarned());
		
	}
	
	public void totalMoneySpent() {
		School s= new School(teachers,students);
		UI.println("Total money Spent :: " + s.getTotalMoneySpent());
	}
	
	public static void main(String[] args) {
		new UserInterfaceForSchool();
	}
}

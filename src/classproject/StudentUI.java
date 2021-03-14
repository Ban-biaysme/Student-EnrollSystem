package classproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import ecs100.UI;

public class StudentUI {
	
	// Add your fields here - you will need some ArrayLists
	private ArrayList<String> names = new ArrayList<String>();
	private ArrayList<String> course = new ArrayList<String>();
	private ArrayList<Integer> points = new ArrayList<Integer>();
	private ArrayList<String> city = new ArrayList<String>();
	private ArrayList<Integer> height = new ArrayList<Integer>(); 		// for loadNamePlace method

	
	public StudentUI() {
		UI.initialise();
		UI.addButton("Display Student", this::displayStudents);
		UI.addButton("Display Courses", this::displayCourse);
		UI.addButton("Display Courses by points", this::listPoints);
		UI.addButton("Display city", this::displayCity);	
		UI.addButton("List Courses by points", this::listPoints);

		loadDatabase();

	}
	
	public void loadDatabase() {
		// open names-db.txt
				File namesDb = new File("studentlist.txt");
				if (namesDb.exists()) {			
					try {
						Scanner scan = new Scanner(namesDb);
						while (scan.hasNext()) {			
							String name = scan.nextLine();
							name = name.trim(); 
							this.names.add(name);
							
							String course = scan.nextLine();
							course = course.trim(); 
							this.course.add(course);
							
							
							int points= scan.nextInt();
							scan.nextLine();
							this.points.add(points);
							
							//scan.nextLine();
							String city = scan.nextLine();
							city = city.trim(); 
							this.city.add(city);
							
							
							int height = scan.nextInt();
							scan.nextLine();
							this.height.add(height);
							
						}
						scan.close();					
						UI.printf("Imported %d names.%n", this.names.size());
						for (int i=0; i<this.names.size(); i++) {					
							UI.printf("%s%n", this.names.get(i));					
						}
						
					} catch (IOException e) {
						UI.println("Error: " + e);
					}
				} else {
					UI.printf("Could not open %s%n", namesDb);
				}

	
	}

	public void displayStudents() {
		UI.clearText();
		UI.printf("Imported %d names.%n", this.names.size());
		
		for (int i=0; i<this.names.size(); i++) {				
			UI.printf("%s%n", this.names.get(i));					
		}
		
	}
	
	public void displayCity() {
		UI.clearText();
		UI.printf("Imported %d city.%n", this.city.size());
		
		for (int i=0; i<this.city.size(); i++) {				
			UI.printf("%s%n", this.city.get(i));					
		}
	}
	
	public void displayCourse() {
		String course = UI.askString("Which Course?");	
		String name = "";
		int ind = course.indexOf(course);
		// if the index has not changed, terminate function.
		if (ind == -1) {
			// loop through and check if any of the entries contain the searched name
			// got to do the lowercase thing!!
			for (int i=0; i<this.course.size(); i++) {				
				if (this.course.get(i).toLowerCase().contains(course.toLowerCase())) {
					ind = i;
					course = this.course.get(i);
					UI.printf("course %s", course , " Found" );
					break; 
				}
			}

			// if the index has not changed, terminate function.
			if (ind == -1) {
				UI.printf("Could not find \"%s\" in the list.%n", course);
				return;
			}
		}
		
		
	}
	
	public void listPoints() {
//		String course = UI.askString("Which Course?");
//		String points = UI.askString("Which points?");
	}
	
	public static void main(String[] args) {
		new StudentUI();
	}
}


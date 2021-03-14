package classproject;

import java.util.ArrayList;

import ecs100.UI;

public class Department {

	private ArrayList<String> departmentName= new ArrayList<String>();
	
	public Department() {
		this .departmentName.add("SoftwareDevelopment");
		this .departmentName.add("UX-UI");
		this .departmentName.add("BusinessAnalysis");
		UI.println("Departments:: "+ this.departmentName);
	}
	
	public ArrayList<String> getDepartment(){
		return departmentName;	
	}

}

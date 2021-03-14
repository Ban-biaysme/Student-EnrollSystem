package EnrollmentProcess;

import java.util.HashMap;
import java.util.Map;

public class Student {

	private int id;
	private String name;
	protected static int IDcnt = 1000000;

	Map<String, Course> course = new HashMap<>();
	Map<String, String> enrollgrade = new HashMap<>();

	public Student(String name, String gr, String cid) {
		this.name = name;
		this.id = IDcnt++;
		enrollgrade.put(cid, gr);
	}
	
	public Student(int id, String  name, String cid) {
		this.id=id;
		this.name=name;
	}

	public int getStID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return  this.id + "\t"  + this.name + "\t\t" +  this.getEnrollgrade();
	}

	public Map<String, Course> getCourse() {
		return course;
	}

	public void enroll(String code, Course c) {
		course.put(code, c);
	}
	
	public Map<String, String> getEnrollgrade() {
		return  enrollgrade;
	}
	
	public void addGrade(String code, String grade) {
		enrollgrade.put(code, grade);
	}
	
	public String getInfo() {	
		String ret = name + " (" + id + ")";
		for (String code : enrollgrade.keySet()) {
			ret = ret + "\n" + enrollgrade.get(code) + "\t" + code;
		}
		return ret;
	}

}
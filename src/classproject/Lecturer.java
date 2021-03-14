package classproject;

public class Lecturer {
	
	private String lecturerName;	
	private double teachingCost;	
	private int teachingDuration;
	
	public Lecturer(String lecturerName, double teachingCost, int teachingDuration) {
		
		this.lecturerName =lecturerName;
		this.teachingCost = teachingCost;
		this.teachingDuration = teachingDuration;
	}

	public String getLecturerName() {
		return lecturerName;
	}

	public void setLecturerName(String lecturerName) {
		this.lecturerName = lecturerName;
	}

	public double getTeachingCost() {
		return teachingCost;
	}

	public void setTeachingCost(double teachingCost) {
		this.teachingCost = teachingCost;
	}

	public double getTeachingDuration() {
		return teachingDuration;
	}

	public void setTeachingDuration(int teachingDuration) {
		this.teachingDuration = teachingDuration;
	}
	
//	public void dispLecturer() {
//		UI.println("\t LECTURER NAME :: " + this.getLecturerName());
//	}
	
	
}

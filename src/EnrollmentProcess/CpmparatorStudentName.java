package EnrollmentProcess;
import java.util.Comparator;
import ecs100.UI;

public class CpmparatorStudentName implements Comparator<Student>{

	String order=null;
	
	public CpmparatorStudentName() {
		order= UI.askString("Enter which order you want to  display the bugs \n"
				+ " A for ascending and D for Decending order  : ");
		
	}
	@Override
	public int compare(Student s1, Student s2) {
		if(order.equalsIgnoreCase("A")) {
			return s1.getName().compareToIgnoreCase(s2.getName());
		}else if(order.equalsIgnoreCase("D")){
			return s2.getName().compareToIgnoreCase(s1.getName());
		}else {
			return 0;
		}
	}

}

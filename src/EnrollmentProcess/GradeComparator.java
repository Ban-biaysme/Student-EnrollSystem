package EnrollmentProcess;

import java.util.Comparator;

public class GradeComparator  implements Comparator<PairStudent<Student, Course>>{
	@Override
	public int compare(PairStudent<Student, Course> o1, PairStudent<Student, Course> o2) {
		return o1.getD1().getName().compareToIgnoreCase(o2.getD2().getCourseName());		
	}	

}

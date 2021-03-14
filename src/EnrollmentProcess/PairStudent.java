package EnrollmentProcess;

public class PairStudent<T1,T2>{

	T1 d1;
	T2 d2;
		
	public PairStudent(T1 d1, T2 d2) {
		this.d1= d1;
		this.d2=d2;
	}

	public T1 getD1() {
		return d1;
	}

	public void setD1(T1 d1) {
		this.d1 = d1;
	}

	public T2 getD2() {
		return d2;
	}

	public void setD2(T2 d2) {
		this.d2 = d2;
	}
	
	public String toString(){	
		return d1.toString() + " " + d2.toString();			
	}
	
}

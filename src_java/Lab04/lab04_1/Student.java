
public class Student {
	//이름, 학번, 소속 학과, 학년, 이수 학점 수
	private String name, snum, major;
	private int grade, credit;
	
	//접근자
	public String getName(){ return name; }
	public String getSnum(){ return snum; }
	public String getMajor(){ return major; }
	public int getGrade(){ return grade; }
	public int getCredit(){ return credit; }
	
	//설정자
	public void setName(String name) {this.name=name;}
	public void setSnum(String snum) {this.snum=snum;}
	public void setMajor(String major) {this.major=major;}
	public void setGrade(int grade) {this.grade=grade;}
	public void setCredit(int credit) {this.credit=credit;}
	
	//입력 함수
	public void setter(String name, String snum, String major, int grade, int credit) {
		setName(name);
		setSnum(snum);
		setMajor(major);
		setGrade(grade);
		setCredit(credit);
	}
	
	//출력함수
	public void print() {
		System.out.println("-----------------------------------------------------");
		System.out.println("이름: "+getName());
		System.out.println("학번: "+getSnum());
		System.out.println("소속 학과: "+getMajor());
		System.out.println("학년: "+getGrade());
		System.out.println("이수 학점 수: "+getCredit());
	}


}

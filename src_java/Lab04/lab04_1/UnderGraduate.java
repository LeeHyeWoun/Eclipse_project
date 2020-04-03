
public class UnderGraduate extends Student {
	//소속 동아리명
	private String club;
	
	//접근자
	public String getClub(){ return club; }
	
	//설정자
	public void setClub(String club) {this.club=club;}
	
	//입력 함수...오버로딩
	public void setter(String name, String snum, String major, int grade, int credit, String club) {
		setter(name, snum, major, grade, credit);
		setClub(club);
	}
	
	//출력함수...오버라이딩
	public void print() {
		super.print();//보모 클래스의 print 메소드 출력
		System.out.println("소속 동아리명: "+getClub());
		System.out.println("-----------------------------------------------------");
	}
}

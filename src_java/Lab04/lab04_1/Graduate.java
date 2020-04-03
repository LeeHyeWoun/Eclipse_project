
public class Graduate extends Student {
	//조교 유형과 장학금 비율
	private String assistant;
	private double srate;

	//생성자
	public String getAssistant(){ return assistant; }
	public double getSrate(){ return srate; }
	
	//설정자
	public void setAssistant(String assistant) {this.assistant=assistant;}
	public void setSrate(double srate) {this.srate=srate;}

	//입력 함수...오버로딩
	public void setter(String name, String snum, String major, int grade, int credit, String assistant, double srate) {
		setter(name, snum, major, grade, credit);
		setAssistant(assistant);
		setSrate(srate);
	}
	
	//출력함수...오버라이딩
	public void print() {
		super.print();//보모 클래스의 print 메소드 출력
		System.out.println("조교 유형: "+getAssistant());
		System.out.println("장학금 비율: "+getSrate());
		System.out.println("-----------------------------------------------------");
	}

}

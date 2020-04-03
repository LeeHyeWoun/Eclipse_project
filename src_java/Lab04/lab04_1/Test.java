
public class Test {
	static public void main(String args[]) {
		//객체 생성
		UnderGraduate ungStudent = new UnderGraduate();
		Graduate gStudent = new Graduate();
		
		//내용 입력
		ungStudent.setter("학부생a", "2017111000", "디지털미디어", 2, 12, "ab동아리");
		gStudent.setter("대학원생b", "2014111000", "컴퓨터", 1, 6, "a유형", 0.25);
		
		//출력...다형성
		ungStudent.print();
		gStudent.print();
	}
}

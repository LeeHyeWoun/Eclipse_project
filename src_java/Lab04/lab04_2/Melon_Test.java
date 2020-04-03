
public class Melon_Test {
	static public void main(String args[]) {
		//객체 생성
		Melon melon = new Melon();
		
		//값 입력
		melon.setCal(38);
		melon.setCost(20000);
		melon.setKg(8);
		melon.setInfo("abc농원");
		
		//출력
		System.out.println(melon.toString());
	}
}

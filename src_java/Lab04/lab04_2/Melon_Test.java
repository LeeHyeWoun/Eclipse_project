
public class Melon_Test {
	static public void main(String args[]) {
		//��ü ����
		Melon melon = new Melon();
		
		//�� �Է�
		melon.setCal(38);
		melon.setCost(20000);
		melon.setKg(8);
		melon.setInfo("abc���");
		
		//���
		System.out.println(melon.toString());
	}
}


public class UnderGraduate extends Student {
	//�Ҽ� ���Ƹ���
	private String club;
	
	//������
	public String getClub(){ return club; }
	
	//������
	public void setClub(String club) {this.club=club;}
	
	//�Է� �Լ�...�����ε�
	public void setter(String name, String snum, String major, int grade, int credit, String club) {
		setter(name, snum, major, grade, credit);
		setClub(club);
	}
	
	//����Լ�...�������̵�
	public void print() {
		super.print();//���� Ŭ������ print �޼ҵ� ���
		System.out.println("�Ҽ� ���Ƹ���: "+getClub());
		System.out.println("-----------------------------------------------------");
	}
}

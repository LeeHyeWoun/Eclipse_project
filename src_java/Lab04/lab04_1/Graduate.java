
public class Graduate extends Student {
	//���� ������ ���б� ����
	private String assistant;
	private double srate;

	//������
	public String getAssistant(){ return assistant; }
	public double getSrate(){ return srate; }
	
	//������
	public void setAssistant(String assistant) {this.assistant=assistant;}
	public void setSrate(double srate) {this.srate=srate;}

	//�Է� �Լ�...�����ε�
	public void setter(String name, String snum, String major, int grade, int credit, String assistant, double srate) {
		setter(name, snum, major, grade, credit);
		setAssistant(assistant);
		setSrate(srate);
	}
	
	//����Լ�...�������̵�
	public void print() {
		super.print();//���� Ŭ������ print �޼ҵ� ���
		System.out.println("���� ����: "+getAssistant());
		System.out.println("���б� ����: "+getSrate());
		System.out.println("-----------------------------------------------------");
	}

}

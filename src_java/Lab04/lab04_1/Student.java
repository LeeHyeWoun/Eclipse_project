
public class Student {
	//�̸�, �й�, �Ҽ� �а�, �г�, �̼� ���� ��
	private String name, snum, major;
	private int grade, credit;
	
	//������
	public String getName(){ return name; }
	public String getSnum(){ return snum; }
	public String getMajor(){ return major; }
	public int getGrade(){ return grade; }
	public int getCredit(){ return credit; }
	
	//������
	public void setName(String name) {this.name=name;}
	public void setSnum(String snum) {this.snum=snum;}
	public void setMajor(String major) {this.major=major;}
	public void setGrade(int grade) {this.grade=grade;}
	public void setCredit(int credit) {this.credit=credit;}
	
	//�Է� �Լ�
	public void setter(String name, String snum, String major, int grade, int credit) {
		setName(name);
		setSnum(snum);
		setMajor(major);
		setGrade(grade);
		setCredit(credit);
	}
	
	//����Լ�
	public void print() {
		System.out.println("-----------------------------------------------------");
		System.out.println("�̸�: "+getName());
		System.out.println("�й�: "+getSnum());
		System.out.println("�Ҽ� �а�: "+getMajor());
		System.out.println("�г�: "+getGrade());
		System.out.println("�̼� ���� ��: "+getCredit());
	}


}

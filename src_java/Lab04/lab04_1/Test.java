
public class Test {
	static public void main(String args[]) {
		//��ü ����
		UnderGraduate ungStudent = new UnderGraduate();
		Graduate gStudent = new Graduate();
		
		//���� �Է�
		ungStudent.setter("�кλ�a", "2017111000", "�����й̵��", 2, 12, "ab���Ƹ�");
		gStudent.setter("���п���b", "2014111000", "��ǻ��", 1, 6, "a����", 0.25);
		
		//���...������
		ungStudent.print();
		gStudent.print();
	}
}

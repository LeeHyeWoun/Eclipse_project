
public class Melon extends Food {
	//���� ���
	private String info;
	
	//������
	public String getInfo() {return info;};
	
	//������
	public void setInfo(String info) {this.info=info;};
	
	//�޼ҵ�
	public String toString() {return "����� Į�θ��� "+getCal()+"\n������"+getCost()+"\n�߷��� "+getKg()+"\n���� ��� ������ "+getInfo();};
}

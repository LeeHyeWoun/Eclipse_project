
import java.util.Scanner; // Scanner Ŭ���� ����...�Է��� ����

public class Lab02 {
	public static void main(String[] args) {
		
		Scanner input = new Scanner (System.in); // ScannerŬ������ ��ü input ���� ����
		
		int [] number = new int [10]; //10���� ������ ���� �迭
		int [] count = new int [10]; //1~10,11~20,...,91~100 10���� ���� ������ ���� ������ ������ �Է��� �迭
		
		//�Է�
		System.out.println("1���� 100������ ���� 10���� �Է��� �ּ���.");
		for(int i = 0; i<number.length; i++) { //for���� ���� 10���� ������ �Է¹޴´�.
			System.out.printf("%d��° ���� : ",i+1);
			number[i] = input.nextInt();
		}
		
		//���
		for(int i = 0; i<number.length; i++) { //number�迭��Ҹ� ���ʴ�� Ȯ���ϱ� ���� �ݺ��� 
			for(int j=0; j<count.length; j++) { //number[i]�� ���° ������ ���ϴ��� ���ʴ�� Ȯ���ϱ� ���� �ݺ���
				if ((int)((number[i]-1)/10) == j) {count[j]++;}
			}
		}
		
		//���
		System.out.println(); //�Է°� ��� ���� ���� ����
		for(int i=0; i<count.length; i++) {
			System.out.printf("%d~%d : ", i*10+1,(i+1)*10); //������ ���
			for(int j=0; j<count[i]; j++) { System.out.print('*'); } //for�ݺ������� count ����ŭ '*'�� ���
			System.out.println();// ���� �ٷ� �Ѿ��
		}
		
	}
}
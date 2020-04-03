import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener{
	//������Ʈ ����
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JTextField tField;
	private JButton[] buttons1;
	private JButton[] buttons2;
	//�迭 �� ���� �� �ʱ�ȭ
	private String[] lebels1 = {"Backspace","CE","C"};
	private String[] lebels2 = {
			"7","8","9","/","sqrt",
			"4","5","6","*","%",
			"1","2","3","-","1/x",
			"0","+/-",".","+","="
			};
	private float[] value = new float[50]; // �ǿ�����
	private String[] op = new String [50];//������

	
	//���� ���� �� �ʱ�ȭ
	private int index = 0;
	private int index2 = 0;
	private String lastValue = ""; 
	private String calculation ="";// textField�� ����� ��
	private float result = 0;
	
	public Calculator() {
		//��ü ����
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		tField = new JTextField(30);
		
		//�迭 ����
		buttons1 = new JButton[3];
		buttons2 = new JButton[20];
		
		//tField�� �Ӽ�
		tField.setText("0.");
		tField.setEditable(false);
		tField.setHorizontalAlignment(JTextField.RIGHT);

		
		//��ġ������ ����
		panel1.setLayout(new GridLayout(0,3,3,3));
		panel2.setLayout(new GridLayout(0,5,3,3));
		
		//
		for (int col =0; col<3; col++) {
			buttons1[index] = new JButton(lebels1[index]);
			buttons1[index].addActionListener(this);
			buttons1[index].setForeground(Color.red);
			panel1.add(buttons1[index]);
			index++;
		}

		//
		index = 0;
		for (int row =0; row<4; row++) {
			for (int col=0; col<5; col++) {
				buttons2[index] = new JButton(lebels2[index]);
				buttons2[index].addActionListener(this);
				panel2.add(buttons2[index]);
				if(col==3) {
					buttons2[index].setForeground(Color.red); }
				index++;
			}
		} buttons2[19].setForeground(Color.red);
		
		//����ϱ�
		add(tField,BorderLayout.NORTH);
		panel3.add(panel1,BorderLayout.NORTH);
		panel3.add(panel2,BorderLayout.CENTER);
		add(panel3,BorderLayout.CENTER);
		
		//â ����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("My Calculator");
		this.setSize(320,225);
		this.setVisible(true);
		
	}
	
	//�̺�Ʈ
	public void actionPerformed(ActionEvent e) {
		String bName =e.getActionCommand();
		if(bName.equals("CE")) { //���� ���⿡ ��Ÿ�� ���ڸ� �����.
			tField.setText("0.");
		}
		else if(bName.equals("C")) { //���� ��� ����� �����.
			tField.setText("0.");
			lastValue= "";
			calculation="";
			for(int i=0; i<50; i++) {
				value[i]=0;
				op[i]="";
			}
		}
		else if(bName.equals("=")) { //��� ��� ���
				//���
				operator();
				tField.setText(calculation);
				//�ʱ�ȭ
				result=0;
				lastValue= "";
				calculation="";
				for(int i=0; i<50; i++) {
					value[i]=0;
					op[i]="";
				}				
			}

		else {
			//C�� �� ��� Ű
			if(bName.equals("Backspace")) { //�� ������ ���� �����
				calculation = calculation.substring(0, calculation.length()-1);
			}
			
			// ���� �Է¿� ���� ����
			for(int i=0; i<10; i++) {
				String Si=Integer.toString(i);
				if( bName.equals(Si)) {
					calculation += i; //�Է��� ��ü ����...tField�� �����ش�.
					lastValue+= i; //���� �Է��� �ǿ�����
					value[index2] = Float.parseFloat(lastValue); //������ ���� �Ǽ��� ��ȯ
				}
			}
			
			if(bName.equals(".")){ //�Ҽ��� ���
				calculation += bName; //�Է��� ��ü ����...tField�� �����ش�.
				lastValue+= bName; //���� �Է��� �ǿ�����
			}
			
			// ��Ģ������
			if(bName.equals("/")||bName.equals("*")||bName.equals("+")||bName.equals("-")) {
				op[index2]=bName;//�����ڸ� �迭�� �Է�
				calculation += bName;//�Է��� ��ü ����...tField�� �����ش�.
				lastValue="";//���� �ǿ����ڸ� �ޱ����� ����
				index2++;
			}
			
			
			// ��Ÿ ������
			if(bName.equals("sqrt")||bName.equals("%")||bName.equals("1/x")||bName.equals("+/-")) {
				operator();
				switch(bName) {
				case "sqrt"://������ ���ϱ�
					result*=result;
					break;
				case "%"://�ۼ�Ʈ ���...100���� ���� �ֱ�
					result/=100;
					break;
				case "1/x"://���� ���
					result=1/result;
					break;
				case "+/-": //���� ������ ��ȣ �ٲٱ�
					result+=-1;
					break;
				}				
				calculation=Float.toString(result);
			}
			
						
			//�������� �����ش�.
			tField.setText(calculation);
		}
		
		
	}
	
	public void operator() {
		result = value[0];
		for(int i=1; i<= index2 ; i++) {
			if(op[i-1]!=null) {
				switch(op[i-1]) {
				case "/":
					result/=value[i];
					break;
				case "*":
					result*=value[i];
					break;
				case "-":
					result-=value[i];
					break;
				case "+":
					result+=value[i];
					break;
				}
			}
		}
		calculation =Float.toString(result);//��� ���
		index2 = 0;//�ʱ�ȭ
	}

	public static void main(String args[]) {
		@SuppressWarnings("unused")
		Calculator s = new Calculator();
	}

}

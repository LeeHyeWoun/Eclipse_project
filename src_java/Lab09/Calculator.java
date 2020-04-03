import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener{
	//컴포넌트 선언
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JTextField tField;
	private JButton[] buttons1;
	private JButton[] buttons2;
	//배열 및 선언 및 초기화
	private String[] lebels1 = {"Backspace","CE","C"};
	private String[] lebels2 = {
			"7","8","9","/","sqrt",
			"4","5","6","*","%",
			"1","2","3","-","1/x",
			"0","+/-",".","+","="
			};
	private float[] value = new float[50]; // 피연산자
	private String[] op = new String [50];//연산자

	
	//변수 선언 및 초기화
	private int index = 0;
	private int index2 = 0;
	private String lastValue = ""; 
	private String calculation ="";// textField에 출력할 값
	private float result = 0;
	
	public Calculator() {
		//객체 생성
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		tField = new JTextField(30);
		
		//배열 생성
		buttons1 = new JButton[3];
		buttons2 = new JButton[20];
		
		//tField의 속성
		tField.setText("0.");
		tField.setEditable(false);
		tField.setHorizontalAlignment(JTextField.RIGHT);

		
		//배치관리자 설정
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
		
		//등록하기
		add(tField,BorderLayout.NORTH);
		panel3.add(panel1,BorderLayout.NORTH);
		panel3.add(panel2,BorderLayout.CENTER);
		add(panel3,BorderLayout.CENTER);
		
		//창 설정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("My Calculator");
		this.setSize(320,225);
		this.setVisible(true);
		
	}
	
	//이벤트
	public void actionPerformed(ActionEvent e) {
		String bName =e.getActionCommand();
		if(bName.equals("CE")) { //현재 계산기에 나타난 숫자를 지운다.
			tField.setText("0.");
		}
		else if(bName.equals("C")) { //현재 계산 결과를 지운다.
			tField.setText("0.");
			lastValue= "";
			calculation="";
			for(int i=0; i<50; i++) {
				value[i]=0;
				op[i]="";
			}
		}
		else if(bName.equals("=")) { //계산 결과 출력
				//출력
				operator();
				tField.setText(calculation);
				//초기화
				result=0;
				lastValue= "";
				calculation="";
				for(int i=0; i<50; i++) {
					value[i]=0;
					op[i]="";
				}				
			}

		else {
			//C를 뺀 상단 키
			if(bName.equals("Backspace")) { //맨 마지막 문자 지우기
				calculation = calculation.substring(0, calculation.length()-1);
			}
			
			// 숫자 입력에 관한 구현
			for(int i=0; i<10; i++) {
				String Si=Integer.toString(i);
				if( bName.equals(Si)) {
					calculation += i; //입력한 전체 내용...tField에 보여준다.
					lastValue+= i; //새로 입력한 피연산자
					value[index2] = Float.parseFloat(lastValue); //연산을 위해 실수로 변환
				}
			}
			
			if(bName.equals(".")){ //소수점 찍기
				calculation += bName; //입력한 전체 내용...tField에 보여준다.
				lastValue+= bName; //새로 입력한 피연산자
			}
			
			// 사칙연산자
			if(bName.equals("/")||bName.equals("*")||bName.equals("+")||bName.equals("-")) {
				op[index2]=bName;//연산자를 배열에 입력
				calculation += bName;//입력한 전체 내용...tField에 보여준다.
				lastValue="";//다음 피연산자를 받기위해 리셋
				index2++;
			}
			
			
			// 기타 연산자
			if(bName.equals("sqrt")||bName.equals("%")||bName.equals("1/x")||bName.equals("+/-")) {
				operator();
				switch(bName) {
				case "sqrt"://제곱근 구하기
					result*=result;
					break;
				case "%"://퍼센트 계산...100으로 나눠 주기
					result/=100;
					break;
				case "1/x"://역수 계산
					result=1/result;
					break;
				case "+/-": //현재 숫자의 부호 바꾸기
					result+=-1;
					break;
				}				
				calculation=Float.toString(result);
			}
			
						
			//계산과정을 보여준다.
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
		calculation =Float.toString(result);//결과 출력
		index2 = 0;//초기화
	}

	public static void main(String args[]) {
		@SuppressWarnings("unused")
		Calculator s = new Calculator();
	}

}

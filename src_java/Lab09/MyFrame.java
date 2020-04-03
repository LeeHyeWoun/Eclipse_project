import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyPanel extends JPanel{
	//컴포넌트 선언
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JButton button1;
	private JButton button2;
	//변수 선언 및 초기화
	private int px=225;
	
	MyPanel(){
		//객체 생성
		panel1 =new JPanel();
		panel2 =new JPanel();
		panel3 =new JPanel();
		button1 =new JButton("왼쪽으로 움직이기");
		button2 =new JButton("오른쪽으로 움직이기");
		
        //panel1의 속성
        panel2.setLayout(null); //panel1을 자유롭게 움직이기 위해
        panel1.setSize(30,200);
        panel1.setLocation(px, 30);
        
        //배경색 설정
        panel1.setBackground(Color.RED);
        panel2.setBackground(Color.YELLOW);

        //버튼의 이벤트 처리...람다식
        //ActionListener는 함수 인터페이스이므로 람다식을 대입할 수 있습니다.
        button1.addActionListener((e)-> {
                if (e.getSource() == button1) { //“왼쪽으로 움직이기”를 눌렀을 때
                	px -= 5;//왼쪽으로 5만큼 움직이기
                	if(px<0) {px=0;}//0<=px<=450범위만 움직이기
                	panel1.setLocation(px, 30);
                }
        });           
        button2.addActionListener((e)-> {
                if (e.getSource() == button2) { //“왼쪽으로 움직이기”를 눌렀을 때
                	px += 5;//오른쪽으로 5만큼 움직이기
                	if(px>450) {px=455;}//0<=px<=455범위만 움직이기
                	panel1.setLocation(px, 30);
                }
        });
        //키 이벤트 처리...무명클래스 사용
        //KeyListener의 추상메소드 3개 중 하나만 사용할 것이므로 어댑터 클래스를 사용합니다.
        panel1.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyPressed	(KeyEvent e) {
        		switch(e.getKeyCode()) {
        		case KeyEvent.VK_LEFT:	px -= 5;	break;
        		case KeyEvent.VK_RIGHT:	px += 5;	break;
        		}//←키보드를 무르면 왼쪽으로 5만큼, →키보드를 누르면 오른쪽으로 5만큼 움직이기
        		if(px<0) {px=0;} else if(px>455) {px=455;}//0<=px<=455범위만 움직이기
        		panel1.setLocation(px, 30);
        	}
        });
        panel1.requestFocus();
        panel1.setFocusable(true);
        
        //마우스 이벤트 처리...무명클래스 사용
        //MouseMotionListener의 추상메소드 2개 중 하나만 사용할 것이므로 어댑터 클래스를 사용합니다.
        panel1.addMouseMotionListener(new MouseMotionAdapter() {
        	@Override
        	public void mouseDragged	(MouseEvent e) {
        		px += e.getX() -15;// -15는 마우스 위치가 기둥의 중앙에 오도록하기 위한 상수
        		if(px<0) {px=0;} else if(px>455) {px=455;}//0<=px<=455범위만 움직이도록
        		panel1.setLocation(px, 30);
        	}
        	
        });
        
        //배치관리자 설정
        this.setLayout(new BorderLayout());
        
        //등록시키기
        panel2.add(panel1);
        panel3.add(button1);
        panel3.add(button2);
        this.add(panel2, BorderLayout.CENTER);
        this.add(panel3, BorderLayout.PAGE_END);

		
	}
	
}

public class MyFrame extends JFrame{
	MyFrame(){
		add(new MyPanel());
		//창 설정
        this.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("박스 움직이기");
        this.setVisible(true);
	}
	public static void main(String[] arg) {
		new MyFrame();
	}
}

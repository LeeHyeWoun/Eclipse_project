import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyPanel extends JPanel{
	//������Ʈ ����
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JButton button1;
	private JButton button2;
	//���� ���� �� �ʱ�ȭ
	private int px=225;
	
	MyPanel(){
		//��ü ����
		panel1 =new JPanel();
		panel2 =new JPanel();
		panel3 =new JPanel();
		button1 =new JButton("�������� �����̱�");
		button2 =new JButton("���������� �����̱�");
		
        //panel1�� �Ӽ�
        panel2.setLayout(null); //panel1�� �����Ӱ� �����̱� ����
        panel1.setSize(30,200);
        panel1.setLocation(px, 30);
        
        //���� ����
        panel1.setBackground(Color.RED);
        panel2.setBackground(Color.YELLOW);

        //��ư�� �̺�Ʈ ó��...���ٽ�
        //ActionListener�� �Լ� �������̽��̹Ƿ� ���ٽ��� ������ �� �ֽ��ϴ�.
        button1.addActionListener((e)-> {
                if (e.getSource() == button1) { //���������� �����̱⡱�� ������ ��
                	px -= 5;//�������� 5��ŭ �����̱�
                	if(px<0) {px=0;}//0<=px<=450������ �����̱�
                	panel1.setLocation(px, 30);
                }
        });           
        button2.addActionListener((e)-> {
                if (e.getSource() == button2) { //���������� �����̱⡱�� ������ ��
                	px += 5;//���������� 5��ŭ �����̱�
                	if(px>450) {px=455;}//0<=px<=455������ �����̱�
                	panel1.setLocation(px, 30);
                }
        });
        //Ű �̺�Ʈ ó��...����Ŭ���� ���
        //KeyListener�� �߻�޼ҵ� 3�� �� �ϳ��� ����� ���̹Ƿ� ����� Ŭ������ ����մϴ�.
        panel1.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyPressed	(KeyEvent e) {
        		switch(e.getKeyCode()) {
        		case KeyEvent.VK_LEFT:	px -= 5;	break;
        		case KeyEvent.VK_RIGHT:	px += 5;	break;
        		}//��Ű���带 ������ �������� 5��ŭ, ��Ű���带 ������ ���������� 5��ŭ �����̱�
        		if(px<0) {px=0;} else if(px>455) {px=455;}//0<=px<=455������ �����̱�
        		panel1.setLocation(px, 30);
        	}
        });
        panel1.requestFocus();
        panel1.setFocusable(true);
        
        //���콺 �̺�Ʈ ó��...����Ŭ���� ���
        //MouseMotionListener�� �߻�޼ҵ� 2�� �� �ϳ��� ����� ���̹Ƿ� ����� Ŭ������ ����մϴ�.
        panel1.addMouseMotionListener(new MouseMotionAdapter() {
        	@Override
        	public void mouseDragged	(MouseEvent e) {
        		px += e.getX() -15;// -15�� ���콺 ��ġ�� ����� �߾ӿ� �������ϱ� ���� ���
        		if(px<0) {px=0;} else if(px>455) {px=455;}//0<=px<=455������ �����̵���
        		panel1.setLocation(px, 30);
        	}
        	
        });
        
        //��ġ������ ����
        this.setLayout(new BorderLayout());
        
        //��Ͻ�Ű��
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
		//â ����
        this.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("�ڽ� �����̱�");
        this.setVisible(true);
	}
	public static void main(String[] arg) {
		new MyFrame();
	}
}

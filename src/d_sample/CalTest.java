package d_sample;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalTest {
	// 1. 멤버변수
	JFrame f;
	JTextField tf;
	JButton[] bNum; // 0~9 숫자 표현할 버튼
	JButton[] bOp; // +, -, *, /
	JButton bEqual;
	
	int first, second;
	String op;

	// 2. 객체 생성
	CalTest() {
		f = new JFrame("유치원"); 
		tf = new JTextField();
		bNum = new JButton[10]; 	// 숫자를 넣어주는 객체 생성
		bOp = new JButton[4];		// 연산자를 넣어 주는 객체 생성
		bEqual = new JButton("=");	// =를 넣어주는 객체 생성

		for (int i = 0; i < bNum.length; i++) {
			bNum[i] = new JButton(String.valueOf(i)); //매개변수가 null이면 문자열null을 만들어 담는다.
		}
		String[] a = { "+", "-", "*", "/" };	//String[] a에 연산자를 담는다. 
		for (int i = 0; i < bOp.length; i++) {
			bOp[i] = new JButton(a[i]);

		}

	} // end of CalTest()

	// 3. 화면구성및 화면 출력
	void addLayout() {

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(5, 3));	// GridLayout(5, 3) -> 가로 칸수, 세로 칸수
		
		for (int i = 1; i < bNum.length; i++) {
			buttonPanel.add(bNum[i]);
		}

		buttonPanel.add(bOp[0]); 	// "+"		- 순서대로 넣어준다.
		buttonPanel.add(bNum[0]); 	// "0"
		buttonPanel.add(bEqual); 	// "="
		buttonPanel.add(bOp[1]); 	// "-"
		buttonPanel.add(bOp[2]); 	// "*"
		buttonPanel.add(bOp[3]); 	// "/"
		
//		f.setBounds(300, 90, 270, 235);		// setBounds() 메서드를 사용하여 절대 위치와 크기 지정 - setBounds(x, y, w, h);
		f.setLayout(new BorderLayout());	//생성한 JButton을 BorderLayout을 이용해서 각 위치에 배치합니다.
		f.add(tf, BorderLayout.NORTH);
		f.add(buttonPanel, BorderLayout.CENTER);

//		f.setTitle("유치원");
		f.setVisible(true);
		f.setSize(300, 370);	// 계산기의 크기 지정
		f.setLocationRelativeTo(null); // 화면의 가운데에 띄움
		f.setResizable(false); // 사이즈조절 불가능
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫을 때 실행 중인 프로그램도 같이 종료되도록 함
	}

	// 4. 이벤트 처리
	void eventProc() {
		// 숫자버튼이 눌렸을때
		for (int i = 0; i < bNum.length; i++) { 
			bNum[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 이벤트가 발생한 컴포넌트의 참조를 얻어옴
					JButton eBtn = (JButton) e.getSource();
					String su = eBtn.getText();
					tf.setText(tf.getText()+su);
			
				}
			});
		}
		// 연산자 버튼이 눌렸을때
		for (int i = 0; i < bOp.length; i++) {
			bOp[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					JButton eBtn = (JButton) e.getSource();
					op = eBtn.getText();
					first = Integer.parseInt(tf.getText());
					tf.setText("");
				}
			});
		}
		// = 버튼이 눌렸을때
		bEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				second = Integer.parseInt(tf.getText());
				int result = 0;
				switch(op) {
				case "+" : result = first + second; break;	//스위치 케이스문으로 첫번째와 두번째의 결과값을 연산하고 브레이크로 빠져나온다.
				case "-" : result = first - second; break;
				case "*" : result = first * second; break;
				case "/" : result = first / second; break;
				}
				tf.setText(String.valueOf(result));	//매개변수가 null이면 문자열null을 만들어 담는다.	
			}
		});
	}

	public static void main(String[] args) {
		CalTest cal = new CalTest();
		cal.addLayout();
		cal.eventProc();

	}

}

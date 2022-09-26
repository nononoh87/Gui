package a_sample;

import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
/*
 *  자바의 GUI (화면)
 * 	-AWT : 1.2이후
 * 		대부분 클래스 앞에 J
 */
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ATest {	//ATest와 BTest의 다른점은 방식차이

	JFrame f;		// Jframe은 java swing 클래스의 일부이며 구현되는 하나의 창이다.
	JButton btn, bcancel;
	JCheckBox cbJava, cbOracle;		// 다중 선택할때 사용
	JRadioButton rbMale, rbFemale;	// 반드시 하나만 체크해야 할때
	JTextField tf;
	JTextArea ta;
	
	ATest() {
		f = new JFrame("나의 첫창");
		btn = new JButton("클릭");
		bcancel = new JButton("취소");
		cbJava = new JCheckBox("자바");
		cbOracle = new JCheckBox("오라클");
		rbMale = new JRadioButton("남자");
		rbFemale = new JRadioButton("여자");
		ButtonGroup group =new ButtonGroup(); //멤버 변수로 안만들고 지역변수로 만든이유 : 한번만 사용할것 같아서
		group.add(rbMale);
		group.add(rbFemale);
		tf = new JTextField(20);
		ta = new JTextArea(40, 20);
	}

	void addLayout() {
		
		//f.setLayout(new FlowLayout());	// FlowLayout : 한줄에 배치
		//f.setLayout(new GridLayout(3, 3)); 	// GridLayout : 행과 열에 배치
		f.setLayout(new BorderLayout());		// BorderLayout : 동/서/남/북/가운데 배치
		
		//붙이기 작업
		f.add(btn, BorderLayout.NORTH);
		f.add(bcancel, BorderLayout.SOUTH);
		//f.add(cbJava);
		//f.add(cbOracle);
			JPanel pEast = new JPanel();
			pEast.add(rbMale);
			pEast.add(rbFemale);
		f.add(pEast, BorderLayout.EAST);
			
		//f.add(rbMale, BorderLayout.EAST);
		//f.add(rbFemale, BorderLayout.EAST);
		f.add(new JLabel("입력하세요"), BorderLayout.WEST);
		//f.add(tf, BorderLayout.EAST);
		f.add(ta, BorderLayout.CENTER);
		
		
		//화면 출력
		f.setBounds(100, 100, 500, 350);	//화면 출력 크기
		f.setVisible(true);					//화면에 나타남 (출력)
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // .EXIT_ON_CLOSE 콘솔창을수동으로 정지를 안해줘도 
														  // 창에 X버튼을 누르면 알아서 정지해주는 명령어.
	}

	public static void main(String[] args) {
		ATest a = new ATest();
		a.addLayout();

	}

}

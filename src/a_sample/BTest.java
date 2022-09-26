package a_sample;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BTest extends JFrame {	//상속관계를 받을때 부모는 무조건 하나밖에 못 온다. 

	JButton btn;
	
	BTest() {
		super ("나의 두번째창");	//sper함수를 이용해서 부모클래스의 것을 사용.
	}

	void addLayout() {
		
		add(btn);
		
		setBounds(100, 100, 500, 350);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		BTest b = new BTest();
		b.addLayout();
	}

}

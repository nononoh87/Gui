package b_info;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InfoView {
	
	//1.멤버 변수 선언
	JFrame f;
	JTextField tfName, tfId, tfTel, tfGender, tfAge, tfHome;
	JTextArea ta;
	JButton bAdd, bShow, bSearch, bDelete, bCancle, bExit; 
	
	//2. 멤버변수 객체 생성
	InfoView(){
		f = new JFrame("DBTest");
		tfName = new JTextField();
		tfId = new JTextField();
		tfTel = new JTextField();
		tfGender = new JTextField();
		tfAge = new JTextField();
		tfHome = new JTextField();
		ta = new JTextArea(40, 20);

		bAdd = new JButton("add");
		bShow = new JButton("Show");
		bSearch= new JButton("Search");
		bDelete = new JButton("Delete");
		bCancle = new JButton("Cancle");
		bExit = new JButton("Exit");
		
	}	
	//3. 화면구성하고 출력
	/*
	 *  전체 플레임 BorderLayout 지정
	 * 		-WEST	: JPanel 붙이기 (GridLayout(6, 2))
	 * 		-CENTER : 텍스트에어리어
	 * 		-SOUTH	: JPanell 붙이기 (GridLayout(1, 6))
	 */
	
	public void addLayout() {
		f.setLayout(new BorderLayout());
		
		JPanel pWEST = new JPanel(new GridLayout(6, 2));
		
		pWEST.add(new JLabel("name"));
		pWEST.add(tfName);
		pWEST.add(new JLabel("ID"));
		pWEST.add(tfId);
		pWEST.add(new JLabel("Tel"));
		pWEST.add(tfTel);
		pWEST.add(new JLabel("Gender"));
		pWEST.add(tfGender);
		pWEST.add(new JLabel("age"));
		pWEST.add(tfAge);
		pWEST.add(new JLabel("Home"));
		pWEST.add(tfHome);
		f.add(pWEST, BorderLayout.WEST);
		
		f.add(new JLabel("입력하세요"), BorderLayout.CENTER);
		f.add(ta, BorderLayout.CENTER);
		
		JPanel pSOUTH = new JPanel(new GridLayout(1, 6));
		pSOUTH.add(bAdd);
		pSOUTH.add(bShow);
		pSOUTH.add(bSearch);
		pSOUTH.add(bDelete);
		pSOUTH.add(bCancle);
		pSOUTH.add(bExit);
		f.add(pSOUTH, BorderLayout.SOUTH);
	
	f.setBounds(300, 300, 900, 400);	
	f.setVisible(true);				
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
	
	public static void main(String[] args) {
		
		InfoView info = new InfoView();
		info.addLayout();
	}

}

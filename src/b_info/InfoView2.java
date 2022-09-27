package b_info;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InfoView2 {
	
	//1.멤버 변수 선언
	JFrame f;
	JTextField tfName, tfId, tfTel, tfSex, tfAge, tfHome;
	JTextArea ta;
	JButton bAdd, bShow, bSearch, bDelete, bCancle, bExit; 
	
	//2. 멤버변수 객체 생성
	InfoView2(){
		f = new JFrame();
		tfName = new JTextField();
		tfId = new JTextField();
		tfTel = new JTextField();
		tfSex = new JTextField();
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
		f.setTitle("DBTest");
		f.setLayout(new BorderLayout());
		
		JPanel pWEST = new JPanel();
		pWEST.setPreferredSize(new Dimension(300, 1));
		pWEST.setLayout(new GridLayout(6, 2));
		
		JLabel Name = new JLabel("Name");
		Name.setHorizontalAlignment(JLabel.CENTER);
		pWEST.add(Name);
		pWEST.add(tfName);
		JLabel Id = new JLabel("Id");
		Id.setHorizontalAlignment(JLabel.CENTER);
		pWEST.add(Id);
		pWEST.add(tfId);
		JLabel Tel = new JLabel("Tel");
		Tel.setHorizontalAlignment(JLabel.CENTER);
		pWEST.add(Tel);
		pWEST.add(tfTel);
		JLabel Sex = new JLabel("Sex");
		Sex.setHorizontalAlignment(JLabel.CENTER);
		pWEST.add(Sex);
		pWEST.add(tfSex);
		JLabel Age = new JLabel("Age");
		Age.setHorizontalAlignment(JLabel.CENTER);
		pWEST.add(Age);
		pWEST.add(tfAge);
		JLabel Home = new JLabel("Home");
		Home.setHorizontalAlignment(JLabel.CENTER);
		pWEST.add(Home);
		pWEST.add(tfHome);
		f.add(pWEST, BorderLayout.WEST);
		
		f.add(ta, BorderLayout.CENTER);
		
		JPanel pSOUTH = new JPanel();
		pSOUTH.setPreferredSize(new Dimension(40, 50));
		pSOUTH.setLayout(new GridLayout(1, 6));
		pSOUTH.add(bAdd);
		pSOUTH.add(bShow);
		pSOUTH.add(bSearch);
		pSOUTH.add(bDelete);
		pSOUTH.add(bCancle);
		pSOUTH.add(bExit);
		f.add(pSOUTH, BorderLayout.SOUTH);
	
	f.setBounds(300, 300, 800, 400);	
	f.setVisible(true);				
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
	
	public static void main(String[] args) {
		
		InfoView2 info = new InfoView2();
		info.addLayout();
	}

}

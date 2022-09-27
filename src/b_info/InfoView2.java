package b_info;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InfoView2 {

	// 1.멤버 변수 선언
	JFrame f;
	JTextField tfName, tfId, tfTel, tfGender, tfAge, tfHome;
	JTextArea ta;
	JButton bAdd, bShow, bSearch, bDelete, bCancle, bExit;

	// 2. 멤버변수 객체 생성
	InfoView2() {

		f = new JFrame();

		tfName = new JTextField();
		tfId = new JTextField();
		tfTel = new JTextField();
		tfGender = new JTextField();
		tfAge = new JTextField();
		tfHome = new JTextField();
		ta = new JTextArea(40, 20);

		bAdd = new JButton("add");
		bShow = new JButton("Show");
		bSearch = new JButton("Search");
		bDelete = new JButton("Delete");
		bCancle = new JButton("Cancle");
		bExit = new JButton("Exit (art + x)", new ImageIcon("src\\b_info\\imgs\\1.PNG")); // 버튼에 1번 이미지를 넣어준다.
		bExit.setHorizontalTextPosition(JButton.CENTER); // HorizontalTextPosition : 텍스트의 위치에 수평을 맞춘다.
		bExit.setVerticalTextPosition(JButton.BOTTOM); // VerticalTextPosition : 텍스트의 위치에 수직을 맞춘다.
		bExit.setRolloverIcon(new ImageIcon("src\\b_info\\imgs\\4.PNG")); // 마우스를 올렸을때 4번 이미지 출력
		bExit.setPressedIcon(new ImageIcon("src\\b_info\\imgs\\3.PNG")); // 클릭시 3번 이미지 출력
		bExit.setToolTipText("프로그램을 종료합니다."); // 마우스를 올렸을때 "프로그램을 종료합니다"란 안내 텍스트 출력
		bExit.setMnemonic('x');

	}
	// 3. 화면구성하고 출력
	/*
	 * 전체 플레임 BorderLayout 지정 -WEST : JPanel 붙이기 (GridLayout(6, 2)) -CENTER :
	 * 텍스트에어리어 -SOUTH : JPanell 붙이기 (GridLayout(1, 6))
	 */

	public void addLayout() {
		f.setTitle("DBTest");
		f.setLayout(new BorderLayout());

		JPanel pWEST = new JPanel();
		pWEST.setPreferredSize(new Dimension(300, 1)); // PreferredSize : 우선의 크기?, Dimension : 크기(치수)
		pWEST.setLayout(new GridLayout(6, 2));

		JLabel Name = new JLabel("Name");
		Name.setHorizontalAlignment(JLabel.CENTER); // HorizontalAlignment : 컨트롤의 개체 또는 텍스트가 해당 컨트롤의 요소에 대해 상대적으로 수평으로
													// 맞추는 방법을 지정합니다.
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
		JLabel Gender = new JLabel("Gender");
		Gender.setHorizontalAlignment(JLabel.CENTER);
		pWEST.add(Gender);
		pWEST.add(tfGender);
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

		f.setBounds(300, 300, 800, 400); // 화면 출력 크기
		f.setVisible(true); // 화면에 나타남 (출력)
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // .EXIT_ON_CLOSE 콘솔창을수동으로 정지를 안해줘도
															// 창에 X버튼을 누르면 알아서 정지해주는 명령어.
	}

	public void eventProc() {
		// ADD 버튼이 눌렸을때
		bAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "ADD 이벤트발생3");
			}	
		});	
		tfId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getJuminInfo();
			}	//end of actionPerformed
		});		//end of addActionListener
		//주민번호 입력창에서 포커스 발생했을때
		tfId.addFocusListener(new FocusListener() {
			public void FocusGained(FocusEvent e) { // 오버라이딩
			}
			public void FocusLost(FocusEvent e) {
				getJuminInfo();
			}
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});	//end of addFocusListener
	}	//end of eventProc()
		
	void getJuminInfo() {
		String jumin = tfId.getText();
		if (jumin.length() < 14) {
			JOptionPane.showMessageDialog(null, " - 포함한 15자를 맞춰주세요");
			return;
		}
		// (1) 주민번호의 7번째 문자로 성별을 구하여 성별창에 출력
		char tfId = jumin.charAt(7);
		String gd = "";

		if (tfId == '1' || tfId == '3' || tfId == '9') {
			gd = "남자";
		} else if (tfId == '2' || tfId == '4' || tfId == '0') {
			gd = "여자";
		}
		tfGender.setText(gd);

		// (2) 주민번호의 8번째 문자로 출신지를 구하여 출신창에 출력

		char s = jumin.charAt(8);
		String hm = "";

		if (s == '0') {
			hm = "서울";
		} else if (s == '1') {
			hm = "인천/부산";
		} else if (s == '2') {
			hm = "경기";
		} else if (s == '9') {
			hm = "출신";
		}
		tfHome.setText(hm);
		JOptionPane.showMessageDialog(null, " - 출신은" + hm + "입니다.");

		// (3) 주민번호에서 년도에 의해 나이를 구해서 나이창에 출력
		String year = jumin.substring(0, 2);
		int year2 = Integer.valueOf(year);
		Calendar c = Calendar.getInstance();
		int age = 0;

		if (tfId == '3' || tfId == '4') {
			age = c.get(Calendar.YEAR) - year2 - 2000 + 1;
			;
		} else {
			age = c.get(Calendar.YEAR) - year2 - 1900 + 1;
		}
		JOptionPane.showMessageDialog(null, " - 나이는 " + age + "입니다.");
	}


	
	public static void main(String[] args) {

		InfoView2 info = new InfoView2();
		info.addLayout();
		info.eventProc();
	}

}

package c_sample;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


/*
 *  화면(JFrame)에 '확인' 버튼 하나 출력
 */

public class EventTest3 {
	JFrame f;
	JButton bt;

	EventTest3() {
		
		f = new JFrame();
		bt = new JButton("확인");
		
		// (1)이벤트 핸들러 만들기
		// 핸들러 - 이벤트 처리 클래스
		//(2)핸들러 객체 생성
		//(3) 이벤트
		bt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null, "이벤트발생3");
			}
		} );
	}

	public void addLayout() {
		f.add(bt);

		f.setBounds(100, 100, 500, 200);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		EventTest3 info = new EventTest3();
		info.addLayout();
	}

}


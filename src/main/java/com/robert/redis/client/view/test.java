package com.robert.redis.client.view;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class test extends JFrame{

	private JTextField jt;
	test(){
		this.setSize(200, 200);
		this.setContentPane(jp());
	}
	
	public JPanel jp(){
		JPanel jp = new JPanel();
		jp.setLayout(new BoxLayout(jp,BoxLayout.X_AXIS));
		jt = new JTextField(20);
		jt.setBounds(0, 0, 20, 10);
		jp.add(jt);
		return jp;
	}
	
	public static void main(String[] args) {
		test t =new test();
		t.setVisible(true);
	}
}

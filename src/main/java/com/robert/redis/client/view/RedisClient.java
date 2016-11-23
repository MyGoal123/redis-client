package com.robert.redis.client.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.robert.redis.client.services.IRedisService;
import com.robert.redis.client.services.RedisService;

public class RedisClient extends JFrame{

	private static final String RC_TITLE = "RedisClient-java";
	private static final int RC_WIDTH = 900;
	private static final int RC_HEIGHT = 600;
	private IRedisService redisService ;
	
	public RedisClient(){
		redisService = new RedisService();
		this.setTitle(RC_TITLE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(RC_WIDTH, RC_HEIGHT);
		this.setLocationRelativeTo(null);
		this.setContentPane(RCJPannel());
	}
	public RedisClient(String host, String password, String port){
		
		redisService = new RedisService();
		this.setTitle(RC_TITLE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(RC_WIDTH, RC_HEIGHT);
		this.setLocationRelativeTo(null);
		this.setContentPane(RCJPannel());
	}
	
	
	public static void main(String[] args) {
		
		RedisClient rc = new RedisClient();
		rc.setVisible(true);
	}

	
	private JPanel RCJPannel(){
		JPanel rcjp = new JPanel();
		rcjp.setLayout(new BorderLayout());
		RCJMenuBar();
		rcjp.add(treeJScrollPane(), BorderLayout.WEST);
		return rcjp;
	}
	
	//菜单
	private JMenuBar RCJMenuBar(){
		JMenuBar rcjmb = new JMenuBar();
		this.setJMenuBar(rcjmb);
		JMenu file, search, help;
		file = new JMenu("文件");
		search = new JMenu("搜索");
		search.addSeparator();
		help = new JMenu("帮助");
		
		rcjmb.add(file);
		rcjmb.add(search);
		rcjmb.add(help);
		
		JMenuItem jmi1, jmi2;
		jmi1 = new JMenuItem("新建连接");
		jmi2 = new JMenuItem("导出");
		
		jmi1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				RedisLogin rl = new RedisLogin();
				rl.setVisible(true);
				
			}
		});
		file.add(jmi1);
		file.addSeparator();
		file.add(jmi2);
		return rcjmb;
	}
	
	public JScrollPane treeJScrollPane(){
		JScrollPane jsp = new JScrollPane(treeJpanel());
		jsp.setBounds(0, 0, 300, 400);
		return jsp;
	}
	
	//左边框--以后单独抽出来
	public JPanel treeJpanel(){
		JPanel jp = new JPanel();
		Set<String> keys = redisService.keys("*");
		int row = keys.size();
		jp.setLayout(new GridLayout(row,1,2,2));
		for(String key : keys){
			if(redisService.typeKey(key).equals("hash")){
				
			}
			jp.add(new JLabel(key));
			
		}
		return jp;
	}
	
	
}

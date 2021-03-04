package com.view;
 
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
 
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JButton;
 
public class 当前时间 extends JFrame {
	
	
	private static final long serialVersionUID = 4306803332677233920L;
	protected Object frame;
	
 
	// 添加 显示时间的JLabel
	public 当前时间() {
		getContentPane().setBackground(new Color(245, 245, 245));
		JLabel time = new JLabel();
		time.setForeground(Color.BLUE);
		time.setBounds(30, 0, 900, 130);
		time.setFont(new Font("微软雅黑", Font.BOLD, 80));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		this.setTitle("\u5F53\u524D\u65F6\u95F4");
		this.setBounds(500, 200, 930, 300);
		this.setVisible(true);
		getContentPane().add(time);
		this.setTimer(time);
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				this.close();
				用户类型选择界面 frame = new 用户类型选择界面();
				frame.setVisible(true);
			}

			private void close() {
				setVisible(false);
			}
		});
		button.setFont(new Font("黑体", Font.PLAIN, 15));
		button.setBounds(416, 213, 107, 27);
		getContentPane().add(button);
	}
 
	// 设置Timer 1000ms实现一次动作 实际是一个线程
	private void setTimer(JLabel time) {
		final JLabel varTime = time;
		Timer timeAction = new Timer(100, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long timemillis = System.currentTimeMillis();
				// 转换日期显示格式
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				varTime.setText(df.format(new Date(timemillis)));
			}
		});
		timeAction.start();
	}
 
	// 运行方法
	public static void main(String[] args) {
		new 当前时间();
	}
 
}

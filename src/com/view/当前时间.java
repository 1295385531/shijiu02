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
 
public class ��ǰʱ�� extends JFrame {
	
	
	private static final long serialVersionUID = 4306803332677233920L;
	protected Object frame;
	
 
	// ��� ��ʾʱ���JLabel
	public ��ǰʱ��() {
		getContentPane().setBackground(new Color(245, 245, 245));
		JLabel time = new JLabel();
		time.setForeground(Color.BLUE);
		time.setBounds(30, 0, 900, 130);
		time.setFont(new Font("΢���ź�", Font.BOLD, 80));
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
				�û�����ѡ����� frame = new �û�����ѡ�����();
				frame.setVisible(true);
			}

			private void close() {
				setVisible(false);
			}
		});
		button.setFont(new Font("����", Font.PLAIN, 15));
		button.setBounds(416, 213, 107, 27);
		getContentPane().add(button);
	}
 
	// ����Timer 1000msʵ��һ�ζ��� ʵ����һ���߳�
	private void setTimer(JLabel time) {
		final JLabel varTime = time;
		Timer timeAction = new Timer(100, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long timemillis = System.currentTimeMillis();
				// ת��������ʾ��ʽ
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				varTime.setText(df.format(new Date(timemillis)));
			}
		});
		timeAction.start();
	}
 
	// ���з���
	public static void main(String[] args) {
		new ��ǰʱ��();
	}
 
}

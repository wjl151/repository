package com.book.view.littleview;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *  功能尚未完善
 * @author 武金龙
 *
 */
public class UnfinishedView extends JFrame {

	private JPanel ufinishedView;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UnfinishedView frame = new UnfinishedView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UnfinishedView() {
		setTitle("\u529F\u80FD\u5C1A\u672A\u5B8C\u5584");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 316);
		ufinishedView = new JPanel();
		ufinishedView.setBorder(new EmptyBorder(5, 5, 5, 5));
		ufinishedView.setLayout(new BorderLayout(0, 0));
		
		setContentPane( ufinishedView);
		ImageIcon img = new ImageIcon(".\\systembackground\\05.jpg");
		JLabel imgLabel = new JLabel(img);
		Integer af = Integer.MIN_VALUE;
		getLayeredPane().add(imgLabel,af);
		imgLabel.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
		((JPanel)getContentPane()).setOpaque(false);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(2);
	}

}

package com.book.view.userview;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.book.model.User;
import com.book.servlet.UserDao;
import com.book.util.DataUtil;

import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class UserAddMonyView extends JFrame {

	private JPanel contentPane;
	private UserDao userDao = new UserDao();
	private int userId;
	private Connection con =null;
	private int mony = 0;
	private User userNew = null;
	private JLabel nowMony = new JLabel("New label");
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UserAddMonyView frame = new UserAddMonyView();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public UserAddMonyView(User user) {
		userId = user.getId();
		userNew = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u8D26\u6237\u4F59\u989D\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 29));
		lblNewLabel.setForeground(Color.BLACK);
		
		
		nowMony.setFont(new Font("宋体", Font.PLAIN, 28));
		nowMony.setForeground(Color.RED);
		
		JLabel lblNewLabel_2 = new JLabel("\u5145\u503C");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 26));
		
		JLabel lblNewLabel_3 = new JLabel("------------------------------------------------------------------------------------------------------------------------------------------------");
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("20");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mony = 20;
			}
		});
		rdbtnNewRadioButton.setFont(new Font("宋体", Font.PLAIN, 25));
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("50");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mony = 50;
			}
		});
		rdbtnNewRadioButton_1.setFont(new Font("宋体", Font.PLAIN, 25));
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("100");
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mony = 100;
			}
		});
		rdbtnNewRadioButton_2.setFont(new Font("宋体", Font.PLAIN, 25));
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("200");
		rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mony=200;
			}
		});
		rdbtnNewRadioButton_3.setFont(new Font("宋体", Font.PLAIN, 25));
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("500");
		rdbtnNewRadioButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mony = 500;
			}
		});
		rdbtnNewRadioButton_4.setFont(new Font("宋体", Font.PLAIN, 25));
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("1000");
		rdbtnNewRadioButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mony=1000;
			}
		});
		rdbtnNewRadioButton_5.setFont(new Font("宋体", Font.PLAIN, 26));
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addMony(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(UserAddMonyView.class.getResource("/images/WX.png")));
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addMony(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(UserAddMonyView.class.getResource("/images/ZFB.png")));
		
		/*
		 * 单选按钮组
		 */
		ButtonGroup monyButton = new ButtonGroup();
		monyButton.add(rdbtnNewRadioButton);
		monyButton.add(rdbtnNewRadioButton_1);
		monyButton.add(rdbtnNewRadioButton_2);
		monyButton.add(rdbtnNewRadioButton_3);
		monyButton.add(rdbtnNewRadioButton_4);
		monyButton.add(rdbtnNewRadioButton_5);
		
		JLayeredPane layeredPane = new JLayeredPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(18)
							.addComponent(nowMony, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
							.addGap(53))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(341, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 406, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(22)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(rdbtnNewRadioButton, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
										.addComponent(rdbtnNewRadioButton_3, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(rdbtnNewRadioButton_4, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
											.addComponent(rdbtnNewRadioButton_5, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(rdbtnNewRadioButton_1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
											.addComponent(rdbtnNewRadioButton_2, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)))
									.addGap(45)))
							.addContainerGap(15, Short.MAX_VALUE))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(40)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addGap(85))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(nowMony, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(54)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_3)
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(rdbtnNewRadioButton_1)
							.addComponent(rdbtnNewRadioButton_2)
							.addComponent(rdbtnNewRadioButton))
						.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(64)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnNewRadioButton_4)
						.addComponent(rdbtnNewRadioButton_5)
						.addComponent(rdbtnNewRadioButton_3))
					.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addGap(44))
		);
		
		nowMony.setText(String.valueOf(user.getMony()));
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);                              //界面居中
		this.setResizable(false);               						//关闭最大化
		this.setDefaultCloseOperation(2);
	}
	/**
	 * 充值事件处理
	 * @param e
	 */
	private void addMony(ActionEvent e) {
		// TODO 自动生成的方法存根
		try {
			con = DataUtil.getConnectionLink();
			int cnt = userDao.userAddMony(con, userId, mony);
			if(cnt>0) {
				JOptionPane.showConfirmDialog(null, "充值成功","成功", 0);
				userNew = userDao.login(con, userNew);
				nowMony.setText(String.valueOf(userNew.getMony()));
			}else {
				JOptionPane.showConfirmDialog(null, "充值失败，请联系作者","失败", 0);
			}
		} catch (Exception e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		}
	}
}

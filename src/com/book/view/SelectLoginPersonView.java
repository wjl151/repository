package com.book.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.book.view.administeredview.AdministratorLoginView;
import com.book.view.littleview.AboutAuthorView;
import com.book.view.userview.UserLoginView;
import com.book.view.userview.UserRegisterView;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 选择登录界面
 * @author 武金龙
 *
 */
public class SelectLoginPersonView extends JFrame {

	private JPanel contentPane;

	@SuppressWarnings("deprecation")
	public SelectLoginPersonView() {
		//改变系统默认字体
		Font font = new Font("Dialog",Font.PLAIN,12);
		java.util.Enumeration keys = UIManager.getDefaults().keys();
		while(keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if(value instanceof javax.swing.plaf.FontUIResource) {
				UIManager.put(key, font);
			}
		}
				
		setResizable(false);
		
		setTitle("图书管理系统");
		setForeground(Color.DARK_GRAY);
		setFont(new Font("楷体", Font.PLAIN, 12));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 180, 787, 517);
		
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//加载背景图片
		ImageIcon img = new ImageIcon("./src/images/bookPic.jpg");
		JLabel imgLabel = new JLabel(img);
		Integer af = Integer.MIN_VALUE;
		getLayeredPane().add(imgLabel,af);
		imgLabel.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
		((JPanel)getContentPane()).setOpaque(false);
		
		JButton btnNewButton = new JButton("\u7528\u6237\u6CE8\u518C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userRegister(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u7528\u6237\u767B\u5F55");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chosseUser(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(SelectLoginPersonView.class.getResource("/images/userLitlePhone.png")));
		btnNewButton_1.setFont(new Font("幼圆", Font.PLAIN, 25));
		
		JButton btnNewButton_2 = new JButton("\u7BA1\u7406\u5458\u767B\u5F55");
		btnNewButton_2.setIcon(new ImageIcon(SelectLoginPersonView.class.getResource("/images/resizeApi.png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chosseAdministered(e);
			}
		});
		btnNewButton_2.setFont(new Font("幼圆", Font.PLAIN, 25));
		
		JButton btnNewButton_3 = new JButton("\u7BA1\u7406\u5458\u6743\u9650\u7533\u8BF7");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getAdministere(e);
			}
		});
		
		JButton btnNewButton_4 = new JButton("\u8054\u7CFB\u4F5C\u8005");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AboutAuthorView().setVisible(true);
			}
		});
		btnNewButton_4.setIcon(new ImageIcon(SelectLoginPersonView.class.getResource("/images/star.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(41)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
							.addGap(117)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(170)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addGap(183)
							.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(45, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(340, Short.MAX_VALUE)
					.addComponent(btnNewButton_4)
					.addGap(332))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(127)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnNewButton_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addComponent(btnNewButton_4)
					.addGap(42))
		);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);  //界面居中显示
		this.setResizable(false);               //关闭最大化
	}
	/**
	 * 获取管理员权限事件处理
	 * @param e
	 */
	private void getAdministere(ActionEvent e) {
		// TODO 自动生成的方法存根
		JOptionPane.showConfirmDialog(null, "请联系作者以获取权限","提醒",2);
	}

	/**
	 * 选择用户事件
	 * @param e
	 */
	private void chosseUser(ActionEvent e) {
		// TODO 自动生成的方法存根
		dispose();
		new UserLoginView().setVisible(true);;
	}

	/**
	 * 用户注册事件处理
	 * @param e
	 */
	private void userRegister(ActionEvent e) {
		// TODO 自动生成的方法存根
		dispose();
		new UserRegisterView().setVisible(true);
	}

	/**
	 * 选择管理员事件处理
	 * @param e
	 */
	protected void chosseAdministered(ActionEvent e) {
		dispose();
		new AdministratorLoginView().setVisible(true);
	}
}

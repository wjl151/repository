package com.book.view.administeredview;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.book.model.Administered;
import com.book.servlet.AdministeredDao;
import com.book.util.DataUtil;
import com.book.util.StringUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

/**
 * 管理员登录界面
 * @author 武金龙
 *
 */
public class AdministratorLoginView extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTxt;
	private JLabel lblNewLabel_2;
//	private JTextField userPasswordTxt;
	private JPasswordField userPasswordTxt = new JPasswordField();
	private DataUtil dataUtil = new DataUtil();
	private AdministeredDao admLogin = new AdministeredDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministratorLoginView frame = new AdministratorLoginView();
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
	public AdministratorLoginView() {
		//改变系统默认字体
		userPasswordTxt.setEchoChar('*');                //密码屏蔽
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel(" \u56FE\u4E66\u7BA1\u7406\u5458\u767B\u5F55");
		lblNewLabel.setIcon(new ImageIcon(AdministratorLoginView.class.getResource("/images/book.png")));
		lblNewLabel.setFont(new Font("幼圆", Font.PLAIN, 30));
		
		JLabel lblNewLabel_1 = new JLabel("\u8D26\u53F7\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(AdministratorLoginView.class.getResource("/images/username.png")));
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 25));
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		userNameTxt.setFont(new Font("Dialog",Font.PLAIN,20));
		lblNewLabel_2 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setIcon(new ImageIcon(AdministratorLoginView.class.getResource("/images/key.png")));
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 25));
		

		userPasswordTxt.setColumns(10);
		userPasswordTxt.setFont(new Font("Dialog",Font.PLAIN,20));
		JButton btnNewButton = new JButton(" \u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				loginEventHand(e1);
			}
		});
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 21));
		btnNewButton.setIcon(new ImageIcon(AdministratorLoginView.class.getResource("/images/login.png")));
		
		JButton btnNewButton_1 = new JButton(" \u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerfome(e);
			}
		});
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setFont(new Font("幼圆", Font.PLAIN, 20));
		btnNewButton_1.setIcon(new ImageIcon(AdministratorLoginView.class.getResource("/images/reset.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(51)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addGap(39))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(userPasswordTxt, 266, 266, 266)
								.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(106)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
							.addGap(93)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(73, GroupLayout.PREFERRED_SIZE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(168, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 382, GroupLayout.PREFERRED_SIZE)
					.addGap(24))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(37)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addGap(47)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(userPasswordTxt, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
					.addContainerGap(55, Short.MAX_VALUE))
		);
		KeyListener keylistener= new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar()=='\n') {
					loginEventHand_1(e);
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {	
			}

			@Override
			public void keyReleased(KeyEvent e) {
			
			}
		};
		userNameTxt.addKeyListener(keylistener);
		userPasswordTxt.addKeyListener(keylistener);
		btnNewButton.addKeyListener(keylistener);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);       
		this.setResizable(false);             	  //关闭最大化
	}
	/**
	 * 单击登录事件处理
	 * @param e1
	 */
	private void loginEventHand(ActionEvent e1) {
		String name = this.userNameTxt.getText();
		String password = new String(this.userPasswordTxt.getPassword());
		if(!StringUtil.isEmpty(name)) {
			JOptionPane.showConfirmDialog(null,"用户名不能为空","错误",0);
			return ;
		}
		if(!StringUtil.isEmpty(password)) {
			JOptionPane.showConfirmDialog(null, "密码不能为空","错误",0);
			return ;
		}
		Administered nowAdministered = new Administered(name,password);
		Connection con=null;
		try {
			con = DataUtil.getConnectionLink();
			nowAdministered = admLogin.login(con, nowAdministered);
			if(nowAdministered==null) {
				JOptionPane.showConfirmDialog(null, "密码或账号错误！","错误", 0);
			}else {
				dispose();
				new AdministratorManagementView().setVisible(true);
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
	
	}
	/**
	 * 回车登录事件处理
	 * @param e1
	 */
	private void loginEventHand_1(KeyEvent e1) {
		String name = this.userNameTxt.getText();
		String password = new String(this.userPasswordTxt.getPassword());
		if(!StringUtil.isEmpty(name)) {
			JOptionPane.showConfirmDialog(null,"用户名不能为空","错误",0);
			return ;
		}
		if(!StringUtil.isEmpty(password)) {
			JOptionPane.showConfirmDialog(null, "密码不能为空","错误",0);
			return ;
		}
		Administered nowAdministered = new Administered(name,password);
		Connection con=null;
		try {
			con = DataUtil.getConnectionLink();
			nowAdministered = admLogin.login(con, nowAdministered);
			if(nowAdministered==null) {
				JOptionPane.showConfirmDialog(null, "密码或账号错误！","错误", 0);
			}else {
				dispose();
				new AdministratorManagementView().setVisible(true);
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
	
	}
	/**
	 * 重置事件处理
	 * @param e
	 */
	private void resetValueActionPerfome(ActionEvent e) {
		// TODO 自动生成的方法存根
		this.userNameTxt.setText("");
		this.userPasswordTxt.setText("");
	}
}

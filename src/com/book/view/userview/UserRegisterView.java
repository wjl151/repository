package com.book.view.userview;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.book.model.User;
import com.book.servlet.UserDao;
import com.book.util.CodeUtil;
import com.book.util.DataUtil;
import com.book.util.StringUtil;
import com.book.view.SelectLoginPersonView;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 用户注册界面
 * @author 武金龙
 *
 */
public class UserRegisterView extends JFrame {

	private JPanel contentPane;
	private JTextField UserCodePassword;
	private JTextField userName;
	private JPasswordField UserPassword1;
	private JPasswordField UserPassWord2;
	private JButton btnNewButton;
	private String codePass;                 //当前验证码的密码
	private Connection con = null;
	private Connection con1 = null;
	private String[] code = new String[2];
	private String codeip;
	private JLabel nowUserName = new JLabel("New label");
	private NowName uio = new NowName();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserRegisterView frame = new UserRegisterView();
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
	public UserRegisterView() {
		
	
		setTitle("\u7528\u6237\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 761, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);   
		JLabel lblNewLabel = new JLabel(" \u8D26\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 22));
		
		JLabel lblNewLabel_1 = new JLabel(" \u5BC6\u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 22));
		
		JLabel lblNewLabel_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 22));
		
		JLabel lblNewLabel_3 = new JLabel("\u9A8C\u8BC1\u7801\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 22));
		
		UserCodePassword = new JTextField();
		UserCodePassword.setBackground(Color.LIGHT_GRAY);
		UserCodePassword.setFont(new Font("宋体", Font.PLAIN, 21));
		UserCodePassword.setColumns(10);
		
		JLabel code = new JLabel("\u9A8C\u8BC1\u7801\u9519\u8BEF\uFF0C\u70B9\u51FB\u5237\u65B0");
		
		
		this.getCode();
		
		code.setIcon(new ImageIcon(codeip));
		
		code.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ef) {
				codeHit(ef);
				code.setIcon(new ImageIcon(codeip));
			}
		});
		
		userName = new JTextField();
		userName.setFont(new Font("宋体", Font.PLAIN, 17));
		userName.setBackground(Color.LIGHT_GRAY);
		userName.setColumns(10);
		
		UserPassword1 = new JPasswordField();
		UserPassword1.setFont(new Font("宋体", Font.PLAIN, 20));
		UserPassword1.setBackground(Color.LIGHT_GRAY);
		UserPassword1.setColumns(10);
	
		UserPassWord2 = new JPasswordField();
		UserPassWord2.setFont(new Font("宋体", Font.PLAIN, 20));
		UserPassWord2.setBackground(Color.LIGHT_GRAY);
		UserPassWord2.setColumns(10);
		
		btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setIcon(new ImageIcon(UserRegisterView.class.getResource("/images/login.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ef) {
				uio.run=false;
				userRegister(ef);
				uio = new NowName();
				uio.start();
				getCode();
				code.setIcon(new ImageIcon(codeip));
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 28));
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(68, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, Alignment.TRAILING)
						.addComponent(lblNewLabel, Alignment.TRAILING)
						.addComponent(lblNewLabel_2, Alignment.TRAILING)
						.addComponent(lblNewLabel_3, Alignment.TRAILING))
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(code, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addGap(63))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(UserCodePassword, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
								.addComponent(UserPassword1)
								.addComponent(UserPassWord2, GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
								.addComponent(userName))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(nowUserName, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addComponent(userName, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(nowUserName, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addGap(55)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(UserPassword1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
							.addGap(47)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(UserPassWord2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
							.addGap(57)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(UserCodePassword, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
							.addGap(31)
							.addComponent(code, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(59, Short.MAX_VALUE))
		);
         KeyListener keylistener= new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar()=='\n') {
					uio.run=false;
					userRegister(e);
					uio = new NowName();
					uio.start();
					getCode();
					code.setIcon(new ImageIcon(codeip));
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {	
			}

			@Override
			public void keyReleased(KeyEvent e) {
			
			}
		};
         btnNewButton.addKeyListener(keylistener);
         userName.addKeyListener(keylistener);
         UserPassword1.addKeyListener(keylistener);
         UserPassWord2.addKeyListener(keylistener);
         UserCodePassword.addKeyListener(keylistener);
         //背景加载
		ImageIcon img = new ImageIcon(".\\systembackground\\UserRegitsterBackground.jpg");
		JLabel imgLabel = new JLabel(img);
		Integer af = Integer.MIN_VALUE;
		getLayeredPane().add(imgLabel,af);
		imgLabel.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
		((JPanel)getContentPane()).setOpaque(false);
		//实时监测用户名是否重复
		uio.start();
		contentPane.setLayout(gl_contentPane);
		this.setResizable(false);               //关闭最大化
	}
	
	/**
	 * 用户姓名提示线程类
	 */
	class NowName extends Thread{
		boolean run = true;
		@Override
		public void run() {
			try {
				con = DataUtil.getConnectionLink();
				if (run) {
					while (true) {
						String name = userName.getText();
						if (!StringUtil.isEmpty(name)) {
							nowUserName.setText("用户名不能为空");
							nowUserName.setForeground(Color.RED);
							continue;
						}
						Thread.sleep(500);

						UserDao usr = new UserDao();
						int cnt = usr.userSelect(con, name);
						if (cnt > 0) {
							nowUserName.setText("用户名重复");
							nowUserName.setForeground(Color.RED);
						} else  {
							nowUserName.setText("用户名可用");
							nowUserName.setForeground(Color.GREEN);
						}
					}
				} else {
					if (con != null) {
						con.close();
					}
					return;
				}
			} catch (Exception e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		
		}
	}
	
	/**
	 * 注册事件处理
	 * @param e
	 */
	private void userRegister(ActionEvent e) {
		// TODO 自动生成的方法存根
		
		try {
			con = DataUtil.getConnectionLink();
			String name = userName.getText();
			String nowNameState = nowUserName.getText();
			String password1 = new String (UserPassword1.getPassword());
			String password2 = new String (UserPassWord2.getPassword());
			String codePassWord = UserCodePassword.getText();
			if(!codePassWord.trim().equalsIgnoreCase(codePass)) {
				JOptionPane.showConfirmDialog(null, "验证码错误","错误",0);
				return ;
			}
			if(!password1.equals(password2)) {
				JOptionPane.showConfirmDialog(null, "密码不一致","错误",0);
				return ;
			}
			UserDao usr = new UserDao();
			if(nowNameState.equalsIgnoreCase("用户名重复")) {
				JOptionPane.showConfirmDialog(null, "用户名重复","错误",0);
				return ;
			}
			User user = new User(name,password1);
			int cnt1=usr.userAdd(con, user);
			if(cnt1>0) {
			   JOptionPane.showConfirmDialog(null, "注册成功","成功",0);
			   dispose();
			   new SelectLoginPersonView().setVisible(true);;
			}else {
				JOptionPane.showConfirmDialog(null, "注册失败，发生未知错误","错误",0);
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

	/**
	 * 回车注册事件
	 * @param e
	 */
	private void userRegister(KeyEvent e) {
		// TODO 自动生成的方法存根
		
		try {
			con = DataUtil.getConnectionLink();
			String name = userName.getText();
			String password1 = new String (UserPassword1.getPassword());
			String password2 = new String (UserPassWord2.getPassword());
			String codePassWord = UserCodePassword.getText();
			if(!codePassWord.trim().equalsIgnoreCase(codePass)) {
				JOptionPane.showConfirmDialog(null, "验证码错误","错误",0);
				return ;
			}
			if(!password1.equals(password2)) {
				JOptionPane.showConfirmDialog(null, "密码不一致","错误",0);
				return ;
			}
			UserDao usr = new UserDao();
			int cnt = usr.userSelect(con, name);
			if(cnt>0) {
				JOptionPane.showConfirmDialog(null, "用户名重复","错误",0);
				return ;
			}
			User user = new User(name,password1);
			int cnt1=usr.userAdd(con, user);
			if(cnt1>0) {
			   JOptionPane.showConfirmDialog(null, "注册成功","成功",0);
			   dispose();
			   new SelectLoginPersonView().setVisible(true);;
			}else {
				JOptionPane.showConfirmDialog(null, "注册失败，发生未知错误","错误",0);
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

	/**
	 * 验证码单击事件处理
	 * @param ef
	 */
	private void codeHit(MouseEvent ef) {
		// TODO 自动生成的方法存根
		this.getCode();
	}

	/**
	 * 调用随机验证码生成
	 */
	private void getCode() {
		try {
			con1 = DataUtil.getConnectionLink();
			code = CodeUtil.random(con1);
			codeip = code[0];
			codePass = code[1];
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			if (con1 != null) {
				try {
					con1.close();
				} catch (SQLException throwables) {
					throwables.printStackTrace();
				}
			}
		}
	}
}

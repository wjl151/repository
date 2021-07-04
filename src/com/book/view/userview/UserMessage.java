package com.book.view.userview;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.book.model.User;
import com.book.servlet.UserDao;
import com.book.util.DataUtil;
import com.book.util.StringUtil;


import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.sql.Connection;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;

/**
 * 用户个人信息修改界面
 * @author 武金龙
 *
 */
public class UserMessage extends JFrame {

	private JPanel contentPane;
	private JTextField userName;
	private JTextField userPassword;
	private JTextField userAddress;
	private JTextField userPhone;
	private User userNew = new User();
	private Connection con = null;
	private UserDao userdao = new UserDao();
	private JLabel userPic = new JLabel("New label");
	private String phoneRoad ;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UserMessage frame = new UserMessage();
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
	public UserMessage(User user) {
		userNew = user;
		phoneRoad = user.getTopphone();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 832, 605);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237ID\uFF1A");
		
		JLabel userid = new JLabel(String.valueOf(user.getId()));
		
		JLabel lblNewLabel_3 = new JLabel("\u4F4F\u5740\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 24));
		
		JLabel lblNewLabel_4 = new JLabel("\u7535\u8BDD\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 24));
		
		userName = new JTextField();
		userName.setColumns(10);
		
		userPassword = new JTextField();
		userPassword.setColumns(10);
		userPic.setIcon(new ImageIcon(user.getTopphone()));
		
		JButton btnNewButton_1 = new JButton("\u63D0\u4EA4");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userNew.setId(user.getId());
				userMessage(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 30));
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 24));
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 24));
		
		userAddress = new JTextField();
		userAddress.setColumns(10);
		
		userPhone = new JTextField();
		userPhone.setColumns(10);
		
		JButton btnNewButton = new JButton("\u4E0A\u4F20\u5934\u50CF");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileTopPhone(e);
			}
		});
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setIcon(new ImageIcon(UserMessage.class.getResource("/images/folder.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(90)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_2))
					.addGap(47)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(userAddress, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
						.addComponent(userPhone, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
						.addComponent(userName, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
						.addComponent(userPassword, Alignment.TRAILING, 313, 313, 313))
					.addGap(69)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
					.addGap(34))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(309)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(userPic, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(userid, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(353, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(318)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(382, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(userPic, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(userid)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(userName, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2, Alignment.TRAILING)
								.addComponent(userPassword, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addGap(36)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
								.addComponent(userAddress, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_4)
								.addComponent(userPhone, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(41, Short.MAX_VALUE))
		);
		//初始化文本
		userAddress.setText(user.getAddress());
		userName.setText(user.getName());
		userPhone.setText(user.getPhone());
		userPassword.setText(user.getPassword());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(2); 			                  //关闭而不退出程序
		this.setResizable(false);             						  //关闭最大化
		contentPane.setLayout(gl_contentPane);
	}

	/**
	 * 上传头像事件处理
	 * @param e
	 */
	private void fileTopPhone(ActionEvent e) {
		// TODO 自动生成的方法存根

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setMultiSelectionEnabled(false);           				 //关闭多选
		fileChooser.setFileFilter(new FileNameExtensionFilter("image(*.jpg,*.png,*.gif)", "jpg","png","gif"));       //文件过滤器
		fileChooser.setAcceptAllFileFilterUsed(false); 						//关闭所有文件选项
		
		int result = fileChooser.showOpenDialog(getParent());
		if(result == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			try {
				phoneCopy(file);
				
			} catch (IOException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
				JOptionPane.showConfirmDialog(null, "上传失败","错误",0);
			}
			userPic.setIcon(new ImageIcon(file.getPath()));
		}
		
	}
	/**
	 * 图片复制到指定文件夹
	 * @param file
	 * @throws IOException 
	 */
	private void phoneCopy(File file) throws IOException {
		// TODO 自动生成的方法存根
		FileInputStream inPhone = new FileInputStream(file);
		String fileRoad = "./topphone/"+String.valueOf(userNew.getId())+".jpg";
		FileOutputStream outPhone = new FileOutputStream(fileRoad);
		int cnt = 0;
		byte [] readPhone = new byte[1024*1024];
		while((cnt=inPhone.read(readPhone)) != -1) {
			outPhone.write(readPhone,0,cnt);
		}
		phoneRoad = fileRoad;
		inPhone.close();
		outPhone.close();
	}

	/**
	 * 用户信息更改提交事件
	 * @param e
	 */
	private void userMessage(ActionEvent e) {
		// TODO 自动生成的方法存根
		userNew.setAddress(userAddress.getText());
		userNew.setName(userName.getText());
		userNew.setPassword(userPassword.getText());
		userNew.setPhone(userPhone.getText());
		userNew.setTopphone(phoneRoad);
		if("".equals(userNew.getAddress())) {
			userNew.setAddress(null);
		}
		if("".equals(userNew.getPhone())) {
			userNew.setPhone(null);
		}
		if(StringUtil.isEmpty(userNew.getName())) {
			if(StringUtil.isEmpty(userNew.getPassword())) {
				try {
					con = DataUtil.getConnectionLink();
					int cnt=userdao.userMessageAlter(con, userNew);
					if(cnt>0) {
						JOptionPane.showConfirmDialog(null, "修改成功","成功",0);
						dispose();
						
					}else {
						JOptionPane.showConfirmDialog(null, "修改失败","失败",0);
					}
				}catch(Exception ex) {
					ex.printStackTrace();
				}finally {
					try {
					  con.close();
					}catch(Exception er) {
						er.printStackTrace();
					}
				}
			}else {
				JOptionPane.showConfirmDialog(null, "密码不能为空","错误",0);
			}
		}else {
			JOptionPane.showConfirmDialog(null, "用户名不能为空","错误",0);
		}
		ImageIcon newPhone = new ImageIcon(phoneRoad);
		newPhone.getImage().flush();									    //清除缓存，更新图片
		UserMainView.UserTop.setIcon(newPhone);	
	}
}

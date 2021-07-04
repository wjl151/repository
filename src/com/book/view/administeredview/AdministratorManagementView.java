package com.book.view.administeredview;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.book.view.littleview.UnfinishedView;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 管理员主界面
 * @author 武金龙
 *
 */
public class AdministratorManagementView extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministratorManagementView frame = new AdministratorManagementView();
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
	public AdministratorManagementView() {
		setTitle("\u56FE\u4E66\u7BA1\u7406\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1099, 827);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		//加载图片
		ImageIcon img = new ImageIcon("./systembackground/booksystem2.jpg");
		JLabel imgLabel = new JLabel(img);
		Integer af = Integer.MIN_VALUE;
		getLayeredPane().add(imgLabel,af);
		imgLabel.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
		((JPanel)getContentPane()).setOpaque(false);
		
		
		JMenu mnNewMenu = new JMenu("\u7528\u6237\u7BA1\u7406");
		mnNewMenu.setIcon(new ImageIcon(AdministratorManagementView.class.getResource("/images/book1.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u6DFB\u52A0\u7528\u6237");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addUser(e);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u5220\u9664\u7528\u6237");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteUser(e);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		mnNewMenu_1.setIcon(new ImageIcon(AdministratorManagementView.class.getResource("/images/book2.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u56FE\u4E66\u6DFB\u52A0");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				 addBookVies(ex);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u56FE\u4E66\u7EF4\u62A4");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eq) {
				bookMaintenance(eq);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u9000\u51FA");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int it = JOptionPane.showConfirmDialog(null, "是否退出");
				if(it==0) {
					dispose();
				}
			}
		});
		mntmNewMenuItem_4.setIcon(new ImageIcon(AdministratorManagementView.class.getResource("/images/login.png")));
		menuBar.add(mntmNewMenuItem_4);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setResizable(false);             					  //关闭最大化
	}
	/**
	 * 删除用户事件处理
	 * @param e
	 */
	protected void deleteUser(ActionEvent e) {
		// TODO 自动生成的方法存根
		new UnfinishedView().setVisible(true);
	}

	/**
	 * 添加用户事件处理
	 * @param e
	 */
	private void addUser(ActionEvent e) {
		// TODO 自动生成的方法存根
		new UnfinishedView().setVisible(true);
	}

	/**
	 * 图书维护事件处理
	 * @param eq
	 */
	private void bookMaintenance(ActionEvent eq) {
		// TODO 自动生成的方法存根
		new AdministeredBookSetView().setVisible(true);
	}

	/**
	 * 添加图书事件处理
	 * @param ex
	 */
	protected void addBookVies(ActionEvent ex) {
		// TODO 自动生成的方法存根
		new AdministeredBookAddView().setVisible(true);
	}
}

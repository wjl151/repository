package com.book.view.administeredview;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.book.model.Book;
import com.book.servlet.AdministeredDao;
import com.book.util.DataUtil;
import com.book.util.StringUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
/**
 * 管理员图书添加界面
 * @author 武金龙
 *
 */
public class AdministeredBookAddView extends JFrame  {

	private JPanel contentPane;
	private JTextField bookName;
	private JTextField bookprice;
	private JTextField bookAuthor;
	private JTextField bookCategory;
	private JTextField bookIBSN;
	private JTextField bookIntroductory;
	private Book addBook = null;
	private AdministeredDao  adm= new AdministeredDao();
	private Connection con =null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministeredBookAddView frame = new AdministeredBookAddView();
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
	public AdministeredBookAddView() {
		
		
		setTitle("\u56FE\u4E66\u6DFB\u52A0");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 889, 548);
		contentPane = new JPanel();
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u4E66\u540D\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		
		bookName = new JTextField();
		bookName.setColumns(10);
		
		bookprice = new JTextField();
		bookprice.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\u7B80\u4ECB\uFF1A");
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1 = new JLabel("\u4EF7\u683C\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2 = new JLabel("\u4F5C\u8005\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		
		bookAuthor = new JTextField();
		bookAuthor.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u7C7B\u522B\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_4 = new JLabel("IBSN\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 20));
		
		bookCategory = new JTextField();
		bookCategory.setColumns(10);
		
		bookIBSN = new JTextField();
		bookIBSN.setColumns(10);
		
		bookIntroductory = new JTextField();
		bookIntroductory.setColumns(10);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eef) {
				addBook(eef);
			}
		});
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 25));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent et) {
				resetBookAdd(et);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 25));
		btnNewButton_1.setForeground(Color.BLACK);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(122)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_1))
								.addGap(18))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(28)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_4))
							.addGap(26)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(bookprice, GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
										.addComponent(bookAuthor, GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(bookName, GroupLayout.PREFERRED_SIZE, 372, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addGap(97))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(bookIBSN, Alignment.LEADING)
										.addComponent(bookCategory, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
									.addGap(89)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
							.addGap(335))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(bookIntroductory, GroupLayout.PREFERRED_SIZE, 388, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(43)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(bookName, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
							.addGap(47)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(bookprice, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
							.addGap(32)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(bookAuthor, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addGap(35)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_3)
								.addComponent(bookCategory, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(123)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(bookIBSN, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(bookIntroductory, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(2);
		this.setResizable(false);                           //关闭最大化
	} 
	
	/**
	 * 重置事件处理
	 * @param et
	 */
	private void resetBookAdd(ActionEvent et) {
		// TODO 自动生成的方法存根
		this.bookName.setText("");
		this.bookAuthor.setText("");
		this.bookCategory.setText("");
		this.bookIntroductory.setText("");
		this.bookprice.setText("");
		this.bookIBSN.setText("");
	}

	/**
	 * 添加book
	 * @param ef
	 */
	private void addBook(ActionEvent ef) {
		String name = this.bookName.getText();
		double price = Double.valueOf(this.bookprice.getText());
		String author = this.bookAuthor.getText();
		String category = this.bookCategory.getText();
		String IBSN = this.bookIBSN.getText();
		String introductory = this.bookIntroductory.getText();
		addBook = new Book(name, price, author, category, IBSN, introductory);
		
		if(!StringUtil.isEmpty(name)) {
			JOptionPane.showConfirmDialog(null,"书名为空","错误",0);
			return ;
		}
		if(!StringUtil.isEmpty(String.valueOf(price))) {
			JOptionPane.showConfirmDialog(null, "价格为空","错误",0);
			return ;
		}
		Connection con = null;
		try {
			con = DataUtil.getConnectionLink();
			int cnt = adm.bookAdd(con,addBook);
			if(cnt==0) {
				JOptionPane.showConfirmDialog(null, "添加失败","错误", 0); 	
			}else {
				JOptionPane.showConfirmDialog(null, "添加成功","成功", 0);
				resetBookAdd(ef);
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
}

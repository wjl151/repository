package com.book.view.userview;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.book.model.Book;
import com.book.model.User;
import com.book.servlet.CommonalityDao;
import com.book.servlet.UserDao;
import com.book.util.DataUtil;
import com.book.util.StringUtil;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户借阅书籍界面
 *
 * @author 武金龙
 */
public class UserBookView extends JFrame {

	private JPanel contentPane;
	private Connection con = null;
	private UserDao userdao = new UserDao();
	private User newUser = null;
	private Book newBook = null;
	private static Set<Book> bookSet = Collections.synchronizedSet(new HashSet<Book>());
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UserBookView frame = new UserBookView();
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
	public UserBookView(Book book, User user) {
		setTitle("\u56FE\u4E66\u8BE6\u60C5");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 915, 687);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);                              //界面居中
		this.setDefaultCloseOperation(2);                              //关闭而不退出程序
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(book.getCover()));     //封面图片;

		JLabel lblNewLabel_1 = new JLabel("\u4E66\u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 25));

		JLabel bookName = new JLabel("New label");
		bookName.setFont(new Font("宋体", Font.PLAIN, 27));

		JLabel lblNewLabel_3 = new JLabel("\u4F5C\u8005\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 25));

		JLabel bookAuthor = new JLabel("New label");
		bookAuthor.setFont(new Font("宋体", Font.PLAIN, 25));

		JLabel lblNewLabel_2 = new JLabel("\u4EF7\u683C\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 25));

		JLabel bookPrice = new JLabel("New label");
		bookPrice.setFont(new Font("宋体", Font.PLAIN, 25));

		JLabel lblNewLabel_5 = new JLabel("\u7C7B\u522B\uFF1A");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 25));

		JLabel bookCategory = new JLabel("New label");
		bookCategory.setFont(new Font("宋体", Font.PLAIN, 25));

		JLabel lblNewLabel_4 = new JLabel("\u7B80\u4ECB\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 25));

		JLabel bookIntroductory = new JLabel("New label");
		bookIntroductory.setFont(new Font("宋体", Font.PLAIN, 25));

		JButton btnNewButton = new JButton("\u501F\u9605");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setbookSet(book.getId(),user.getId());
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 31));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_contentPane.createSequentialGroup()
																.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
																		.addComponent(lblNewLabel_3)
																		.addComponent(lblNewLabel_1)
																		.addComponent(lblNewLabel_2))
																.addPreferredGap(ComponentPlacement.RELATED)
																.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																		.addComponent(bookPrice)
																		.addComponent(bookAuthor, GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
																		.addComponent(bookIntroductory, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)
																		.addComponent(bookName, GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)))
														.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
														.addGroup(gl_contentPane.createSequentialGroup()
																.addComponent(lblNewLabel_5)
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addComponent(bookCategory)))
												.addContainerGap())
										.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
												.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
												.addGap(216))))
		);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addGap(24)
												.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addGap(39)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
														.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
														.addComponent(bookName))
												.addGap(35)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
														.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
														.addComponent(bookAuthor))
												.addGap(53)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
														.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
														.addComponent(bookPrice))
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
														.addComponent(lblNewLabel_5)
														.addComponent(bookCategory))
												.addGap(62)
												.addComponent(lblNewLabel_4)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(bookIntroductory, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
								.addGap(28))
		);
		bookName.setText(book.getName());
		if (!StringUtil.isEmpty(String.valueOf(book.getPrice()))) {
			bookPrice.setText("暂无价格信息");
		} else bookPrice.setText(String.valueOf(book.getPrice()));
		bookAuthor.setText(book.getAuthor());
		bookIntroductory.setText(book.getIntroductory());
		bookCategory.setText(book.getCategory());
		contentPane.setLayout(gl_contentPane);
		this.setResizable(false);                                               //关闭最大化
	}

	/**
	 * 填充book常量池同时new线程启动保证线程安全
	 * @param bookId
	 * @param userId
	 */
	public void setbookSet(int bookId, int userId) {

			try {
				con = DataUtil.getConnectionLink();
				CommonalityDao ddo = new CommonalityDao();
				newBook = ddo.bookInquire(con, bookId);
				boolean findBool = false;
				for (Book book1 : bookSet) {
					if (newBook.equals(book1)) {
						newBook = book1;
						findBool = true;
						break;
					}
				}
				if(!findBool){
					System.out.println("ss");
					bookSet.add(newBook);
				}
				UserDao usedao = new UserDao();
				newUser = usedao.userLoginId(con, userId);
				Thread t = new Thread(new BorrowBook(newBook,newUser));
				t.start();
			} catch (Exception exception) {
				exception.printStackTrace();
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (SQLException throwables) {
						throwables.printStackTrace();
					}
				}
			}
		}

	/**
	 * 借书线程类
	 */
	class BorrowBook implements Runnable {
		private int userId;
		private int bookId;
		private Book newBook;
		private User newUser;

		public BorrowBook(int userId, int bookId) {
			this.userId = userId;
			this.bookId = bookId;
		}

		public BorrowBook(Book newBook, User newUser) {
			this.newBook = newBook;
			this.newUser = newUser;
		}

		@Override
		public  void run() {
			synchronized (newBook) {
				int bookNum = 0;
				int userMony = 0;
				try {
					con = DataUtil.getConnectionLink();
					UserDao userDao1 = new UserDao();
					userMony = userDao1.getUserNowMony(con, newUser.getId());
					CommonalityDao comdao = new CommonalityDao();
					bookNum = comdao.getBookNumber(con, newBook.getId());
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					if (con != null) {
						try {
							con.close();
						} catch (SQLException throwables) {
							throwables.printStackTrace();
						}
					}
				}
				if (newBook.getPrice() > userMony) {
					JOptionPane.showConfirmDialog(null, "账户余额不足，请充值", "余额不足", 0);
					return;
				}
				if (bookNum > 0) {
					try {

						Book book = new Book();
						book.setId(newBook.getId());

						book.setPrice(newBook.getPrice());
						con = DataUtil.getConnectionLink();
						int cnt = userdao.borrowBook(con, book, newUser.getId(), newUser.getMony());
						if (cnt > 0) {
							dispose();
							JOptionPane.showConfirmDialog(null, "借阅成功", "成功", 0);
						} else {
							JOptionPane.showConfirmDialog(null, "借阅失败", "错误", 0);
						}
					} catch (Exception e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					} finally {
						try {
							con.close();
						} catch (SQLException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}
					}
				} else {
					JOptionPane.showConfirmDialog(null, "借阅失败,馆内暂无图书", "错误", 0);
				}
			}
		}
	}

}

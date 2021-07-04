package com.book.view.userview;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.book.model.Book;
import com.book.model.User;
import com.book.servlet.CommonalityDao;
import com.book.servlet.UserDao;
import com.book.util.DataUtil;
import com.book.view.littleview.AboutAuthorView;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Vector;
import java.awt.event.ActionEvent;

/**
 * 用户主界面
 * @author 武金龙
 *
 */
public class UserMainView extends JFrame {

	private JPanel contentPane;
	private JTable table = new JTable();
	private Connection con = null;
	private CommonalityDao commonalitydao = null;
	private HashSet<Book> onBook= null; 
	private String selectBook1 ;
	private User userNew = null;
	private int bookId;
	public static JLabel UserTop = new JLabel("\u5934\u50CF");        //便于用户更改头像后使主界面头像同时改变

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
		/**
		 * @param user
		 */
	public UserMainView(User user) {
		userNew=user;
		setTitle("\u56FE\u4E66\u501F\u9605\u7CFB\u7EDF V1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1110, 773);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JButton btnNewButton_3 = new JButton("\u67E5\u8BE2");
		JScrollPane bookTable = new JScrollPane();
		ButtonGroup group = new ButtonGroup();
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\u6240\u6709\u56FE\u4E66");
		rdbtnNewRadioButton.setForeground(Color.CYAN);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allBook(e);
			}
		});
		rdbtnNewRadioButton.setFont(new Font("宋体", Font.PLAIN, 17));
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\u5728\u9986\u56FE\u4E66");
		rdbtnNewRadioButton_1.setForeground(Color.CYAN);
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setOpaque(false);
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onLibraryBook(e);
			}
		});
		rdbtnNewRadioButton_1.setSelected(true);
		rdbtnNewRadioButton_1.setFont(new Font("宋体", Font.PLAIN, 17));
		
		JLabel lblNewLabel_2 = new JLabel("\u56FE\u4E66\u5217\u8868");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 35));
		rdbtnNewRadioButton.setOpaque(false);
		
		
		UserTop.setIcon(new ImageIcon(user.getTopphone()));          //加载用户头像
		
		JButton aboutMy = new JButton("\u4E2A\u4EBA\u4FE1\u606F");
		aboutMy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userMess(e);
				
			}
		});
		aboutMy.setFont(new Font("宋体", Font.PLAIN, 24));
		
		JButton aboutMyBook = new JButton("\u6211\u7684\u501F\u9605");
		aboutMyBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UserBorrowBookListView(user).setVisible(true);
			}
		});
		aboutMyBook.setFont(new Font("宋体", Font.PLAIN, 24));
		
		JButton btnNewButton = new JButton("\u5173\u4E8E\u4F5C\u8005");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aboutAuthor(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 24));
		
		JButton btnNewButton_1 = new JButton("\u5237\u65B0");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onLibraryBook(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(UserMainView.class.getResource("/images/reset.png")));
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 22));
		
		JButton btnNewButton_2 = new JButton("\u5207\u6362\u7528\u6237");
		btnNewButton_2.addActionListener(new ActionListener() {
			/**
			 * 切换用户
			 */
			public void actionPerformed(ActionEvent e) {
				userSwitch(e);
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 24));
		
		JLabel lblNewLabel = new JLabel("");
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u8F93\u5165\u4E66\u540D\u67E5\u8BE2\uFF1A");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JTextField selectBookName = new JTextField();
		selectBookName.setColumns(10);
		
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectBook1 = selectBookName.getText();
				selectBook(e);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(UserMainView.class.getResource("/images/pig.png")));
		btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 25));
		
		JButton btnNewButton_4 = new JButton("\u5145\u503C");
		btnNewButton_4.addActionListener(new ActionListener() {
			/*
			 * 充值事件
			 */
			public void actionPerformed(ActionEvent e) {
				nowUserLogin();
				new UserAddMonyView(userNew).setVisible(true);
			}
		});
		btnNewButton_4.setFont(new Font("宋体", Font.PLAIN, 24));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(81)
							.addComponent(UserTop, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(90)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(aboutMy, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(aboutMyBook, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addPreferredGap(ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(rdbtnNewRadioButton_1, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(rdbtnNewRadioButton, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
								.addComponent(bookTable, GroupLayout.PREFERRED_SIZE, 664, GroupLayout.PREFERRED_SIZE))
							.addGap(36))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addGap(28))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addGap(18)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(selectBookName, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
									.addGap(54)
									.addComponent(btnNewButton_3))
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE))
							.addGap(126)))
					.addGap(36))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(39)
					.addComponent(UserTop, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(aboutMy)
					.addGap(35)
					.addComponent(aboutMyBook)
					.addGap(36)
					.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(80))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addComponent(lblNewLabel)
							.addGap(9)
							.addComponent(btnNewButton_3))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(28)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(selectBookName, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1))))
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnNewRadioButton)
						.addComponent(btnNewButton_1)
						.addComponent(rdbtnNewRadioButton_1))
					.addGap(20)
					.addComponent(bookTable, GroupLayout.PREFERRED_SIZE, 475, GroupLayout.PREFERRED_SIZE)
					.addGap(24))
		);
		
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "\u4E66\u540D", "\u4F5C\u8005", "\u7C7B\u522B", "\u4EF7\u683C", "IBSN"
			}){
				boolean[] columnEditables = new boolean[] {
						false, false, false, false, false,false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(52);
		table.getColumnModel().getColumn(1).setPreferredWidth(69);
		table.getColumnModel().getColumn(2).setPreferredWidth(74);
		table.getColumnModel().getColumn(5).setPreferredWidth(94);
		bookTable.setViewportView(table);
		table.getTableHeader().setBackground(Color.WHITE); //表单背景
		Font af = new Font("Dialog",Font.PLAIN,15);            //表头字体
		table.getTableHeader().setFont(af);
		table.getTableHeader().setForeground(Color.BLUE);
		table.addMouseListener(new MouseListener(){
			@Override
		    public void mouseReleased(MouseEvent e) {
		 
		    }
		 
		    @Override
		    public void mousePressed(MouseEvent e) {
		 
		    }
		 
		    @Override
		    public void mouseExited(MouseEvent e) {
		 
		    }
		 
		    @Override
		    public void mouseEntered(MouseEvent e) {
		 
		    }
		 
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        // 点击几次，这里是双击事件
		        if (e.getClickCount() == 2) {
		        	int selectedRow = table.getSelectedRow();
		        	//书籍ID
					bookId = Integer.valueOf(table.getValueAt(selectedRow, 0).toString());

			       try {
					con = DataUtil.getConnectionLink();
					UserDao dao = new UserDao();
					userNew = dao.login(con, user);
					new UserBookView(new CommonalityDao().bookInquire(con, bookId),userNew).setVisible(true);

					onLibraryBook();
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}finally {
					try {
						if (con != null) {
							con.close();
						}

					} catch (SQLException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
				}
			      		
		        }
		    }
		});
		
		this.onLibraryBook();                           //首次填充表格
		//背景加载
		ImageIcon img = new ImageIcon("./systembackground/04.jpg");
		JLabel imgLabel = new JLabel(img);
		Integer afg = Integer.MIN_VALUE;
		getLayeredPane().add(imgLabel,afg);
		imgLabel.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
		((JPanel)getContentPane()).setOpaque(false);

		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);         //界面居中
		this.setResizable(false);               //关闭最大化

	}
	/**
	 * 切换用户事件处理
	 * @param e
	 */
	private void userSwitch(ActionEvent e) {
			// TODO 自动生成的方法存根
		dispose();
		new UserLoginView().setVisible(true);
	}
	/**
	 * 用户信息修改事件处理
	 * @param e
	 */
	private void userMess(ActionEvent e) {
			// TODO 自动生成的方法存根
		try {
			con = DataUtil.getConnectionLink();
			UserDao dao = new UserDao();
			User userNew1 = dao.login(con, userNew);       								//用户从新获取更新信息
			new UserMessage(userNew1).setVisible(true);	
			ImageIcon newPhone = new ImageIcon(userNew1.getTopphone());
			newPhone.getImage().flush();									//清除缓存，更新图片
			UserTop.setIcon(newPhone);						
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
	 * 关于作者事件处理
	 * @param e
	 */
	private void aboutAuthor(ActionEvent e) {
		new AboutAuthorView().setVisible(true);;
	}
	/**
	 * 查询事件处理
	 * @param e
	 */
	private void selectBook(ActionEvent e) {
		// TODO 自动生成的方法存根
		DefaultTableModel std = (DefaultTableModel) table.getModel();
		std.setRowCount(0);   										      //清空旧数据
		try {
			con = DataUtil.getConnectionLink();
			commonalitydao = new CommonalityDao();
			ResultSet ss = commonalitydao.bookInquire(con, selectBook1);
			while(ss.next()) {
				Vector row = new Vector();
				row.add(ss.getString("id"));
				row.add(ss.getString("name"));
				row.add(ss.getString("author"));
				row.add(ss.getString("category"));
				row.add(ss.getString("price"));	
				row.add(ss.getString("IBSN"));
				std.addRow(row);
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
	 * 所有图书事件处理
	 * @param e
	 */
	private void allBook(ActionEvent e) {
		// TODO 自动生成的方法存根
		try {
			con = DataUtil.getConnectionLink();
			commonalitydao = new CommonalityDao();
			onBook = commonalitydao.onLibraryAllBookInquire(con);
			fillTable();
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
	 * 在馆图书事件处理
	 * @param e
	 */
	private void onLibraryBook(ActionEvent e) {
		// TODO 自动生成的方法存根
		try {
			con = DataUtil.getConnectionLink();
			commonalitydao = new CommonalityDao();
			onBook = commonalitydao.onLibraryBookInquire(con);
			fillTable();
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
	 * 无参调用图书查询
	 */
	private  void onLibraryBook() {
		// TODO 自动生成的方法存根
		try {
			con = DataUtil.getConnectionLink();
			commonalitydao = new CommonalityDao();
			onBook = commonalitydao.onLibraryBookInquire(con);
			fillTable();
			
		} catch (Exception e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
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
	 * 填充表格
	 */
	 private void fillTable() {
		DefaultTableModel std = (DefaultTableModel) table.getModel();
		std.setRowCount(0); 										//清空旧数据
		for(Book boo : onBook) {
			Vector row = new Vector();
			row.add(boo.getId());
			row.add(boo.getName());
			row.add(boo.getAuthor());
			row.add(boo.getCategory());
			row.add(boo.getPrice());
			row.add(boo.getIBSN());
			std.addRow(row);
		}
	}

	/**
	 * 用户信息更新
	 * @param
	 */
	private void nowUserLogin() {
		UserDao useLogin = new UserDao();
		Connection con=null;
		try {
			con = DataUtil.getConnectionLink();
			userNew = useLogin.login(con, userNew);

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

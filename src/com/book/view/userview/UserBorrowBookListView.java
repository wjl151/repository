package com.book.view.userview;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.book.model.User;
import com.book.servlet.UserDao;
import com.book.util.DataUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 用户借阅信息界面
 * @author 武金龙
 *
 */
public class UserBorrowBookListView extends JFrame {

	private JPanel contentPane;
	private JTable borrowBookList;
	UserDao ast = new UserDao();
	Connection con = null;
	int userId;
	private JTable table;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UserBorrowBookListView frame = new UserBorrowBookListView();
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
	public UserBorrowBookListView(User user) {
		setTitle("\u501F\u9605\u4FE1\u606F");
		userId = user.getId();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 833, 688);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		this.setLocationRelativeTo(null);          //界面居中
		JLabel lblNewLabel = new JLabel("\u6211\u7684\u501F\u9605\u5386\u53F2");
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 28));
		
		JLabel lblNewLabel_1 = new JLabel("\u501F\u9605\u4E2D\u7684\u4E66\u7C4D");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 28));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JButton btnNewButton = new JButton("\u8FD8\u4E66");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnBook(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 28));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(324)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(319)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(86)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(scrollPane_1)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(330)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(58, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u4E66\u540D", "\u501F\u4E66\u65E5\u671F", "\u6700\u665A\u8FD8\u4E66\u65E5\u671F"
			})
			{
				boolean[] columnEditables = new boolean[] {
					false, false, false,false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
		});
		table.getTableHeader().setBackground(Color.WHITE); //表单背景
		Font af2 = new Font("Dialog",Font.PLAIN,15);            //表头字体
		table.getTableHeader().setFont(af2);
		table.getTableHeader().setForeground(Color.RED);
		table.getColumnModel().getColumn(1).setPreferredWidth(105);
		table.getColumnModel().getColumn(2).setPreferredWidth(106);
		scrollPane_1.setViewportView(table);
		Font af = new Font("Dialog",Font.PLAIN,15);
		
		borrowBookList = new JTable();
		borrowBookList.setForeground(Color.CYAN);
		borrowBookList.setBackground(Color.DARK_GRAY);
		borrowBookList.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u4E66\u540D", "\u501F\u4E66\u65E5\u671F", "\u8FD8\u4E66\u65E5\u671F"
			})
			 {
				boolean[] columnEditables = new boolean[] {
					false, false, false,false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
		});
		
		borrowBookList.getTableHeader().setBackground(Color.WHITE); //表单背景
		Font af1 = new Font("Dialog",Font.PLAIN,15);            //表头字体
		borrowBookList.getTableHeader().setFont(af);	
		borrowBookList.getTableHeader().setForeground(Color.RED);
		borrowBookList.getColumnModel().getColumn(0).setPreferredWidth(83);
		borrowBookList.getColumnModel().getColumn(1).setPreferredWidth(92);
		borrowBookList.getColumnModel().getColumn(2).setPreferredWidth(95);
		scrollPane.setViewportView(borrowBookList);
		contentPane.setLayout(gl_contentPane);
		borrowNowTable();
		allBorrowNowTable();
		this.setDefaultCloseOperation(2); 			                  //关闭而不退出程序
		this.setResizable(false);               //关闭最大化
	}
	/**
	 * 还书事件处理
	 * @param e
	 */
	private void returnBook(ActionEvent e) {
		// TODO 自动生成的方法存根
		 DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		 LocalDate backTime1 = LocalDate.parse(table.getValueAt(table.getSelectedRow(),1).toString(), fmt);
		 Date backTime = Date.valueOf(backTime1);
		try {
			
		  String a = table.getValueAt(table.getSelectedRow(),0).toString();
		  try {
			  con = DataUtil.getConnectionLink();
	          int cnt=ast.returnBook(con, userId, a, backTime);
	          if(cnt>0) {
	        	  JOptionPane.showConfirmDialog(null, "还书成功","成功",0);
	          }else JOptionPane.showConfirmDialog(null, "还书失败","错误",0);
		  } catch(Exception ex) {
			 
	    	   ex.printStackTrace();
	       }finally {
	    	   try {
	    		   con.close();
	    	   }catch(Exception ef) {
	    		   ef.printStackTrace();
	    	   }
	       }
	      
		} catch(Exception ex) {
			 JOptionPane.showConfirmDialog(null, "请选择要还的图书","错误",0);
		 }
		borrowNowTable();
		allBorrowNowTable();
	}
	/**
	 * 借阅中图书列表更新
	 */
	private void borrowNowTable() {
		DefaultTableModel std = (DefaultTableModel) table.getModel();
		std.setRowCount(0);   										//清空旧数据
		try {
			con = DataUtil.getConnectionLink();
			ResultSet ss = ast.selectNowBorrowBook(con,userId);
			while(ss.next()) {
				Vector row = new Vector();
				
				row.add(ss.getString("name"));
				row.add(ss.getString("outtime"));
				row.add(ss.getString("endtime"));
				std.addRow(row);
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
	 * 图书借阅历史列表更新
	 */
	private void allBorrowNowTable() {
		DefaultTableModel std = (DefaultTableModel) borrowBookList.getModel();
		std.setRowCount(0);   										//清空旧数据
		try {
			con = DataUtil.getConnectionLink();
			ResultSet ss = ast.backSelectNowBorrowBook(con,userId);
			while(ss.next()) {
				Vector row = new Vector();
				row.add(ss.getString("name"));
				row.add(ss.getString("outtime"));
				row.add(ss.getString("backtime"));
				std.addRow(row);
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

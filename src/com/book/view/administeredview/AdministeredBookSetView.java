package com.book.view.administeredview;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.book.servlet.CommonalityDao;
import com.book.util.DataUtil;



import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

/**
 * 图书修改管理界面
 * @author 武金龙
 *
 */
public class AdministeredBookSetView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministeredBookSetView frame = new AdministeredBookSetView();
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
	public AdministeredBookSetView() {
		setTitle("\u56FE\u4E66\u4FEE\u6539\u7BA1\u7406\u754C\u9762");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1296, 846);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);          //界面居中
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u4E66\u540D\u67E5\u8BE2\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		
		inquireTxt = new JTextField();
		inquireTxt.setColumns(10);
		
		JButton btnNewButton = new JButton(" \u67E5\u8BE2");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 22));
		btnNewButton.setIcon(new ImageIcon(AdministeredBookSetView.class.getResource("/images/pig.png")));
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inquireBook(e);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnNewButton_1 = new JButton("  \u5237\u65B0");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ety) {
				refreshDate(ety);
			}
		});
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setIcon(new ImageIcon(AdministeredBookSetView.class.getResource("/images/reset.png")));
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 21));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(280)
							.addComponent(lblNewLabel)
							.addGap(53)
							.addComponent(inquireTxt, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)
							.addGap(60)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
							.addComponent(btnNewButton_1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(185, Short.MAX_VALUE)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 907, GroupLayout.PREFERRED_SIZE)))
					.addGap(180))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(52)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(inquireTxt, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
							.addGap(58))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addGap(18)))
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 517, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(116, Short.MAX_VALUE))
		);
		
		bookTable = new JTable();
		bookTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "\u4E66\u540D", "\u4F5C\u8005", "\u4EF7\u683C", "\u5206\u7C7B", "IBSN", "\u6570\u91CF"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false,false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bookTable.getTableHeader().setBackground(Color.WHITE); //表单背景
		Font af = new Font("Dialog",Font.PLAIN,15);            //表头字体
		bookTable.getTableHeader().setFont(af);
		bookTable.getTableHeader().setForeground(Color.RED);
		
		bookTable.getColumnModel().getColumn(0).setPreferredWidth(49);
		bookTable.getColumnModel().getColumn(1).setPreferredWidth(64);
		bookTable.getColumnModel().getColumn(2).setPreferredWidth(77);
		bookTable.getColumnModel().getColumn(3).setPreferredWidth(55);
		bookTable.getColumnModel().getColumn(4).setPreferredWidth(59);
		bookTable.getColumnModel().getColumn(5).setPreferredWidth(137);
		bookTable.getColumnModel().getColumn(6).setPreferredWidth(56);
		scrollPane.setViewportView(bookTable);
		
		//表格双击响应
		bookTable.addMouseListener(new MouseListener(){
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
		        	int selectedRow = bookTable.getSelectedRow();
		        	//传入书籍ID
		        	
				   int id = Integer.valueOf(bookTable.getValueAt(selectedRow, 0).toString());
			       Connection con1 = null;
			       try {
					con1 = DataUtil.getConnectionLink();
					new AdministeredBookChangeView(new CommonalityDao().bookInquire(con1, id)).setVisible(true);
					 
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}finally {
					try {
						con1.close();
					} catch (SQLException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
				}
			      
			      
					
		        }
		    }

			
		});
		contentPane.setLayout(gl_contentPane);
		this.fillTable("");
		this.setDefaultCloseOperation(2); 			//关闭而不退出程序
		this.setResizable(false);             	  //关闭最大化
	}
	/**
	 * 刷新事件处理
	 * @param ety
	 */
	protected void refreshDate(ActionEvent ety) {
		// TODO 自动生成的方法存根
		fillTable("");
	}

	/**
	 * 查询书籍
	 * @param e
	 */
	private void inquireBook(ActionEvent e) {
		// TODO 自动生成的方法存根
		String aft = this.inquireTxt.getText();
		this.fillTable(aft);
	}
	/**
	 * 表单数据操作
	 */
	CommonalityDao ast = new CommonalityDao();
	Connection con = null;
	private JTextField inquireTxt;
	private JTable bookTable;
	private void fillTable(String ut) {
		DefaultTableModel std = (DefaultTableModel) bookTable.getModel();
		std.setRowCount(0);;   										//清空旧数据
		try {
			con = DataUtil.getConnectionLink();
			ResultSet ss = ast.bookInquire(con, ut);
			while(ss.next()) {
				Vector row = new Vector();
				row.add(ss.getString("id"));
				row.add(ss.getString("name"));
				row.add(ss.getString("author"));
				row.add(ss.getString("price"));
				row.add(ss.getString("category"));
				row.add(ss.getString("IBSN"));
				row.add(ss.getString("number"));
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

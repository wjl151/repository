package com.book.view.administeredview;

import java.awt.BorderLayout;




import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.book.model.Book;
import com.book.servlet.AdministeredDao;
import com.book.util.DataUtil;
import com.book.util.StringUtil;
//import com.mysql.cj.CharsetMapping;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.time.LocalDate;
import java.util.Calendar;


import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.List;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;

/**
 * 图书修改界面
 * @author 武金龙
 *
 */
public class AdministeredBookChangeView extends JFrame {

	private JPanel bookPicture;
	private Book changeBook = null;
	private Connection con = null;
	private Integer id=null;
	private JTextField bookname;
	private JTextField bookPrice;
	private JTextField bookAuthor;
	private JTextField bookPulishdateYear;
	private JTextField bookPulishdateMonth;
	private JTextField bookPulishdateDay;
	private JTextField bookIBSN;
	private JTextField bookNumber;
	private JComboBox bookCategory = new JComboBox();
    private	JLabel bookPhone = new JLabel("");
    private String phoneRoad ;


	/**
	 * Create the frame.
	 */
	public AdministeredBookChangeView(Book changeBook) {
		setTitle("\u56FE\u4E66\u4FEE\u6539");

		this.changeBook = changeBook;
		id = changeBook.getId();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1079, 720);
		this.setLocationRelativeTo(null);                              //界面居中
		bookPicture = new JPanel();
		bookPicture.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(bookPicture);

		ImageIcon phone1 = new ImageIcon(changeBook.getCover());
		phone1.getImage().flush();									//清除缓存
		bookPhone.setIcon(phone1);     //封面图片
		
		JLabel lblNewLabel_1 = new JLabel(" \u4E66\u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 22));
		
		bookname = new JTextField();
		bookname.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel(" \u5206 \u7C7B\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 22));
		
		JLabel eawd = new JLabel(" \u4EF7\u683C\uFF1A");
		eawd.setFont(new Font("宋体", Font.PLAIN, 22));
		
		bookPrice = new JTextField();
		bookPrice.setColumns(10);
		
		JLabel sdad = new JLabel(" \u4F5C\u8005\uFF1A");
		sdad.setFont(new Font("宋体", Font.PLAIN, 22));
		
		bookAuthor = new JTextField();
		bookAuthor.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel(" \u51FA\u7248\u65E5\u671F\uFF1A");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 22));
		
		bookPulishdateYear = new JTextField();
		bookPulishdateYear.setColumns(10);
		
		JLabel sda = new JLabel("\u5E74");
		sda.setFont(new Font("宋体", Font.PLAIN, 22));
		
		bookPulishdateMonth = new JTextField();
		bookPulishdateMonth.setColumns(10);
		
		JLabel eqw = new JLabel("\u6708");
		eqw.setFont(new Font("宋体", Font.PLAIN, 22));
		
		bookPulishdateDay = new JTextField();
		bookPulishdateDay.setColumns(10);
		
		JLabel hghgj = new JLabel("\u65E5");
		hghgj.setFont(new Font("宋体", Font.PLAIN, 22));
		
		bookIBSN = new JTextField();
		bookIBSN.setColumns(10);
		
		JLabel ttrs = new JLabel(" IBSN\uFF1A");
		ttrs.setFont(new Font("宋体", Font.PLAIN, 22));
		
		JLabel bookIntrorductory = new JLabel(" \u7B80\u4ECB\uFF1A");
		bookIntrorductory.setFont(new Font("宋体", Font.PLAIN, 22));
		
		JTextArea bookIntroductory = new JTextArea();
		
		JButton btnNewButton = new JButton("\u63D0\u4EA4");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eef) {
				String tyu = bookIntroductory.getText();
				bookUpdate(eef,tyu);
			}
		});
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setIcon(new ImageIcon(AdministeredBookChangeView.class.getResource("/images/true.png")));
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 30));
		
		JLabel lblNewLabel_3 = new JLabel(" \u6570\u91CF\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 22));
		
		bookNumber = new JTextField();
		bookNumber.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u5220\u9664\u56FE\u4E66");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteBook(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(AdministeredBookChangeView.class.getResource("/images/error.png")));
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 25));
		btnNewButton_1.setForeground(Color.RED);
		
		
		bookCategory.setModel(new DefaultComboBoxModel(new String[] {"\u6570\u5B66\u7C7B", "\u8BA1\u7B97\u673A\u7C7B", "\u6682\u65E0\u5206\u7C7B"}));
		
		JButton btnNewButton_2 = new JButton("\u4E0A\u4F20\u4E66\u7C4D\u5C01\u9762");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookPhoneUpdate(e);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(AdministeredBookChangeView.class.getResource("/images/folder.png")));
		GroupLayout gl_bookPicture = new GroupLayout(bookPicture);
		gl_bookPicture.setHorizontalGroup(
			gl_bookPicture.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_bookPicture.createSequentialGroup()
					.addGroup(gl_bookPicture.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_bookPicture.createSequentialGroup()
							.addGap(19)
							.addComponent(bookPhone, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_bookPicture.createSequentialGroup()
							.addGap(109)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_bookPicture.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_bookPicture.createSequentialGroup()
							.addGap(39)
							.addGroup(gl_bookPicture.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_bookPicture.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_bookPicture.createSequentialGroup()
										.addComponent(lblNewLabel_1)
										.addGap(26))
									.addGroup(gl_bookPicture.createSequentialGroup()
										.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)))
								.addGroup(gl_bookPicture.createSequentialGroup()
									.addComponent(sdad)
									.addGap(26)))
							.addGroup(gl_bookPicture.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_bookPicture.createSequentialGroup()
									.addGroup(gl_bookPicture.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_bookPicture.createSequentialGroup()
											.addComponent(bookPulishdateYear, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(sda, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(bookPulishdateMonth, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(eqw, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(bookPulishdateDay, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
										.addGroup(gl_bookPicture.createSequentialGroup()
											.addGroup(gl_bookPicture.createParallelGroup(Alignment.LEADING, false)
												.addComponent(bookCategory, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(bookAuthor, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
											.addGap(18, 60, Short.MAX_VALUE)
											.addGroup(gl_bookPicture.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_bookPicture.createSequentialGroup()
													.addComponent(eawd, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(bookPrice, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
												.addGroup(gl_bookPicture.createSequentialGroup()
													.addComponent(lblNewLabel_3)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(bookNumber, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)))))
									.addGap(28)
									.addComponent(hghgj, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_bookPicture.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(bookname, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
									.addGap(101))))
						.addGroup(gl_bookPicture.createSequentialGroup()
							.addGap(18)
							.addComponent(lblNewLabel_5))
						.addGroup(gl_bookPicture.createSequentialGroup()
							.addGap(28)
							.addGroup(gl_bookPicture.createParallelGroup(Alignment.LEADING)
								.addComponent(bookIntrorductory)
								.addComponent(ttrs))
							.addGap(32)
							.addGroup(gl_bookPicture.createParallelGroup(Alignment.LEADING)
								.addComponent(bookIBSN, GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
								.addGroup(gl_bookPicture.createSequentialGroup()
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
								.addComponent(bookIntroductory, GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE))))
					.addGap(103))
		);
		gl_bookPicture.setVerticalGroup(
			gl_bookPicture.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_bookPicture.createSequentialGroup()
					.addGroup(gl_bookPicture.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_bookPicture.createSequentialGroup()
							.addGap(35)
							.addComponent(bookPhone, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_bookPicture.createSequentialGroup()
							.addGap(46)
							.addGroup(gl_bookPicture.createParallelGroup(Alignment.LEADING, false)
								.addComponent(bookname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
							.addGap(39)
							.addGroup(gl_bookPicture.createParallelGroup(Alignment.LEADING, false)
								.addComponent(bookPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_bookPicture.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
									.addComponent(bookCategory, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(eawd, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(41)
							.addGroup(gl_bookPicture.createParallelGroup(Alignment.BASELINE)
								.addComponent(sdad, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
								.addComponent(bookAuthor, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(bookNumber, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
							.addGap(49)
							.addGroup(gl_bookPicture.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
								.addComponent(hghgj)
								.addComponent(bookPulishdateDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(eqw)
								.addComponent(bookPulishdateMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(sda)
								.addComponent(bookPulishdateYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(40)
							.addGroup(gl_bookPicture.createParallelGroup(Alignment.BASELINE)
								.addComponent(ttrs)
								.addComponent(bookIBSN, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
							.addGap(59)
							.addGroup(gl_bookPicture.createParallelGroup(Alignment.LEADING)
								.addComponent(bookIntroductory, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
								.addComponent(bookIntrorductory, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_bookPicture.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
					.addGap(27))
		);
		bookIntroductory.setLineWrap(true);
		eawd.setText("\u4EF7\u683C");
		ttrs.setText(" IBSN:");
		//初始化文本框信息设置
		bookname.setText(" "+changeBook.getName());
		bookIntroductory.setText(" "+changeBook.getIntroductory());
		bookIBSN.setText(" "+changeBook.getIBSN());
		bookNumber.setText(" " +String.valueOf(changeBook.getNumber()));
		bookPrice.setText(" "+String.valueOf(changeBook.getPrice()));
		bookAuthor.setText(changeBook.getAuthor());
		bookPicture.setLayout(gl_bookPicture);
		//设置下拉框默认值
		
		bookCategory.setSelectedItem(changeBook.getCategory());
		if(changeBook.getPublishdate()!=null) {
			LocalDate bookDate = changeBook.getPublishdate().toLocalDate();
			bookPulishdateYear.setText(String.valueOf(bookDate.getYear()) );
			bookPulishdateMonth.setText(String.valueOf(bookDate.getMonthValue()));
			bookPulishdateDay.setText(String.valueOf(bookDate.getDayOfMonth()));
		}
		
		
		this.setDefaultCloseOperation(2); 			                  //关闭而不退出程序
		this.setResizable(false);               					//关闭最大化
		
	}
	/**
	 * 图书封面上传事件
	 * @param e
	 */
	protected void bookPhoneUpdate(ActionEvent e) {
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
			bookPhone.setIcon(new ImageIcon(file.getPath()));
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
		String fileRoad = "./bookbackgroud/bookBackgroud"+String.valueOf(changeBook.getId())+".jpg";
		FileOutputStream outPhone = new FileOutputStream(fileRoad);
		int cnt = 0;
		byte [] readPhone = new byte[1024*1024];

		while((cnt =inPhone.read(readPhone)) != -1) {
			outPhone.write(readPhone,0,cnt);
		}
		phoneRoad=fileRoad;
		inPhone.close();
		outPhone.close();
	}
	/**
	 * 删除图书
	 * @param e
	 */
	private void deleteBook(ActionEvent e) {
		// TODO 自动生成的方法存根
		try {
			con = DataUtil.getConnectionLink();
			AdministeredDao adm = new AdministeredDao();
			int cnt = adm.deleteBook(con, id);
			if(cnt>0) {
				JOptionPane.showConfirmDialog(null, "删除成功","成功",0);
				dispose();
			}else {
				JOptionPane.showConfirmDialog(null, "删除失败","失败",0);

			}
		} catch (Exception e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
	}

	/**
	 * 修改事件处理
	 * @param eef
	 */
	private void bookUpdate(ActionEvent eef,String introductory) {
		// TODO 自动生成的方法存根
		Book book = new Book();
		book.setId(id);
		if(!StringUtil.isEmpty(bookname.getText())) {
			JOptionPane.showConfirmDialog(null, "书名不能为空","错误",0);
			return ;
		}
		
		book.setName(bookname.getText().trim());
		book.setAuthor(bookAuthor.getText().trim());
		book.setIBSN(bookIBSN.getText().trim());
		book.setCategory(bookCategory.getSelectedItem().toString().trim());
		book.setNumber(Integer.valueOf(bookNumber.getText().trim()));
		book.setPrice(Double.valueOf(bookPrice.getText().trim()));
		book.setAuthor(bookAuthor.getText().trim());
		book.setIntroductory(introductory);
		book.setCover(phoneRoad);

		if(StringUtil.isEmpty(bookPulishdateYear.getText()) && StringUtil.isEmpty(bookPulishdateMonth.getText()) && StringUtil.isEmpty(bookPulishdateDay.getText())) {
			LocalDate data = LocalDate.of(Integer.valueOf(bookPulishdateYear.getText()), 
					         Integer.valueOf(bookPulishdateMonth.getText()), Integer.valueOf(bookPulishdateDay.getText()));
			book.setPublishdate(Date.valueOf(data));
		}
		
		try {
			con = DataUtil.getConnectionLink();
			new AdministeredDao().bookUpdate(con,book);
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
		JOptionPane.showConfirmDialog(null, "修改成功","成功",0);
		dispose();
	}
}
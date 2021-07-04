package com.book.view.littleview;

/**
 * 关于作者
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

/**
 * 关于作者
 * @author 武金龙
 *
 */
public class AboutAuthorView extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AboutAuthorView frame = new AboutAuthorView();
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
    public AboutAuthorView() {
        setTitle("\u5173\u4E8E\u4F5C\u8005");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 585, 360);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("\u8F6F\u4EF620-1\uFF1A");
        lblNewLabel.setForeground(Color.BLUE);
        lblNewLabel.setBackground(Color.BLUE);
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 35));

        JLabel lblNewLabel_1 = new JLabel(" \u6B66\u91D1\u9F99");
        lblNewLabel_1.setForeground(Color.BLUE);
        lblNewLabel_1.setBackground(Color.BLUE);
        lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 35));

        JLabel lblNewLabel_2 = new JLabel("\u4F5C\u8005\uFF1A");
        lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 26));
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(76)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(38)
                                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18)
                                                .addComponent(lblNewLabel_1)))
                                .addContainerGap(122, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(64)
                                .addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(86, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
        this.setLocationRelativeTo(null);                                 //界面居中显示
        this.setDefaultCloseOperation(2); 			                       //关闭而不退出程序
        this.setResizable(false);               //关闭最大化
    }
}

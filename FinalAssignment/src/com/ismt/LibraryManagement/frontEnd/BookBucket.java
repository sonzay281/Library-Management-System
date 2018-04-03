package com.ismt.LibraryManagement.frontEnd;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.ismt.LibraryManagement.backend.dao.UserDAO;
import com.ismt.LibraryManagement.backend.dao.impl.UserDAOImpl;
import com.ismt.LibraryManagement.backend.entity.User;

public class BookBucket extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public BookBucket(int mid) {
		setResizable(false);
		setTitle("STUDENT BUCKET");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 640, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 153, 153)),
				"STUDENT BUCKET", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 153, 153)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnDashboard = new JButton("DASHBOARD");
		btnDashboard.setIcon(new ImageIcon(BookBucket.class.getResource("/resources/icons/icons8-user-menu-male.png")));
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new RegisteredUser(mid).setVisible(true);
			}
		});
		btnDashboard.setBounds(498, 21, 126, 25);
		contentPane.add(btnDashboard);

		UserDAO userDAO = new UserDAOImpl();
		String[] columnNames = { "BID", "BOOK NAME", "SUBJECT", "AUTHOR", "PUBLICATION", "ISSUED DATE", "DUE DATE" };

		table = new JTable();
		table.setBounds(106, 115, 1, 1);
		DefaultTableModel tbl = new DefaultTableModel(columnNames, 0);
		table.setModel(tbl);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 57, 614, 303);
		contentPane.add(scrollPane);

		table.setVisible(true);
		try {
			User u = new User();
			u.setMid(mid);
			userDAO.getAllBooks();
			for (User a : userDAO.getBucketList(u)) {
				tbl.addRow(new Object[] { a.getBid(), a.getBookName(), a.getSubject(), a.getAuthor(),
						a.getPublication(), a.getIssueDate(), a.getDueDate() });
			}
		} catch (ClassNotFoundException | SQLException e1) {
			System.out.println(e1.getMessage());
			e1.printStackTrace();
		}

	}
}

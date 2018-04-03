package com.ismt.LibraryManagement.frontEnd;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.ismt.LibraryManagement.backend.dao.UserDAO;
import com.ismt.LibraryManagement.backend.dao.impl.UserDAOImpl;
import com.ismt.LibraryManagement.backend.entity.User;

import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ListBooks extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public ListBooks() {
		setResizable(false);
		setTitle("BOOK STORE");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 640, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 153, 153)),
				"BOOK STORE", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 153, 153)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnDashboard = new JButton("DASHBOARD");
		btnDashboard.setIcon(new ImageIcon(ListBooks.class.getResource("/resources/icons/icons8-user-menu-male.png")));
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LoginPage().setVisible(true);
			}
		});
		btnDashboard.setBounds(498, 21, 126, 25);
		contentPane.add(btnDashboard);

		UserDAO userDAO = new UserDAOImpl();
		String[] columnNames = { "BID", "BOOK NAME", "SUBJECT", "AUTHOR", "PUBLICATION", "ADDED DATE", "QUANTITY" };

		table = new JTable();
		table.setBounds(106, 115, 1, 1);
		DefaultTableModel tbl = new DefaultTableModel(columnNames, 0);
		table.setModel(tbl);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 57, 614, 303);
		contentPane.add(scrollPane);

		table.setVisible(true);
		try {

			userDAO.getAllBooks();
			for (User a : userDAO.getAllBooks()) {
				tbl.addRow(new Object[] { a.getBid(), a.getBookName(), a.getSubject(), a.getAuthor(),
						a.getPublication(), a.getAddedDate(), a.getQuantity() });
			}
		} catch (ClassNotFoundException | SQLException e1) {
			System.out.println(e1.getMessage());
			e1.printStackTrace();
		}

	}
}

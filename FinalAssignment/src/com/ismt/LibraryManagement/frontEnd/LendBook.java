package com.ismt.LibraryManagement.frontEnd;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JEditorPane;

import com.ismt.LibraryManagement.backend.dao.UserDAO;
import com.ismt.LibraryManagement.backend.dao.impl.UserDAOImpl;
import com.ismt.LibraryManagement.backend.entity.User;
import com.toedter.calendar.JDateChooser;

public class LendBook extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtBID;
	private JTextField txtBookName;
	private JTextField txtStudentName;
	private JTextField txtMID;
	private JButton btnCancel;
	private JDateChooser dueDate;
	User u = new User();

	/**
	 * Create the frame.
	 */
	public LendBook() {
		setResizable(false);
		setForeground(Color.LIGHT_GRAY);
		setTitle("LEND BOOK");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(400, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setForeground(new Color(25, 25, 112));
		contentPane.setBorder(new TitledBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 153, 153)),
				"LEND BOOK", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBookId = new JLabel("BOOK ID");
		lblBookId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBookId.setForeground(Color.BLACK);
		lblBookId.setBackground(Color.LIGHT_GRAY);
		lblBookId.setBounds(11, 25, 120, 25);
		contentPane.add(lblBookId);

		txtBID = new JTextField();
		txtBID.setBounds(142, 23, 232, 25);
		contentPane.add(txtBID);
		txtBID.setColumns(10);

		JLabel lblBookName = new JLabel("BOOK NAME");
		lblBookName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBookName.setForeground(Color.BLACK);
		lblBookName.setBounds(11, 63, 120, 25);
		contentPane.add(lblBookName);

		txtBookName = new JTextField();
		txtBookName.setBounds(142, 61, 232, 25);
		contentPane.add(txtBookName);
		txtBookName.setColumns(10);

		JLabel lblSubject = new JLabel("STUDENT NAME");
		lblSubject.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSubject.setForeground(Color.BLACK);
		lblSubject.setBounds(11, 101, 120, 25);
		contentPane.add(lblSubject);

		JLabel lblAuthor = new JLabel("MEMBER ID");
		lblAuthor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAuthor.setForeground(Color.BLACK);
		lblAuthor.setBounds(11, 139, 120, 25);
		contentPane.add(lblAuthor);

		JLabel lblPublication = new JLabel("DUE DATE");
		lblPublication.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPublication.setForeground(Color.BLACK);
		lblPublication.setBounds(11, 177, 120, 25);
		contentPane.add(lblPublication);

		txtStudentName = new JTextField();
		txtStudentName.setBounds(142, 99, 232, 25);
		contentPane.add(txtStudentName);
		txtStudentName.setColumns(10);

		txtMID = new JTextField();
		txtMID.setBounds(142, 141, 232, 25);
		contentPane.add(txtMID);
		txtMID.setColumns(10);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					UserDAO userDAO = new UserDAOImpl();
					u.setBid(Integer.parseInt(txtBID.getText()));
					u.setBookName(txtBookName.getText());
					u.setStudentName(txtStudentName.getText());
					u.setMid(Integer.parseInt(txtMID.getText()));
					u.setDueDate(dueDate.getDate());
					int result = userDAO.borrowBook(u);
					if (result > 0) {
						JOptionPane.showMessageDialog(null, "Operation Successful.");
						dispose();
						new AdminDashboard().setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null,
								"Please chech the store before you perform this operation.");
						dispose();
						new AdminDashboard().setVisible(true);
					}
				} catch (ClassNotFoundException | SQLException | IOException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					e.printStackTrace();
					dispose();
					new AdminDashboard().setVisible(true);
				}

			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSave.setIcon(new ImageIcon("G:\\programming\\New folder (2)\\save.png"));
		btnSave.setForeground(new Color(25, 25, 112));
		btnSave.setBounds(274, 214, 100, 30);
		contentPane.add(btnSave);

		btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminDashboard().setVisible(true);
				dispose();
			}
		});
		btnCancel.setForeground(new Color(25, 25, 112));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancel.setBounds(152, 214, 100, 30);
		contentPane.add(btnCancel);
		contentPane.add(getDueDate());
	}

	private JDateChooser getDueDate() {
		if (dueDate == null) {
			dueDate = new JDateChooser();
			dueDate.setBounds(142, 177, 232, 25);
		}
		return dueDate;
	}
}

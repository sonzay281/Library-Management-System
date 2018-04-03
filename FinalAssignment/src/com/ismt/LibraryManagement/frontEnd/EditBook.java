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

import com.ismt.LibraryManagement.backend.dao.UserDAO;
import com.ismt.LibraryManagement.backend.dao.impl.UserDAOImpl;
import com.ismt.LibraryManagement.backend.entity.User;

public class EditBook extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtBID;
	private JTextField txtBookName;
	private JTextField txtPublication;
	private JTextField txtAuthor;
	private JTextField txtQuantity;
	private JTextField txtSearch;
	User u = new User();
	private JLabel lblSubject;
	private JTextField txtSubject;
	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// EditBook frame = new EditBook();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the frame.
	 */
	public EditBook() {
		setResizable(false);
		setTitle("Edit Book\r\n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(400, 315);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 153, 153)),
				"UPDATE BOOK DETAILS", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSno = new JLabel("BOOK ID");
		lblSno.setForeground(new Color(25, 25, 112));
		lblSno.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSno.setBounds(10, 48, 123, 25);
		contentPane.add(lblSno);

		txtBID = new JTextField();
		txtBID.setEnabled(false);
		txtBID.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtBID.setBounds(156, 47, 218, 25);
		contentPane.add(txtBID);
		txtBID.setColumns(10);

		JLabel lblBookName = new JLabel("BOOK NAME");
		lblBookName.setForeground(new Color(25, 25, 112));
		lblBookName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBookName.setBounds(10, 113, 123, 25);
		contentPane.add(lblBookName);

		txtBookName = new JTextField();
		txtBookName.setBounds(156, 111, 218, 25);
		contentPane.add(txtBookName);
		txtBookName.setColumns(10);

		JLabel lblPublication = new JLabel("PUBLICATION");
		lblPublication.setForeground(new Color(25, 25, 112));
		lblPublication.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPublication.setBounds(10, 149, 123, 25);
		contentPane.add(lblPublication);

		txtPublication = new JTextField();
		txtPublication.setBounds(156, 149, 218, 25);
		contentPane.add(txtPublication);
		txtPublication.setColumns(10);

		JLabel lblAuthor = new JLabel("AUTHOR");
		lblAuthor.setForeground(new Color(25, 25, 112));
		lblAuthor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAuthor.setBounds(10, 185, 122, 25);
		contentPane.add(lblAuthor);

		txtAuthor = new JTextField();
		txtAuthor.setBounds(155, 185, 218, 25);
		contentPane.add(txtAuthor);
		txtAuthor.setColumns(10);

		JLabel lblQuantity = new JLabel("QUANTITY");
		lblQuantity.setForeground(new Color(25, 25, 112));
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblQuantity.setBounds(11, 221, 122, 25);
		contentPane.add(lblQuantity);

		txtQuantity = new JTextField();
		txtQuantity.setBounds(156, 220, 218, 25);
		contentPane.add(txtQuantity);
		txtQuantity.setColumns(10);

		JButton btnDelete = new JButton("CANCEL");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminDashboard().setVisible(true);
				dispose();
			}
		});
		btnDelete.setIcon(new ImageIcon("G:\\programming\\New folder (2)\\clear.png"));
		btnDelete.setForeground(new Color(25, 25, 112));
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDelete.setBounds(156, 247, 97, 28);
		contentPane.add(btnDelete);

		JButton btnEdit = new JButton("UPDATE");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UserDAO userDAO = new UserDAOImpl();
					u.setBid(Integer.parseInt(txtBID.getText()));
					u.setSubject(txtSubject.getText());
					u.setBookName(txtBookName.getText());
					u.setAuthor(txtAuthor.getText());
					u.setPublication(txtPublication.getText());
					u.setQuantity(Integer.parseInt(txtQuantity.getText()));
					int result = userDAO.updateBook(u);
					if (result > 0) {
						JOptionPane.showMessageDialog(null, "Operation successfull.");
						dispose();
						new AdminDashboard().setVisible(true);

					}
				} catch (ClassNotFoundException | SQLException | IOException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					dispose();
					new AdminDashboard().setVisible(true);
					e1.getMessage();
					e1.printStackTrace();
				}
			}
		});
		btnEdit.setIcon(new ImageIcon("G:\\programming\\New folder (2)\\edit img22.png"));
		btnEdit.setForeground(new Color(25, 25, 112));
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEdit.setBounds(277, 247, 97, 28);
		contentPane.add(btnEdit);

		JLabel label = new JLabel("SEARCH");
		label.setBounds(10, 13, 49, 25);
		contentPane.add(label);

		txtSearch = new JTextField();
		txtSearch.setColumns(10);
		txtSearch.setBounds(69, 15, 114, 25);
		contentPane.add(txtSearch);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					UserDAO userDAO = new UserDAOImpl();
					u.setBid(Integer.parseInt(txtSearch.getText()));
					System.out.println(u.getBid());
					userDAO.searchBook(u);
					for (User a : userDAO.searchBook(u)) {
						txtBID.setText(String.valueOf(a.getBid()));
						txtSubject.setText(a.getSubject());
						txtBookName.setText(a.getBookName());
						txtAuthor.setText(a.getAuthor());
						txtPublication.setText(a.getPublication());
						txtQuantity.setText(String.valueOf(a.getQuantity()));
					}
				} catch (ClassNotFoundException | SQLException | IOException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					dispose();
					new AdminDashboard().setVisible(true);
					e.printStackTrace();
				}

			}
		});
		button.setIcon(new ImageIcon(EditBook.class.getResource("/resources/icons/icons8-search.png")));
		button.setBounds(188, 14, 39, 25);
		contentPane.add(button);

		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtSearch.setText(null);
				txtBID.setText(null);
				txtBookName.setText(null);
				txtAuthor.setText(null);
				txtPublication.setText(null);
				txtQuantity.setText(null);
				txtSubject.setText(null);
			}
		});
		btnReset.setBounds(240, 15, 89, 25);
		contentPane.add(btnReset);
		contentPane.add(getLblSubject());
		contentPane.add(getTxtSubject());
	}

	private JLabel getLblSubject() {
		if (lblSubject == null) {
			lblSubject = new JLabel("SUBJECT");
			lblSubject.setForeground(new Color(25, 25, 112));
			lblSubject.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblSubject.setBounds(10, 77, 123, 25);
		}
		return lblSubject;
	}

	private JTextField getTxtSubject() {
		if (txtSubject == null) {
			txtSubject = new JTextField();
			txtSubject.setColumns(10);
			txtSubject.setBounds(156, 75, 218, 25);
		}
		return txtSubject;
	}
}

package com.ismt.LibraryManagement.frontEnd;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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

public class AddBook extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtBID;
	private JTextField txtBookName;
	private JTextField txtSubject;
	private JTextField txtAuthor;
	private JTextField txtPublication;
	private JTextField txtQuantity;
	private JButton btnCancel;
	private JLabel label;
	private JTextField txtSearch;
	private JButton button;
	User u = new User();
	private JButton button_1;
	
	/**
	 * Create the frame.
	 */
	public AddBook() {
		setResizable(false);
		setTitle("ADD BOOK");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(415, 382);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new TitledBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 153, 102)), "Add Book",
				TitledBorder.CENTER, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBookId = new JLabel("BOOK ID");
		lblBookId.setBounds(new Rectangle(0, 0, 0, 30));
		lblBookId.setForeground(new Color(25, 25, 112));
		lblBookId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBookId.setBounds(24, 52, 91, 25);
		contentPane.add(lblBookId);

		txtBID = new JTextField();
		txtBID.setEditable(false);
		txtBID.setEnabled(false);
		txtBID.setBounds(new Rectangle(0, 0, 0, 30));
		txtBID.setBounds(165, 50, 224, 25);
		contentPane.add(txtBID);
		txtBID.setColumns(10);

		JLabel lblBookName = new JLabel("BOOK NAME");
		lblBookName.setBounds(new Rectangle(0, 0, 0, 30));
		lblBookName.setForeground(new Color(25, 25, 112));
		lblBookName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBookName.setBounds(24, 97, 91, 25);
		contentPane.add(lblBookName);

		txtBookName = new JTextField();
		txtBookName.setBounds(new Rectangle(0, 0, 0, 30));
		txtBookName.setBounds(165, 96, 224, 25);
		contentPane.add(txtBookName);
		txtBookName.setColumns(10);

		JLabel lblSubject = new JLabel("SUBJECT");
		lblSubject.setBounds(new Rectangle(0, 0, 0, 30));
		lblSubject.setForeground(new Color(25, 25, 112));
		lblSubject.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSubject.setBounds(24, 141, 91, 25);
		contentPane.add(lblSubject);

		txtSubject = new JTextField();
		txtSubject.setBounds(new Rectangle(0, 0, 0, 30));
		txtSubject.setBounds(165, 142, 224, 25);
		contentPane.add(txtSubject);
		txtSubject.setColumns(10);

		JLabel lblAuthor = new JLabel("AUTHOR");
		lblAuthor.setBounds(new Rectangle(0, 0, 0, 30));
		lblAuthor.setForeground(new Color(25, 25, 112));
		lblAuthor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAuthor.setBounds(24, 184, 91, 25);
		contentPane.add(lblAuthor);

		txtAuthor = new JTextField();
		txtAuthor.setBounds(new Rectangle(0, 0, 0, 30));
		txtAuthor.setBounds(165, 185, 224, 25);
		contentPane.add(txtAuthor);
		txtAuthor.setColumns(10);

		JLabel lblPublication = new JLabel("PUBLICATION");
		lblPublication.setBounds(new Rectangle(0, 0, 0, 30));
		lblPublication.setForeground(new Color(25, 25, 112));
		lblPublication.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPublication.setBounds(24, 220, 91, 25);
		contentPane.add(lblPublication);

		txtPublication = new JTextField();
		txtPublication.setBounds(new Rectangle(0, 0, 0, 30));
		txtPublication.setBounds(165, 221, 224, 25);
		contentPane.add(txtPublication);
		txtPublication.setColumns(10);

		JLabel lblQuantity = new JLabel("QUANTITY");
		lblQuantity.setBounds(new Rectangle(0, 0, 0, 30));
		lblQuantity.setForeground(new Color(25, 25, 112));
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblQuantity.setBounds(24, 265, 91, 25);
		contentPane.add(lblQuantity);

		txtQuantity = new JTextField();
		txtQuantity.setBounds(new Rectangle(0, 0, 0, 30));
		txtQuantity.setBounds(165, 266, 224, 25);
		contentPane.add(txtQuantity);
		txtQuantity.setColumns(10);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UserDAO userDAO = new UserDAOImpl();
					u.setBookName(txtBookName.getText());
					u.setSubject(txtSubject.getText());
					u.setAuthor(txtAuthor.getText());
					u.setPublication(txtPublication.getText());
					u.setQuantity(Integer.parseInt(txtQuantity.getText()));

					int result = userDAO.newBook(u);

					if (result > 0) {
						JOptionPane.showMessageDialog(null, "Book added successfully.Book ID:" + result);
						new AdminDashboard().setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, result);
						dispose();
					}
					dispose();
				} catch (ClassNotFoundException | SQLException | IOException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					dispose();
					new AdminDashboard().setVisible(true);
					e1.getMessage();

					e1.printStackTrace();
				}
			}
		});
		btnSave.setIcon(new ImageIcon("G:\\programming\\New folder (2)\\save.png"));
		btnSave.setForeground(new Color(25, 25, 112));
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSave.setBounds(292, 302, 97, 30);
		contentPane.add(btnSave);
		contentPane.add(getBtnCancel());

		label = new JLabel("SEARCH");
		label.setBounds(23, 14, 49, 25);
		contentPane.add(label);

		txtSearch = new JTextField();
		txtSearch.setColumns(10);
		txtSearch.setBounds(82, 16, 114, 25);
		contentPane.add(txtSearch);

		button = new JButton("");
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
		button.setIcon(new ImageIcon(AddBook.class.getResource("/resources/icons/icons8-search.png")));
		button.setBounds(201, 15, 39, 25);
		contentPane.add(button);
		
		button_1 = new JButton("RESET");
		button_1.addActionListener(new ActionListener() {
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
		button_1.setBounds(248, 14, 78, 25);
		contentPane.add(button_1);
	}

	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("CANCEL");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new AdminDashboard().setVisible(true);
					dispose();
				}
			});
			btnCancel.setForeground(new Color(25, 25, 112));
			btnCancel.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnCancel.setBounds(175, 302, 97, 30);
		}
		return btnCancel;
	}
}

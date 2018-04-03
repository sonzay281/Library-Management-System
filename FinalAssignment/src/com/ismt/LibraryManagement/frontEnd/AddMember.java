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
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import com.ismt.LibraryManagement.backend.dao.UserDAO;
import com.ismt.LibraryManagement.backend.dao.impl.UserDAOImpl;
import com.ismt.LibraryManagement.backend.entity.User;
import javax.swing.JPasswordField;

public class AddMember extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtSID;
	private JTextField txtUsername;
	private JTextField txtSearchBox;
	private JButton button;
	private JSeparator separator;
	private JTextField txtMID;
	private JLabel lblStudentId;
	User u = new User();
	private JPasswordField txtPassword;

	/**
	 * Create the frame.
	 */
	public AddMember() {
		setResizable(false);
		setTitle("ADD MEMBER");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(400, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new TitledBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 153, 102)),
				"NEW MEMBER REGISTRATION", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblName = new JLabel("NAME");
		lblName.setForeground(new Color(25, 25, 112));
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblName.setBounds(10, 117, 110, 25);
		contentPane.add(lblName);

		txtName = new JTextField();
		txtName.setBounds(130, 117, 235, 25);
		contentPane.add(txtName);
		txtName.setColumns(10);

		JLabel lblSection = new JLabel("SID");
		lblSection.setForeground(new Color(25, 25, 112));
		lblSection.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSection.setBounds(10, 161, 110, 16);
		contentPane.add(lblSection);

		txtSID = new JTextField();
		txtSID.setBounds(130, 158, 235, 24);
		contentPane.add(txtSID);
		txtSID.setColumns(10);

		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setForeground(new Color(25, 25, 112));
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsername.setBounds(10, 193, 110, 32);
		contentPane.add(lblUsername);

		txtUsername = new JTextField();
		txtUsername.setBounds(130, 198, 235, 25);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);

		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(new Color(25, 25, 112));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(10, 243, 110, 19);
		contentPane.add(lblPassword);

		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UserDAO userDAO = new UserDAOImpl();
					u.setSid(Integer.parseInt(txtSID.getText()));
					u.setStudentName(txtName.getText());
					u.setEmail(txtUsername.getText());
					// u.setSection(txtSection.getText());
					u.setPassword(String.valueOf(txtPassword.getPassword()));
					int result = userDAO.createAccount(u);
					if (result > 0) {
						JOptionPane.showMessageDialog(null, "Account created successfully.Your member ID is:" + result);
						dispose();
						new AdminDashboard().setVisible(true);

					}
				} catch (ClassNotFoundException | SQLException | IOException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					e1.printStackTrace();
					dispose();
					new AdminDashboard().setVisible(true);
				}

			}
		});
		btnSave.setIcon(new ImageIcon("G:\\programming\\New folder (2)\\save.png"));
		btnSave.setBackground(new Color(138, 43, 226));
		btnSave.setForeground(new Color(25, 25, 112));
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSave.setBounds(268, 279, 100, 30);
		contentPane.add(btnSave);

		JLabel lblSearch = new JLabel("SEARCH");
		lblSearch.setBounds(10, 25, 49, 27);
		contentPane.add(lblSearch);
		contentPane.add(getTxtSearchBox());
		contentPane.add(getButton());
		contentPane.add(getSeparator());
		contentPane.add(getTxtMID());
		contentPane.add(getLblStudentId());

		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminDashboard().setVisible(true);
				dispose();
			}
		});
		btnCancel.setForeground(new Color(25, 25, 112));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancel.setBackground(new Color(138, 43, 226));
		btnCancel.setBounds(140, 279, 100, 30);
		contentPane.add(btnCancel);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(130, 238, 235, 24);
		contentPane.add(txtPassword);

		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSearchBox.setText(null);
				txtName.setText(null);
				txtMID.setText(null);
				txtSID.setText(null);
				txtPassword.setText(null);
				txtUsername.setText(null);
			}
		});
		btnReset.setBounds(257, 25, 89, 27);
		contentPane.add(btnReset);
	}

	private JTextField getTxtSearchBox() {
		if (txtSearchBox == null) {
			txtSearchBox = new JTextField();
			txtSearchBox.setBounds(69, 25, 114, 27);
			txtSearchBox.setColumns(10);
		}
		return txtSearchBox;
	}

	private JButton getButton() {
		if (button == null) {
			button = new JButton("");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						UserDAO userDAO = new UserDAOImpl();
						u.setMid(Integer.parseInt(txtSearchBox.getText()));
						System.out.println(u.getSid());
						userDAO.searchMember(u);
						for (User a : userDAO.searchMember(u)) {
							txtMID.setText(String.valueOf(a.getMid()));
							txtSID.setText(String.valueOf(a.getSid()));
							txtName.setText(a.getStudentName());
							txtUsername.setText(a.getEmail());
							txtPassword.setText(a.getPassword());
						}
					} catch (ClassNotFoundException | SQLException | IOException e) {

						JOptionPane.showMessageDialog(null, e.getMessage());
						dispose();
						new AdminDashboard().setVisible(true);
						e.printStackTrace();
					}
				}
			});
			button.setIcon(new ImageIcon("J:\\Resources\\icons\\icons8-search.png"));
			button.setBounds(188, 26, 39, 26);
		}
		return button;
	}

	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(10, 62, 394, 2);
		}
		return separator;
	}

	private JTextField getTxtMID() {
		if (txtMID == null) {
			txtMID = new JTextField();
			txtMID.setEditable(false);
			txtMID.setColumns(10);
			txtMID.setBounds(130, 75, 235, 25);
		}
		return txtMID;
	}

	private JLabel getLblStudentId() {
		if (lblStudentId == null) {
			lblStudentId = new JLabel("MEMBER ID");
			lblStudentId.setForeground(new Color(25, 25, 112));
			lblStudentId.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblStudentId.setBounds(10, 75, 110, 22);
		}
		return lblStudentId;
	}
}

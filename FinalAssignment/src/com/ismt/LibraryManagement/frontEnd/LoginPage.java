package com.ismt.LibraryManagement.frontEnd;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

import com.ismt.LibraryManagement.backend.dao.UserDAO;
import com.ismt.LibraryManagement.backend.dao.impl.UserDAOImpl;
import com.ismt.LibraryManagement.backend.entity.User;
import javax.swing.JPasswordField;

public class LoginPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEmail;
	private JButton btnNormalUser;
	private JLabel lblHaventRegisteredYet;
	private JSeparator separator;
	private JSeparator separator_1;
	private JLabel lblCopyrightBijay;
	User u = new User();
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		setResizable(false);
		setBackground(new Color(128, 0, 0));
		setForeground(new Color(153, 50, 204));
		setTitle("LOGIN\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 360);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new TitledBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 153, 153)),
				"WELCOME TO SAMAJIK COLLEGE LMS SYSTEM.", TitledBorder.CENTER, TitledBorder.TOP,
				new Font("Tahoma", Font.BOLD, 12), new Color(51, 153, 153)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsername = new JLabel("EMAIL");
		lblUsername.setIcon(new ImageIcon("G:\\programming\\New folder (2)\\username.png"));
		lblUsername.setBounds(10, 25, 90, 28);
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setIcon(new ImageIcon("G:\\programming\\New folder (2)\\Security-Password-2-icon.png"));
		lblPassword.setBounds(10, 80, 90, 28);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblPassword);

		txtEmail = new JTextField();
		txtEmail.setBounds(128, 27, 246, 28);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblUserType = new JLabel("USER TYPE");
		lblUserType.setIcon(new ImageIcon("G:\\programming\\New folder (2)\\user-type.png"));
		lblUserType.setBounds(10, 125, 90, 27);
		lblUserType.setForeground(Color.WHITE);
		lblUserType.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblUserType);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(0, 153, 153), new Color(0, 153, 153),
				new Color(0, 153, 153), new Color(0, 153, 153)));
		comboBox.setBounds(128, 125, 246, 28);
		comboBox.setBackground(Color.LIGHT_GRAY);
		comboBox.setForeground(new Color(25, 25, 112));
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "REGISTERED USER", "ADMINISTRATOR" }));
		contentPane.add(comboBox);

		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(0, 153, 153), new Color(0, 153, 153),
				new Color(0, 153, 153), new Color(0, 153, 153)));
		btnLogin.setIcon(new ImageIcon(LoginPage.class.getResource("/resources/icons/icons8-login.png")));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogin.setBounds(274, 176, 100, 30);
		btnLogin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				try {
					UserDAO userDAO = new UserDAOImpl();
					String email = txtEmail.getText();
					u.setEmail(txtEmail.getText());
					String password = String.valueOf(txtPassword.getPassword());
					System.out.println("Data sent to User.");
					System.out.println(email + password);
					userDAO.getByUserName(u);

					if (!email.isEmpty() && !password.isEmpty()) {
						System.out.println("Passed.");

						if (email.equals("admin") && password.equals("admin")
								&& comboBox.getSelectedItem().equals("ADMINISTRATOR")) {
							new AdminDashboard().setVisible(true);
							System.out.println("Passed1.");

							dispose();
						} else {
							System.out.println("Passed2.");

							for (User u : userDAO.getByUserName(u)) {
								System.out.println("Passed3.");

								System.out.println(u.getPassword());
								int mid = u.getMid();
								if (password.equals(u.getPassword())) {
									new RegisteredUser(mid).setVisible(true);
									dispose();
								} else {
									JOptionPane.showConfirmDialog(null, "User not found. Please register first.");
								}
							}
						}
					} else {
						JOptionPane.showConfirmDialog(null, "Please enter the username and password.");
					}

				} catch (ClassNotFoundException | SQLException e) {
					e.getMessage();
					e.printStackTrace();
				}
			}

		});
		btnLogin.setBackground(Color.LIGHT_GRAY);
		btnLogin.setForeground(new Color(25, 25, 112));
		contentPane.add(btnLogin);
		contentPane.add(getBtnNormalUser());
		contentPane.add(getLblHaventRegisteredYet());
		contentPane.add(getSeparator());
		contentPane.add(getSeparator_1());
		contentPane.add(getLblCopyrightBijay());

		JButton btnCancel = new JButton("EXIT");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Thanks for using Samajik College Library Management system.");
				System.exit(5);
			}
		});
		btnCancel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(0, 153, 153), new Color(0, 153, 153),
				new Color(0, 153, 153), new Color(0, 153, 153)));
		btnCancel.setIcon(new ImageIcon(LoginPage.class.getResource("/resources/icons/icons8-cancel.png")));
		btnCancel.setForeground(new Color(25, 25, 112));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancel.setBackground(Color.LIGHT_GRAY);
		btnCancel.setBounds(158, 176, 90, 30);
		contentPane.add(btnCancel);
		contentPane.add(getTxtPassword());

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(LoginPage.class.getResource("/resources/Login Panel.png")));
		label.setBounds(8, 15, 380, 310);
		contentPane.add(label);
	}

	private JButton getBtnNormalUser() {
		if (btnNormalUser == null) {
			btnNormalUser = new JButton("BOOK STORE");
			btnNormalUser.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new ListBooks().setVisible(true);
				}
			});
			btnNormalUser.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY,
					Color.LIGHT_GRAY, Color.LIGHT_GRAY));
			btnNormalUser.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnNormalUser.setBackground(new Color(51, 153, 153));
			btnNormalUser.setBounds(10, 257, 364, 23);
		}
		return btnNormalUser;
	}

	private JLabel getLblHaventRegisteredYet() {
		if (lblHaventRegisteredYet == null) {
			lblHaventRegisteredYet = new JLabel("HAVEN'T REGISTERED YET?  SEE AVAILABLE BOOKS HERE:");
			lblHaventRegisteredYet.setForeground(Color.WHITE);
			lblHaventRegisteredYet.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblHaventRegisteredYet.setHorizontalAlignment(SwingConstants.CENTER);
			lblHaventRegisteredYet.setBounds(10, 232, 364, 14);
		}
		return lblHaventRegisteredYet;
	}

	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(10, 215, 364, 6);
		}
		return separator;
	}

	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setBounds(10, 285, 364, 2);
		}
		return separator_1;
	}

	private JLabel getLblCopyrightBijay() {
		if (lblCopyrightBijay == null) {
			lblCopyrightBijay = new JLabel("COPYRIGHT 2018 BIJAY ACHARYA || ISMT COLLEGE ");
			lblCopyrightBijay.setForeground(Color.WHITE);
			lblCopyrightBijay.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblCopyrightBijay.setHorizontalAlignment(SwingConstants.CENTER);
			lblCopyrightBijay.setBounds(11, 298, 363, 14);
		}
		return lblCopyrightBijay;
	}

	private JPasswordField getTxtPassword() {
		if (txtPassword == null) {
			txtPassword = new JPasswordField();
			txtPassword.setBounds(128, 80, 246, 28);
		}
		return txtPassword;
	}
}

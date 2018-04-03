package com.ismt.LibraryManagement.frontEnd;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class AdminDashboard extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnListAllBooks;
	private JButton btnListAll;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnLend;
	private JButton btnNewRegistration;
	private JSeparator separator;
	private JLabel lblNewLabel;
	private JLabel label;
	private JButton btnLogout;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// Dashboard frame = new Dashboard();
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

	public AdminDashboard() {
		setResizable(false);
		setTitle("ADMIN DASHBOARD");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(425, 323);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new TitledBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 153, 153)),
				"WELCOME ADMIN", TitledBorder.CENTER, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 12),
				new Color(0, 153, 153)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnLogout());
		contentPane.add(getBtnListAllBooks());
		contentPane.add(getBtnListAll());
		contentPane.add(getBtnUpdate());
		contentPane.add(getBtnDelete());
		contentPane.add(getBtnLend());
		contentPane.add(getBtnNewRegistration());
		contentPane.add(getSeparator());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLabel());

	}

	private JButton getBtnListAllBooks() {
		if (btnListAllBooks == null) {
			btnListAllBooks = new JButton("ADD BOOKS");
			btnListAllBooks.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnListAllBooks
					.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 153, 153), new Color(0, 153, 153)));
			btnListAllBooks.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new AddBook().setVisible(true);
					dispose();
				}
			});
			btnListAllBooks.setBounds(23, 179, 100, 30);
		}
		return btnListAllBooks;
	}

	private JButton getBtnListAll() {
		if (btnListAll == null) {
			btnListAll = new JButton("LIST ALL");
			btnListAll.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("Oing to List books.");
					dispose();
					new ListBooks().setVisible(true);
					System.out.println("Oing to List books.");
				
				}
			});
			btnListAll.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnListAll
					.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 153, 153), new Color(0, 153, 153)));
			btnListAll.setBounds(172, 179, 100, 30);
		}
		return btnListAll;
	}

	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton("UPDATE");
			btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnUpdate.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 153, 153), new Color(0, 153, 153)));
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new EditBook().setVisible(true);
					dispose();
				}
			});
			btnUpdate.setBounds(306, 179, 100, 30);
		}
		return btnUpdate;
	}

	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("DELETE");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new DeleteBook().setVisible(true);
					dispose();
				}
			});
			btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnDelete.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 153, 153), new Color(0, 153, 153)));
			btnDelete.setBounds(23, 228, 100, 30);
		}
		return btnDelete;
	}

	private JButton getBtnLend() {
		if (btnLend == null) {
			btnLend = new JButton("LEND");
			btnLend.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnLend.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 153, 153), new Color(0, 153, 153)));
			btnLend.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new LendBook().setVisible(true);
					dispose();
				}
			});
			btnLend.setBounds(172, 228, 100, 30);
		}
		return btnLend;
	}

	private JButton getBtnNewRegistration() {
		if (btnNewRegistration == null) {
			btnNewRegistration = new JButton("NEW MEMBER");
			btnNewRegistration.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnNewRegistration
					.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 153, 153), new Color(0, 153, 153)));
			btnNewRegistration.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new AddMember().setVisible(true);
					dispose();
				}
			});
			btnNewRegistration.setBounds(306, 228, 100, 30);
		}
		return btnNewRegistration;
	}

	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(10, 266, 396, 2);
		}
		return separator;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("COPYRIGHT 2018 BIJAY ACHARYA || ISMT COLLEGE ");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(10, 269, 396, 14);
		}
		return lblNewLabel;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setIcon(new ImageIcon(AdminDashboard.class.getResource("/resources/AdminDashboard.png")));
			label.setBounds(7, 15, 404, 272);
		}
		return label;
	}

	private JButton getBtnLogout() {
		if (btnLogout == null) {
			btnLogout = new JButton("");
			btnLogout.setIcon(new ImageIcon(AdminDashboard.class.getResource("/resources/icons/icons8-logout.png")));
			btnLogout.setBackground(Color.RED);
			btnLogout.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnLogout.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 153, 153), new Color(0, 153, 153)));
			btnLogout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new LoginPage().setVisible(true);
					dispose();
				}
			});
			btnLogout.setBounds(362, 15, 47, 30);
		}
		return btnLogout;
	}
}

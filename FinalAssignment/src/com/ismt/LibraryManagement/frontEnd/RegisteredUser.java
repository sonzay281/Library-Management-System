package com.ismt.LibraryManagement.frontEnd;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import com.ismt.LibraryManagement.backend.dao.UserDAO;
import com.ismt.LibraryManagement.backend.dao.impl.UserDAOImpl;
import com.ismt.LibraryManagement.backend.entity.User;

public class RegisteredUser extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel label_1;
	private JSeparator separator_2;
	private JButton btnBorrowNew;
	private JButton btnReturnBook;
	private JButton btnSeeBucket;
	private JLabel label_2;
	private JButton btnLogout;
	private JLabel lblSeeAllAvailable;
	private JButton btnNewButton;
	private JButton btnSeeStore;

	/**
	 * Create the frame.
	 */
	public RegisteredUser(int mid) {
		setResizable(false);
		setTitle("REGISTERED USER DASHBOARD");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(400, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setForeground(new Color(25, 25, 112));
		contentPane.setBorder(new TitledBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 153, 153)),
				"WELCOME TO SAMAJIK COLLEGE LMS SYSTEM.", TitledBorder.CENTER, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getSeparator_2());
		contentPane.add(getBtnBorrowNew(mid));
		contentPane.add(getLabel_2());
		contentPane.add(getLblSeeAllAvailable());

		JLabel lblMemberId = new JLabel("MEMBER ID:" + mid);
		lblMemberId.setForeground(new Color(0, 255, 0));
		lblMemberId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMemberId.setBounds(10, 22, 100, 24);
		contentPane.add(lblMemberId);
		contentPane.add(getBtnLogout());
		// contentPane.add(getBtnSeeBucket(mid));
		contentPane.add(getButton_1());
		contentPane.add(getButton_2());
		btnReturnBook = new JButton("RETURN");
		contentPane.add(btnReturnBook);
		btnReturnBook.setIcon(
				new ImageIcon(RegisteredUser.class.getResource("/resources/icons/icons8-return-purchase.png")));
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bid = JOptionPane.showInputDialog(null, "PLEASE ENTER THE BOOK ID:", "BOOK RETURN", NORMAL);
				try {
					User u = new User();
					UserDAO userDAO = new UserDAOImpl();
					u.setBid(Integer.parseInt(bid));
					u.setMid(mid);
					int result = userDAO.returnBook(u);
					if (result > 0) {
						JOptionPane.showMessageDialog(null, "Successfully returned to Library.");
					}
				} catch (ClassNotFoundException | SQLException | IOException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "ERROR!", ERROR);
					e1.printStackTrace();
				}

			}
		});
		btnReturnBook.setForeground(new Color(25, 25, 112));
		btnReturnBook.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReturnBook.setBackground(new Color(138, 43, 226));
		btnReturnBook.setBounds(125, 199, 118, 30);

		btnSeeBucket = new JButton("MY BUCKET");
		btnSeeBucket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new BookBucket(mid).setVisible(true);
			}
		});
		contentPane.add(btnSeeBucket);
		btnSeeBucket
				.setIcon(new ImageIcon(RegisteredUser.class.getResource("/resources/icons/icons8-restore-window.png")));
		btnSeeBucket.setForeground(new Color(25, 25, 112));
		btnSeeBucket.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSeeBucket.setBackground(new Color(138, 43, 226));
		btnSeeBucket.setBounds(253, 199, 131, 30);
		// contentPane.add(getBtnReturnBook());
		contentPane.add(getLabel_1());
	}

	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("");
			label_1.setForeground(new Color(0, 255, 51));
			label_1.setIcon(new ImageIcon(RegisteredUser.class.getResource("/resources/Reg1.png")));
			label_1.setBounds(6, 15, 382, 250);
		}
		return label_1;
	}

	private JSeparator getSeparator_2() {
		if (separator_2 == null) {
			separator_2 = new JSeparator();
			separator_2.setBounds(10, 240, 374, 2);
		}
		return separator_2;
	}

	private JButton getBtnBorrowNew(int mid) {
		if (btnBorrowNew == null) {
			btnBorrowNew = new JButton("BORROW");
			btnBorrowNew
					.setIcon(new ImageIcon(RegisteredUser.class.getResource("/resources/icons/icons8-add-list.png")));
			btnBorrowNew.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new BorrowBook(mid).setVisible(true);
					dispose();
				}
			});
			btnBorrowNew.setForeground(new Color(25, 25, 112));
			btnBorrowNew.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnBorrowNew.setBackground(new Color(138, 43, 226));
			btnBorrowNew.setBounds(10, 199, 105, 30);
		}
		return btnBorrowNew;
	}

	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("COPYRIGHT 2018 BIJAY ACHARYA || ISMT COLLEGE ");
			label_2.setForeground(Color.WHITE);
			label_2.setHorizontalAlignment(SwingConstants.CENTER);
			label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
			label_2.setBounds(10, 246, 374, 14);
		}
		return label_2;
	}

	private JButton getBtnLogout() {
		if (btnLogout == null) {
			btnLogout = new JButton("");
			btnLogout.setBackground(new Color(255, 51, 0));
			btnLogout.setIcon(
					new ImageIcon("J:\\Programming\\Java\\FASimulatedBankMachine\\src\\icons\\icons8-logout.png"));
			btnLogout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new LoginPage().setVisible(true);
					dispose();
				}
			});
			btnLogout.setBounds(345, 22, 39, 23);
		}
		return btnLogout;
	}

	private JLabel getLblSeeAllAvailable() {
		if (lblSeeAllAvailable == null) {
			lblSeeAllAvailable = new JLabel("SEE ALL AVAILABLE BOOKS IN THE LIBRARY ");
			lblSeeAllAvailable.setBackground(new Color(0, 153, 153));
			lblSeeAllAvailable.setForeground(Color.WHITE);
			lblSeeAllAvailable.setHorizontalAlignment(SwingConstants.CENTER);
			lblSeeAllAvailable.setFont(new Font("Arial Black", Font.BOLD, 12));
			lblSeeAllAvailable.setBounds(10, 104, 374, 14);
		}
		return lblSeeAllAvailable;
	}

	private JButton getButton_1() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("BORROW");
			btnNewButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 51, 102)));
			btnNewButton.setForeground(new Color(102, 51, 153));
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnNewButton.setBounds(10, 199, 105, 30);
		}
		return btnNewButton;
	}

	private JButton getButton_2() {
		if (btnSeeStore == null) {
			btnSeeStore = new JButton("SEE STORE");
			btnSeeStore.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new ListBooks().setVisible(true);
				}
			});
			btnSeeStore.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnSeeStore.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 51, 102)));
			btnSeeStore.setBounds(125, 129, 131, 30);
		}
		return btnSeeStore;
	}
}

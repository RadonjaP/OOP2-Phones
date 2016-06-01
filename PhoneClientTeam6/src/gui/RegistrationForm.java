package gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.naming.NamingException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import beans.BeansManagerTeam6;
import beans.StatelessBeanTeam6Remote;
import entity.User;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class RegistrationForm extends JFrame {

	private StatelessBeanTeam6Remote sbr;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtEmail;
	private JTextField txtUsername;
	private JTextArea txtShortDesc;
	private ImageIcon avatar;
	private JComboBox<ImageIcon> avatars;
	private ImageIcon[] avatarsIcons;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public RegistrationForm() {
		setResizable(false);
		setTitle("Registration form");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 595, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		try {

			sbr = new BeansManagerTeam6().getStatelessBean();

		} catch (NamingException e) {
			e.printStackTrace();
		}

		JLabel lblFirstLastName = new JLabel("First & Last name");
		lblFirstLastName.setFont(new Font("Tahoma", Font.PLAIN, 13));

		txtFirstName = new JTextField();
		txtFirstName.setColumns(10);

		txtLastName = new JTextField();
		txtLastName.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));

		txtEmail = new JTextField();
		txtEmail.setColumns(10);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));

		txtUsername = new JTextField();
		txtUsername.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JLabel lblShortDes = new JLabel("Short Description");
		lblShortDes.setFont(new Font("Tahoma", Font.PLAIN, 13));

		txtShortDesc = new JTextArea();
		txtShortDesc.setLineWrap(true);
		txtShortDesc.setWrapStyleWord(true);

		loadAvatars();

		JLabel lblAvatar = new JLabel("Avatar");
		lblAvatar.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JButton btnRegistration = new JButton("Registration");
		btnRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onRegistration();
			}
		});

		// avatars = new JComboBox();
		avatars = new JComboBox<>(avatarsIcons);

		passwordField = new JPasswordField();

		GroupLayout groupLayout = new GroupLayout(contentPane);
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(88)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(lblAvatar, GroupLayout.PREFERRED_SIZE, 107,
														GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(avatars, GroupLayout.PREFERRED_SIZE, 100,
												GroupLayout.PREFERRED_SIZE).addGap(18).addComponent(btnRegistration,
														GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblFirstLastName, GroupLayout.PREFERRED_SIZE, 107,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(txtFirstName, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(txtLastName, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblShortDes, GroupLayout.PREFERRED_SIZE, 107,
												GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, 225,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 225,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(passwordField, 225, 225, 225).addComponent(txtShortDesc,
												GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))))
				.addGap(137)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(67)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblFirstLastName)
						.addComponent(txtFirstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtShortDesc, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblShortDes, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(29)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(avatars, GroupLayout.PREFERRED_SIZE, 38,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnRegistration, GroupLayout.PREFERRED_SIZE, 37,
												GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup().addGap(27).addComponent(lblAvatar,
								GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(37, Short.MAX_VALUE)));
		contentPane.setLayout(groupLayout);
	}

	private void loadAvatars() {
		avatarsIcons = new ImageIcon[4];
		for (int i = 0; i < 4; i++) {
			avatarsIcons[i] = new ImageIcon(getClass().getResource("res/" + (i + 1) + ".jpg"));
		}

	}

	private void onRegistration() {

		String username = txtUsername.getText().trim();
		String password = passwordField.getText();
		String firstName = txtFirstName.getText().trim();
		String lastName = txtLastName.getText().trim();
		String shortDesc = txtShortDesc.getText().trim();
		String email = txtEmail.getText().trim();
		avatar = (ImageIcon) avatars.getSelectedItem();
		if (!isAnyEmptyFields()) {
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setName(firstName);
			user.setLastName(lastName);
			user.setDescription(shortDesc);
			user.setEmail(email);
			/* Treba staviti pravu adresu */
			user.setPictureAddress(avatar.getImage().toString());
			try {
				sbr.register(user);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else
			JOptionPane.showMessageDialog(RegistrationForm.this, "All fields are required to input",
					"Field empty error", JOptionPane.ERROR_MESSAGE);

	}

	private boolean isAnyEmptyFields() {
		int n1 = txtFirstName.getText().trim().length();
		int n2 = txtLastName.getText().trim().length();
		int n3 = txtUsername.getText().trim().length();
		int n4 = passwordField.getPassword().length;
		int n5 = txtEmail.getText().trim().length();
		int n6 = txtShortDesc.getText().trim().length();
		return !(n1 > 0 && n2 > 0 && n3 > 0 && n4 > 0 && n5 > 0 && n6 > 0);
	}

}

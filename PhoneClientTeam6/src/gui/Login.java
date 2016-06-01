package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.enterprise.inject.spi.BeanManager;
import javax.naming.NamingException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;

import beans.BeansManagerTeam6;
import beans.StatefulBeanTeam6Remote;
import beans.StatelessBeanTeam6Remote;

import java.awt.Font;
import javax.swing.SwingConstants;
@SuppressWarnings("serial")
public class Login extends JFrame {

	private BeansManagerTeam6 beanManager;
	private StatefulBeanTeam6Remote sbr;
	
	/**
	 * 
	 */

	public static final Image image = Toolkit.getDefaultToolkit().createImage(Login.class.getResource("res/logo.jpg"));
	private JButton btnLogin;
	private JButton btnSignUp;
	private JTextField txtUserName;
	private JTextField txtPassword;
	private Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
	private Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2);

	public Login(StatefulBeanTeam6Remote sbr) {
		this.sbr = sbr;
		JLabel beck = new JLabel(new ImageIcon(
				Login.class.getResource("res/pozadina.png")));
		setContentPane(beck);
		beck.setLayout(new BoxLayout(beck, BoxLayout.Y_AXIS));
		beck.add(Box.createVerticalStrut(160));
		beck.add(name());
		beck.add(pass());
		beck.add(Box.createVerticalStrut(11));
		beck.add(login());
		beck.add(signUp());
		getRootPane().setDefaultButton(btnLogin);

		btnLogin.setCursor(cursor);
		btnSignUp.setCursor(cursor);

		txtPassword.setToolTipText("Unesi sifru");
		txtUserName.setToolTipText("Unesi user name");

	}

	private JPanel name() {
		JLabel lblName = new JLabel("Username");
		lblName.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		lblName.setForeground(Color.black);
		lblName.setMinimumSize(new Dimension(130, 30));
		lblName.setMaximumSize(new Dimension(130, 30));
		lblName.setPreferredSize(new Dimension(130, 30));

		txtUserName = new JTextField();
		txtUserName.setMaximumSize(new Dimension(200, 30));
		txtUserName.setMinimumSize(new Dimension(200, 30));
		txtUserName.setPreferredSize(new Dimension(200, 30));
		txtUserName.setBorder(border);
		txtUserName.setForeground(Color.gray);

		JPanel pnlName = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		pnlName.setOpaque(false);
		pnlName.setMaximumSize(new Dimension(350, 40));
		pnlName.add(lblName);
		pnlName.add(txtUserName);
		return pnlName;
	}

	private JPanel pass() {

		JLabel lblPass = new JLabel("Password");
		lblPass.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		lblPass.setForeground(Color.black);
		lblPass.setMinimumSize(new Dimension(130, 30));
		lblPass.setMaximumSize(new Dimension(130, 30));
		lblPass.setPreferredSize(new Dimension(130, 30));

		txtPassword = new JPasswordField();
		txtPassword.setForeground(Color.GRAY);
		txtPassword.setMaximumSize(new Dimension(200, 30));
		txtPassword.setMinimumSize(new Dimension(200, 30));
		txtPassword.setPreferredSize(new Dimension(200, 30));
		txtPassword.setBorder(border);

		JPanel pnlPassword = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		pnlPassword.setOpaque(false);
		pnlPassword.setMaximumSize(new Dimension(350, 40));
		pnlPassword.add(lblPass);
		pnlPassword.add(txtPassword);
		return pnlPassword;
	}

	private JPanel login() {

		btnLogin = new JButton("Login");
		btnLogin.setForeground(new Color(0, 128, 192));
		btnLogin.setBackground(new Color(94, 167, 221));
		btnLogin.setMinimumSize(new Dimension(120, 35));
		btnLogin.setMaximumSize(new Dimension(120, 35));
		btnLogin.setPreferredSize(new Dimension(120, 35));
		btnLogin.setOpaque(false);
		
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = txtUserName.getText();
				String password = txtPassword.getText();
				try {
					sbr.login(username, password);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(Login.this, "Inserted data are not correct!",
							"Field empty error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
					return;
				}
				JOptionPane.showMessageDialog(Login.this, "Welcome "+sbr.getLoggedUser().getUsername(),
						"Successful login", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		JPanel pnlLogin = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		pnlLogin.setOpaque(false);
		pnlLogin.setMaximumSize(new Dimension(350, 40));
		pnlLogin.add(btnLogin);
		return pnlLogin;
	}

	private JPanel signUp() {
		JLabel lblSignUp = new JLabel("New user");
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUp.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		lblSignUp.setForeground(Color.black);
		lblSignUp.setMinimumSize(new Dimension(130, 30));
		lblSignUp.setMaximumSize(new Dimension(130, 30));
		lblSignUp.setPreferredSize(new Dimension(130, 30));

		btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				}catch(Exception ex){
					
				}
				RegistrationForm rf = new RegistrationForm();
				rf.setSize(640, 480);
				rf.setLocationRelativeTo(null);
				rf.setIconImage(image);
				rf.setVisible(true);
			}
		});
		btnSignUp.setForeground(new Color(0, 128, 192));
		btnSignUp.setBackground(new Color(94, 167, 221));
		btnSignUp.setMinimumSize(new Dimension(120, 35));
		btnSignUp.setMaximumSize(new Dimension(120, 35));
		btnSignUp.setPreferredSize(new Dimension(120, 35));
		btnSignUp.setOpaque(false);

		JPanel pnlSignUp = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		pnlSignUp.setOpaque(false);
		pnlSignUp.setMaximumSize(new Dimension(350, 40));
		pnlSignUp.add(lblSignUp);
		//pnlSignUp.add(Box.createHorizontalStrut());
		pnlSignUp.add(btnSignUp);

		return pnlSignUp;
	}
	
	public static void main(String [] args) throws NamingException{
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Exception e){
			
		}
		BeansManagerTeam6 beanManager = new BeansManagerTeam6();
		Login login=new Login(beanManager.getStatefulBean());
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.setSize(640, 480);
		login.setLocationRelativeTo(null);
		login.setResizable(false);
		JLabel lblTxt = new JLabel("Welcome to Shop with Telephones - Login or Sign up ");
		login.setTitle(lblTxt.getText());
		login.setIconImage(image);
		login.setVisible(true);
	}
}
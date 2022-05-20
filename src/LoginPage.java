package src;
import java.awt.*;
import javax.swing.*;

public class LoginPage {
	public JFrame frame;
	private JTextField quantityLbl;
	private JTextField priceLbl;
	private JTextField addNewLbl;
	private JTextField textField_3;
	private JPasswordField passwordField;
	private JTextField textField_4;
	private JTextField usernameText;
	private JPasswordField passwordText;
	private JTextField firstNameText;
	private JTextField lastNameText;
	private JTextField emailText;
	private JTextField positionText;
	private JTextField loginUsernameTxt;
	private JPasswordField passwordLoginTxt;
	private JTextField userText1;
	private JPasswordField passwordText1;
	private JTextField firstText1;
	private JTextField lastText1;
	private JTextField emailText1;
	private JTextField shippingText1;
	private JTextField deleteTxtF;
	private JTextField addNewL, quantityLb, priceLb;
	public JButton loginSubmitBtn;
	public JButton exitBtn;
	public JPanel Login;

	public LoginPage() {
		initialize();
	}

	private void initialize() {


		Login = new JPanel();
		Login.setLayout(null);

		JLabel user_label = new JLabel();
		user_label.setText("User Name :");
		user_label.setBounds(21, 11, 634, 31);
		Login.add(user_label);

		loginUsernameTxt = new JTextField();
		loginUsernameTxt.setBounds(21, 53, 634, 31);
		Login.add(loginUsernameTxt);

		JLabel password_label = new JLabel();
		password_label.setText("Password :");
		password_label.setBounds(21, 108, 634, 31);
		Login.add(password_label);

		passwordLoginTxt = new JPasswordField();
		passwordLoginTxt.setBounds(21, 150, 634, 31);
		Login.add(passwordLoginTxt);

		loginSubmitBtn = new JButton("LOGIN");
		loginSubmitBtn.setBounds(20, 208, 250, 30);
		Login.add(loginSubmitBtn);
		
		JButton signUpButn = new JButton("Sign up");
		signUpButn.setBounds(405, 208, 250, 30);
		Login.add(signUpButn);

		exitBtn = new JButton("Exit");
		exitBtn.setBounds(21, 250, 634, 31);
		Login.add(exitBtn);

		JLabel loginMessage = new JLabel();
		loginMessage.setBounds(21, 300, 634, 31);
		Login.add(loginMessage);
	}
}

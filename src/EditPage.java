package src;

import java.awt.Label;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class EditPage {
	public JTextField lNameField;
	public JTextField numberField;
	public JTextField fNameField;
	public JTextField collegetxt;
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
	public JPanel itemModPanel;
	public JButton newPlayer;
	public JButton deleteButton;
	public JComboBox teamsCombo;
	
	
	public EditPage() {
	itemModPanel = new JPanel();
	itemModPanel.setBackground(Color.GRAY);
	itemModPanel.setLayout(null);

	
	
	
//	//new variables for sprocs
//	// dropdown box for teams
//			// populate with teams
//			String[] teams = { "76ers", "Bucks", "Bulls", "Cavaliers", "Celtics", "Clippers", "Grizzlies", "Hawks", "Heat",
//					"Hornets", "Jazz", "Kings", "Knicks", "Lakers", "Magic", "Mavericks", "Nets", "Nuggets", "Pacers",
//					"Pelicans", "Pistons", "Raptors", "Rockets", "Spurs", "Suns", "Thunder", "Timberwolves",
//					"Trail Blazers", "Warriors", "Wizards" };
//
//			//creating combo box
//			teamsCombo = new JComboBox<String>(teams);
//			teamsCombo.setBounds(50, 120, 100, 20);
//			itemModPanel.add(teamsCombo);


	JLabel lblNewLabel = new JLabel("Edit Page");
	lblNewLabel.setForeground(Color.WHITE);
	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
	lblNewLabel.setBounds(261, 11, 165, 30);
	itemModPanel.add(lblNewLabel);



	Label label_1 = new Label("First Name:");
	label_1.setForeground(Color.WHITE);
	label_1.setBounds(50, 149, 91, 22);
	itemModPanel.add(label_1);



	fNameField = new JTextField();
	fNameField.setColumns(10);
	fNameField.setBounds(40, 180, 126, 39);
	itemModPanel.add(fNameField);

	Label label_3 = new Label("Last Name:");
	label_3.setForeground(Color.WHITE);
	label_3.setBounds(270, 149, 91, 22);
	itemModPanel.add(label_3);



	lNameField = new JTextField();
	lNameField.setColumns(10);
	lNameField.setBounds(260, 180, 126, 39);
	itemModPanel.add(lNameField);
	
	newPlayer = new JButton();
	newPlayer.setText("ADD/UPDATE PLAYER");
	newPlayer.setBounds(490, 180, 130, 40);
	itemModPanel.add(newPlayer);



	Label NumberLabel = new Label("Number");
	NumberLabel.setForeground(Color.WHITE);
	NumberLabel.setBounds(270, 249, 91, 22);
	itemModPanel.add(NumberLabel);



	numberField = new JTextField();
	numberField.setColumns(10);
	numberField.setBounds(260, 280, 126, 39);
	itemModPanel.add(numberField);


//
	Label label_2 = new Label("Team");
	label_2.setForeground(Color.WHITE);
	label_2.setBounds(50, 249, 91, 22);
	itemModPanel.add(label_2);



	collegetxt = new JTextField();
	collegetxt.setColumns(10);
	collegetxt.setBounds(40, 280, 126, 39);
	itemModPanel.add(collegetxt);
	
	deleteButton = new JButton();
	deleteButton.setText("CHANGE COACH TEAM");
	deleteButton.setBounds(490, 280, 130, 40);
	itemModPanel.add(deleteButton);

	
	
	
	}
	
	
	///////////////////////////////////////////HELPER METHODS//////////////////////////////////////////
	
	
	
}


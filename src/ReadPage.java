package src;

import java.awt.Label;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ReadPage {
	public JTextField clgtxt;
	public JTextField teamtxt;
	public JTextField nametxt;
	public JTextField abbrtxt;
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
	public JButton findPlayer;
	public JButton findTeam;
	public ReadPage() {
	itemModPanel = new JPanel();
	itemModPanel.setBackground(Color.GRAY);
	itemModPanel.setLayout(null);



	JLabel lblNewLabel = new JLabel("BasketballFinder");
	lblNewLabel.setForeground(Color.WHITE);
	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
	lblNewLabel.setBounds(261, 11, 165, 14);
	itemModPanel.add(lblNewLabel);



	Label label_1 = new Label("Player Name:");
	label_1.setForeground(Color.WHITE);
	label_1.setBounds(50, 149, 91, 22);
	itemModPanel.add(label_1);



	nametxt = new JTextField();
	nametxt.setColumns(10);
	nametxt.setBounds(40, 180, 126, 39);
	itemModPanel.add(nametxt);

	Label label_3 = new Label("College Name:");
	label_3.setForeground(Color.WHITE);
	label_3.setBounds(270, 149, 91, 22);
	itemModPanel.add(label_3);



	clgtxt = new JTextField();
	clgtxt.setColumns(10);
	clgtxt.setBounds(260, 180, 126, 39);
	itemModPanel.add(clgtxt);
	
	findPlayer = new JButton();
	findPlayer.setText("Find Player");
	findPlayer.setBounds(490, 180, 126, 39);
	itemModPanel.add(findPlayer);



	Label label_1_1 = new Label("Team Name:");
	label_1_1.setForeground(Color.WHITE);
	label_1_1.setBounds(270, 249, 91, 22);
	itemModPanel.add(label_1_1);



	teamtxt = new JTextField();
	teamtxt.setColumns(10);
	teamtxt.setBounds(260, 280, 126, 39);
	itemModPanel.add(teamtxt);



	Label label_2 = new Label("Team Abbr:");
	label_2.setForeground(Color.WHITE);
	label_2.setBounds(50, 249, 91, 22);
	itemModPanel.add(label_2);



	abbrtxt = new JTextField();
	abbrtxt.setColumns(10);
	abbrtxt.setBounds(40, 280, 126, 39);
	itemModPanel.add(abbrtxt);
	
	findTeam = new JButton();
	findTeam.setText("Find Team");
	findTeam.setBounds(490, 280, 126, 39);
	itemModPanel.add(findTeam);
//
//
//
//	Label label2 = new Label("Item name :");
//	label2.setForeground(Color.WHITE);
//	label2.setBounds(50, 270, 91, 22);
//	itemModPanel.add(label2);
//
//
//
//	addNewL = new JTextField();
//	addNewL.setColumns(10);
//	addNewL.setBounds(40, 300, 126, 39);
//	itemModPanel.add(addNewL);
//
//
//
//	Label label_0 = new Label("Item Quantity:");
//	label_0.setForeground(Color.WHITE);
//	label_0.setBounds(280, 270, 91, 22);
//	itemModPanel.add(label_0);
//
//
//
//	quantityLb = new JTextField();
//	quantityLb.setColumns(10);
//	quantityLb.setBounds(270, 300, 126, 39);
//	itemModPanel.add(quantityLb);
//
//
//
//	Label label_1_ = new Label("Item Price:");
//	label_1_.setForeground(Color.WHITE);
//	label_1_.setBounds(500, 270, 91, 22);
//	itemModPanel.add(label_1_);
//
//
//
//	priceLb = new JTextField();
//	priceLb.setColumns(10);
//	priceLb.setBounds(490, 300, 126, 39);
//	itemModPanel.add(priceLb);
//
//
//
//	JButton addItem = new JButton("Add Confirm");
//	addItem.setBounds(485, 350, 140, 30);
//	itemModPanel.add(addItem);
//
//
//
//	JButton quantityButton = new JButton("Update Quantity");
//	quantityButton.setBounds(265, 230, 140, 30);
//	itemModPanel.add(quantityButton);
//
//
//
//	JButton priceButton = new JButton("Update Price");
//	priceButton.setBounds(485, 230, 140, 30);
//	itemModPanel.add(priceButton);
//
//
//
//	Label labelD = new Label("Delete item:");
//	labelD.setForeground(Color.WHITE);
//	labelD.setBounds(300, 66, 91, 22);
//	itemModPanel.add(labelD);
//
//
//
//	deleteTxtF = new JTextField();
//	deleteTxtF.setColumns(10);
//	deleteTxtF.setBounds(390, 55, 126, 39);
//	itemModPanel.add(deleteTxtF);
//
//
//
//	JButton confirmButto = new JButton("Delete Confirm");
//	confirmButto.setBounds(520, 60, 140, 30);
//	itemModPanel.add(confirmButto);
	}
}

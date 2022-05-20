package src;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TeamInfo {

	public JPanel itemModPanel;
	public JButton findPlayer;
	public JButton findTeam;
	public JComboBox<String> teamsCombo;
	
	
	
	
	
	public TeamInfo() {
		
		

		
		
		
	itemModPanel = new JPanel();
	itemModPanel.setBackground(Color.GRAY);
	itemModPanel.setLayout(null);


	
	
	

	JLabel lblNewLabel = new JLabel("More Team Info");
	lblNewLabel.setForeground(Color.WHITE);
	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
	lblNewLabel.setBounds(261, 11, 165, 30);
	itemModPanel.add(lblNewLabel);
	
	



	//current coach info
	Label coachLabel = new Label("Current Coach:");
	coachLabel.setForeground(Color.WHITE);
	coachLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
	coachLabel.setBounds(50, 149, 150, 22);
	itemModPanel.add(coachLabel);
	
	JLabel currentCoach = new JLabel("SELECT TEAM FIRST");
	currentCoach.setForeground(Color.WHITE);
	currentCoach.setFont(new Font("Tahoma", Font.BOLD, 18));
	currentCoach.setBounds(50, 180, 250, 22);
	itemModPanel.add(currentCoach);



	
//current stats info
	Label statsLabel = new Label("Stats:");
	statsLabel.setForeground(Color.WHITE);
	statsLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
	statsLabel.setBounds(270, 149, 91, 22);
	itemModPanel.add(statsLabel);
	
//	JLabel coachLabel = new JLabel("Current Coach:");
//	coachLabel.setForeground(Color.WHITE);
//	coachLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
//	coachLabel.setBounds(50, 149, 150, 22);
//	itemModPanel.add(coachLabel);


//arena info
	Label arenaLabel = new Label("Arena:");
	arenaLabel.setForeground(Color.WHITE);
	arenaLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
	arenaLabel.setBounds(50, 300, 70, 22);
	itemModPanel.add(arenaLabel);

	Label arenaName = new Label("SELECT TEAM FIRST");
	arenaName.setForeground(Color.WHITE);
	arenaName.setFont(new Font("Tahoma", Font.BOLD, 18));
	arenaName.setBounds(150, 300, 250, 22);
	itemModPanel.add(arenaName);




//capacity info
	Label capacityLabel = new Label("Capacity:");
	capacityLabel.setForeground(Color.WHITE);
	capacityLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
	capacityLabel.setBounds(50, 320, 91, 22);
	itemModPanel.add(capacityLabel);

	
	Label capacity = new Label("SELECT TEAM FIRST");
	capacity.setForeground(Color.WHITE);
	capacity.setFont(new Font("Tahoma", Font.BOLD, 18));
	capacity.setBounds(150, 320, 250, 22);
	itemModPanel.add(capacity);


//address info
	Label addressLabel = new Label("Address:");
	addressLabel.setForeground(Color.WHITE);
	addressLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
	addressLabel.setBounds(50, 340, 91, 22);
	itemModPanel.add(addressLabel);
	
	
	Label address = new Label("SELECT TEAM FIRST");
	address.setForeground(Color.WHITE);
	address.setFont(new Font("Tahoma", Font.BOLD, 18));
	address.setBounds(150, 340, 250, 22);
	itemModPanel.add(address);

	}
}

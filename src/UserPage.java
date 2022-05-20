package src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.util.*;

public class UserPage {

	public JPanel userPanel;

	// having to add new things for main
	public JComboBox teamsCombo;
	protected Object populatedPlayers;
	protected JComboBox playersCombo;
	public String selectedFirstName = "";
	public String selectedLastName = "";
	public String selectedTeamAbrv = "";
	String selectedTeam = "";
	
	
	public JLabel ppgLabel = new JLabel("PPG: ");
	public JLabel threeLabel = new JLabel("3P%: ");
	public JLabel ftperLabel = new JLabel("FT%: ");
	public JLabel fgLabel = new JLabel("FG%: ");

	public JLabel ppgStat = new JLabel("null 1");
	public JLabel ftStat = new JLabel("null 2");
	public JLabel threeStat = new JLabel("null 3");
	public JLabel fgStat = new JLabel("null 4");
	
	String[] statsList = { "ThreePointers", "FreeThrows", "TotalRebounds", "Assists", "Steals", "Blocks", "Points" };
	public JComboBox statCombo = new JComboBox(statsList);
	
	
	String[] overUnderEqual = { "over", "under"};
	public JComboBox overUnder = new JComboBox(overUnderEqual);
	
	public JTextField value = new JTextField();
	
	
	protected DefaultListModel listOfGames;

	public JButton run;

	public JList gameList;

	public Object playerCombo;

	public UserPage() {
		userPanel = new JPanel();
		userPanel.setBackground(Color.GRAY);
		userPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("User Select");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(261, 5, 165, 30);
		userPanel.add(lblNewLabel);

		// dropdown box for teams
		// populate with teams
		String[] teams = { "76ers", "Bucks", "Bulls", "Cavaliers", "Celtics", "Clippers", "Grizzlies", "Hawks", "Heat",
				"Hornets", "Jazz", "Kings", "Knicks", "Lakers", "Magic", "Mavericks", "Nets", "Nuggets", "Pacers",
				"Pelicans", "Pistons", "Raptors", "Rockets", "Spurs", "Suns", "Thunder", "Timberwolves",
				"Trail Blazers", "Warriors", "Wizards" };

		//creating combo box
		teamsCombo = new JComboBox(teams);
		teamsCombo.setBounds(10, 40, 100, 20);
		userPanel.add(teamsCombo);

		ArrayList<String> populatedPlayers = new ArrayList<String>();
		//populatedPlayers.add("Pick a team 1st");
		playersCombo = new JComboBox();
		playersCombo.setModel(new DefaultComboBoxModel(populatedPlayers.toArray()));
		playersCombo.setBounds(130, 40, 100, 20);

		userPanel.add(playersCombo);

		// creating a variable of first and last name for easier use in main
		playersCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println("test worked");

				// if the selection is not null it sets public variables to the first and last
				// name
				if (playersCombo.getSelectedItem() != null) {
					String fullName = playersCombo.getSelectedItem().toString();

					int space = fullName.indexOf(' ');
					selectedFirstName = fullName.substring(0, space);
					selectedLastName = fullName.substring(space + 1);

					// testing to get selected team
					System.out.println(selectedFirstName);
					System.out.println(selectedLastName);
					System.out.println("expected test");

				}

			}
		});

		// creating a variable of first and last name for easier use in main
		teamsCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println("test worked");

				// if the selection is not null it sets public variables to the first and last
				// name
				if (teamsCombo.getSelectedItem() != null) {
					selectedTeam = teamsCombo.getSelectedItem().toString();

					// testing to get selected team
					System.out.println(selectedFirstName);
					System.out.println(selectedLastName);

				}

			}
		});

		// select stats ///////////////////////////////////////////////////////////////////////////////
		
		statCombo.setBounds(250, 40, 100, 20);
		userPanel.add(statCombo);

		// over/under
		
		overUnder.setBounds(360, 40, 100, 20);
		userPanel.add(overUnder);

		// value for over under
		
		value.setBounds(470, 40, 40, 20);
		userPanel.add(value);

		// run

		run = new JButton();
		run.setText("run selection");
		run.setBounds(520, 40, 100, 20);
		userPanel.add(run);

		run.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.out.println(teamsCombo.getSelectedItem() + " " + playersCombo.getSelectedItem() + " "
						+ statCombo.getSelectedItem() + " " + overUnder.getSelectedItem() + " " + value.getText());

			}
		});

		// list of game dates to show user/////////////////////////////////////////////
		listOfGames = new DefaultListModel();

		// the list itself
		JList gameList = new JList(listOfGames); // data has type Object[]

		gameList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		gameList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		gameList.setVisibleRowCount(2);
		JScrollPane gameListScroller = new JScrollPane(gameList);
		// listScroller.setPreferredSize(new Dimension(250, 80));
		// listScroller.setVisible(true);

		//adds spacing 
		gameList.setFixedCellWidth(100);
		gameList.setFixedCellHeight(20);
		
		gameListScroller.setBounds(10, 100, 300, 100);

		userPanel.add(gameListScroller);

		// EXTRA GAME STATS
		// SELECT * FROM GAMES WHERE they matche the above statement
		DefaultListModel gameInfo = new DefaultListModel();
//		for (int i = 0; i < 10; i++) {
//			gameInfo.addElement("Jane Doe \n");
//			gameInfo.addElement("John Smith \n");
//			gameInfo.addElement("Kathy Green \n");
//		}
		
		
		gameInfo.addElement(" points: 15");
		gameInfo.addElement(" assists: 2");
		gameInfo.addElement(" steals: 1.5");

		//list that holds all the data from a game
		JList infoList = new JList(gameInfo); // data has type Object[]

		infoList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		infoList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		infoList.setVisibleRowCount(2);
		JScrollPane infoListScroller = new JScrollPane(infoList);

		infoListScroller.setBounds(10, 250, 500, 100);

		userPanel.add(infoListScroller);
		
		
		
		
		
		
		/////////////////////////////////////AVG STATS AREA//////////////////////////////////////////////////
		
		
		//ppg stuff
		
		ppgLabel.setForeground(Color.WHITE);
		ppgLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		ppgLabel.setBounds(350, 100, 165, 30);
		userPanel.add(ppgLabel);
		
		
		
		
		threeLabel.setForeground(Color.WHITE);
		threeLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		threeLabel.setBounds(350, 130, 165, 30);
		userPanel.add(threeLabel);
		
		
		
		
		ftperLabel.setForeground(Color.WHITE);
		ftperLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		ftperLabel.setBounds(350, 160, 165, 30);
		userPanel.add(ftperLabel);
		
		
		
		
		fgLabel.setForeground(Color.WHITE);
		fgLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		fgLabel.setBounds(350, 190, 165, 30);
		userPanel.add(fgLabel);
		
		
		//////value holders
		
	
		
		ppgStat.setForeground(Color.WHITE);
		ppgStat.setFont(new Font("Tahoma", Font.BOLD, 18));
		ppgStat.setBounds(420, 100, 165, 30);
		userPanel.add(ppgStat);
		
		
		
		
		ftStat.setForeground(Color.WHITE);
		ftStat.setFont(new Font("Tahoma", Font.BOLD, 18));
		ftStat.setBounds(420, 130, 165, 30);
		userPanel.add(ftStat);
		
		
		
		
		threeStat.setForeground(Color.WHITE);
		threeStat.setFont(new Font("Tahoma", Font.BOLD, 18));
		threeStat.setBounds(420, 160, 165, 30);
		userPanel.add(threeStat);
		
		
		
		
		fgStat.setForeground(Color.WHITE);
		fgStat.setFont(new Font("Tahoma", Font.BOLD, 18));
		fgStat.setBounds(420, 190, 165, 30);
		userPanel.add(fgStat);
		/////////////
		

	}

//////////////GETTERS////////////////////////////////////////////////////////////////////////
	public String getFirstName() {

		return selectedFirstName;
	}

	public String getLastName() {

		return selectedLastName;
	}

	public String getTeam() {

		return selectedTeam;
	}

}

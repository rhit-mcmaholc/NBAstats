package src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;

/************************************************************************/
/* A small example of using JDBC to the FoodDelivery DB */
/* Used as an example for CSSE333 - tracy section */
/* Calls a stored procedure that we previously created. */
/*
 * April 6, 2022 /
 ************************************************************************/
public class Main {

	public static Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	// TODO: Task 1

	// BUILD YOUR CONNECTION STRING HERE USING THE SAMPLE URL ABOVE
	public static void main(String[] args) {
		/*
		 * This first section creaions a URL "connection string" to be used to connect
		 * to the particular database. Generally, would be assembled in a different way,
		 * particularly the username/password Note that the connection uses a special
		 * account: FoodDeliveryUserTracy The intent is to use an account with the
		 * minimal required permissions.
		 */
		String url = "jdbc:sqlserver://${dbServer};databaseName=${dbName};user=${user};password={${pass}}";
		// String passwordCreator =
		// "po;jwquenxmfpge6981067p5b5p31-paaosad/o011872745nrdh?";
		String fullUrl = url.replace("${dbServer}", "titan.csse.rose-hulman.edu").replace("${dbName}", "NBAStats_S4G4")
				.replace("${user}", "NBAStatsManager").replace("${pass}", "2_Ff/%d~<(*=A*a,");
		// System.out.println(fullUrl);

		/*
		 * create these connections in a scope so that they can be reliably closed in
		 * several places.
		 */
		final Connection connection;
		// System.out.println(url);
		Scanner reader = new Scanner(System.in);
		/*
		 * Note that SQL Server operations all must be in try/catch structures as they
		 * can throw SQLException exceptions.
		 * 
		 */
		try {
			// open the connection to the DB
			JFrame frame = new JFrame();
			frame.setBounds(100, 100, 704, 482);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			connection = DriverManager.getConnection(fullUrl);

			LoginPage window = new LoginPage();
			frame.add(window.Login, BorderLayout.CENTER);

			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			frame.setVisible(true);

			TeamInfo window2 = new TeamInfo();
			tabbedPane.addTab("More Info", null, window2.itemModPanel, null);

			EditPage window3 = new EditPage();
			tabbedPane.addTab("Player", null, window3.itemModPanel, null);

			UserPage window4 = new UserPage();
			tabbedPane.addTab("UserPage", null, window4.userPanel, null);

			window.loginSubmitBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					window.Login.setEnabled(false);
					window.Login.setVisible(false);
					frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
				}
			});
			window.exitBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(1);
				}
			});
//			window2.findPlayer.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
////					 ArrayList<String> rests = new ArrayList<String>();
////						dbService.connect("SodaBaseUsermcmaholc", "Password123");
//					try {
//						PreparedStatement statement;
//						String selectSql = "SELECT FreeThrowPercent FROM [Player] pl";
//						selectSql += " JOIN Person pe ON pe.ID = pl.PlayerID";
//						if (!window2.nametxt.getText().isEmpty() || !window2.clgtxt.getText().isEmpty()) {
//							selectSql += " WHERE";
//							if (!window2.nametxt.getText().isEmpty() && !window2.clgtxt.getText().isEmpty()) {
//								selectSql += " College = ? AND [First Name] = ?";
//								statement = connection.prepareStatement(selectSql);
//								statement.setString(2, window2.nametxt.getText());
//								statement.setString(1, window2.clgtxt.getText());
//
//							} else if (!window2.clgtxt.getText().isEmpty()) {
//								selectSql += " College = ?";
//								statement = connection.prepareStatement(selectSql);
//								statement.setString(1, window2.clgtxt.getText());
//							} else {
//								selectSql += " [First Name] = ?";
//
//								statement = connection.prepareStatement(selectSql);
//								statement.setString(1, window2.nametxt.getText());
//							}
//						} else {
//							statement = connection.prepareStatement(selectSql);
//						}
//						connection.setAutoCommit(false);
//						System.out.println(statement);
//						ResultSet resultSet = statement.executeQuery();
//						resultSet.next();
//						JOptionPane.showMessageDialog(frame,
//								"FreeThrowPercent:" + resultSet.getDouble("FreeThrowPercent") * 100 + "%");
//						// System.out.println(hash);
//
//						// System.out.println(hashtemp);
//
//						// System.out.println(resultSet.getString("name"));
//
//						// Print results from select statement
//						// System.out.println("loop");
//					} catch (SQLException e2) {
//						JOptionPane.showMessageDialog(frame, "No player found");
//						e2.printStackTrace();
//					}
//				}
//			});
//			window2.findTeam.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
////					 ArrayList<String> rests = new ArrayList<String>();
////						dbService.connect("SodaBaseUsermcmaholc", "Password123");
//					try {
//						PreparedStatement statement;
//						String selectSql = "SELECT HomeArenaName FROM [Team]";
//						if (!window2.teamtxt.getText().isEmpty() || !window2.abbrtxt.getText().isEmpty()) {
//							selectSql += " WHERE";
//							if (!window2.teamtxt.getText().isEmpty() && !window2.abbrtxt.getText().isEmpty()) {
//								selectSql += " TeamName = ? AND TeamAbbreviation = ?";
//								statement = connection.prepareStatement(selectSql);
//								statement.setString(1, window2.teamtxt.getText());
//								statement.setString(2, window2.abbrtxt.getText());
//
//							} else if (!window2.abbrtxt.getText().isEmpty()) {
//								selectSql += " TeamAbbreviation = ?";
//								statement = connection.prepareStatement(selectSql);
//								statement.setString(1, window2.abbrtxt.getText());
//							} else {
//								selectSql += " TeamName = ?";
//								statement = connection.prepareStatement(selectSql);
//								statement.setString(1, window2.teamtxt.getText());
//							}
//						} else {
//							statement = connection.prepareStatement(selectSql);
//						}
//						connection.setAutoCommit(false);
//						ResultSet resultSet = statement.executeQuery();
//						resultSet.next();
//						JOptionPane.showMessageDialog(frame, "HomeArenaName:" + resultSet.getString("HomeArenaName"));
//						// System.out.println(hash);
//
//						// System.out.println(hashtemp);
//
//						// System.out.println(resultSet.getString("name"));
//
//						// Print results from select statement
//						// System.out.println("loop");
//					} catch (SQLException e2) {
//
//						JOptionPane.showMessageDialog(frame, "No team found");
//						e2.printStackTrace();
//					}
//				}
//			});

			/// edit page listeners
			// create or update player
			
			////////////////////////////////////////////////////ADD NEW PLAYER////////////////////////////
			window3.newPlayer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					 ArrayList<String> rests = new ArrayList<String>();
//						dbService.connect("SodaBaseUsermcmaholc", "Password123");
					String firstName = window3.fNameField.getText();
					String lastName = window3.lNameField.getText();
					String team = window3.collegetxt.getText();
					String number = window3.numberField.getText();
					int ID = -1;
					// boolean exists;

					//getting new max playerid
					try {
						CallableStatement statement;
						String selectSql = " SELECT id FROM Person where [First Name] = ? and [Last Name] = ?";
						
						statement = connection.prepareCall(selectSql);
						statement.setString(1, firstName);
						statement.setString(2, lastName);
						ResultSet resultSet = statement.executeQuery();
						resultSet.next();

						ID = resultSet.getInt("ID");
						System.out.println(ID);

						// player already exists
						if ((lastName != null || firstName != null) && ID > -1) {

							System.out.println("player already exists nothing needed to do");

//							
						}
						// player not currently in the database
					} catch (SQLException e2) {

						try {
							PreparedStatement statement2;
							String selectSql = " INSERT INTO PERSON([First Name], [Last Name]) Values(?, ?)";
							statement2 = connection.prepareStatement(selectSql);
							statement2.setString(1, firstName);
							statement2.setString(2, lastName);
							statement2.execute();

							selectSql = " SELECT id FROM Person where [First Name] = ? and [Last Name] = ?";
							statement2 = connection.prepareStatement(selectSql);
							statement2.setString(1, firstName);
							statement2.setString(2, lastName);
							ResultSet resultSet = statement2.executeQuery();
							resultSet.next();

							ID = resultSet.getInt("ID");
							System.out.println(ID);

							selectSql = " INSERT INTO Player([PlayerID]) Values(?)";
							statement2 = connection.prepareStatement(selectSql);
							statement2.setInt(1, ID);
							statement2.execute();

							
							
							System.out.println("added player");
							
							selectSql = " INSERT INTO PlayedFor([PlayerID], [TeamName]) Values(?, ?)";
							statement2 = connection.prepareStatement(selectSql);
							statement2.setInt(1, ID);
							statement2.setString(2,team);
							statement2.execute();
							

						} catch (SQLException e3) {
							System.out.println("couldnt add player");
						}

					}
				}
			});

		
			
			////////////////////////////////////////DELETE PLAYER/////////////////////////////////////////////
			window3.deleteButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					 ArrayList<String> rests = new ArrayList<String>();
//						dbService.connect("SodaBaseUsermcmaholc", "Password123");
					String firstName = window3.fNameField.getText();
					String lastName = window3.lNameField.getText();
					String college = window3.collegetxt.getText();
					String number = window3.numberField.getText();
					// boolean exists;

					try {
						PreparedStatement statement;

						String selectSql = " SELECT id FROM Person where [First Name] = ? and [Last Name] = ?";
						statement = connection.prepareStatement(selectSql);
						statement.setString(1, firstName);
						statement.setString(2, lastName);
						ResultSet resultSet = statement.executeQuery();
						resultSet.next();

						int ID = resultSet.getInt("ID");
						System.out.println(ID);

						
						selectSql = " DELETE FROM Playedfor where [PlayerID] = ?";
						statement = connection.prepareStatement(selectSql);
						statement.setInt(1, ID);
						statement.execute();
						
						selectSql = " DELETE FROM Player where PlayerId = ?";
						statement = connection.prepareStatement(selectSql);
						statement.setInt(1, ID);
						statement.execute();

						selectSql = " DELETE FROM Person where [First Name] = ? and [Last Name] = ?";
						statement = connection.prepareStatement(selectSql);
						statement.setString(1, firstName);
						statement.setString(2, lastName);
						statement.execute();

				
						
						System.out.println("deleted player");

					} catch (SQLException e2) {

						JOptionPane.showMessageDialog(frame, "no player found");
						e2.printStackTrace();

					}
				}
			});

			/////////////////////////////////// USER PAGE
			/////////////////////////////////// LISTENER/////////////////////////////////////////////////////////////

			// user page filling up dropdown box
			window4.teamsCombo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// System.out.println("test worked");

					// clearing whatever is left over
					window4.playersCombo.removeAllItems();


					String teamName = window4.teamsCombo.getSelectedItem().toString();
					// System.out.println(teamName + "TESTING");

					try {
						CallableStatement statement;

						String selectSql = "EXEC dbo.FindPlayerByTeam  ? ";
						statement = connection.prepareCall(selectSql);
						statement.setString(1, teamName);
						ResultSet resultSet = statement.executeQuery();

						// gets results
						while (resultSet.next()) {

							String fName = resultSet.getString("First Name");

							String lName = resultSet.getString("Last Name");

							String fullName = fName + " " + lName;

							// adding player to dropdown
							window4.playersCombo.addItem(fullName);

						}

					} catch (SQLException e2) {

						JOptionPane.showMessageDialog(frame, "error with team selection");
						e2.printStackTrace();

					}

				}

			});

			// filling up table with all the game dates

			window4.run.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// System.out.println("test worked");

					// clearing whatever is left over
					String firstName = window4.getFirstName();
					String lastName = window4.getLastName();
					String teamName = window4.getTeam();
					String selectedStat = window4.statCombo.getSelectedItem().toString();
					int overUnderStat = 0;
					if(window4.overUnder.getSelectedItem().toString().contains("over")) {
						overUnderStat = 1;
					}
					int number = Integer.parseInt(window4.value.getText());
					
					System.out.println(firstName + "!");
					System.out.println(lastName + "!");
					System.out.println(teamName + "!");
					
					System.out.println(teamName + firstName + lastName + selectedStat + overUnderStat + number);
					//System.out.println(firstName + " " + lastName + " " + teamName);
					
					if (firstName != null && lastName != null && teamName != null) {

						try {
							CallableStatement statement;

							//System.out.println("gets here");
							String selectSql = "EXEC dbo.[ReadGameDatesForBets] ?, ?, ?, ?, ?, ? ";
							statement = connection.prepareCall(selectSql);
							statement.setString(1, teamName);
							statement.setString(2, firstName);
							statement.setString(3, lastName);
							statement.setString(4, selectedStat);
							statement.setInt(5,overUnderStat);
							statement.setInt(6, number);
							ResultSet resultSet = statement.executeQuery();

							System.out.println("right before result set");
							// gets results
							while (resultSet.next()) {

								//System.out.println("list test ");
								//add Game dates to list
								String gameDate = resultSet.getDate("GameDate").toString();
								System.out.println(resultSet.getDate("GameDate").toString());
								window4.listOfGames.addElement(gameDate);
								//System.out.println("gameDate added: " + gameDate);
								
							}

						} catch (SQLException e2) {

							JOptionPane.showMessageDialog(frame, "error with getting dates");
							e2.printStackTrace();

						}

					}
				}

			});

			//filling up second list with data from selected date
			window4.run.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//window4.ppgLabel.setText("IT WORKED");
				}

			});

			
			///////showing averages/////////////////
			window4.playersCombo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String firstName = window4.getFirstName();
					String lastName = window4.getLastName();
					

				
					
					System.out.println(firstName + " " + lastName + " TEST WITH AVERAGES");
					
					if (firstName != null && lastName != null) {

						try {
							CallableStatement statement;

							//System.out.println("gets here");
							String selectSql = "exec dbo.ReadPlayerAverageStats ?, ?";
							statement = connection.prepareCall(selectSql);
							statement.setString(1, firstName);
							statement.setString(2, lastName);
						
							ResultSet resultSet = statement.executeQuery();

							System.out.println("right before result set");
							// gets results
							while (resultSet.next()) {

								//System.out.println("list test ");
								//add Game dates to list
								String fgPer = resultSet.getBigDecimal("FieldGoalPercent").toString();
								String threePer = resultSet.getBigDecimal("ThreePointerPercent").toString();
								String ftPer = resultSet.getBigDecimal("FreeThrowPercent").toString();
								String ppg = resultSet.getBigDecimal("PointsPerGame").toString();
								//System.out.println(resultSet.getDate("GameDate").toString());
								
								window4.fgStat.setText(fgPer);
								window4.threeStat.setText(threePer);
								window4.ftStat.setText(ftPer);
								window4.ppgStat.setText(ppg);
								//System.out.println("gameDate added: " + gameDate);
								
							}

						} catch (SQLException e2) {

							JOptionPane.showMessageDialog(frame, "error with getting averages");
							e2.printStackTrace();

						}

					}
				
					
				}

			});
			
			
			
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//			JFrame frame = new JFrame();
//	        frame.setTitle("NBA Stats");
//	        frame.setLocation(0, 0);
//	        frame.setSize((int) screen.getWidth(),(int) screen.getHeight());
//	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	        frame.setVisible(true);
//	        JPanel panel=new JPanel();  
//	        panel.setBounds(0,0,(int) screen.getWidth(),(int) screen.getHeight());    
//	        panel.setBackground(Color.gray);  
//	        JButton b1=new JButton("Add");     
//	        b1.setBounds((int) screen.getWidth() * 9 / 10,(int) screen.getHeight() * 1 / 10,(int) screen.getWidth() * 9.5 / 10,30);    
//	        b1.setBackground(Color.yellow);   
//	        JButton b2=new JButton("Get");   
//	        b2.setBounds(100,100,80,30);    
//	        b2.setBackground(Color.green);   
//	        panel.add(b1); panel.add(b2);  
//	        frame.add(panel);  

			// create a structure to call the stored procedure, CheckSalesQuota
////			CallableStatement stmt = connection.prepareCall("{? = call CheckSalesQuota(?)}");
//			// set the first ? to get the return value from the SPROC
//			stmt.registerOutParameter(1, Types.INTEGER);
//			// prompt for the sales quota to send -- note this should be sanity checked, but isn't here
//			System.out.println("Enter the sales quota to check: \n");
//			int quota = reader.nextInt();
//			// set the second ? to the value read in
//			stmt.setString(2, Integer.toString(quota));
//			// ask SQL server to execute the SPROC and make the results available in results
//			ResultSet results = stmt.executeQuery();
//			// while there is a tuple, loop threw and process each one
//			while (results.next()) {
//				//get the results and make them stored as local variables
//				String first_name = results.getString(1);
//				String last_name = results.getString(2);
//				//print out the results to make sure they look good
//				System.out.println("First Name = " + first_name + ", Last Name = " + last_name );
//			}
//			//This must be done after reading the result set (JDBC rules, apparently)
//			//Process the return code and see if successful
//			int returnCode = stmt.getInt(1);
//			if (returnCode == 0) {
//				System.out.println("Success!");
//			}
//			else {
//				System.out.println("Procedure reported an error.");
//			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
//		finally {
//			try {
//				// make sure to close the DB connection and the input stream
//				if (connection!=null && !connection.isClosed()) {
//					connection.close();
//					reader.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}

	}

	static void createPlayer(String firstName, String LastName) {

	}

}
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
		String passwordCreator = "po;jwquenxmfpge6981067p5b5p31-paaosad/o011872745nrdh?";
		String fullUrl = url.replace("${dbServer}", "titan.csse.rose-hulman.edu").replace("${dbName}", "NBAStats_S4G4")
				.replace("${user}", "mcmaholc").replace("${pass}",
						passwordCreator.substring(51, 52).toUpperCase() + passwordCreator.substring(38, 39)
								+ passwordCreator.substring(10, 11) + passwordCreator.substring(7, 8)
								+ passwordCreator.substring(27, 28) + passwordCreator.substring(27, 28)
								+ passwordCreator.substring(17, 18) + passwordCreator.substring(17, 18)
								+ passwordCreator.substring(24, 25).toUpperCase() + passwordCreator.substring(38, 39)
								+ passwordCreator.substring(24, 25));
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
			ReadPage window2 = new ReadPage();
			tabbedPane.addTab("BasketballFinder", null, window2.itemModPanel, null);
			EditPage window3 = new EditPage();
			tabbedPane.addTab("Player", null, window3.itemModPanel, null);
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
			window2.findPlayer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					 ArrayList<String> rests = new ArrayList<String>();
//						dbService.connect("SodaBaseUsermcmaholc", "Password123");
					try {
						PreparedStatement statement;
						String selectSql = "SELECT FreeThrowPercent FROM [Player] pl";
						selectSql += " JOIN Person pe ON pe.ID = pl.PlayerID";
						if (!window2.nametxt.getText().isEmpty() || !window2.clgtxt.getText().isEmpty()) {
							selectSql += " WHERE";
							if (!window2.nametxt.getText().isEmpty() && !window2.clgtxt.getText().isEmpty()) {
								selectSql += " College = ? AND [First Name] = ?";
								statement = connection.prepareStatement(selectSql);
								statement.setString(2, window2.nametxt.getText());
								statement.setString(1, window2.clgtxt.getText());

							} else if (!window2.clgtxt.getText().isEmpty()) {
								selectSql += " College = ?";
								statement = connection.prepareStatement(selectSql);
								statement.setString(1, window2.clgtxt.getText());
							} else {
								selectSql += " [First Name] = ?";

								statement = connection.prepareStatement(selectSql);
								statement.setString(1, window2.nametxt.getText());
							}
						} else {
							statement = connection.prepareStatement(selectSql);
						}
						connection.setAutoCommit(false);
						System.out.println(statement);
						ResultSet resultSet = statement.executeQuery();
						resultSet.next();
						JOptionPane.showMessageDialog(frame,
								"FreeThrowPercent:" + resultSet.getDouble("FreeThrowPercent") * 100 + "%");
						// System.out.println(hash);

						// System.out.println(hashtemp);

						// System.out.println(resultSet.getString("name"));

						// Print results from select statement
						// System.out.println("loop");
					} catch (SQLException e2) {
						JOptionPane.showMessageDialog(frame, "No player found");
						e2.printStackTrace();
					}
				}
			});
			window2.findTeam.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					 ArrayList<String> rests = new ArrayList<String>();
//						dbService.connect("SodaBaseUsermcmaholc", "Password123");
					try {
						PreparedStatement statement;
						String selectSql = "SELECT HomeArenaName FROM [Team]";
						if (!window2.teamtxt.getText().isEmpty() || !window2.abbrtxt.getText().isEmpty()) {
							selectSql += " WHERE";
							if (!window2.teamtxt.getText().isEmpty() && !window2.abbrtxt.getText().isEmpty()) {
								selectSql += " TeamName = ? AND TeamAbbreviation = ?";
								statement = connection.prepareStatement(selectSql);
								statement.setString(1, window2.teamtxt.getText());
								statement.setString(2, window2.abbrtxt.getText());

							} else if (!window2.abbrtxt.getText().isEmpty()) {
								selectSql += " TeamAbbreviation = ?";
								statement = connection.prepareStatement(selectSql);
								statement.setString(1, window2.abbrtxt.getText());
							} else {
								selectSql += " TeamName = ?";
								statement = connection.prepareStatement(selectSql);
								statement.setString(1, window2.teamtxt.getText());
							}
						} else {
							statement = connection.prepareStatement(selectSql);
						}
						connection.setAutoCommit(false);
						ResultSet resultSet = statement.executeQuery();
						resultSet.next();
						JOptionPane.showMessageDialog(frame, "HomeArenaName:" + resultSet.getString("HomeArenaName"));
						// System.out.println(hash);

						// System.out.println(hashtemp);

						// System.out.println(resultSet.getString("name"));

						// Print results from select statement
						// System.out.println("loop");
					} catch (SQLException e2) {
						
						
						JOptionPane.showMessageDialog(frame, "No team found");
						e2.printStackTrace();
					}
				}
			});

			/// edit page listeners
			// create or update player
			window3.newPlayer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					 ArrayList<String> rests = new ArrayList<String>();
//						dbService.connect("SodaBaseUsermcmaholc", "Password123");
					String firstName = window3.nametxt.getText();
					String lastName = window3.lastNameTxt.getText();
					String college = window3.collegetxt.getText();
					String ft = window3.ftText.getText();
					int ID = -1;
					// boolean exists;

					try {
						PreparedStatement statement;
						String selectSql = " SELECT id FROM Person where [First Name] = ? and [Last Name] = ?";					
						statement = connection.prepareStatement(selectSql);
						statement.setString(1, firstName);
						statement.setString(2, lastName);
						ResultSet resultSet = statement.executeQuery();
						resultSet.next();

						ID = resultSet.getInt("ID");
						System.out.println(ID);

						// player already exists
						if ((lastName != null || firstName != null) && ID > -1) {

							if (!ft.isEmpty()) {
								selectSql = "UPDATE Player SET FreeThrowPercent = ? WHERE PlayerID = ?";
								statement = connection.prepareStatement(selectSql);
								statement.setString(1, ft);
								statement.setInt(2, ID);
							}

							if (!college.isEmpty()) {
								selectSql = "UPDATE Player SET college = ? WHERE PlayerID = ?";
								statement = connection.prepareStatement(selectSql);
								statement.setString(1, college);
								statement.setInt(2, ID);
							}

							System.out.println(firstName);
						} 
					} catch (SQLException e2) {
					
					try {
						PreparedStatement statement2;
						String selectSql = " INSERT INTO PERSON([First Name], [Last Name]) Values(?, ?)";					
						statement2 = connection.prepareStatement(selectSql);
						statement2.setString(1, firstName);
						statement2.setString(2, lastName);
						statement2.execute();
						System.out.println("added player");
						
					}
					catch(SQLException e3) {
						System.out.println("couldnt add player");
					}
					
		
						
					}
				}
			});
			
			
			window3.deleteButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					 ArrayList<String> rests = new ArrayList<String>();
//						dbService.connect("SodaBaseUsermcmaholc", "Password123");
					String firstName = window3.nametxt.getText();
					String lastName = window3.lastNameTxt.getText();
			
					// boolean exists;

					try {
						PreparedStatement statement;
						String selectSql = " DELETE FROM Person where [First Name] = ? and [Last Name] = ?";					
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
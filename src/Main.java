package src;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import javax.swing.JFrame;
/************************************************************************/
/*  A small example of using JDBC to the FoodDelivery DB                */
/*  Used as an example for CSSE333 - tracy section                      */
/*  Calls a stored procedure that we previously created.                */
/*  April 6, 2022
/************************************************************************/
public class Main {

	public static void main(String[] args) {
		/* 
		 * This first section creaions a URL "connection string" to be used to connect to the particular
		 * database.  Generally, would be assembled in a different way, particularly the username/password
		 * Note that the connection uses a special account: FoodDeliveryUserTracy
		 * The intent is to use an account with the minimal required permissions.  
		 */
		String url = "jdbc:sqlserver://${dbServer};databaseName=${dbName};user=${user};password={${pass}}";
		String passwordCreator = "po;jwquenxmfpge6981067p5b5p31-paaosad/o011872745nrdh?";
		String fullUrl = url
				.replace("${dbServer}", "titan.csse.rose-hulman.edu")
				.replace("${dbName}", "NBAStats_S4G4")
				.replace("${user}", "mcmaholc")
				.replace("${pass}", );
		//System.out.println(fullUrl);

		/*
		 * create these connections in a scope so that they can be reliably closed in several places.
		 */
		Connection connection = null;
		Scanner reader = new Scanner(System.in);
		/*
		 * Note that SQL Server operations all must be in try/catch structures as they 
		 * can throw SQLException exceptions.  
		 */
		try {
			// open the connection to the DB
			connection = DriverManager.getConnection(fullUrl);
			JFrame frame = new JFrame();
	        frame.setTitle("NBA Stats");
	        frame.setSize(1600, 800);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
	        
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
			connection.close();
			reader.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				// make sure to close the DB connection and the input stream
				if (connection!=null && !connection.isClosed()) {
					connection.close();
					reader.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
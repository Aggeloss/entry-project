import javax.swing.*;
import java.sql.*;
import com.microsoft.sqlserver.jdbc.*;

public class Functions {

	private Statement statement;
	private Connection conn;
	private String connectionString;
	/*private String ID, NAME, SURNAME, ADDRESS, NUMBER, TOWN,
				   POSTALCODE, PHONE, DOB, NUMOFRENT, NOTES,
				   GENDER;*/
	int Customer_ID;
	
	private String ID, CONTENT, SERVICE;
	
	private String CONTACT_S, COUNTRY_S, NAME_S, ADD1_S, ADD2_S, ADD3_S,
				   CITY_S, POSTALCODE_S;
	
	private String CONTACT_R, COUNTRY_R, NAME_R, ADD1_R, ADD2_R, ADD3_R,
				   CITY_R, POSTALCODE_R;
	
	public Functions() {
		//System.setProperty("java.net.preferIPv6Addresses", "true"); 
		
		connectionString =  
                "jdbc:sqlserver://localhost\\ANGELOS-PC:1433;databaseName=client_entry;user=TestUser;password=14534145";
		
		try { 
			
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//System.setProperty("java.net.preferIPv6Addresses", "true"); 
			//sourceURL = new String ("jdbc:odbc:client_DSN");
			
			conn = DriverManager.getConnection(connectionString);
			
			statement = conn.createStatement();
			
			System.out.print("Connected! ");
			//System.out.print(Main_Constructor.Date);
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void Delete() {
		
		try {
			String ans = (String)JOptionPane.showInputDialog("Enter the id " +
															"of the customer you" +
															" want to delete: ");
			if(ans != null) {
				int id = Integer.parseInt(ans);
				
				String sql = "DELETE FROM CUSTOMER " +
							 "WHERE ID=" + id;
				
				int result = statement.executeUpdate(sql);
				
				if(result == 1) {
					JOptionPane.showMessageDialog(null,
								"Customer " + id + "deleted" +
								" successfully.",
								"Information Message",
								JOptionPane.INFORMATION_MESSAGE);
				}else if(result == 0) {
					JOptionPane.showMessageDialog(null, 
								"Invalid id!", "Error " +
								"Message",
								JOptionPane.ERROR_MESSAGE);
				}
			}
		}catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null,
						"Invalid data: " +
						sqle.getMessage(),
						"Error Message",
						JOptionPane.ERROR_MESSAGE);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null,
						e.getMessage(),
						"Error Message",
						JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void Select() {
		
		try {
			String output = "", str = "";
			JTextArea outputArea = new JTextArea(35,80);
			JScrollPane jsp = new JScrollPane(outputArea);
			
			String ans = (String)JOptionPane.showInputDialog("Enter the " + 
											 "name of the town of the branch" +
											 " you want to find: ");
			if(ans != null) {
				
				String sql = "SELECT V.CODE, V.NAME," +
							 "V.ADDRESS, V.NUMBER FROM " +
							 "VIDEOCLUB V WHERE " +
							 "V.TOWN=" + ans;
				ResultSet result = statement.executeQuery(sql);
				str = displayResults(result);
				output = "Video club data:" + '\n';
				output += "\n" + str;
				
				outputArea.setText(output);
				outputArea.setEditable(false);
				JOptionPane.showMessageDialog(null, jsp,
							"Video club data",
							JOptionPane.INFORMATION_MESSAGE);
			}
		}catch(SQLException sqle) {
			JOptionPane.showMessageDialog(null,
						"Invalid data: " +
						sqle.getMessage(),
						"Error Message",
						JOptionPane.ERROR_MESSAGE);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,
						e.getMessage(), "Error Message",
						JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void Insert() {
		
		ID         = Main_Constructor.ID;
		SERVICE    = Main_Constructor.Service;
		CONTENT    = Main_Constructor.Content;
		
		NAME_S	   = Main.sender.getName();
		CONTACT_S  = Main.sender.getContact();
		COUNTRY_S  = Main.sender.getCountry();
		CITY_S 	   = Main.sender.getCity();
		POSTALCODE_S = Main.sender.getPostal_Code();
		ADD1_S 	   = Main.sender.getAdd1();
		ADD2_S 	   = Main.sender.getAdd2();
		ADD3_S 	   = Main.sender.getAdd3();
		
		NAME_R	   = Main.receiver.getName();
		CONTACT_R  = Main.receiver.getContact();
		COUNTRY_R  = Main.receiver.getCountry();
		CITY_R 	   = Main.receiver.getCity();
		POSTALCODE_R = Main.receiver.getPostal_Code();
		ADD1_R 	   = Main.receiver.getAdd1();
		ADD2_R 	   = Main.receiver.getAdd2();
		ADD3_R 	   = Main.receiver.getAdd3();
		
		try {
			
			String sql = "INSERT INTO Waybill_Data"
					    +"(BARCODE,SERVICE,CONTENT,"
					    + "DATE,COUNTRY_S,NAME_S,CONTACT_S,"
					    + "CITY_S,ADD1_S,ADD2_S,ADD3_S,POSTALCODE_S,"
					    + "COUNTRY_R,NAME_R,CONTACT_R,CITY_R,"
					    + "ADD1_R,ADD2_R,ADD3_R,POSTALCODE_R)"
					    +" VALUES "
					    +"('"+ID+"',"
					    +"'"+SERVICE+"',"
					    +"'"+CONTENT+"',"
					    +"GETDATE(),"
					    +"'"+COUNTRY_S+"',"
					    +"'"+NAME_S+"',"
					    +"'"+CONTACT_S+"',"
					    +"'"+CITY_S+"',"
					    +"'"+ADD1_S+"',"
					    +"'"+ADD2_S+"',"
					    +"'"+ADD3_S+"',"
					    +"'"+POSTALCODE_S+"',"
					    +"'"+COUNTRY_R+"',"
					    +"'"+NAME_R+"',"
					    +"'"+CONTACT_R+"',"
					    +"'"+CITY_R+"',"
					    +"'"+ADD1_R+"',"
					    +"'"+ADD2_R+"',"
					    +"'"+ADD3_R+"',"
					    +"'"+POSTALCODE_R+"')";
			
			int result = statement.executeUpdate(sql);
			
			JOptionPane.showMessageDialog(null, 
						"Customer " + ID + " successfully inserted!",
						"Successfull Insert",
						JOptionPane.INFORMATION_MESSAGE);
		}catch(SQLException sqle) {
			JOptionPane.showMessageDialog(null,
						"Invalid data: " +
					    sqle.getMessage(),
					    "Error Message",
					    JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	
	public void Update() {
		
		try {
			String str = (String)JOptionPane.showInputDialog("Please type " +
											"the id of the product you" +
											"want to return: ");
			
			if(str != null) {
				int answer = Integer.parseInt(str);
				
				String sql = "UPDATE RENTS SET" +
							 "RDATEOUT = RTRIM(CAST" +
							 "(GETDATE() AS " +
							 "NVARCHAR(30))) WHERE " +
							 "PRODID=" + answer + 
							 	"AND RDATEOUT IS NULL";
				
				int result = statement.executeUpdate(sql);
				
				if(result == 1) {
					JOptionPane.showMessageDialog(null,
								"Product " + answer + 
								" successfully returned!",
								"Succesfull Return",
								JOptionPane.INFORMATION_MESSAGE);
				}else if(result == 0) {
					JOptionPane.showMessageDialog(null,
								"Product " + answer + 
								"is not rented or" + 
								"does not exist!",
								"Unsuccesfull Return",
								JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}catch(SQLException sqle) {
			JOptionPane.showMessageDialog(null,
				    sqle.getMessage(),"Error Message",
				    JOptionPane.ERROR_MESSAGE);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,
					e.getMessage(), "Error Message",
					JOptionPane.ERROR_MESSAGE);
		
		}
		
	}
	
	public void Procedure() {
		
		JTextArea outputArea = new JTextArea(30,30);
		JScrollPane jsp = new JScrollPane(outputArea);
		String output,str;
		
		try {
			CallableStatement cstmt = conn.prepareCall("{call PROCED}");
			
			output = "Popular Products Ordered by " +
					 "Frequency :" + "\n";
			output += "\n" + "PRODUCT \t" + "TITLE \t" +
					  "CATEGORY \t" + "FREQUENCY \n";
			
			boolean bool = cstmt.execute();
			
			while(true) {
				ResultSet rs = cstmt.getResultSet();
				
				str = displayResults(rs);
				output += str;
				
				rs.close();
				
				if (!cstmt.getMoreResults()) break;
			}
			
			outputArea.setText(output);
			outputArea.setEditable(false);
			JOptionPane.showMessageDialog(null,jsp,
						"Popular Products",
						JOptionPane.INFORMATION_MESSAGE);
			
			cstmt.close();
		}catch(SQLException sqle){
			JOptionPane.showMessageDialog(null,
				    sqle.getMessage() + "," + 
				    sqle.getSQLState() + "," +
				    sqle.getErrorCode(),
				    "Error Message",
				    JOptionPane.ERROR_MESSAGE);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,
					e.getMessage(), 
					"Error Message",
					JOptionPane.ERROR_MESSAGE);
		
		}
		
	}
	
	static String displayResults (ResultSet rs) throws SQLException {
		
		String str = "";
		ResultSetMetaData rsmeta = rs.getMetaData();
		int numColumns = rsmeta.getColumnCount();
		
		for(int i=1; i<=numColumns; i++) {
			if(i < numColumns) 
				str = str.concat(rsmeta.getColumnName(i) + '\t');
			else 
				str = str.concat(rsmeta.getColumnName(i) + '\n');
		}
		
		while(rs.next()) {
			for(int i=1; i<=numColumns; i++) {
				if(i < numColumns)
					str = str.concat(rs.getString(i) + '\t');
				else
					str = str.concat(rs.getString(i).trim() + '\n');
			}
		}
		
		return str;
		
	}
	
	public void close() {
		
		try {
			conn.close();
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		
	}
	
}
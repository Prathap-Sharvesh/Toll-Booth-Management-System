package tollbooth;

import java.sql.*;
import java.util.*;

public class admin {

	Scanner sc = new Scanner(System.in);
	int vehicleNo;
	String brandName;
	int vehicleType;

	public void addDetails(vehicle v) throws Exception
	{

		String query = "Insert into vehicle values (?,?,?)";
		Connection con = DbConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, v.vehicleNo);
		pst.setString(2,v.brandName);
		pst.setInt(3, v.vehicleType);
		
		pst.executeUpdate();
		
		System.out.println("Vehicle Details added Successfully"	);
	}
		
	public void viewDetails() throws Exception
	{
		String query = "Select * from vehicle";
		Connection con = DbConnection.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			System.out.println("Vehicle No: " + rs.getInt(1));
			
			System.out.println("Brand Name: " + rs.getString(2));
			if(rs.getInt(3)==2)
				System.out.println("Vehicle Type " +"Two-Wheeler");
			else
				System.out.println("Vehicle Type " +"Four-Wheeler");
			
			System.out.println("========================================");
		}

	}

	public void removeDetails( int no) throws Exception {
		// TODO Auto-generated method stub
		String query = "Delete from vehicle where vehicle_no = ?";
		Connection con = DbConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1,no);
		
		
		int rowsAffected = pst.executeUpdate();
		 
		if (rowsAffected > 0) {
	        System.out.println("Vehicle deleted successfully.");
	    } 
		else {
	        System.out.println("No vehicle found with that number.");
	    }
	}
	
	public void searchDetails( int no) throws Exception {
		// TODO Auto-generated method stub
		
		String query = "Select * from vehicle where vehicle_no = ?";
		Connection con = DbConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, no);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			System.out.println("Vehicle No: " + rs.getInt(1));
			
			System.out.println("Brand Name: " + rs.getString(2));
			if(rs.getInt(3)==2)
				System.out.println("Vehicle Type " +"Two-Wheeler");
			else
				System.out.println("Vehicle Type " + "Four-Wheeler");
			
			System.out.println("========================================");
		}

	}
	
	public void modifyDetails(int no) throws Exception {
	   
	    System.out.print("Enter new brand name: ");
	    String newBrand = sc.nextLine();

	    System.out.print("Enter new vehicle type (2 for Two-Wheeler, 4 for Four-Wheeler): ");
	    int newType = sc.nextInt();

	    String query = "UPDATE vehicle SET brand_name = ?, vehicle_type = ? WHERE vehicle_no = ?";
	    Connection con = DbConnection.getConnection();
	    PreparedStatement pst = con.prepareStatement(query);
	    pst.setString(1, newBrand);
	    pst.setInt(2, newType);
	    pst.setInt(3, no);

	    int rowsAffected = pst.executeUpdate();

	    if (rowsAffected > 0) {
	        System.out.println("Vehicle details updated successfully.");
	    } else {
	        System.out.println("No vehicle found with number: " + no);
	    }
	}

}
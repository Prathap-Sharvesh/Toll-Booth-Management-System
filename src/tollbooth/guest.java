package tollbooth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class guest {
	
	public void searchDetails( int no) throws Exception {
		// TODO Auto-generated method stub
		
		String query = "Select * from vehicle where vehicle_no = ?";
		Connection con = DbConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, no);
		ResultSet rs = pst.executeQuery();
		
	    boolean found = false;
	    while (rs.next()) {
	        found = true;
	        System.out.println("Vehicle No: " + rs.getInt(1));
	        System.out.println("Brand Name: " + rs.getString(2));
	        if (rs.getInt(3) == 2)
	            System.out.println("Vehicle Type: Two-Wheeler");
	        else
	            System.out.println("Vehicle Type: Four-Wheeler");
	        System.out.println("========================================");
	    }

	    if (!found) {
	        System.out.println("No details found");
	    }
		
	}
}

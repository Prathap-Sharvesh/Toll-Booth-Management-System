package tollbooth;
import java.util.*;
import java.awt.*;

public class system {
		
	public static void main(String[] args) throws Exception {
		
		
	
		int user,adminOption,guestOption;
		Scanner sc = new Scanner (System.in);
		admin ad = new admin ();
		guest g = new guest();
		
		while (true)
		{
			System.out.println ( "\t \tWelcome to the XYZ Toll Booth ");
			System.out.println ( "\t ==========================================\n");
			System.out.println("Press 1 to enter as admin \n2 to enter as guest \n3 to exit");
			user = sc.nextInt();
			if (user == 1)
			{
				
				System.out.println ( " 1. Add Vehicle to Database ");
				System.out.println ( " 2. Delete Vehicle from Database ");
				System.out.println ( " 3. Modify Vehicle from Database ");
				System.out.println ( " 4. View Vehicles from Database ");
				System.out.println ( " 5. Search for Vehicle in Database ");
				
				System.out.println ( "\n Enter the operation to perform");
				adminOption = sc.nextInt();
		
				if (adminOption == 1)
				{
					vehicle v = new vehicle();
					v.setVehicleDetails();
					ad.addDetails(v);
				}
				else if (adminOption == 2)
				{
					
					System.out.println("Enter the vehicle number :");
					int no = sc.nextInt();
					ad.removeDetails(no);
					
				}
				else if (adminOption == 3)
				{
					System.out.println("Enter the vehicle number :");
					int no = sc.nextInt();
				
					ad.modifyDetails(no);
				}
				else if (adminOption == 4)
				{
					
					ad.viewDetails();
				}
				
				else if (adminOption == 5)
				{
					System.out.println("Enter the vehicle number :");
					int no = sc.nextInt();
					ad.searchDetails(no);
					
				}

			}
			else if (user == 2)
			{
				System.out.println ( " 1. Search for Vehicle in Database ");
				guestOption = sc.nextInt();
				if(guestOption == 1)
				{
					System.out.println("Enter the vehicle number :");
					int no = sc.nextInt();
					g.searchDetails(no);
				}
			}
			else if (user == 3)
			{
				System.exit(0);
			}
			
		}
	}
}

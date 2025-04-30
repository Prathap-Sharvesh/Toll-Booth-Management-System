package tollbooth;

import java.util.*;
public class vehicle {
	
	int vehicleNo;
	String brandName;
	int vehicleType;
	Scanner sc = new Scanner(System.in);
	//Constructor
		public vehicle(){
//			System.out.println( " Enter the vehicle number : " );
//			vehicleNo=sc.nextInt();
//			System.out.println( " Enter the brand name : " );
//			brandName=sc.next();
//			System.out.println( " Enter the vehicle type: " );
//			vehicleType=sc.nextInt();
//				
		}
	public void setVehicleDetails ()
	{
		System.out.println( " Enter the vehicle number : " );
		vehicleNo=sc.nextInt();
		System.out.println( " Enter the brand name : " );
		brandName=sc.next();
		System.out.println( " Enter the vehicle type: " );
		vehicleType=sc.nextInt();
	}

	
	
	
	public  void displayVehicleDetails() {
		System.out.println( " The Vehicle Number is " + vehicleNo);
		System.out.println( " The Brand Name is " + brandName);
		if (vehicleType == 2)
			System.out.println( " The Vehicle Type is " + "Two Wheeler");
		else if (vehicleType == 3)
			System.out.println( " The Vehicle Type is " + "Two Wheeler");
		else if (vehicleType == 4)
			System.out.println( " The Vehicle Type is " + "Four Wheeler");
		else if (vehicleType == 8)
			System.out.println( " The Vehicle Type is " + "Truck");
	}
	
}

package tollbooth;

import java.util.*;
public class vehicle {
	
	int vehicleNo;
	String brandName;
	int vehicleType;
	int fees;
	Scanner sc = new Scanner(System.in);
	//Constructor
		public vehicle(){
//			System.out.println( " Enter the vehicle number : " );
//			vehicleNo=sc.nextInt();
//			System.out.println( " Enter the brand name : " );
//			brandName=sc.next();
//			System.out.println( " Enter the vehicle type: " );
//			vehicleType=sc.nextInt();
		}
	public void setVehicleDetails ()
	{
		System.out.println( " Enter the vehicle number : " );
		vehicleNo=sc.nextInt();
		System.out.println( " Enter the brand name : " );
		brandName=sc.next();
		System.out.println( " Enter the vehicle type: " );
		vehicleType=sc.nextInt();
		if (vehicleType > 4)
		{
			fees = 200;
		}
		else if (vehicleType == 4){
			fees = 100;
		}
		else {
			fees = 0;
		}
	}

	
}

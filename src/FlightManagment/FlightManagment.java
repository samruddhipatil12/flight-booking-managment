package FlightManagment;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import UserManagment.User;

public class FlightManagment {
	
	static ArrayList<Flight> al = new ArrayList();
	public static void FlightManagment() throws IOException
	{
		loadDataFromFileToArrayList();
		Scanner scan = new Scanner(System.in);
	    boolean CanIKeepRunTheProgram = true;
	    while(CanIKeepRunTheProgram == true )
	    {
	    	System.out.println(" **** WELCOME TO FLIGHT BOOKING SYSTEM **** ");
	    	System.out.println(" 1.Add Flight ");
	    	System.out.println(" 2.Edit Flight ");
	    	System.out.println(" 3.Search Flight ");
	    	System.out.println(" 4.Cancel Flight ");
	    	System.out.println(" 5.Quit");
	    	
	    	int optionselectedbycustomer = scan.nextInt();
	    	
	    	if(optionselectedbycustomer == FlightOption.Quit)
	    	{
                File file = new File("C:\\Users\\Mr Patil\\Desktop\\space\\FlightBooking\\src\\FlightManagment\\Flight.csv");
				
				FileWriter fr = new FileWriter(file , true);
				
				BufferedWriter br = new BufferedWriter(fr);
				
				for(Flight f1:al)
				{
					br.write(f1.flightname+","+f1.flightnumber+","+f1.departurecity+","+f1.destinationcity+","+f1.date+","+f1.time+","+f1.airport+","+f1.ticketprice+"\n");
				}
				br.close();
				fr.close();
				file = null; 
				
	    		System.out.println(" !!! Program Closed !!! ");
	    		CanIKeepRunTheProgram = false;
	    	}
	    
	    	else if(optionselectedbycustomer == FlightOption.Add_Flight)
	    	{
	    		AddFlight();
	    	}
	    	else if(optionselectedbycustomer == FlightOption.Edit_Flight)
	    	{
	    		System.out.println(" Enter the Flight Name to edit : ");
	    		scan.nextLine();
	    		String editflightdetails = scan.nextLine();
	    		EditFlight(editflightdetails);
	    	}
	    	else if(optionselectedbycustomer == FlightOption.Search_Flight)
	    	{
	    		System.out.println(" Enter the Flight Name to search : ");
	    		scan.nextLine();
	    		String searchflight = scan.nextLine();
	    		SearchFlight(searchflight);
	    	}
	    	else if(optionselectedbycustomer == FlightOption.Cancel_Flight)
	    	{
	    		System.out.println(" Enter the Flight Name to cancel : ");
	    		scan.nextLine();
	    		String cancelflight = scan.nextLine();
	    		CancelFlight(cancelflight);
	    	}
	    }
	    System.out.println(" *** After While Loop *** ");
	    for(int i=0; i<al.size();i++)
	    {
	    	System.out.println(al.get(i).flightname);
	    	System.out.println(al.get(i).flightnumber);
	    	System.out.println(al.get(i).departurecity);
	    	System.out.println(al.get(i).time);
	    	System.out.println(al.get(i).date);
	    	System.out.println(al.get(i).airport);
	    	System.out.println(al.get(i).ticketprice);
	    }
	}
	public static void AddFlight()
	{
		Scanner scan = new Scanner(System.in);
		Flight f1 = new Flight();
		System.out.println(" Enter the Flight Name : ");
		f1.flightname = scan.nextLine();
		System.out.println(" Enter the Flight Number : ");
		f1.flightnumber = scan.nextLine();
		System.out.println( " Enter the Departure City : ");
		f1.departurecity = scan.nextLine();
		System.out.println(" Enter the Destination city : ");
		f1.destinationcity = scan.nextLine();
		System.out.println(" Enter the Date : ");
		f1.date = scan.nextLine();
		System.out.println(" Enter the time : ");
		f1.time = scan.nextLine();
		System.out.println(" Enter the AirPort Name : ");
		f1.airport= scan.nextLine();
		System.out.println(" Enter the Ticket Price : ");
		f1.ticketprice = scan.nextLine();
		
		al.add(f1);	
	}
	public static void EditFlight(String editflightdetails)
	{
		for(Flight f1:al)
		{
			if(f1.flightname.equalsIgnoreCase(editflightdetails))
			{
				System.out.println(" Enter the new flight name : "+f1.flightname);
				System.out.println(" Enter the new flight Number : "+f1.flightnumber);
				System.out.println(" Enter the new departure city : "+f1.departurecity);
				System.out.println(" Enter the new destination city : "+f1.destinationcity);
				System.out.println(" Enter the new date : "+f1.date);
				System.out.println(" Enter the new time : "+f1.time);
				System.out.println(" Enter the new airport name : "+f1.airport);
				System.out.println(" Enter the new ticket price : "+f1.ticketprice);
				
				System.out.println(" INFORMATION UPDATED ");
				return;
			}
		} ;
		System.out.println(" FLIGHT NOT FOUND");
	}
	public static void SearchFlight(String searchflightdetails )
	{
		for(Flight f1:al)
		{
			if(f1.flightname.equalsIgnoreCase(searchflightdetails))
			{
				System.out.println(f1.flightname);
				System.out.println(f1.flightnumber);
				System.out.println(f1.departurecity);
				System.out.println(f1.destinationcity);
				System.out.println(f1.date);
				System.out.println(f1.time);
				System.out.println(f1.airport);
				System.out.println(f1.ticketprice);
				return;
			}
		}
		System.out.println(" FLIGHT NOT FOUND ");
	}
	public static void CancelFlight(String cancelflight)
	{
		Iterator<Flight>itr = al.iterator();
		while(itr.hasNext())
		{
			Flight f1 = itr.next();
			if(f1.flightname.equalsIgnoreCase(cancelflight))
			{
				itr.remove();
				System.out.println(" Flight "+f1.flightname+" has been canceled ");
				return;
			}
		}
		
	}
	public static void loadDataFromFileToArrayList() throws IOException
	{
		File file = new File("C:\\Users\\Mr Patil\\Desktop\\space\\FlightBooking\\src\\FlightManagment\\Flight.csv");
		
		FileReader fr = new FileReader(file);
		
		BufferedReader br = new BufferedReader(fr);
		String line ="";
		
		while((br.readLine())!=null)
		{
		   Flight f1 = new Flight();
		   
		   String[] flightDataArray = line.split(",");
		   
		   if(flightDataArray.length>7)
		   {
			   f1.flightname = flightDataArray[0];
			   f1.flightnumber = flightDataArray[1];
			   f1.departurecity = flightDataArray[2];
			   f1.destinationcity = flightDataArray[3];
			   f1.date = flightDataArray[4];
			   f1.time = flightDataArray[5];
			   f1.airport = flightDataArray[6];
			   f1.ticketprice = flightDataArray[7];
			   
			   
			   al.add(f1);
		   }
		}
		br.close();
		fr.close();
		file = null;
	}
}

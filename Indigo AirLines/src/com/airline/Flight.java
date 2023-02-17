package com.airline;

import java.util.ArrayList;

import java.util.Scanner;

public class Flight {
	static Scanner sc = new Scanner(System.in);

// --------------------------------------------------------------

	public static void bookFlight() {
		try {
			String bday;
			System.out.println("----------------------------------------------");
			System.out.println("Booking your flight");
			System.out.println("----------------------------------------------");

			int i = 1;
			String from = "", to = "", from1 = "", to1 = "";

			// Airport cities in India
			String city[] = { "Thiruvanandhapuram", "Chennai", "Banglore", "Hydrabad", "Goa", "Mumbai", "Delhi",
					"Kolkota" };
			for (String s : city) {
				System.out.println(i++ + ")" + s);
			}
			// Displaying all the cities

			System.out.println("----------------------------------------------");
			System.out.println("Enter the from and to location...");
			for (i = 0; i < 2; i++) {
				System.out.print("Enter : ");
				int ch = sc.nextInt();
				String m = "";
				switch (ch) {
				case 1:
					m = "tvr";
					break;
				case 2:
					m = "maa";
					break;
				case 3:
					m = "blr";
					break;
				case 4:
					m = "hyd";
					break;
				case 5:
					m = "goa";
					break;
				case 6:
					m = "bom";
					break;
				case 7:
					m = "del";
					break;
				case 8:
					m = "kol";
					break;
				default:
					System.out.println("Enter the correct value : ");
				}

				if (i == 0) {
					from = m;
					from1 = city[ch - 1];
				} else {
					to = m;
					to1 = city[ch - 1];
				}

			}
			System.out.println("----------------------------------------------");
			String planeno = (from + to);
			System.out.println(planeno + " Flights From " + from1 + " to " + to1);

			System.out.println("----------------------------------------------");

			// Method isDay()
			String weekdays[] = { "Sunday   ", "Monday   ", "Tuesday  ", "Wednesday", "Thursday ", "Friday   ",
					"Saturday " };

			for (int ch = 1, k = 0; ch <= 7; ch++) {

				ArrayList<String> day;
				switch (ch) {
				case 1:
					day = sunday();
					break;
				case 2:
					day = monday();
					break;
				case 3:
					day = tuesday();
					break;
				case 4:
					day = wednesday();
					break;
				case 5:
					day = thursday();
					break;
				case 6:
					day = friday();
					break;
				case 7:
					day = saturday();
					break;
				default:
					day = null;
				}
				int flightCount = 0;
				System.out.print(ch + ") " + weekdays[k++] + " --> ");
				boolean flag = true;
				for (String o : day) {

					if (o.equals(planeno)) {
						flightCount++;
						flag = false;
					}
				}
				if (flag == true) {
					System.out.println("X No Flight");
				} else {
					System.out.println(flightCount + " Flight is Available ");
				}
			}
//----------------------------------------------------------------------------------

			System.out.print("Enter the day : ");
			int ch = sc.nextInt();
			ArrayList<String> day;
			switch (ch) {
			case 1:
				day = sunday();
				break;
			case 2:
				day = monday();
				break;
			case 3:
				day = tuesday();
				break;
			case 4:
				day = wednesday();
				break;
			case 5:
				day = thursday();
				break;
			case 6:
				day = friday();
				break;
			case 7:
				day = saturday();
				break;
			default:
				day = null;

			}
			boolean flag = true;
			for (String o : day) {
				if (o.equals(planeno)) {
					flag = false;
				}
			}
			if (flag == true) {

				System.out.println("Sorry! ");

			} else {
				bday = weekdays[ch - 1];
				System.out.print("\nEnter Your name : ");
				sc.nextLine();
				String bname = sc.nextLine();
				System.out.println(bname + " : Name");
				System.out.println(bday + " : day");
				System.out.println(from1 + " : from");
				System.out.println(to1 + " : to");
				System.out.println(planeno + " : Flight no ");

				System.out.print("BOOK NOW (Y/N) :");
				try {

					String yn = sc.nextLine();

					if (yn.toLowerCase().charAt(0) == 'y') {

						Bookings b = new Bookings(from1, to1, bday, bname, planeno);
						System.out.println(b.toString());
					}
				} catch (Exception e) {
					System.out.println("Invalid Input! Enter Name in words\n");
					sc.nextLine();
					bookFlight();
				}

			}
		} catch (Exception e) {
			System.out.println("---------Invalid Input---------\n");
			sc.nextLine();
			bookFlight();
		}

	}
	// --------------------------------------------------------------------------------------------

	public static void showFlightsByRoute() {
		try {
			System.out.println("\n----------------------------------------------");

			String planeno = route();
			isFight(planeno);
			System.out.println("\n----------------------------------------------");

		} catch (Exception e) {
			System.out.println("Invalid Input :( Enter Number");
			sc.next();
			showFlightsByRoute();
		}
	}

	// --------------------------------------------------------------

	public static void showDayFlights() {

		ArrayList<String> day = isDay();

		int i = 3;
		for (String s : day) {
			if (i % 4 == 0) {
				System.out.println();
			}
			System.out.print(s + "\t");
			i++;
		}

		System.out.println("\n----------------------------------------------");

	}
	// ----------------------------------------------------------------------------------------

	public static void showAllFlights() {
		System.out.println("----------------------------------------------");

		System.out.println("Schedule of the Flights from all the cities ");
		System.out.println("----------------------------------------------");

		for (int ch = 1; ch <= 7; ch++) {

			ArrayList<String> day;
			switch (ch) {
			case 1:
				day = sunday();
				break;
			case 2:
				day = monday();
				break;
			case 3:
				day = tuesday();
				break;
			case 4:
				day = wednesday();
				break;
			case 5:
				day = thursday();
				break;
			case 6:
				day = friday();
				break;
			case 7:
				day = saturday();
				break;
			default:
				day = null;

			}
			int i = 4;
			for (String s : day) {
				if (i % 5 == 0) {
					System.out.println();
				}
				System.out.print(s.toUpperCase() + "\t");
				i++;
			}

			System.out.println("\n----------------------------------------------");

		}
	}

//----------------------------------------------------------------------------------------------
//Method to get locations from the passenger 
	public static String route() {
		int i = 1;
		String from = "", to = "", from1 = "", to1 = "";

		// Airport cities in India
		String city[] = { "Thiruvanandhapuram", "Chennai", "Banglore", "Hydrabad", "Goa", "Mumbai", "Delhi",
				"Kolkota" };
		for (String s : city) {
			System.out.println(i++ + ")" + s);
		}
		// Displaying all the cities

		System.out.println("----------------------------------------------");
		System.out.println("Enter the from and to location...");
		for (i = 0; i < 2; i++) {
			System.out.print("Enter : ");
			int ch = sc.nextInt();
			String m = "";
			switch (ch) {
			case 1:
				m = "tvr";
				break;
			case 2:
				m = "maa";
				break;
			case 3:
				m = "blr";
				break;
			case 4:
				m = "hyd";
				break;
			case 5:
				m = "goa";
				break;
			case 6:
				m = "bom";
				break;
			case 7:
				m = "del";
				break;
			case 8:
				m = "kol";
				break;
			default:
				System.out.println("Enter the correct value : ");
			}

			if (i == 0) {
				from = m;
				from1 = city[ch - 1];
			} else {
				to = m;
				to1 = city[ch - 1];
			}

		}
		System.out.println("----------------------------------------------");
		String planeno = (from + to);
		System.out.println(planeno.toUpperCase() + " Flights From " + from1 + " to " + to1);

		System.out.println("----------------------------------------------");
		return planeno;
	}

//---------------------------------------------------------------------------------------------
	public static ArrayList<String> isDay() {

		System.out.println("----------------------------------------------");

		String weekdays[] = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
		for (int i = 0, k = 1; i < weekdays.length; i++) {
			System.out.println(k++ + ") " + weekdays[i]);
		}

		System.out.println("----------------------------------------------");
		System.out.print("Enter the day : ");
		int day = sc.nextInt();
		System.out.println("----------------------------------------------");

		switch (day) {
		case 1:
			return sunday();
		case 2:
			return monday();
		case 3:
			return tuesday();
		case 4:
			return wednesday();
		case 5:
			return thursday();
		case 6:
			return friday();
		case 7:
			return saturday();
		default:
			System.out.println("Wrong input ");

		}
		return null;

	}

//------------------------------------------------------------------------------------
	public static void isFight() {

		String planeno = route();
		boolean flag = true;
		// System.out.println("Your flight Name is " + planeno);

		ArrayList<String> date = isDay();

		for (String o : date) {
			if (o.equals(planeno)) {
				System.out.println("----------------------------------------------");

				System.out.println(o.toUpperCase() + " Flight is available");

				System.out.println("----------------------------------------------");
				flag = false;

			}
		}
		if (flag == true) {
			System.out.println("----------------------------------------------");

			System.out.println("Sorry,No Flights in this route this day...");
			System.out.println("----------------------------------------------");

		}
	}

	// ------------------------------------------------------------------------------------
	public static void isFight(String planeno) {

		String weekdays[] = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

		for (int ch = 1, k = 0; ch <= 7; ch++) {

			ArrayList<String> day;
			switch (ch) {
			case 1:
				day = sunday();
				break;
			case 2:
				day = monday();
				break;
			case 3:
				day = tuesday();
				break;
			case 4:
				day = wednesday();
				break;
			case 5:
				day = thursday();
				break;
			case 6:
				day = friday();
				break;
			case 7:
				day = saturday();
				break;
			default:
				day = null;

			}
			int flightCount = 0;
			System.out.print(weekdays[k++] + " --> ");
			boolean flag = true;
			for (String o : day) {

				if (o.equals(planeno)) {
					flightCount++;

					flag = false;

				}
			}
			if (flag == true) {

				System.out.println("No Flight");

			} else {
				System.out.println(flightCount + " Flight is Available ");
			}

		}
	}

	// ------------------------------------------------------------------------------------
	public static ArrayList<String> sunday() {

		ArrayList<String> day = new ArrayList<String>();
		day.add("Sunday");
		day.add("maahyd");
		day.add("maablr");
		day.add("maahyd");
		day.add("bomhyd");
		day.add("bomdel");
		day.add("bomblr");
		day.add("bomkol");
		day.add("bomgoa");
		day.add("koldel");
		day.add("kolmaa");
		day.add("kolbom");
		day.add("kolhyd");
		day.add("hydtvr");
		day.add("kolhyd");
		day.add("hydtvr");
		day.add("hydbom");
		day.add("hydblr");
		day.add("hydmaa");
		day.add("hyddel");
		return day;

	}

	// ------------------------------------------------------------------------------------
	public static ArrayList<String> monday() {

		ArrayList<String> day = new ArrayList<String>();
		day.add("Monday");
		day.add("maagoa");
		day.add("maablr");
		day.add("maatvr");
		day.add("bomkol");
		day.add("bomgoa");
		day.add("koldel");
		day.add("kolmaa");
		day.add("kolbom");
		day.add("kolhyd");
		day.add("hydblr");
		day.add("hydmaa");
		day.add("hyddel");
		return day;

	}

	// ------------------------------------------------------------------------------------
	public static ArrayList<String> tuesday() {

		ArrayList<String> day = new ArrayList<String>();
		day.add("Tuesday");
		day.add("bomhyd");
		day.add("bomdel");
		day.add("bomblr");
		day.add("bomkol");
		day.add("kolhyd");
		day.add("hydtvr");
		day.add("kolhyd");
		day.add("hydtvr");
		day.add("hydbom");
		day.add("hydblr");
		day.add("hydmaa");
		day.add("hyddel");
		return day;

	}

	// ------------------------------------------------------------------------------------
	public static ArrayList<String> wednesday() {

		ArrayList<String> day = new ArrayList<String>();
		day.add("WEDNESDAY");
		day.add("maahyd");
		day.add("maablr");
		day.add("maatvr");
		day.add("bomgoa");
		day.add("koldel");
		day.add("kolmaa");
		day.add("kolbom");
		day.add("kolhyd");
		day.add("hydtvr");
		day.add("hydblr");
		day.add("hydmaa");
		day.add("hyddel");
		return day;

	}

	// ------------------------------------------------------------------------------------
	public static ArrayList<String> thursday() {

		ArrayList<String> day = new ArrayList<String>();
		day.add("THURSDAY");
		day.add("maahyd");
		day.add("bomkol");
		day.add("bomgoa");
		day.add("koldel");
		day.add("kolmaa");
		day.add("kolbom");
		day.add("kolhyd");
		day.add("hydtvr");
		day.add("kolhyd");
		day.add("hydtvr");
		day.add("hydbom");
		day.add("hydblr");
		day.add("hydmaa");
		day.add("hyddel");
		return day;

	}

	// ------------------------------------------------------------------------------------
	public static ArrayList<String> friday() {

		ArrayList<String> day = new ArrayList<String>();
		day.add("FRIDAY");
		day.add("maahyd");
		day.add("maablr");
		day.add("maatvr");
		day.add("bomhyd");
		day.add("bomdel");
		day.add("bomblr");
		day.add("bomkol");
		day.add("bomgoa");
		day.add("koldel");
		day.add("kolmaa");
		day.add("kolbom");
		day.add("kolhyd");
		day.add("hydtvr");
		return day;

	}

	// ------------------------------------------------------------------------------------
	public static ArrayList<String> saturday() {

		ArrayList<String> day = new ArrayList<String>();
		day.add("SATURDAY");
		day.add("maahyd");
		day.add("maablr");
		day.add("maatvr");
		day.add("bomhyd");
		day.add("bomdel");
		day.add("kolhyd");
		day.add("hydtvr");
		day.add("kolhyd");
		day.add("hydtvr");
		day.add("hydbom");
		day.add("hydblr");
		day.add("hydmaa");
		day.add("hyddel");
		return day;

	}

}

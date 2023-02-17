package com.airline;

import java.util.Scanner;

public class AirLineReservation {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("----------------------------------------------");
		System.out.println("----------WELCOME TO INDIGO AIRLINES----------");
		System.out.println("----------------------------------------------");

		exe();

	}

	public static void exe() {
		try {

			while (true) {

				System.out.println("|               INDIGO AIRLINES              |");
				System.out.println("----------------------------------------------");

				System.out.println("1) FIND FLIGHT BY DAY \n" + "2) FIND FLIGHT BY ROUTE \n" + "3) SHOW ALL FLIGHTS\n"
						+ "4) BOOK A Flight\n" + "5) EXIT");

				System.out.print("Select : ");
				int select = sc.nextInt();

				switch (select) {
				case 1:
					Flight.showDayFlights();
					break;
				case 2:
					Flight.showFlightsByRoute();
					break;
				case 3:
					Flight.showAllFlights();
					break;
				case 4:
					Flight.bookFlight();
				case 5:
					System.out.println("Thank you visit again");
					System.exit(0);

				default:
					exe();

				}

			}
		} catch (Exception e) {
			System.out.println(e);
			sc.nextLine();
			System.out.println("Invalid Input... Plz Enter correct value");

		} finally {

			exe();
		}

	}

}

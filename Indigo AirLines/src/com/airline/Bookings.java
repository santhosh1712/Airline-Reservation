package com.airline;

public class Bookings {

	int id;
	String from;
	String to;
	String day;
	String pname;
	String planeno;
	
	
	
	public Bookings(String from, String to, String day, String pname, String planeno) {
		super();
		this.from = from;
		this.to = to;
		this.day = day;
		this.pname = pname;
		this.planeno = planeno;
		this.id= -1 * getPlaneno().hashCode();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPlaneno() {
		return planeno;
	}
	public void setPlaneno(String planeno) {
		this.planeno = planeno;
	}
	@Override
	public String toString() {
		return  
				  "\n\n\n\n\n\n\n_________________________________"			
				+ "\n BOARDING PASS - INDIGO AIRLINES "
				+ "\n*********************************" 
				+ "\nPassanger Name : " + pname
				+ "\nBooking Id     : " + id 
				+ "\nFrom           : " + from 
				+ "\nTo             : " + to 
				+ "\nDay            : " + day 
				+ "\n*********************************" 
				+ "\n FLIGHT        : " + planeno 
				+ "\n*********************************"							
				+ "\n      HAVE A NICE JOURNEY"
				+ "\n---------------------------------\n\n\n\n";			
		
	}
	
		
	}


package edu.project3;

import java.util.ArrayList;

public class Contact{
	
	public String contactName;
	public String contactNumber;
	public String contactEmail;
	public String contactNote;
	
	/**
	* initializes all the instance variables
	***/
	
	public Contact(){
		this.contactName= "n/a";
		this.contactNumber = "n/a";
		this.contactEmail = "n/a";
		this.contactNote = "n/a";
	}
	
	/**
	* overload constructor that creates a default contact
	* @param name - the name of the contact
	* @param number - the number of the contact
	* @param email - the email of the contact
	* @param note - any notes about the contact
	*/
	public Contact(String name, String number, String email, String note){
		this.contactName = name;
		this.contactNumber = number;
		this.contactEmail = email;
		this.contactNote = note;
	}
	public void setName(String name) {
		this.contactName = name;
	}
	public void setNumber(String number) {
		this.contactNumber = number;
	}
	public void setEmail(String email) {
		this.contactEmail = email;
	}
	public void setNote(String note) {
		this.contactNote = note;
	}
	public String toString() {
		if (this.contactNumber.length()==10) {
			String first = this.contactNumber.substring(0,3);
			String second = this.contactNumber.substring(3,6);
			String third = this.contactNumber.substring(6,10);
			String rnumber = "("+first+")"+second+"-"+third;
			
			return "Name: "+ this.contactName+ "\nNumber:" 
					+ rnumber + " \nEmail: "
					+ this.contactEmail + " \nNote: " 
					+ this.contactNote+"\n";
		}
		else  {
			String first = this.contactNumber.substring(0,3);
			String second = this.contactNumber.substring(3,7);
			String rnumber = first+"-"+second;
			
			return "Name: "+ this.contactName+ "\nNumber:" 
			+ rnumber + " \nEmail: "
			+ this.contactEmail + " \nNote: " 
			+ this.contactNote+"\n";
			
		}
		
	}
	
}




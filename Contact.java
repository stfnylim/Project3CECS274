package edu.project3;

import java.util.ArrayList;

public class Contact{
	
	private String contactName;
	private String contactNumber;
	private String contactEmail;
	private String contactNote;
	
	public Contact(){
		this.contactName= "n/a";
		this.contactNumber = "n/a";
		this.contactEmail = "n/a";
		this.contactNote = "n/a";
	}
	public Contact(String name, String number, String email, String note){
		this.contactName = name;
		
		String first = number.substring(0,3);
		String second = number.substring(3,6);
		String third = number.substring(6,10);
		String rnumber = "("+first+")"+second+"-"+third;
		
		this.contactNumber = rnumber;
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
		return "Name: "+ this.contactName+ "\nNumber:" 
				+ this.contactNumber + " \nEmail: "
				+ this.contactEmail + " \nNote: " 
				+ this.contactNote+"\n";
	}
	
		
	//----------------- TESTER ----------------------
	public static void main(String[] args) {
		Contact hello = new Contact("Jenny","5556665555","stfnylim@gmail.com", "hi");
		Contact hello2 = new Contact("Henny","5556665555","stfnylim@gmail.com", "hi");
		//System.out.println(hello);
		Phonebook.addContact(hello);
		Phonebook.addContact(hello2);
		Phonebook.getContacts();
		new Phonebook(hello,"name","whenny");
		Phonebook.getContacts();
		
	}
}




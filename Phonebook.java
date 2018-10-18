package edu.project3;

import java.util.ArrayList;

public class Phonebook{
	
	
	public static ArrayList<Contact> phonebook = new ArrayList<Contact>();
	
	
	public void Modify(Contact contact, String option, String change){
		if (option == "name") {
			
		}
		else (option == "number") {
			
		}
		else (option == "email") {
			
		}
		else (option == "note") {
			
		}
		
	
		
	}
	
	public static ArrayList<Contact> getContacts() {
		
		return phonebook;
	}
	
	public void deleteContact(Contact contact) {
		phonebook.remove(contact);
		// error message
	}
	public static void addContact(Contact contact) {
		phonebook.add(contact);
		//error message
	}
	
}

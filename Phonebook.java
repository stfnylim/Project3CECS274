package edu.project3;

import java.util.ArrayList;

public class Phonebook{
	
	
	public static ArrayList<Contact> phonebook = new ArrayList<Contact>();
	
	/**
	* Modifies the contact
	* @param contact - the contacts from the "Contact" class
	* @param option - The option the user has selected
	* @param change - the change the user wants to see
	*/
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
	/**
	* gets the phonebook for the cellphone
	* @return the phonebook
	*/
	public static ArrayList<Contact> getContacts() {
		
		return phonebook;
	}
	/**
	* Deletes the contact from the phonebook
	* @param contact - the contact in the phonebook
	*/
	public void deleteContact(Contact contact) {
		phonebook.remove(contact);
		// error message
	}
	/**
	* Adds a contact to the phonebook
	* @param contact - the contact to be added
	*/
	public static void addContact(Contact contact) {
		phonebook.add(contact);
		//error message
	}
	
}

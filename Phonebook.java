package edu.project3;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;  
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author stfnylim
 *
 */


public class Phonebook{
	
	
	public static ArrayList<Contact> phonebook = new ArrayList<Contact>();
	public static ArrayList<String> names = new ArrayList<String>();
	/*to modify phonebook
	 * 
	 */
	public Phonebook(Contact contact, String option, String change){
		
		if (option == "name") {
			contact.setName(change);
		}
		else if (option == "number") {
			contact.setNumber(change);
		}
		else if (option == "email") {
			contact.setEmail(change);
		}
		else if (option == "note") {
			contact.setNote(change);
		}
	}

	
	public static void getContacts() {
		System.out.println("Contacts:");
		// FIXME: SORT INTO ALPHA ORDER
		for (int i=0;i<phonebook.size();i++) {
			
			System.out.println(phonebook.get(i));
		}
	
	}
	
	public static void deleteContact(String name) {
		phonebook.remove(phonebook.get(names.indexOf(name)));
		names.remove(name);
		// error message
	}
	public static void addContact() {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter name to add:");
		String name = in.nextLine();
		
		System.out.println("Please enter number to add:");
		String number = in.nextLine();
		
		while (!(number.length()==10)&&!(number.length()==7)) {
			System.out.println("Sorry, invalid number.\n"
					+ "Please try again:");
			number = in.nextLine();
		}
		
		System.out.println("Please enter email to add:");
		String email = in.nextLine();
		
		System.out.println("Please enter note to add:");
		String note = in.nextLine();
		
		
		
		System.out.println(new Contact(name, number, email, note));
		phonebook.add(new Contact(name, number, email, note));
		names.add(name);
		//error message
	}
	//-------------- favorite contacts ------------------
	
	
	public static ArrayList<String> favoriteContacts = new ArrayList<String>();
	
	public static void addFavoriteContact(String contactName) {
		favoriteContacts.add(contactName);
	}
	
	public static void deleteFavoriteContact(String name) {
		favoriteContacts.remove(name);
	}
	
	
	/* originalNumber is supposed to be the number contact you want to change
	 * and newNumber is the number you're changing it to
	 */
	
	public static void changeFavorite(int originalNumber, int newNumber) {
		String contact = favoriteContacts.get(originalNumber-1);
		favoriteContacts.remove(contact);
		favoriteContacts.add(newNumber-1, contact);
	}
	
	
	/*
	 * to display all the favorites
	 */
	public static void displayFavorites() {
		System.out.println("Favorite Contacts: ");
		// making the option to display less than 5 contacts if less than 5 were inputed by user
		if(favoriteContacts.size()<5) {
			for (int i=0;i<favoriteContacts.size();i++) {
				
				System.out.println(i+1+". " + favoriteContacts.get(i));
			}
		}
		// if more were added, then displaying 5
		else {
			for (int i=0;i<5;i++) {
				
				System.out.println(i+1+". " + favoriteContacts.get(i));
				
			}
		}
	}
	 
	//-------------- phonelog ---------------------
	
	public static ArrayList<String> phonelog = new ArrayList<String>();
	

	
	public static void dialLog() {
		System.out.println("Would you like to dial a number, contact, or favorite?");
		Scanner in = new Scanner(System.in);
		String dialOption = in.nextLine();
		if (dialOption.equals("number")) {
			System.out.println("Please input number:");
			String number = in.nextLine();
			Phonebook.dialNumber(number);
			
		}
		else if (dialOption.equals("contact")) {
			System.out.println("Please input contact name:");
			String contact = in.nextLine();
			Phonebook.dialContact(contact);
		}
		else if (dialOption.equals("favorite")) {
			System.out.println("Please input favorite number:");
			int favNum = in.nextInt();
			Phonebook.dialFavorite(favNum);
		}
		else {
			System.out.println("Sorry, that isn't an option");
		}
	}
	
	public static void dialNumber(String number) {
		List<String> numbers = new ArrayList();
		for (int i=0; i<=(phonebook.size()-1);i++) {
			numbers.add(phonebook.get(i).contactNumber);
		}
		if (numbers.contains(number)) {
			System.out.println("Dialing..." + phonebook.get(numbers.indexOf(number)).contactName);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
			DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDateTime now = LocalDateTime.now();
			System.out.println("during: " + dtf.format(now));
			
			// if phonelog doesn't contain the call, then it adds into phone log
			if (!phonelog.contains(phonebook.get(numbers.indexOf(number)).contactName)) {
				phonelog.add(phonebook.get(numbers.indexOf(number)).contactName);
				}
			// or else, it stores it as the same call as another log
			else {
				
				phonelog.remove(phonebook.get(numbers.indexOf(number)).contactName);
				phonelog.add(phonebook.get(numbers.indexOf(number)).contactName + " (2)");
			}
			
		}
		else {
			System.out.println("Dialing... " + number);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
			DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDateTime now = LocalDateTime.now();
			System.out.println("during: " + dtf.format(now));

			if (!phonelog.contains(number)) {
				phonelog.add(number);
				}
			else {
				
				phonelog.remove(number);
				phonelog.add(number + " (2)");
			}
		}
		
	}


	public static void dialContact(String contact) {
		
		List<String> names = new ArrayList();
		for (int i=0; i<=(phonebook.size()-1);i++) {
			names.add(phonebook.get(i).contactName);
		}
		if (!names.contains(contact)) {
			System.out.println("Sorry this contact is not in the phonebook. Please try again.");
			Phonebook.dialLog();
		}
		else {
			System.out.println("Dialing... " + contact);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
			DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDateTime now = LocalDateTime.now();
			System.out.println("during: " + dtf.format(now));
			
			//to check if the phonelog already has the dialed number with the same time
			if (!phonelog.contains(contact)) {
			phonelog.add(contact);
			}
			else {
				
				phonelog.remove(contact );
				phonelog.add(contact + " (2)");
			}
		}
		
	}
	
	public static void dialFavorite(int number) {
		System.out.println("Dialing... " + favoriteContacts.get(number-1));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime now = LocalDateTime.now();
		System.out.println("during: " + dtf.format(now));
		
		String log = favoriteContacts.get(number-1);
		
		if (!phonelog.contains(log)) {
			phonelog.add(log);
			}
		else {
			
			phonelog.remove(log);
			phonelog.add(log+ " (2)");
		}
	}
	 
	
	public static void displayPhonelog() {
		System.out.println("Phonelog:");
		for (int i=0; i<phonelog.size();i++) {
			System.out.println(phonelog.get(i));
		}
	}
	
}


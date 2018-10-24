package edu.project3;

import java.util.Scanner;

public class Cellphone {
	
	public static void CellphoneMainMenu() {
		while(true) {
			Scanner in = new Scanner(System.in);
			System.out.println("\nMain Menu:\n"
					+ "1. Add contact\n"
					+ "2. Delete contact\n"
					+ "3. Display contacts\n"
					+ "4. Call\n"
					+ "5. Display phonelog\n"
					+ "6. Favorites menu\n"
					+ "7. Shutdown phone"
					+ "\n"
					+ "Please enter an option:");
			String response = in.nextLine();
			if(response.equals("1")) {
				Phonebook.addContact();
			}
			else if (response.equals("2")) {
				System.out.println("Which contact would you like to delete?");
				String name = in.nextLine();
				Phonebook.deleteContact(name);
				
				
				
			}
			else if(response.equals("3")) {
				Phonebook.getContacts();
			}
			else if(response.equals("4")) {
				Phonebook.dialLog();
			}
			else if(response.equals("5")) {
				Phonebook.displayPhonelog();
			}
			else if(response.equals("6")) {
				while(true) {
					System.out.println("Favorites Menu\n"
							+ "1. Add favorite contact\n"
							+ "2. Delete favorite contact\n"
							+ "3. Modify list\n"
							+ "4. Display favorites list\n"
							+ "5. Back to main menu\n"
							+ "\n"
							+ "Please enter an option:");
					String favresponse = in.nextLine();
					if (favresponse.equals("1")) {
						System.out.println("Who would you like to add to favorites?:");
						String favname = in.nextLine();
						Phonebook.addFavoriteContact(favname);
					}
					else if (favresponse.equals("2")) {
						System.out.println("Who would you like to delete from favorites?:");
						String favname = in.nextLine();
						Phonebook.deleteFavoriteContact(favname);
					}
					else if (favresponse.equals("3")) {
						Phonebook.displayFavorites();
						
						try {
							System.out.println("Who would you like to move?\n"
									+ " Please input the corresponding number:");
							String favNum = in.nextLine();
							int favNum3 = Integer.parseInt(favNum);
							System.out.println("To which number would you like to\n"
									+ "move it to?:");
							String favNum2 = in.nextLine();
							int favNum4 = Integer.parseInt(favNum2);
							
							Phonebook.changeFavorite(favNum3, favNum4);
						}
						catch (NumberFormatException e) {
							System.out.println("Sorry, you did not put in a number.");
						}
						catch (ArrayIndexOutOfBoundsException e) {
							System.out.println("Sorry, you did not put a valid number.");
						}
						
						
						
					}
					else if (favresponse.equals("4")) {
						Phonebook.displayFavorites();
					}
					else if (favresponse.equals("5")) {
						break;
					}
					else {
						System.out.println("Sorry that is not a valid option.\n"
								+ "Please try again.");
					}
				}
				
			}
			else if(response.equals("7")) {
				System.out.println("Phone is shutting down...");
				break;}
			else {
				System.out.println("Sorry that is not a valid option.\n"
						+ "Please try again.");
			}
		}
		
				
	}
}

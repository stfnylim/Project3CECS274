package edu.project3;

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
	public String toString() {
		return "Name: "+ this.contactName+ " Number:" + this.contactNumber + " Email: "+ this.contactEmail+ " Note: " + this.contactNote;
	}
	
	public class Phonebook{
		//public ArrayList 
		
		private String Modify(String contact, String option){
			//if 
			
		}
		
		private String getContacts() {
			//return arraylist
		}
		
		private String deleteContact(String contact) {
			
		}
		
		
		
	}
	//----------------- TESTER ----------------------
	public static void main(String[] args) {
		Contact hello = new Contact("Jenny","5556665555","stfnylim@gmail.com", "hi");
		System.out.println(hello);
	}
}




package jcd10;


import java.util.Scanner;

public class Test {
	/**
	 * The main program.
	 * 
	 * @param name
	 *            .file Input Text File
	 */

	public static void main(String[] args) {
		AddressBook b1=new AddressBook();
		Scanner sc=new Scanner(System.in);
		Boolean quit=false;
	 do{
		System.out.println("Address book");
		System.out.println("1.Add Contact");
		System.out.println("2.Remove Contact");
		System.out.println("3.Update Contact");
		System.out.println("4.Print Contact");
		System.out.println("5.Print Contact By Name");
		System.out.println("6.Print Contact By Zip Code");
		System.out.println("7.Save Addressbook to File");
		System.out.println("8.Load Addressbook from File");
		System.out.println("9.Quit");
		
		int no=sc.nextInt();
		switch(no){
		
		case 1:
			String fname;
			String lname;
			long phoneNo;
			String add;
			Integer zip;
			String email;
			
			System.out.println("Enter First name:");
			fname=sc.next();
			System.out.println("Enter Last name:");
			lname=sc.next();
			System.out.println("Enter Phone no:");
			phoneNo=sc.nextLong();
			System.out.println("Enter Address:");
			add=sc.next();
			System.out.println("Enter Zip Code:");
			zip=Integer.parseInt(sc.next());
			System.out.println("Enter Email Address:");
			email=sc.next();
			
			boolean addC=b1.add(fname, lname, phoneNo, add, zip, email);
			if(!addC){
				System.out.println("Contact already exists");
			}
			break;
			
		case 2:
			
			System.out.println("Enter first name:");
			fname=sc.next();
			System.out.println("Enter last name:");
			lname=sc.next();
			
			Name name=new Name(fname,lname);
			
			boolean removeC=b1.remove(name);
			if(!removeC){
				System.out.println("No Such Contact");
			}
			break;
			
		case 3:
			
			System.out.println("Enter first name:");
			fname=sc.next();
			System.out.println("Enter last name:");
			lname=sc.next();
			
			System.out.println("Enter Phone no:");
			phoneNo=sc.nextLong();
			System.out.println("Enter Address name:");
			add=sc.next();
			System.out.println("Enter Zip Code:");
			zip=sc.nextInt();
			System.out.println("Enter Email Address:");
			email=sc.next();
			
			 name=new Name(fname,lname);
			boolean updateC=b1.updateContact(name,phoneNo,add,zip,email);
			if(!updateC){
				System.out.println("No such contact");
			}
			break;
			
		case 4:
			System.out.println("Enter first name:");
			fname=sc.next();
			System.out.println("Enter last name:");
			lname=sc.next();
			
			name=new Name(fname,lname);
			
			b1.print(name);
			break;
			
		case 5:

			b1.printByName();
			break;
			
		case 6:
			
			b1.printByZip();
			break;
			
		case 7:
			String fileName;
			
			System.out.println("Enter name of file for addressbook");
		fileName=sc.next();
			
			b1.saveAddressbook(fileName);
			break;
			
			
		case 8:
			int clientNo;
			System.out.println("Enter client id");
			clientNo=sc.nextInt();
			b1=b1.loadAddressbook(clientNo);
			b1.printByName();
			break;

			
			
		case 9:
			quit=true;
			break;
			
		default:
			System.out.println("Wrong option chosen");
			break;	
		
		}
		
		
	 }while(!quit);
	}


}

package jcd10;




import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class AddressBook implements Serializable {
	/** Tree Map with key:name value:contact*/
	TreeMap<Name,Contact> t=new TreeMap<Name,Contact>();
	
	/**
	 * 
	 * 
	 * @param firstName
	 * @param lastName
	 * @param phoneNo
	 * @param address
	 * @param zipCode
	 * @param e_mail
	 * 
	 * @return     if the contact has been added or not
	 * 
	 *            Add a contact to the addressbook
	 * 
	 * 
	 **/
	
	public boolean add(String firstName,String lastName,long phoneNo,String address,Integer zipCode,String e_mail){
		
		Contact aContact=new Contact(phoneNo,address,zipCode,e_mail);
		Name name=new Name(firstName,lastName);
		
		 if(!t.containsKey(name)){
		t.put(name, aContact);
		return true;
		}
		else{
			return false;
		}
	
			
	}
	
	/**
	 * Removes the contact with the specified name
	 * 
	 * @param e
	 * 
	 * @return    if the contact has been removed or not
	 *            Removes the contact with the specified name
	 * 
	 * 
	 **/
	public boolean remove(Name e){
		
		
		if(t.containsKey(e)){
			t.remove(e);
			return true;
		}
			
		return false;
		
	}
	/**
	 * 
	 * 
	 * @param e
	 * @param phoneNo
	 * @param address
	 * @param zipCode
	 * @param e_mail
	 * 
	 * @return if the contact has been updated or not
	 * 
	 *            Updates a contact with the specified name
	 * 
	 * 
	 **/
	public boolean updateContact(Name e,long phoneNo,String address,Integer zipCode,String e_mail){
		Contact update=new Contact(phoneNo,address,zipCode,e_mail);
		
		if(t.containsKey(e)){
			t.put(e,update);
			return true;	
		}
		return false;
		
	}
	/**
	 * 
	 * 
	 * @param e
	 *            Prints a contact specified by name
	 * 
	 * 
	 **/
    public void print(Name e){
    	Map.Entry<Name, Contact> x=null;
    	if(t.containsKey(e)){
    		x=t.ceilingEntry(e);
    		
    		System.out.println(x.getKey() +" -> "+ x.getValue());
    	}
    	else{
    		System.out.println("No such contact");
    	}
    	
		
	}
    /**
	 * 
	 * 
	 * 
	 *            Prints all contact sorted by zip code
	 * 
	 * 
	 **/
    public void printByZip(){
    	ArrayList<CollectClass> a=new ArrayList<CollectClass>();
    	Set<Map.Entry<Name, Contact>> set=t.entrySet();
    	Iterator<Map.Entry<Name, Contact>> i=set.iterator();
    	
    	while(i.hasNext()){
    		Map.Entry<Name, Contact> temp=i.next();
    		a.add(new CollectClass(temp.getKey(),temp.getValue()));
    	}
    	
    	Collections.sort(a);
    	System.out.println(a);
    	
    }
    /**
	 * 
	 * 
	 * 
	 *            Prints all contact sorted by name
	 * 
	 * 
	 **/
	public void printByName(){
		System.out.println(t);
	}
	
	/**
	 * 
	 * 
	 * @param fileName
	 *            Saves a file with the inputed name
	 * 
	 * 
	 **/
	
	public void saveAddressbook( String fileName){
	try {
		Socket client=new Socket("127.0.0.1",9999);
		//FileOutputStream ostream=new FileOutputStream(fileName);
		ObjectOutputStream o=new ObjectOutputStream(client.getOutputStream());
		o.writeObject(new String("write"));
		
		o.writeObject(this);
		ObjectInputStream i=new ObjectInputStream(client.getInputStream());
		int x=i.readInt();
		System.out.println("Addressbook saved at "+x);
		//o.flush();
		o.close();
		i.close();
		client.close();
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	
	/**
	 * 
	 * 
	 * @param name
	 * 
	 * @return    The addressbook from the file
	 *            Saves a file with the inputed name
	 * 
	 * 
	 **/
	
	public AddressBook loadAddressbook(int no){
		//socket
		//outputstream
		//send write
		//change name to int
		//send int
		//recive object
		//return object
		
		
		try {
			//FileInputStream istream= new FileInputStream(name);
			Socket client=new Socket("127.0.0.1",9999);
			ObjectOutputStream o=new ObjectOutputStream(client.getOutputStream());
			o.writeObject(new String("read"));
			o.writeInt(no);
			
			ObjectInputStream i=new ObjectInputStream(client.getInputStream());
			AddressBook addBook=(AddressBook)i.readObject();
			 
			return addBook;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
}

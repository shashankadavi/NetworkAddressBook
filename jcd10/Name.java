package jcd10;


/**
 * Name.java
 * Creates the name entity for addressbook
 * 
 * 
 * @author Aayushi Khurana
 * @author Pranay Shashank Adavi
 * 
 * 
 */


import java.io.Serializable;
import java.util.Map;
import java.util.Map.Entry;

public class Name implements Comparable<Name>,Serializable{
	
	/** Name of a contact */
	String firstName;
	String lastName;
	
	/**
	 * 
	 * @param f
	 * @param l
	 * 
	 *            Constructor to initialize the name object
	 */
	
	public Name(String f,String l){
		this.firstName=f;
		this.lastName=l;
	}
	/**
	 * 
	 * 
	 * @param o
	 *          Compares if the values of object are equal to those of current object
	 * 
	 * 
	 **/
	@Override
	public boolean equals(Object o){
		Name x=(Name)o;
		return (this.firstName.equalsIgnoreCase(x.firstName) && this.lastName.equalsIgnoreCase(x.lastName));
	}
	/**
	 * 
	 * 
	 * @return  String representation of data members
	 *          Converts the data members into string format
	 * 
	 * 
	 **/
	
	@Override
	public String toString(){
		return "Name: "+firstName+" "+lastName+" ";
	}
	/**
	 * 
	 * 
	 * @param o
	 * @return    value of the comparison
	 *          Compares two elements and helps to sort them
	 * 
	 * 
	 **/

	@Override
	public int compareTo(Name o){
		if(this.lastName.equalsIgnoreCase(o.lastName)){
			return this.firstName.compareTo(o.firstName);
		}else{
			return this.lastName.compareTo(o.lastName);
		}
	}
	
	
	
	
}

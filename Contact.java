


/**
 * Contact.java
 * Creates the contact details for the addressbook
 * 
 * 
 * @author Aayushi Khurana
 * @author Pranay Shashank Adavi
 * 
 * 
 */

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

public class Contact implements Serializable{

	/** Contact details */
	long phoneNo;
	String address;
	Integer zipCode;
	String emailAdd;
	/**
	 * 
	 * @param phoneNo
	 * @param address;
	 * @param zipCode
	 * @param emailAdd 
	 * 
	 *            Constructor to initialize the contact details
	 */

	
	Contact(long phoneNo, String address, Integer zipCode, String emailAdd) {

		this.phoneNo = phoneNo;
		this.address = address;
		this.zipCode = zipCode;
		this.emailAdd = emailAdd;

	}
	/**
	 * 
	 * @return  String representation of data members
	 * 
	 *          Converts the data members into string format
	 * 
	 * 
	 **/

	public String toString() {
		// return a new add
		return "Phone No:" + phoneNo + " Address:" + address + "-" + zipCode
				+ " Email Address:" + emailAdd + "\n";

	}
}

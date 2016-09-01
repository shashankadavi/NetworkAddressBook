package jcd10;

/**
 * CollectClass.java
 * Creates a class that enables sorting by zip code
 * 
 * 
 * @author Aayushi Khurana
 * @author Pranay Shashank Adavi
 * 
 * 
 */


public class CollectClass implements Comparable<CollectClass>{
	
	/**Data members of type name and contact */
	Name n;
	Contact c;
	/**
	 * 
	 * @param id
	 * 
	 *            Constructor to initialize the root node
	 */
	
	public CollectClass(Name n,Contact c){
		this.n=n;
		this.c=c;
	}
	/**
	 * 
	 * 
	 * @param o
	 * 
	 * @return    value of the comparison
	 *            Compares two elements and helps to sort them
	 * 
	 * 
	 **/
	@Override
	public int compareTo(CollectClass o) {
		return this.c.zipCode.compareTo(o.c.zipCode);
	}
	/**
	 * 
	 * @return  String representation of data members
	 * 
	 *          Converts the data members into string format
	 * 
	 * 
	 **/

	public String toString(){
		return n+"="+c;
	}
	
}

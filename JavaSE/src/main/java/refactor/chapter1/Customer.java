package refactor.chapter1;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
	private String _name;
	private Vector<Rental> _rentals = new Vector<Rental>();

	public Customer() {
	}

	public Customer(String name, Vector<Rental> rentals) {
		super();
		this._name = name;
		this._rentals = rentals;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return _name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this._name = name;
	}

	/**
	 * @return the rentals
	 */
	public Vector<Rental> getRentals() {
		return _rentals;
	}

	/**
	 * @param rentals
	 *            the rentals to set
	 */
	public void setRentals(Vector<Rental> rentals) {
		this._rentals = rentals;
	}
	
	public String statement(){
		Enumeration<Rental> rentals = _rentals.elements();
		
		String result = "Rental Record for " + _name + "\n";
		while(rentals.hasMoreElements()){
			Rental each = rentals.nextElement();
			
			//展示
			result += "\t" + each.getMovie().getTitle() + "\t" + each.getCharge() + "\n";
		}
		
		result += "Amount owed is " + getTotalCharge() + "\n";
		result += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points";
		return result;
	}
	
	
	public String htmlStatement(){
		Enumeration<Rental> rentals = _rentals.elements();
		
		String result = "<H1>Rental Record for <EM>" + _name + "</EM></H1><P>\n";
		while(rentals.hasMoreElements()){
			Rental each = rentals.nextElement();
			
			//展示
			result += each.getMovie().getTitle() + ": " + each.getCharge() + "<BR>\n";
		}
		
		result += "Amount owed is " + getTotalCharge() + "\n";
		result += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points";
		return result;
	}
	
	private double getTotalCharge(){
		double result = 0;
		Enumeration<Rental> rentals = _rentals.elements();
		while(rentals.hasMoreElements()){
			Rental each = rentals.nextElement();
			result += each.getCharge();
		}
		return result;
	}
	
	private int getTotalFrequentRenterPoints(){
		int result = 0;
		Enumeration<Rental> rentals = _rentals.elements();
		while(rentals.hasMoreElements()){
			Rental each = rentals.nextElement();
			result += each.getFrequentRenterPoints();
		}
		return result;
	}

}

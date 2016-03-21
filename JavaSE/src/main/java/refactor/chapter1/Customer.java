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
		double totalAmount = 0d;
		int frequentRenterPoints = 0;
		Enumeration<Rental> rentals = _rentals.elements();
		
		String result = "Rental Record for " + _name + "\n";
		while(rentals.hasMoreElements()){
			Rental each = rentals.nextElement();
			
			//租金
			double thisAmount = 0d;
			switch(each.getMovie().getPriceCode()){
			case Movie.REGULAR:
				thisAmount += 2;
				if(each.getDaysRented() > 2){
					thisAmount += (each.getDaysRented() - 2) * 1.5;
				}
				break;
			case Movie.NEW_RELEASE:
				thisAmount += each.getDaysRented() * 3;
				break;
			case Movie.CHILDRENS:
				thisAmount += 1.5;
				if(each.getDaysRented() > 3){
					thisAmount += (each.getDaysRented() -3 ) * 1.5;
				}
				break;
			}
			totalAmount += thisAmount;
			
			
			//=gw 这个写法，也可以放到上面的switch中啊， 租金计算与积分计算在一起？？？
			//积分
			frequentRenterPoints ++;
			if(each.getMovie().getPriceCode() == Movie.NEW_RELEASE && each.getDaysRented() > 1){
				frequentRenterPoints ++;
			}
			
			
			//展示
			result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
		}
		
		result += "Amount owed is " + totalAmount + "\n";
		result += "You earned " + frequentRenterPoints + " frequent renter points";
		return result;
	}

}

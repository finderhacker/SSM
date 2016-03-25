package refactor.chapter1;

//影片   
public class Movie {

	//影片类型， 一个影片在生命周期中可以调整类型
	public final static int CHILDRENS = 2;
	public final static int REGULAR = 0;
	public final static int NEW_RELEASE = 1;

	private String _title;
	private int _priceCode;

	public Movie() {
		super();
	}

	public Movie(String title, int priceCode) {
		super();
		this._title = title;
		this._priceCode = priceCode;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return _title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this._title = title;
	}

	/**
	 * @return the priceCode
	 */
	public int getPriceCode() {
		return _priceCode;
	}

	/**
	 * @param priceCode
	 *            the priceCode to set
	 */
	public void setPriceCode(int priceCode) {
		this._priceCode = priceCode;
	}
	
	double getCharge(int daysRented) {
		double result = 0d;
		switch(getPriceCode()){
		case Movie.REGULAR:
			result += 2;
			if(daysRented > 2){
				result += (daysRented - 2) * 1.5;
			}
			break;
		case Movie.NEW_RELEASE:
			result += daysRented * 3;
			break;
		case Movie.CHILDRENS:
			result += 1.5;
			if(daysRented > 3){
				result += (daysRented -3 ) * 1.5;
			}
			break;
		}
		return result;
	}
	
	int getFrequentRenterPoints(int daysRented) {
		if(getPriceCode() == Movie.NEW_RELEASE && daysRented > 1){
			return 2;
		}
		else{
			return 1;
		}
	}

}

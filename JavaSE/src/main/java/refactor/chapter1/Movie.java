package refactor.chapter1;

//影片   
public class Movie {

	//影片类型， 一个影片在生命周期中可以调整类型
	public final static int CHILDRENS = 2;
	public final static int REGULAR = 0;
	public final static int NEW_RELEASE = 1;

	private String _title;
	private Price _price;

	public Movie() {
		super();
	}

	public Movie(String title, int priceCode) {
		super();
		this._title = title;
		setPriceCode(priceCode);
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
		return _price.getPriceCode();
	}

	/**
	 * @param priceCode
	 *            the priceCode to set
	 */
	public void setPriceCode(int priceCode) {
		switch (priceCode) {
		case REGULAR:
			_price = new RegularPrice();
			break;
		case CHILDRENS:
			_price = new ChildrensPrice();
			break;
		case NEW_RELEASE:
			_price = new NewReleasePrice();
			break;
		default:
			throw new IllegalArgumentException("Incorrect Price Code");
		}
	}
	
	double getCharge(int daysRented) {
		return _price.getCharge(daysRented);
	}
	
	int getFrequentRenterPoints(int daysRented) {
		return _price.getFrequentRenterPoints(daysRented);
	}

}

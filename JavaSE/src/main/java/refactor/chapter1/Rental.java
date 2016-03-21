package refactor.chapter1;

//租期
public class Rental {

	private Movie _movie;
	private int _daysRented;

	public Rental() {
		super();
	}

	public Rental(Movie movie, int daysRented) {
		super();
		this._movie = movie;
		this._daysRented = daysRented;
	}

	/**
	 * @return the movie
	 */
	public Movie getMovie() {
		return _movie;
	}

	/**
	 * @param movie
	 *            the movie to set
	 */
	public void setMovie(Movie movie) {
		this._movie = movie;
	}

	/**
	 * @return the daysRented
	 */
	public int getDaysRented() {
		return _daysRented;
	}

	/**
	 * @param daysRented
	 *            the daysRented to set
	 */
	public void setDaysRented(int daysRented) {
		this._daysRented = daysRented;
	}

}

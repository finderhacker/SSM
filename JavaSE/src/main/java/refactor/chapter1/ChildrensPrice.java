package refactor.chapter1;

public class ChildrensPrice extends Price {

	@Override
	int getPriceCode() {
		return Movie.CHILDRENS;
	}

	double getCharge(int daysRented) {
		double result = 1.5d;
		if (daysRented > 3) {
			result += (daysRented - 3) * 1.5;
		}
		return result;
	}
}

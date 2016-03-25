package refactor.chapter1;

import java.util.Vector;

import org.junit.Test;

public class RefactorTest {

	@Test
	public void test(){
		Movie childMovie = new Movie("child", Movie.CHILDRENS);
		
		Movie newMovie = new Movie("new", Movie.NEW_RELEASE);
		
		Movie regMovie = new Movie("reg", Movie.REGULAR);
		
		Rental r1 = new Rental(childMovie, 2);
		Rental r2 = new Rental(childMovie, 3);
		Rental r3 = new Rental(childMovie, 4);

		Rental r4 = new Rental(newMovie, 1);
		Rental r5 = new Rental(newMovie, 2);
		Rental r6 = new Rental(newMovie, 3);
		
		
		Rental r7 = new Rental(regMovie, 3);
		Rental r8 = new Rental(regMovie, 4);
		Rental r9 = new Rental(regMovie, 5);
		
		Vector<Rental> gwV = new Vector<Rental>();
		Vector<Rental> ttV = new Vector<Rental>();
		gwV.add(r1); gwV.add(r2); gwV.add(r3);
		gwV.add(r4); gwV.add(r5); gwV.add(r6);
		gwV.add(r7); gwV.add(r8); gwV.add(r9);
		Customer gw = new Customer("gw", gwV);
		Customer tt = new Customer("tt", ttV);
		
		System.out.printf("%s", gw.statement());
	}

/*
Rental Record for gw
	child	1.5
	child	1.5
	child	3.0
	new	3.0
	new	6.0
	new	9.0
	reg	3.5
	reg	5.0
	reg	6.5
Amount owed is 39.0
You earned 11 frequent renter points
*/

}

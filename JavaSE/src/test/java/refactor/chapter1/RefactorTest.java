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
		Customer gw = new Customer("gw", gwV);
		Customer tt = new Customer("tt", ttV);		
	}
	
}

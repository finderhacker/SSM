package Thinking19;

import java.io.NotActiveException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

enum Spiciness {
	NOT, MILD, MEDIUM, HOT, FLAMING ;
}

class SimpleEnumUse {
	public static void main(String[] args) {
		/*Spiciness medium = Spiciness.MEDIUM;
		System.out.println(medium + "  " + medium.getClass() + "  " + medium.getDeclaringClass());
		
		for(Spiciness s: Spiciness.values()){
			System.out.println("order: " + s.ordinal() + "  " + s);
		}
		
		System.out.println(Spiciness.FLAMING == Spiciness.FLAMING);*/
		
		//用反射也不能构造出enum对象
		Class<Spiciness> clazz = Spiciness.class ;
		Constructor con = clazz.getDeclaredConstructors()[0];
		con.setAccessible(true);
		try {
			System.out.println(con);
			Object newInstance = con.newInstance("ABC", 10);
			System.out.println(newInstance);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}


class Burrito{
	Spiciness degree ;
	Burrito(Spiciness degree){
		this.degree = degree ;
	}
	
	void desc(){
		switch (degree) {  //与switch的结合
		case NOT :  //case部分很简单明了
			System.out.println("not spicy at all");
			break;
		case MILD :
		case MEDIUM :
			System.out.println("a little hot");
			break ;
		case HOT:
		case FLAMING :
		default:
			System.out.println("maybe too hot");
			break;
		}
	}
	
	public static void main(String[] args) {
		Burrito
			plain = new Burrito(Spiciness.NOT) ,
			greenChile = new Burrito(Spiciness.MEDIUM) ;
		
		plain.desc();
		greenChile.desc();
			
	}
}
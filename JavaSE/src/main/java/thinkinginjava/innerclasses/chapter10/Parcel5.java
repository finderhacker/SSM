package thinkinginjava.innerclasses.chapter10;

public class Parcel5 {
	private String str = "global";

	public Destination destination(String s){
		final String str1 = "Local" ;  //常量
		final String str2 = "Local" + Math.random();  //会变成内部类的一个成员变量
		
		class PDestination implements Destination{
			private String label;
			
			private PDestination(String whereTo){
				label = whereTo;
			}
			
			@Override
			public String readLabel() {
				System.out.println(str1 + "  " + str2 + "  " + Parcel5.this.str);
				return label;
			}
			
		}
		return new PDestination(s);
	}
	
	public static void main(String[] args) {
		Parcel5 parcel5 = new Parcel5();
		Destination destination = parcel5.destination("Home");
		System.out.println(destination.readLabel());
		System.out.println(destination.readLabel());
	}
}

package thinkinginjava.innerclasses.chapter10;

public class Parcel1 {
	class Contents {
		private int i = 11;

		public int value() {
			return i;
		}
	}

	class Destination {
		private String label;
		
		public Destination() {
			this("123");
			this.label = "123";
		}

		public Destination(String label) {
			super();
			this.label = label;
		}

		String readLabel() {
			return label;
		}
	}

	public void ship(String dest) {
		Contents c = new Contents();  //astore_2
		Destination d = new Destination(dest);  //astore_3
		System.out.println(c.value());
		System.out.println(d.readLabel());
	}

	public static void main(String[] args) {
		Parcel1 parcel1 = new Parcel1();
		parcel1.ship("KaiFeng");

		Contents c = parcel1.new Contents();
	}
}

class Test extends Parcel1{
	public static void main(String[] args) {
		Parcel1 parcel1 = new Parcel1();  //astore_1
		parcel1.ship("KaiFeng");

		Parcel1.Contents c = parcel1.new Contents();  //astore_2
		
		Test test = new Test();  //astore_3
		Contents c2 = test.new Contents();
	}
}

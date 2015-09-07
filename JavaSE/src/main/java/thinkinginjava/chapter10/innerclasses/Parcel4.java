package thinkinginjava.chapter10.innerclasses;

public class Parcel4 {
	private class Pcontents implements Contents{
		private int i = 11 ;
		
		@Override
		public int value() {
			Pdestination p =new Pdestination("ffd");

			Pdestination pdestination = new Pdestination("Home");
			Pdestination.PPP pppp = pdestination.new PPP();
			
			
			return i;
			
		}
		
	}
	
	private class Pdestination implements Destination{
		private String label;
		
		private Pdestination(String whereTo){
			label = whereTo;
		}
		
		@Override
		public String readLabel() {
			return label;
		}
		
		private class PPP{
			private PPP(){
				System.out.println("Oh my Gad");
			}
		}
	}
	
	public Contents contents(){
		return new Pcontents();
	}
	
	public Pdestination destination(){
		Pdestination pdestination = new Pdestination("Home");
		Pdestination.PPP p = pdestination.new PPP();
		
		return new Pdestination("Home" + p);
	}
}


class Parcel4Test{
	public static void main(String[] args) {
		Parcel4 parcel = new Parcel4();
		System.out.println(parcel.contents().value());
		System.out.println(((Destination)parcel.destination()).readLabel());
	}
}

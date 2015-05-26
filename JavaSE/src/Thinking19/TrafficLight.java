package Thinking19;

enum Signal{GREEN, YELLOW, RED}

public class TrafficLight {
	Signal color = Signal.RED ;
	
	private void chage(){
		switch(color){
		case RED:
			color = Signal.YELLOW ;
			break ;
		case YELLOW:
			color = Signal.GREEN ;
			break ;
		case GREEN:
			color = Signal.RED ;
			break ;
		}
	}
	
	@Override
	public String toString() {
		return "the light is " + color ;
	};
	
	public static void main(String[] args) {
		TrafficLight tl = new TrafficLight() ;
		for(int i=0; i<7; i++){
			System.out.println(tl);
			tl.chage();
		}
	}
}

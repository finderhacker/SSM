package Thinking19;

import java.util.Arrays;

public enum OzWitch {
	WEST(0, "Miss Gulch, aka the Wicked Witch of the West") ,
	NORTH(1, "Glinda, the Good Witch of the North") ,
	EAST(2, "Wicked Witch of the East, wearer of the Ruby Slippers, crushed by Dorothy's house") ,
	SOUTH(3, "Good by inference , but missing") ;
	
	private String desc ;
	
	OzWitch(Integer index, String desc){
		this.desc = desc ;
	}
	
	public String getDesc(){
		return this.desc ;
	}
	
	@Override
	public String toString() {
		return "gw" ;
	};
	
	
	public static void main(String[] args) {
		for(OzWitch oz: OzWitch.values()){
			System.out.println(oz.getDesc() + "  " + oz.name() + " -- " + oz);
			
			System.out.println(Arrays.toString(oz.getClass().getDeclaredConstructors()));
		}
		
//		OzWitch ozWitch = new OzWitch("aa" ,10, 10, "sdf");
	}

}

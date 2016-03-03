package init;

public class Super {
	static String name = "super";
	
	private int age = 10;
	
	private void bye(){
		System.out.printf("%s", "super bye");
	}

	public String say() {
		return "Super [age=" + age + "]";
	}
	
	public static void main(String[] args) {
		Super s = new Base();
		System.out.printf("%s", s.age);
		System.out.printf("%s", s.say());
		s.bye();
		
	}
}

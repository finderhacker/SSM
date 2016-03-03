package ziji.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class SerialTest {
	private String file = "serial.ser";

	public static void main(String[] args) {
		new SerialTest().serializeToDisk();
	}
	
	
	public void serializeToDisk() {

		try {
			Person me = new Person("Guo", "Wei", 28, Gender.MALE);
			Person her = new Person("Wang", "Ting", 28, Gender.FEMALE);
			me.setSpouse(her);
			her.setSpouse(me);

			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(me);
			oos.writeObject(her);
			oos.close();
			
			System.out.println(me);
			System.out.println(her);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Person me = (Person)ois.readObject();
			Person her = (Person)ois.readObject();
			ois.close();
			
			System.out.println(me);
			System.out.println(her);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

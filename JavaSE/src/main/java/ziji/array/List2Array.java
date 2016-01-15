package ziji.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class List2Array {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		
		Object[] array = list.toArray();
		for(Object obj: array){
			String str = (String)obj;
			System.out.printf("%s%n", str);
		}
	}

}

package corejava.chapt12.generic;

public class PairTest2 {
	public static void main(String[] args) {
		String[] words = {"Mary", "Had", "a", "little", "lamb"};
		Pair<String> minmax = ArrayAlg2.minmax(words);

		String min = minmax.getFirst();
		String max = minmax.getSecond();
		
		System.out.printf("min=%s, max=%s%n", min, max);
		
		
		min = ArrayAlg2.min(words);
		System.out.printf("min = %s%n", min);
	}
}

class ArrayAlg2 {
	public static <T extends Comparable<T>> Pair<T> minmax(T[] a){
		if(a == null || a.length == 0){
			return null ;
		}
		
		T min = a[0];
		T max = a[0];
		
		for(int i=1; i<a.length; i++){
			if(a[i].compareTo(max)>0){
				max = a[i];
			}
			
			if(a[i].compareTo(min)<0){
				min = a[i];
			}
		}
		
		return new Pair<T>(min, max);
	}
	
	public static Pair<String> minmax(String[] a){
		if(a == null || a.length == 0){
			return null ;
		}
		
		String min = a[0];
		String max = a[0];
		
		for(int i=1; i<a.length; i++){
			if(a[i].compareTo(max)>0){
				max = a[i];
			}
			
			if(a[i].compareTo(min)<0){
				min = a[i];
			}
		}
		
		return new Pair<String>(min, max);
	}
	
	public static <T extends Comparable<T>> T min(T[] a){
		if(a == null || a.length == 0){
			return null;
		}
		
		T small = a[0];
		for(int i=1; i<a.length ; i++){
			if(small.compareTo(a[i])>0){
				small = a[i];
			}
		}
		return small;
	}
}
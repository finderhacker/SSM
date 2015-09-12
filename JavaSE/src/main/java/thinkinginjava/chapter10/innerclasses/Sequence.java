package thinkinginjava.chapter10.innerclasses;

public class Sequence {
	private Object[] items;
	private int next = 0;
	
	public Sequence(int size) {
		items = new Object[size];
	}
	
	public void add(Object x){
		if(next< items.length){
			items[next++] = x;
		}
	}
	
	private class SequenceSelector implements Selector{
		private int index = 0;
		
		@Override
		public boolean end() {
			return index == items.length;
		}

		@Override
		public Object current() {
			return items[index];
		}

		@Override
		public void next() {
			if(index< items.length){
				index ++ ;
			}
		}
		
	}
	
	public Selector selector(){
		return new SequenceSelector();
	}
	
	
	public static void main(String[] args) {
		Sequence sequence = new Sequence(10);
		for(int i=0; i<10 ; i++){
			sequence.add(i);
		}
		
		Selector selector = sequence.selector();
		while(!(selector.end())){
			System.out.print(selector.current()+ "  ");
			selector.next();
		}
		System.out.println();
		
		
		Sequence sequence1 = new Sequence(10);
		for(int i=0; i<10 ; i++){
			sequence1.add(new StringHolder(i+""));
		}
		
		Selector selector1 = sequence1.selector();
		while(!(selector1.end())){
			System.out.println(selector1.current()+ "  ");
			selector1.next();
		}
	}
	
}

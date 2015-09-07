package thinkinginjava.chapter19.enumeration;

enum Spiciness {
	//必须放在最开始。
	NOT(1) {
		@Override
		void a() {
			// TODO Auto-generated method stub
			
		}
	}, MILD(2) {
		@Override
		void a() {
			// TODO Auto-generated method stub
			
		}
	}, MEDIUM(3) {
		@Override
		void a() {
			// TODO Auto-generated method stub
			
		}
	}, HOT(4) {
		@Override
		void a() {
			// TODO Auto-generated method stub
			
		}
	}, FLAMING(4) {
		@Override
		void a() {
			// TODO Auto-generated method stub
			
		}
	};

	static {
		assert (FLAMING.ordinal() == 10);
		System.out.println("gw");
	}

	private final int i;
	
	Spiciness(int i) {
		this.i = i;
	}

	abstract void a();
	
	
}

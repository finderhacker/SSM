package corejava.chapt12.generic;

import java.io.Serializable;

public class Interval<T extends Comparable<T> & Serializable> {
	private T lower;
	private T upper;

	public Interval(T lower, T upper) {
		if (lower.compareTo(upper) > 0) {
			this.lower = upper;
			this.upper = lower;
		} else {
			this.lower = lower;
			this.upper = upper;
		}
	}

	public T getLower() {
		return lower;
	}

	public void setLower(T lower) {
		this.lower = lower;
	}

	public T getUpper() {
		return upper;
	}

	public void setUpper(T upper) {
		this.upper = upper;
	}

}

package corejava.chapt12.generic;

import java.util.Date;

public class DateInterval extends Pair<Date> {

	@Override
	public Date getSecond() {
		return super.getSecond();
	}

	@Override
	public void setSecond(Date second){
		if(second.compareTo(getFirst())>=0){
			setSecond(second);
		}
	}

	//协变返回类型也有 桥方法
	@Override
	protected DateInterval clone() throws CloneNotSupportedException {
		return (DateInterval) super.clone();
	}
	
	
}

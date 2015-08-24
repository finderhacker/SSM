package ziji.callback.demo1;

import java.text.SimpleDateFormat;
import java.util.Date;

//相当于class A  
public class At911 implements BoomWTC {// 相当于【背景1】
	private boolean decide;
	private TerroristAttack ta;// 相当于【背景2】

	public At911() {
		Date now = new Date();
		SimpleDateFormat myFmt1 = new SimpleDateFormat("yy/MM/dd HH:mm");
		this.decide = (myFmt1.format(now)).equals("01/09/11 09:44");
		this.ta = new TerroristAttack();
	}

	// 获得拉登的决定
	public boolean benLaDengDecide() {
		return decide;
	}

	// 执行轰炸世贸
	public void boom() {
		ta.attack(this);// class A调用class B的方法传入自己的对象，相当于【you call me】
	}
	
	
	public static void main(String[] args) {
		At911 at$911 = new At911();
		at$911.boom();
	}
}
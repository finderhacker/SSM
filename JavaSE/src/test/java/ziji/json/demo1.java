package ziji.json;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

public class demo1 {

	@Test
	public void test(){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("a", new Date());
		jsonObject.put("b", Calendar.getInstance());
		
		System.out.println(jsonObject.toString());
		
		
		
	}
}

package ziji.a;

import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.math.BigInteger;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;






import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import com.jd.fastjson.JSON;
import com.jd.fastjson.JSONObject;

import ziji.springtest;

public class TestA {
	private static final Logger logger = Logger.getLogger(TestA.class);

	@Test
	@Ignore
	public void aa() {
		String str1 = "str1";
		String str2 = "str2";
		Class<? extends String> class1 = str1.getClass();  //Class<String>
		Class<? extends String> class2 = str2.getClass();  //Class<String>
		Class<? extends Class> class11 = class1.getClass();  //Class<Class>
		Class<? extends Class> class21 = class2.getClass();  //Class<Class>
		
		System.out.println(class1 + "  " + class2 + "  " + (class1 == class2));
		System.out.println(class11 + "  " + class21 + "  " + (class11 == class21));
		
		Float f = 12f;
		Class<? extends Float> class3 = f.getClass();  //Class<Float>
		Class<? extends Class> class31 = class3.getClass();  //Class<Class>
		
		System.out.println(class3);
		System.out.println(class11 + "  " + class31 + "  " + (class11 == class31));
		
		Class<?> class4 = int.class;
		Class<? extends Class> class41 = class4.getClass();  //Class<Class>
		System.out.println(class4);
		System.out.println(class21 + "  " + class41 + "  " + (class21 == class41));
		
		Class<Serializable> class5 = Serializable.class;  //Class<Serializable>
		Class<? extends Class> class51 = class5.getClass();  //Class<Class>
		System.out.println(class5);
		System.out.println(class31 + "  " + class51 + "  " + (class31 == class51));
		
		
		
		//即使用反射也不能new出class实例。
		Class c = Class.class;
		try {
			Constructor con = c.getDeclaredConstructor(null);
			con.setAccessible(true);
			Object newInstance = con.newInstance(null);
			System.out.println(newInstance);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Test @Ignore
	public void bb(){
		BigDecimal b1 = new BigDecimal("2.0");
		BigDecimal b2 = new BigDecimal("2.00");
		
		System.out.println("hashcode : b1 = " + b1.hashCode()  + " , b2 = " + b2.hashCode());
		System.out.println("equals : " + b1.equals(b2));
		System.out.println("compareTo : " + b1.compareTo(b2));
		
		Map<BigDecimal, Integer> map = new HashMap<BigDecimal, Integer>();
		map.put(b1, 1);
		map.put(b2, 1);
		System.out.println("HashMap " + map);
		
		Map<BigDecimal, Integer> map1 = new TreeMap<BigDecimal, Integer>();
		map1.put(b1, 1);
		map1.put(b2, 1);
		System.out.println("TreeMap " + map1);
		
		Set<BigDecimal> set = new HashSet<BigDecimal>();
		set.add(b1);
		set.add(b2);
		System.out.println("HashSet " + set);
		
		Set<BigDecimal> set1 = new TreeSet<BigDecimal>();
		set1.add(b1);
		set1.add(b2);
		System.out.println("TreeSet " + set1);
		
		String s1 = b1.toString();
		String s2 = b2.toString();
		System.out.println(s1 + "  " + s2  + "  " + s1.equals(s2));
	}
	
	@Test
	public void cc(){
		
		StringBuilder jsonData = new StringBuilder();
        jsonData.append("{");
        jsonData.append("\"accountDays\":\"").append(0).append("\",");
        jsonData.append("\"accountTime\":\"").append(8).append("\",");
        jsonData.append("\"amount\":\"").append(6).append("\",");
        jsonData.append("\"bussinessTime\":\"").append(7).append("\",");
        jsonData.append("\"cooperationId\":\"").append(5).append("\",");
        jsonData.append("\"currency\":\"").append(137).append("\",");
        jsonData.append("\"direction\":\"").append(-1).append("\",");
        jsonData.append("\"feeTypeId\":\"").append(22).append("\",");
        jsonData.append("\"operatorPin\":\"").append(9).append("\",");
        jsonData.append("\"rfBusinessId\":\"").append(2).append("\",");
        jsonData.append("\"rfSystemId\":\"").append(129).append("\",");
        jsonData.append("\"supplierId\":\"").append(3).append("\",");
        jsonData.append("\"supplierName\":\"").append(4).append("\",");
        jsonData.append("\"uuid\":\"").append(1).append("\"");
        jsonData.append("}");
		
        
        JSONObject obj = new JSONObject();
        obj.put("uuid", "1");
        obj.put("rfSystemId", "129");
        obj.put("rfBusinessId", "2");
        obj.put("supplierId", "3");
        obj.put("supplierName", "4");
        obj.put("cooperationId", "5");
        obj.put("feeTypeId", "22");
        obj.put("amount", "6");
        obj.put("currency", "137");
        obj.put("direction", "-1");
        obj.put("bussinessTime", "7");
        obj.put("accountTime", "8");
        obj.put("accountDays", "0");
        obj.put("operatorPin", "9");

        System.out.println(jsonData);
        System.out.println(obj);
        
        
        System.out.println(JSON.parseObject("df:123"));
        
	}
}

package ziji.a;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.math.BigInteger;
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

import net.sf.json.JSONSerializer;

import org.apache.log4j.Logger;

import static org.junit.Assert.*;

import org.junit.Test;

import ziji.springtest;

public class TestA {
	private static final Logger logger = Logger.getLogger(TestA.class);

	@Test
	public void aa() {	}
	
	
	@Test
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
}

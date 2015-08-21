package ziji.a;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.math.BigInteger;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import net.sf.json.JSONSerializer;

import org.apache.log4j.Logger;

import static org.junit.Assert.*;

import org.junit.Test;

import ziji.springtest;

public class TestA {
	private static final Logger logger = Logger.getLogger(TestA.class);

	@Test
	public void aa() {
		String str=  "a,b,c,d,e,f";

		BigInteger b1 = new BigInteger("3");
		BigInteger b2 = new BigInteger("2");

		
		String[] a = new String[]{str};
		System.out.println(a.length);
		System.out.println(b1.divide(b2));
		


		BigInteger bigInteger = new BigInteger(1, new byte[]{50,60,70,80,90});
		System.out.println(bigInteger + "  " + bigInteger.bitCount() + "  "+ bigInteger.bitLength());
		
		
		System.out.println((-1 ==-1));
	}
}

package ziji.a;

import java.io.InputStream;
import java.math.BigDecimal;
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
		
		String[] a = new String[]{str};
		System.out.println(a.length);
		
	}
}
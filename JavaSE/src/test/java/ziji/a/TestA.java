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
import java.util.Collections;
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
	public void dd(){
		StringBuilder sb = new StringBuilder();
		sb.append("\"message\":\""+ a() + "\"");
		sb.append("\n\n");
		sb.append("\"message\":"+ a() + "");
		sb.append("\n\n");
		
		System.out.printf(sb.toString());
		
	}


	private String a() {
		return null;
	}

}

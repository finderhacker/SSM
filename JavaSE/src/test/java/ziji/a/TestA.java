package ziji.a;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;

import org.apache.log4j.Logger;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestA {
	private static final Logger logger = Logger.getLogger(TestA.class);

	@Test
	public void aa() {

		BigDecimal resulet = new BigDecimal("000100").divide(new BigDecimal("8"), 2 , RoundingMode.HALF_UP);
		System.out.println(resulet + " un = " + resulet.unscaledValue() + "  sc = " + resulet.scale() + " 精度=" + resulet.precision());
		
		
		MathContext mathContext = new MathContext(2, RoundingMode.HALF_UP);
		BigDecimal resulet1 = new BigDecimal("01").divide(new BigDecimal("8"), mathContext);
		System.out.println(resulet1 + " un = " + resulet1.unscaledValue() + "  sc = " + resulet1.scale() + " 精度=" + resulet1.precision());
		
		
	}
}

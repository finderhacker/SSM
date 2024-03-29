package jmockit.gw;

/*
 * Copyright (c) 2006-2015 Rogério Liesenfeld
 * This file is subject to the terms of the MIT license (see LICENSE.txt).
 */

import java.util.*;

import static java.util.Arrays.asList;

import org.junit.*;
import org.junit.rules.*;

import static org.junit.Assert.*;
import mockit.Expectations;
import mockit.Mocked;
import mockit.StrictExpectations;
import mockit.internal.*;

public final class ExpectationsWithVarArgsMatchersTest {
	@Rule
	public final ExpectedException thrown = ExpectedException.none();

	static class Collaborator {
		List<?> complexOperation(Object input1, Object... otherInputs) {
			return input1 == null ? Collections.emptyList()
					: asList(otherInputs);
		}

		@SuppressWarnings("UnusedDeclaration")
		int anotherOperation(int i, boolean b, String s, String... otherStrings) {
			return -1;
		}

		boolean doSomething(int i, Object... values) {
			return i + values.length > 0;
		}
	}

	public interface Dependency {
		void doSomething(String... args);
	}

	@Mocked
	Collaborator mock;
	@Mocked
	Dependency mock2;

	@Test
	public void replayVarargsMethodWithDifferentThanExpectedNonVarargsArgument() {
		thrown.expect(UnexpectedInvocation.class);
System.out.println(this + "  " + mock + "  " + mock2);		

		new StrictExpectations() {
			{
				mock.complexOperation(1, 2, 3);
			}
		};

		mock.complexOperation(2, 2, 3);
	}

	@Test
	public void replayVarargsMethodWithDifferentThanExpectedNumberOfVarargsArguments_strict() {
		thrown.expect(UnexpectedInvocation.class);
System.out.println(this + "  " + mock + "  " + mock2);

		new StrictExpectations() {
			{
				mock.complexOperation(1, 2, 3);
			}
		};

		mock.complexOperation(1, 2);
	}

	@Test
	public void replayVarargsMethodWithDifferentThanExpectedNumberOfVarargsArguments() {
		thrown.expect(MissingInvocation.class);
System.out.println(this + "  " + mock + "  " + mock2);

		new Expectations() {
			{
				mock2.doSomething("1", "2", "3");
				times = 1;
			}
		};

		mock2.doSomething("1", "2");
	}

	@Test
	public void replayVarargsMethodWithDifferentThanExpectedVarargsArgument_strict() {
		thrown.expect(UnexpectedInvocation.class);
System.out.println(this + "  " + mock + "  " + mock2);
		
		new StrictExpectations() {
			{
				mock.complexOperation(1, 2, 3);
			}
		};

		mock.complexOperation(1, 2, 4);
	}

	@Test
	public void replayVarargsMethodWithDifferentThanExpectedVarargsArgument() {
		thrown.expect(MissingInvocation.class);
System.out.println(this + "  " + mock + "  " + mock2);

		new Expectations() {
			{
				mock2.doSomething("1", "2", "3");
				minTimes = 1;
			}
		};

		mock2.doSomething("1", "2", "4");
	}

	@Test
	public void expectInvocationOnMethodWithVarargsArgumentUsingArgumentMatchers() {
System.out.println(this + "  " + mock + "  " + mock2);
		new Expectations() {
			{
				mock.complexOperation(withEqual(1), withNotEqual(2), withNull());
				mock2.doSomething(withPrefix("C"), withSuffix("."));
			}
		};

		mock.complexOperation(1, 3, null);
		mock2.doSomething("Cab", "123.");
	}

	@Test
	public void expectInvocationWithAnyNumberOfVariableArguments() {
System.out.println(this + "  " + mock + "  " + mock2);
		new StrictExpectations() {
			{
				mock.complexOperation(any, (Object[]) null);
				times = 3;
				mock2.doSomething((String[]) any);
				minTimes = 2;
				mock.complexOperation(123, (Object[]) any);
			}
		};

		mock.complexOperation("test");
		mock.complexOperation(null, 'X');
		mock.complexOperation(1, 3, null);
		mock2.doSomething();
		mock2.doSomething("test", "abc");
		mock.complexOperation(123, true, "test", 3);
	}

	@Test
	public void expectInvocationsWithMatcherForVarargsParameterOnly() {
System.out.println(this + "  " + mock + "  " + mock2);
		final List<Integer> values = asList(1, 2, 3);

		new Expectations() {
			{
				mock.complexOperation("test", (Object[]) any);
				result = values;
				mock.anotherOperation(1, true, null, (String[]) any);
				result = 123;
				mock.doSomething(anyInt, (Object[]) any);
				result = true;
			}
		};

		assertSame(values, mock.complexOperation("test", true, 'a', 2.5));
		assertSame(values, mock.complexOperation("test", 123));
		assertSame(values, mock.complexOperation("test"));

		assertEquals(123, mock.anotherOperation(1, true, null));
		assertEquals(123, mock.anotherOperation(1, true, null, "A", null, "b"));
		assertEquals(123, mock.anotherOperation(1, true, "test", "a", "b"));

		assertTrue(mock.doSomething(-1));
		assertTrue(mock.doSomething(-2, "test"));
	}

	@Test
	public void expectInvocationOnVarargsMethodWithMatcherOnlyForRegularFirstParameter() {
System.out.println(this + "  " + mock + "  " + mock2);		
		new Expectations() {
			{
				mock.complexOperation(any, 1, 2);
			}
		};

		mock.complexOperation("test", 1, 2);
	}

	@Test
	public void expectInvocationWithMatchersForRegularParametersAndAllVarargsValues() {
System.out.println(this + "  " + mock + "  " + mock2);
		new Expectations() {
			{
				mock.complexOperation(anyBoolean, anyInt, withEqual(2));
				mock.complexOperation(anyString, withEqual(1), any,
						withEqual(3), anyBoolean);
			}
		};

		mock.complexOperation(true, 1, 2);
		mock.complexOperation("abc", 1, 2, 3, true);
	}

	@Test
	public void recordExpectationsWithMatchersForSomeRegularParametersAndNoneForVarargs() {
System.out.println(this + "  " + mock + "  " + mock2);
		new Expectations() {
			{
				mock.anotherOperation(1, anyBoolean, "test", "a");
				result = 1;
				mock.anotherOperation(anyInt, true, withSubstring("X"), "a",
						"b");
				result = 2;
			}
		};

		// Invocations that match a recorded expectation:
		assertEquals(1, mock.anotherOperation(1, true, "test", "a"));
		assertEquals(1, mock.anotherOperation(1, true, "test", "a"));
		assertEquals(1, mock.anotherOperation(1, false, "test", "a"));

		assertEquals(2, mock.anotherOperation(2, true, "aXb", "a", "b"));
		assertEquals(2, mock.anotherOperation(-1, true, "  X", "a", "b"));
		assertEquals(2, mock.anotherOperation(0, true, "XXX", "a", "b"));
		assertEquals(2, mock.anotherOperation(1, true, "X", "a", "b"));

		// Invocations that don't match any expectation:
		assertEquals(0, mock.anotherOperation(1, false, "test", null, "a"));
		assertEquals(0, mock.anotherOperation(1, false, "tst", "a"));
		assertEquals(0, mock.anotherOperation(0, false, "test", "a"));
		assertEquals(0, mock.anotherOperation(1, true, "test", "b"));
		assertEquals(0, mock.anotherOperation(1, true, "test"));

		assertEquals(0, mock.anotherOperation(2, false, "aXb", "a", "b"));
		assertEquals(0, mock.anotherOperation(1, true, "  X", "A", "b"));
		assertEquals(0, mock.anotherOperation(0, true, "XXX", "a"));
		assertEquals(0, mock.anotherOperation(0, true, "XXX", "b"));
		assertEquals(0, mock.anotherOperation(32, true, "-Xx", "a", null));
	}

	@Test
	public void expectInvocationsWithNonNullRegularArgumentAndAnyVarargs() {
System.out.println(this + "  " + mock + "  " + mock2);
		new Expectations() {
			{
				mock.complexOperation(withNotNull(), (Object[]) any);
				times = 3;
			}
		};

		mock.complexOperation(new Object(), 1, "2");
		mock.complexOperation("", true, 'a', 2.5);
		mock.complexOperation(123);
	}

	@Test
	public void expectInvocationWithNonNullRegularArgumentAndAnyVarargsButReplayWithNull() {
		thrown.expect(UnexpectedInvocation.class);
System.out.println(this + "  " + mock + "  " + mock2);

		new StrictExpectations() {
			{
				mock.complexOperation(withNotNull(), (Object[]) any);
			}
		};

		mock.complexOperation(null, 1, "2");
	}

	@Test
	public void expectInvocationWithMatchersForSomeRegularParametersAndAllForVarargs() {
System.out.println(this + "  " + mock + "  " + mock2);
		new Expectations() {
			{
				mock.anotherOperation(anyInt, true, withEqual("abc"),
						anyString, withEqual("test"));
				result = 1;
				mock.anotherOperation(0, anyBoolean, withEqual("Abc"),
						anyString, anyString, anyString);
				result = 2;
			}
		};

		assertEquals(0, mock.anotherOperation(1, false, "test", null, "a"));

		assertEquals(1, mock.anotherOperation(2, true, "abc", "xyz", "test"));
		assertEquals(1, mock.anotherOperation(-1, true, "abc", null, "test"));
		assertEquals(0,
				mock.anotherOperation(-1, true, "abc", null, "test", null));

		assertEquals(2,
				mock.anotherOperation(0, false, "Abc", "", "Abc", "test"));
		assertEquals(0,
				mock.anotherOperation(0, false, "Abc", "", "Abc", "test", ""));
	}

	@SuppressWarnings("unused")
	class VarArgs {
		public void varsOnly(int... ints) {
		}

		public void mixed(String arg0, int... ints) {
		}
	}

	@SuppressWarnings("NullArgumentToVariableArgMethod")
	@Test
	public void expectInvocationWithNoVarArgs(@Mocked final VarArgs varargs) {
System.out.println(this + "  " + mock + "  " + mock2);
		new StrictExpectations() {
			{
				varargs.varsOnly();
				times = 2;
				varargs.mixed("abcd");
				times = 2;
			}
		};

		varargs.varsOnly();
		varargs.varsOnly(null);
		varargs.mixed("abcd");
		varargs.mixed("abcd", null);
	}

	class ReferenceVarArgs {
		@SuppressWarnings("unused")
		public void mixed(String[] strings, Integer... ints) {
		}
	}

	@Test
	public void expectInvocationWithNonPrimitiveVarArgs(
			@Mocked final ReferenceVarArgs varargs) {
System.out.println(this + "  " + mock + "  " + mock2);
		final String[] strings1 = new String[0];
		final String[] strings2 = { "efgh", "ijkl" };

		new Expectations() {
			{
				varargs.mixed(null, 4, 5, 6);
				varargs.mixed(strings1, 4, 5, 6);
				varargs.mixed(strings2, 4, 5, 6);
				varargs.mixed(null);
				varargs.mixed(strings1);
				varargs.mixed(strings2);
			}
		};

		varargs.mixed(null, 4, 5, 6);
		varargs.mixed(strings1, 4, 5, 6);
		varargs.mixed(strings2, 4, 5, 6);
		varargs.mixed(null);
		varargs.mixed(strings1);
		varargs.mixed(strings2);
	}

	@SuppressWarnings("unused")
	class PrimitiveVarArgs {
		public void varsOnly(int... ints) {
		}

		public void mixed(String arg0, String[] strings, int... ints) {
		}
	}

	@SuppressWarnings("NullArgumentToVariableArgMethod")
	@Test
	public void expectInvocationWithPrimitiveVarArgs(
			@Mocked final PrimitiveVarArgs varargs) {
System.out.println(this + "  " + mock + "  " + mock2);
		final String[] strings1 = new String[0];
		final String[] strings2 = { "efgh", "ijkl" };

		new StrictExpectations() {
			{
				varargs.varsOnly(1, 2, 3);
				varargs.varsOnly(null);
				varargs.mixed("abcd", null, 4, 5, 6);
				varargs.mixed("abcd", strings1, 4, 5, 6);
				varargs.mixed("abcd", strings2, 4, 5, 6);
				varargs.mixed("abcd", null);
				varargs.mixed("abcd", strings1);
				varargs.mixed("abcd", strings2);
				varargs.mixed("abcd", null, null);
				varargs.mixed(null, null, null);
			}
		};

		varargs.varsOnly(1, 2, 3);
		varargs.varsOnly(null);
		varargs.mixed("abcd", null, 4, 5, 6);
		varargs.mixed("abcd", strings1, 4, 5, 6);
		varargs.mixed("abcd", strings2, 4, 5, 6);
		varargs.mixed("abcd", null);
		varargs.mixed("abcd", strings1);
		varargs.mixed("abcd", strings2);
		varargs.mixed("abcd", null, null);
		varargs.mixed(null, null, null);
	}

	class MixedVarArgs {
		@SuppressWarnings("unused")
		public void mixed(String[] strings, int... ints) {
		}
	}

	@Test
	public void expectInvocationWithPrimitiveVarArgsUsingMatchers(
			@Mocked final MixedVarArgs varargs) {
System.out.println(this + "  " + mock + "  " + mock2);
		final String[] strings1 = new String[0];
		final String[] strings2 = { "efgh", "ijkl" };

		new Expectations() {
			{
				varargs.mixed((String[]) withNull(), withEqual(4),
						withEqual(5), withEqual(6));
				varargs.mixed(withEqual(strings1), withEqual(4), withEqual(5),
						withEqual(6));
				varargs.mixed(withEqual(strings2), withEqual(4), withEqual(5),
						withEqual(6));
				varargs.mixed((String[]) withNull());
				varargs.mixed(withEqual(strings1));
				varargs.mixed(withEqual(strings2));
			}
		};

		varargs.mixed(null, 4, 5, 6);
		varargs.mixed(strings1, 4, 5, 6);
		varargs.mixed(strings2, 4, 5, 6);
		varargs.mixed(null);
		varargs.mixed(strings1);
		varargs.mixed(strings2);
	}

	@Test
	public void expectInvocationWithMatchersForAllParametersAndVarargsValuesButReplayWithDifferentVarargValue() {
		thrown.expect(UnexpectedInvocation.class);
System.out.println(this + "  " + mock + "  " + mock2);

		new StrictExpectations() {
			{
				mock.complexOperation(anyString, anyBoolean, withEqual(123L));
			}
		};

		mock.complexOperation("abc", true, 1L);
		
	}

	@Test
	public void expectationRecordedWithNotNullMatcherForVarargsParameter() {
System.out.println(this + "  " + mock + "  " + mock2);
		new Expectations() {
			{
				mock.doSomething(0, (Object[]) withNotNull());
				result = true;
			}
		};

		assertTrue(mock.doSomething(0, "test"));
		// noinspection NullArgumentToVariableArgMethod
		assertFalse(mock.doSomething(0, (Object[]) null));
	
	}
}
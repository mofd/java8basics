package de.swm.ngprog.lambdas;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author kubovy.jan <br>
 * copyright (C) 2016, SWM Services GmbH
 */
public class IntCalculationTest {
	@Test
	public final void testWithInterfaceImplementation() throws Exception {
		final IntCalculation calc = new IntCalculation(0);
		assertEquals(0, calc.getValue());
		System.out.println(calc);

		calc.eval(new IntOperation() {
			@Override
			public int calculate(final int a) {
				return a + 2;
			}
		});
		assertEquals(2, calc.getValue());
		System.out.println(calc);
	}

	@Test
	public final void testCalculationWithLambda() throws Exception {
		final IntCalculation calc = new IntCalculation(0);
		assertEquals(0, calc.getValue());
		System.out.println(calc);

		calc.eval(a -> a + 2);
		assertEquals(2, calc.getValue());
		System.out.println(calc);
	}

	@Test
	public final void testWithInterfaceImplementationInVariable() throws Exception {
		final IntCalculation calc = new IntCalculation(2);
		final IntOperation multiplyOperation = new IntOperation() {
			@Override
			public int calculate(final int a) {
				return a << 1;
			}
		};

		calc.eval(multiplyOperation);
		assertEquals(4, calc.getValue());
		System.out.println(calc);
	}

	@Test
	public final void testCalculationWithLambdaInVariable() throws Exception {
		final IntCalculation calc = new IntCalculation(2);

		final IntOperation powerOperation = a -> a << 1;

		calc.eval(powerOperation);
		assertEquals(4, calc.getValue());
		System.out.println(calc);

		calc.eval(this::subtractOne);
		assertEquals(3, calc.getValue());
		System.out.println(calc);
	}

	@Test
	public final void testWithInterfaceUsingMethod() throws Exception {
		final IntCalculation calc = new IntCalculation(4);
		calc.eval(new IntOperation() {
			@Override
			public int calculate(final int a) {
				return subtractOne(a);
			}
		});
		assertEquals(3, calc.getValue());
		System.out.println(calc);

		calc.eval(new IntOperation() {
			@Override
			public int calculate(final int a) {
				return subtractTwo(a);
			}
		});
		assertEquals(1, calc.getValue());
		System.out.println(calc);
	}

	@Test
	public final void testCalculationWithLambdaUsingMethod() throws Exception {
		final IntCalculation calc = new IntCalculation(4);
		calc.eval(this::subtractOne);
		assertEquals(3, calc.getValue());
		System.out.println(calc);

		calc.eval(IntCalculationTest::subtractTwo);
		assertEquals(1, calc.getValue());
		System.out.println(calc);
	}

	private int subtractOne(final int x) {
		return x - 1;
	}

	private static int subtractTwo(final int x) {
		return x - 2;
	}
}

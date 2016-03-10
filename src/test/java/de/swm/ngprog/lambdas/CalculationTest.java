package de.swm.ngprog.lambdas;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author kubovy.jan <br>
 * copyright (C) 2016, SWM Services GmbH
 */
public class CalculationTest {
	@Test
	public final void testWithInterfaceImplementation() throws Exception {
		final Calculation<Double> calc = new Calculation<>(0.0);
		assertEquals(0.0, calc.getValue());
		System.out.println(calc);

		calc.eval(new Operation<Double>() {
			@Override
			public Double calculate(final Double a) {
				return a + 2.0;
			}
		});
		assertEquals(2.0, calc.getValue());
		System.out.println(calc);
	}

	@Test
	public final void testCalculationWithLambda() throws Exception {
		final Calculation<Double> calc = new Calculation<>(0.0);
		assertEquals(0.0, calc.getValue());
		System.out.println(calc);

		calc.eval(a -> a + 2.0);
		assertEquals(2.0, calc.getValue());
		System.out.println(calc);
	}

	@Test
	public final void testWithInterfaceImplementationInVariable() throws Exception {
		final Calculation<Double> calc = new Calculation<>(2.0);
		final Operation<Double> multiplyOperation = new Operation<Double>() {
			@Override
			public Double calculate(final Double a) {
				return StrictMath.pow(a, 2.0);
			}
		};

		calc.eval(multiplyOperation);
		assertEquals(4.0, calc.getValue());
		System.out.println(calc);
	}

	@Test
	public final void testCalculationWithLambdaInVariable() throws Exception {
		final Calculation<Double> calc = new Calculation<>(2.0);

		final Operation<Double> powerOperation = a -> StrictMath.pow(a, 2.0);

		calc.eval(powerOperation);
		assertEquals(4.0, calc.getValue());
		System.out.println(calc);

		calc.eval(this::subtractOne);
		assertEquals(3.0, calc.getValue());
		System.out.println(calc);
	}

	@Test
	public final void testWithInterfaceUsingMethod() throws Exception {
		final Calculation<Double> calc = new Calculation<>(4.0);
		calc.eval(new Operation<Double>() {
			@Override
			public Double calculate(final Double a) {
				return subtractOne(a);
			}
		});
		assertEquals(3.0, calc.getValue());
		System.out.println(calc);

		calc.eval(new Operation<Double>() {
			@Override
			public Double calculate(final Double a) {
				return subtractTwo(a);
			}
		});
		assertEquals(1.0, calc.getValue());
		System.out.println(calc);
	}

	@Test
	public final void testCalculationWithLambdaUsingMethod() throws Exception {
		final Calculation<Double> calc = new Calculation<>(4.0);
		calc.eval(this::subtractOne);
		assertEquals(3.0, calc.getValue());
		System.out.println(calc);

		calc.eval(CalculationTest::subtractTwo);
		assertEquals(1.0, calc.getValue());
		System.out.println(calc);
	}

	private Double subtractOne(final Double x) {
		return x - 1.0;
	}

	private static Double subtractTwo(final Double x) {
		return x - 2.0;
	}
}

package de.swm.ngprog.lambdas;

/**
 * @author kubovy.jan <br>
 * copyright (C) 2016, SWM Services GmbH
 */
public final class IntCalculation {
	private int value;

	public IntCalculation(final int value) {
		this.value = value;
	}

	public IntCalculation eval(final IntOperation opration) {
		this.value = opration.calculate(this.value);
		return this;
	}

	public int getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return String.format("IntCalculation{value=%d}", this.value); //NON-NLS
	}
}

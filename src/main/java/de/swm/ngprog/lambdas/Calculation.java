package de.swm.ngprog.lambdas;

/**
 * @author kubovy.jan <br>
 * copyright (C) 2016, SWM Services GmbH
 */
public final class Calculation<T extends Number> {
	private T value;

	public Calculation(final T value) {
		this.value = value;
	}

	public Calculation eval(final Operation<T> operation) {
		this.value = operation.calculate(this.value);
		return this;
	}

	public T getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return String.format("Calculation{value=%s}", this.value); //NON-NLS
	}
}

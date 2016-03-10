package de.swm.ngprog.lambdas;

/**
 * @author kubovy.jan <br>
 * copyright (C) 2016, SWM Services GmbH
 */
@FunctionalInterface
public interface Operation<T extends Number> {
	T calculate(T a);
}

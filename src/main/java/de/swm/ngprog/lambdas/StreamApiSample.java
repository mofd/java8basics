package de.swm.ngprog.lambdas;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kubovy.jan <br>
 * copyright (C) 2016, SWM Services GmbH
 */
public class StreamApiSample {
	public static void main(final String[] args) {
		final List<Integer> numbers = Arrays.asList(5, 10, 6, 58, 69, 15, 1, 48, 86, 3, 43, 72, 8);
		final List<String> strings = Arrays.asList("Lorem", "ipsum", "dolor", "sit", "amet", "consectetur", //NON-NLS
				"adipiscing", "elit", "Aenean", "blandit", "efficitur", "lorem", "at", "tincidunt", "quam", //NON-NLS
				"egestas", "Proin", "vitae", "lacinia", "velit", "Nullam", "quis", "ante", "finibus"); //NON-NLS

		final long lessThen10Count = numbers.stream()
				.filter(x -> x < 10)
				.count();
		System.out.println(lessThen10Count);

		final long lengthLessThen5Count = strings.stream()
				.filter(str -> str.length() < 5)
				.count();
		System.out.println(lengthLessThen5Count);

		strings.stream()
				.map(String::length) // .map(str -> str.length())
				.forEach(len -> System.out.println(String.format(" - %d", len))); //NON-NLS

		final String sortedStringListByLengthWhichAreLongerThan3Characters = strings.stream()
				.filter(str -> str.length() > 3)
				.map(str -> new Pair<>(str, str.length()))
				.sorted((o1, o2) -> o1.getValue().compareTo(o2.getValue()))
				.map(Pair::getKey)
				.collect(Collectors.joining(", ", "Sorted strings: ", " :)")); //NON-NLS
		System.out.print(sortedStringListByLengthWhichAreLongerThan3Characters);
	}
}

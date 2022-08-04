package org.none;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.none.model.Color.BLUE;
import static org.none.model.Color.GREEN;
import static org.none.model.Color.RED;


import org.junit.jupiter.api.Test;
import org.none.logic.Sorter;
import org.none.model.Tube;
import org.none.model.Tubes;
import org.none.utils.Fixtures;

class SortTest {

	@Test
	void alreadySortedTubes() {
		Tubes tubes = new Tubes(Tube.of(RED, RED), Tube.of(BLUE, BLUE));

		Sorter sorter = new Sorter(tubes, Fixtures.DEFAULT_CONFIGURATION);
		Tubes sorted = sorter.sort();
		assertTrue (Fixtures.isEmptyOrSorted(sorted));
	}

	@Test
	void alreadySortedAndEmptyTubes() {
		Tubes tubes = new Tubes(Tube.of(RED, RED), Tube.of(BLUE, BLUE), new Tube(2));

		Sorter sorter = new Sorter(tubes, Fixtures.DEFAULT_CONFIGURATION);
		Tubes sorted = sorter.sort();
		assertTrue (Fixtures.isEmptyOrSorted(sorted));
	}

	@Test
	void simplestSortProblem() {
		Tubes tubes = new Tubes(Tube.of(RED, BLUE), Tube.of(BLUE, RED), new Tube(2));

		Sorter sorter = new Sorter(tubes, Fixtures.DEFAULT_CONFIGURATION);
		Tubes sorted = sorter.sort();
		assertTrue (Fixtures.isEmptyOrSorted(sorted));
	}

	@Test
	void unSortedTubes() {
		Tubes tubes = new Tubes(Tube.of(RED, BLUE), Tube.of(GREEN, RED), Tube.of(GREEN, BLUE), new Tube(2));

		Sorter sorter = new Sorter(tubes, Fixtures.DEFAULT_CONFIGURATION);
		Tubes sorted = sorter.sort();
		assertTrue (Fixtures.isEmptyOrSorted(sorted));
	}

	@Test
	void depth3Tubes() {
		Tubes tubes = new Tubes(Tube.of(RED, BLUE, GREEN), Tube.of(GREEN, RED, BLUE), Tube.of(GREEN, BLUE, RED), new Tube(3));

		Sorter sorter = new Sorter(tubes, Fixtures.DEFAULT_CONFIGURATION.iterations(300));
		Tubes sorted = sorter.sort();
		assertTrue (Fixtures.isEmptyOrSorted(sorted));
	}
}

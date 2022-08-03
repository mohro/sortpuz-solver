package org.none;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.none.model.Color.BLUE;
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
	void unSortedTubes() {
		Tubes tubes = new Tubes(Tube.of(RED, BLUE), Tube.of(BLUE, RED), new Tube(2));

		Sorter sorter = new Sorter(tubes, Fixtures.DEFAULT_CONFIGURATION);
		Tubes sorted = sorter.sort();
		assertTrue (Fixtures.isEmptyOrSorted(sorted));
	}

}

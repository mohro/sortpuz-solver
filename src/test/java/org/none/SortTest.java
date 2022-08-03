package org.none;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.none.model.Color.BLUE;
import static org.none.model.Color.RED;


import org.junit.jupiter.api.Test;
import org.none.logic.Sorter;
import org.none.model.Tube;
import org.none.utils.Fixtures;

class SortTest {

	@Test
	void alreadySortedTubes() {
		Tube[] tubes = new Tube[2];
		tubes[0] = new Tube(RED, RED);
		tubes[1] = new Tube(BLUE, BLUE);

		Sorter sorter = new Sorter(tubes);
		Tube[] sorted = sorter.sort();
		assertTrue (Fixtures.isEmptyOrSorted(sorted));
	}

	@Test
	void alreadySortedAndEmptyTubes() {
		Tube[] tubes = new Tube[3];
		tubes[0] = new Tube(RED, RED);
		tubes[1] = new Tube(BLUE, BLUE);
		tubes[2] = new Tube();

		Sorter sorter = new Sorter(tubes);
		Tube[] sorted = sorter.sort();
		assertTrue (Fixtures.isEmptyOrSorted(sorted));
	}

	@Test
	void unSortedTubes() {
		Tube[] tubes = new Tube[3];
		tubes[0] = new Tube(BLUE, RED);
		tubes[1] = new Tube(BLUE, RED);
		tubes[2] = new Tube();

		Sorter sorter = new Sorter(tubes);
		Tube[] sorted = sorter.sort();
		assertTrue (Fixtures.isEmptyOrSorted(sorted));
	}

}

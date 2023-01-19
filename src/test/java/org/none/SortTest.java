package org.none;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.none.model.Color.BLUE;
import static org.none.model.Color.GREEN;
import static org.none.model.Color.NONE;
import static org.none.model.Color.RED;
import static org.none.utils.Fixtures.tube;


import org.junit.jupiter.api.Test;
import org.none.logic.Sorter;
import org.none.model.Tube;
import org.none.model.Tubes;
import org.none.utils.Fixtures;

class SortTest {

	@Test
	void depth3Tubes() {
		Tubes tubes = new Tubes(tube(RED, BLUE, GREEN), tube(GREEN, RED, BLUE), tube(GREEN, BLUE, RED), new Tube(3));

		Sorter sorter = new Sorter(tubes, Fixtures.DEFAULT_CONFIGURATION.iterations(100));
		Tubes sorted = sorter.sort();
		assertTrue (Fixtures.isEmptyOrSorted(sorted));
	}
}

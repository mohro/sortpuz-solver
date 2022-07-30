package org.none.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.none.model.Color.BLUE;
import static org.none.model.Color.RED;

import org.junit.jupiter.api.Test;

public class TubeTest {

	@Test
	public void testIsSorted() {
		Tube tube = new Tube(RED, RED);
		assertTrue(tube.isSameColor());

		Tube tube2 = new Tube(BLUE, BLUE);
		assertTrue(tube2.isSameColor());
	}

	@Test
	public void testIsUnsorted() {
		Tube tube = new Tube(RED, BLUE);
		assertFalse(tube.isSameColor());

		Tube tube2 = new Tube(BLUE, RED);
		assertFalse(tube2.isSameColor());
	}

}

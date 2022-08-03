package org.none.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.none.model.Color.BLUE;
import static org.none.model.Color.NONE;
import static org.none.model.Color.RED;

import org.junit.jupiter.api.Test;

class TubeTest {

	@Test
	void testIsSorted() {
		Tube tube = new Tube(RED, RED);
		assertTrue(tube.isSameColor());

		Tube tube2 = new Tube(BLUE, BLUE);
		assertTrue(tube2.isSameColor());
	}

	@Test
	void testIsUnsorted() {
		Tube tube = new Tube(RED, BLUE);
		assertFalse(tube.isSameColor());

		Tube tube2 = new Tube(BLUE, RED);
		assertFalse(tube2.isSameColor());
	}

	@Test
	void tubeFullnessTest() {
		assertTrue(Tube.of(RED, RED).isFull());
		assertTrue(Tube.of(BLUE, RED).isFull());
		assertFalse(Tube.of(NONE, RED).isFull());
		assertFalse(Tube.of(NONE, NONE).isFull());
	}

	@Test
	void tubeSamenessTest() {
		assertTrue(Tube.of(RED, RED).isSameColor());
		assertTrue(Tube.of(NONE, NONE).isSameColor());

		assertFalse(Tube.of(BLUE, RED).isSameColor());
		assertFalse(Tube.of(NONE, RED).isSameColor());
	}

	@Test
	void testTopColors() {
		assertEquals(Tube.of(RED, BLUE, BLUE, BLUE).topColor(), RED);
		assertEquals(Tube.of(NONE, NONE, NONE, RED).topColor(), RED);
		assertEquals(Tube.of(NONE, NONE, NONE, NONE).topColor(), NONE);
	}

	@Test
	void testNextIndex() {
		assertEquals(Tube.of(RED, RED).nextIndex(), -1);
		assertEquals(Tube.of(NONE, RED).nextIndex(), 0);
		assertEquals(Tube.of(NONE, NONE).nextIndex(), 1);
	}

	@Test
	void compatibilityTest() {
		assertTrue(Tube.of(RED, RED).isCompatible(Tube.of(NONE, RED)));
		assertTrue(Tube.of(RED, RED).isCompatible(Tube.of(NONE, NONE)));
		assertFalse(Tube.of(RED, RED).isCompatible(Tube.of(NONE, BLUE)));
	}
}

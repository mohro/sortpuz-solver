package org.none.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.none.model.Color.BLUE;
import static org.none.model.Color.GREEN;
import static org.none.model.Color.NONE;
import static org.none.model.Color.RED;
import static org.none.utils.Fixtures.tube;

import org.junit.jupiter.api.Test;

class TubeTest {

	@Test
	void testIsSorted() {
		assertTrue(tube(RED, RED).isSameColor());
		assertTrue(tube(BLUE, BLUE).isSameColor());
	}

	@Test
	void testIsUnsorted() {
		assertFalse(tube(RED, BLUE).isSameColor());
		assertFalse(tube(BLUE, RED).isSameColor());
	}

	@Test
	void tubeFullnessTest() {
		assertTrue(tube(RED, RED).isFull());
		assertTrue(tube(BLUE, RED).isFull());
		assertFalse(tube(NONE, RED).isFull());
		assertFalse(tube(NONE, NONE).isFull());
	}

	@Test
	void tubeSamenessTest() {
		assertTrue(tube(RED, RED).isSameColor());
		assertTrue(tube(NONE, NONE).isSameColor());

		assertFalse(tube(BLUE, RED).isSameColor());
		assertFalse(tube(NONE, RED).isSameColor());
	}

	@Test
	void testTopColors() {
		assertEquals(tube(RED, BLUE, BLUE, BLUE).topColor(), RED);
		assertEquals(tube(NONE, NONE, NONE, RED).topColor(), RED);
		assertEquals(tube(NONE, NONE, NONE, NONE).topColor(), NONE);
	}

	@Test
	void testNextIndex() {
		assertEquals(tube(RED, RED).nextIndex(), -1);
		assertEquals(tube(NONE, RED).nextIndex(), 0);
		assertEquals(tube(NONE, NONE).nextIndex(), 1);
	}

	@Test
	void compatibilityTest() {
		assertTrue(tube(RED, RED).isCompatible(tube(NONE, RED)));
		assertTrue(tube(RED, RED).isCompatible(tube(NONE, NONE)));
		assertFalse(tube(RED, RED).isCompatible(tube(NONE, BLUE)));
	}

	@Test
	void testColorAt() {
		assertEquals(tube(RED, GREEN, BLUE).colorAt(0), RED);
		assertEquals(tube(RED, GREEN, BLUE).colorAt(1), GREEN);
		assertEquals(tube(RED, GREEN, BLUE).colorAt(2), BLUE);
	}
}

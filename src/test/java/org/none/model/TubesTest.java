package org.none.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.none.model.Color.BLUE;
import static org.none.model.Color.NONE;
import static org.none.model.Color.RED;

import org.junit.jupiter.api.Test;

class TubesTest {

	@Test
	void testFailedConstruction() {
		assertThrows(RuntimeException.class, () -> new Tubes(null));
		assertThrows(RuntimeException.class, () -> new Tubes(new Tube(RED, RED), new Tube(BLUE)));
		assertThrows(RuntimeException.class, () -> new Tubes(new Tube(RED, RED), new Tube(BLUE, BLUE, BLUE)));
		assertThrows(RuntimeException.class, () -> new Tubes(new Tube(RED, RED), new Tube(10)));
	}

	@Test
	void testConstruction() {
		new Tubes(new Tube(RED, RED), new Tube(BLUE, BLUE));
		new Tubes(new Tube(RED, RED, RED), new Tube(BLUE, BLUE, BLUE));
		new Tubes(new Tube(RED, RED, RED), new Tube(3));
	}

	@Test
	void transferTest() {
		Tubes tubes = new Tubes(
						Tube.of(RED, BLUE),
						Tube.of(NONE, RED)
					);
		tubes.transfer(0, 1);
		assertTrue(tubes.isFull(1));
	}

	@Test
	void doNotTransferBlueTest() {
		Tubes tubes = new Tubes(
						Tube.of(BLUE, RED),
						Tube.of(NONE, RED)
		);
		tubes.transfer(0, 1);
		assertTrue(tubes.isFull(0));
		assertFalse(tubes.isFull(1));
	}

	@Test
	void transferToEmptyTube() {
		Tubes tubes = new Tubes(
						Tube.of(RED, BLUE),
						Tube.of(2)
		);
		tubes.transfer(0, 1);
		assertFalse(tubes.isFull(0));
		assertFalse(tubes.isFull(1));
	}

	@Test
	void transferToFull() {
		Tubes tubes = new Tubes(
			Tube.of(RED, RED),
			Tube.of(2)
		);
		tubes.transfer(0, 1);
		assertTrue(tubes.isEmpty(0));
		assertTrue(tubes.isFull(1));
	}

	@Test
	void transferToHalfFull() {
		Tubes tubes = new Tubes(
						Tube.of(RED, RED),
						Tube.of(NONE, RED)
		);
		tubes.transfer(0, 1);
		assertTrue(tubes.isPartial(0));
		assertTrue(tubes.isFull(1));
	}

	@Test
	void transferPartial() {
		Tubes tubes = new Tubes(
						Tube.of(RED, RED, BLUE),
						Tube.of(3)
		);
		tubes.transfer(0, 1);
		assertEquals(tubes.top(0), 2);
		assertEquals(tubes.top(1), 1);
	}
}

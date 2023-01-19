package org.none.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.none.model.Color.BLUE;
import static org.none.model.Color.NONE;
import static org.none.model.Color.RED;
import static org.none.utils.Fixtures.tube;
import static org.none.utils.Fixtures.tubes;

import org.junit.jupiter.api.Test;

class TubesTest {

    @Test
    void testFailedConstruction() {
        // Do not replace constructors with factory methods. The purpose is to test the constructors.
        assertThrows(RuntimeException.class, () -> new Tubes(null));
        assertThrows(RuntimeException.class, () -> new Tubes(new Tube(RED, RED), new Tube(BLUE)));
        assertThrows(RuntimeException.class, () -> new Tubes(new Tube(RED, RED), new Tube(BLUE, BLUE, BLUE)));
        assertThrows(RuntimeException.class, () -> new Tubes(new Tube(RED, RED), new Tube(10)));
    }

    @Test
    void transferTest() {
		Tubes tubes = tubes(tube(RED, BLUE), tube(NONE, RED));
        tubes.transfer(0, 1);
        assertTrue(tubes.isFull(1));
    }

    @Test
    void doNotTransferBlueTest() {
        Tubes tubes = tubes(tube(BLUE, RED), tube(NONE, RED));
        tubes.transfer(0, 1);
        assertTrue(tubes.isFull(0));
        assertFalse(tubes.isFull(1));
    }

    @Test
    void transferToEmptyTube() {
        Tubes tubes = tubes(tube(RED, BLUE), tube(2));
        tubes.transfer(0, 1);
        assertFalse(tubes.isFull(0));
        assertFalse(tubes.isFull(1));
    }

    @Test
    void transferToFull() {
		Tubes tubes = tubes(tube(RED, RED), tube(2));
        tubes.transfer(0, 1);
        assertTrue(tubes.isEmpty(0));
        assertTrue(tubes.isFull(1));
    }

    @Test
    void transferToHalfFull() {
        Tubes tubes = tubes(tube(RED, RED), tube(NONE, RED));
        tubes.transfer(0, 1);
        assertTrue(tubes.isPartial(0));
        assertTrue(tubes.isFull(1));
    }

    @Test
    void transferPartial() {
        Tubes tubes = tubes(tube(RED, RED, BLUE), tube(3));
        tubes.transfer(0, 1);
        assertEquals(tubes.top(0), 2);
        assertEquals(tubes.top(1), 1);
    }

    @Test
    void tubesDepth() {
        Tubes tubes = tubes(tube(RED, RED, BLUE), tube(3));
        assertEquals(tubes.depth(), 3);
    }
}

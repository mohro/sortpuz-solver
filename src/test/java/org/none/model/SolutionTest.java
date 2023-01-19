package org.none.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @Test
    void testEquality() {
        List<Step> steps = Arrays.asList(new Step(0, 1));
        Solution s1 = new Solution(steps);

        assertEquals(steps, s1.steps());

    }
}

package org.none.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Solution {
    private final List<Step> steps;

    public Solution(List<Step> steps) {
        this.steps = steps;
    }

    public Solution() {
        steps = new ArrayList<>();
    }

    public List<Step> steps() {
        return steps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solution solution = (Solution) o;
        return Objects.equals(steps, solution.steps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(steps);
    }

    public void nextStep(int source, int destination) {
        steps.add(new Step(source, destination));
    }
}

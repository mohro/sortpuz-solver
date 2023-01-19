package org.none.model;

import java.util.List;

public class Solution {
    private final List<Step> steps;

    public Solution(List<Step> steps) {
        this.steps = steps;
    }

    public List<Step> steps() {
        return steps;
    }
}

package org.none.photos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Solution {
    private final List<List<Integer>> rows;
    private CostPacket costPacket;


    public Solution(List<List<Integer>> rows, CostPacket costPacket) {
        this.rows = rows;
        this.costPacket = costPacket;
    }

    public Solution of(List<List<Integer>> rows) {
        return new Solution(rows, costPacket);
    }
    public double cost() {
        int lowerCost = arraysLessThanMinBound();
        return rows.size() + lowerCost + penalizeSize();
    }

    public double penalizeSize() {
        int cost = 0;
        for (List<Integer> row: rows) {
            if (row.size() > 1) {
                cost += (row.size() - 1) * costPacket.sizePenalty();
            }
        }
        return cost;
    }

    private int arraysLessThanMinBound() {
        int cost = 0;
        for (List<Integer> row: rows) {
            int local = costPacket.minSum() - sum(row);
            cost += Math.max(local, 0);
        }

        return cost;
    }

    private int sum(List<Integer> row) {
        int total = 0;
        for (int i = 0; i <row.size(); i++) {
            total += row.get(i);
        }

        return total;
    }

    public int size() {
        return rows.size();
    }

    public List<List<Integer>> copyRows() {
        return rows.stream()
                .map(ArrayList::new)
                .collect(Collectors.toList());
    }

    public void print() {
        rows.forEach(System.out::println);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solution solution = (Solution) o;
        return Objects.equals(rows, solution.rows);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rows);
    }

    @Override
    public String toString() {
        return "Solution{" +
                "rows=" + rows +
                '}';
    }
}

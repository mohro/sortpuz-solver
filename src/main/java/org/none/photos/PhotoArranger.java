package org.none.photos;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class PhotoArranger {
    private final int[] initial;
    private final int max;
    private final long seed = 10;
    private final Random random;
    private final int MAX_ITERATIONS = 1000;
    private final CostPacket costPacket;
    
    public PhotoArranger(int[] input, int min, int max, int maxBuckets, int sizePenalty) {
        this.initial = input;
        this.max = max;
        this.random = new Random(seed);
        this.costPacket = new CostPacket(min, max, 0, maxBuckets, sizePenalty);
    }

    public Solution arrange() {
        Solution baseSolution = this.initialize();
        return solve(baseSolution);
    }

    private Solution solve(Solution baseSolution) {
        Solution currentSolution = baseSolution;
        Solution bestSolution = baseSolution;

        List<List<Integer>> rows;
        int counter = 0;
        double prevCost = baseSolution.cost();
        int noCostChangeCounter = 0;
        while(counter++ < MAX_ITERATIONS) {
            rows = currentSolution.copyRows();
            int size = currentSolution.size();
            int start = this.random.nextInt(size);
            int end = this.random.nextInt(size);
            if (start == end) {
                continue;
            }

            int index = this.random.nextInt(rows.get(start).size());

            if (rows.get(start).get(index) + sum(rows.get(end)) <= max) {
                transform(rows, start, index, end);
            }
            currentSolution = currentSolution.of(rows);
            if (currentSolution.cost() < bestSolution.cost()) {
                bestSolution = currentSolution;
                prevCost = bestSolution.cost();
                noCostChangeCounter = 0;
            }

            if (prevCost == currentSolution.cost()) {
                noCostChangeCounter++;
            }

            if (noCostChangeCounter > 20) {
                currentSolution = baseSolution;
                noCostChangeCounter = 0;
            }
        }
        bestSolution.print();
        return bestSolution;
    }

    private void transform(List<List<Integer>> rows, int start, int index, int end) {
        int value = rows.get(start).remove(index);
        rows.get(end).add(value);
        if (rows.get(start).isEmpty()) {
            rows.remove(start);
        }
    }

    private Integer sum(List<Integer> integers) {
        int sum = 0;

        for (int i = 0; i < integers.size(); i++) {
            sum += integers.get(i);
        }
        return sum;
    }

    private Solution initialize() {

         List<List<Integer>> rows = Arrays.stream(initial)
                .mapToObj(Arrays::asList)
                .collect(Collectors.toList());

         return new Solution(rows, costPacket);
    }
}

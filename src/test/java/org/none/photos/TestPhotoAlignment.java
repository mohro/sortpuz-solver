package org.none.photos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestPhotoAlignment {
    @Test
    void testPhotoArrays() {
        int[] input = {1, 3, 4, 5, 6, 7, 8, 9, 10};
        int min = 12, max = 14;
        int max_buckets = 4;
        int size_penalty = 1;
        List<List<Integer>> rows = new ArrayList<>();
        rows.add(Arrays.asList(2, 11));
        rows.add(Arrays.asList(3, 10));

        PhotoArranger arranger = new PhotoArranger(input, min, max, max_buckets, size_penalty);
        Assertions.assertEquals(rows, arranger.arrange().copyRows());

    }

}

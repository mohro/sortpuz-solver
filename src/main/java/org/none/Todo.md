### Sort Puz solver. 

1. ~~Inefficient algorithm implementation~~
2. 3x4 Problem requires 90 moves with brute force. Manual solution is possible in ~10 moves.
3. ~~Add toString to tubes.~~
4. Record successful steps and return as solution.
5. Simulate case where randomness leads to unsolvable state. Only way to solve is to try a different variation
6. Currently, randomness only controls the source and destination tubes by integers. Should be able to select tubes on other criteria such as color, empty space in tube etc.
7. Stop iterating if number of idle iterations exceeds threshold.
8. Get solution found by sorter so far
9. Introduce cost for solution state. Sorted tube cost should be lower than Empty tube cost to make it more desirable for the machine 
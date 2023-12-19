package org.none.photos;

public class CostPacket {
    private final int minSum, maxSum, minBucket, maxBucket, sizePenalty;

    public CostPacket(int minSum, int maxSum, int minBucket, int maxBucket, int sizePenalty) {
        this.minSum = minSum;
        this.maxSum = maxSum;
        this.minBucket = minBucket;
        this.maxBucket = maxBucket;
        this.sizePenalty = sizePenalty;
    }

    public int minSum() {
        return minSum;
    }

    public int maxSum() {
        return maxSum;
    }

    public int minBucket() {
        return minBucket;
    }

    public int maxBucket() {
        return maxBucket;
    }

    public int sizePenalty() {
        return sizePenalty;
    }
}

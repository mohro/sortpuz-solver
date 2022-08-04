package org.none.model;

public class Configuration {

	private int maxIterations;
	private long randomSeed;

	public Configuration(int maxIterations, long randomSeed) {
		this.maxIterations = maxIterations;
		this.randomSeed = this.randomSeed;
	}

	public Configuration iterations(int iterations) {
		return new Configuration(iterations, this.randomSeed);
	}

	public int maxIterations() {
		return maxIterations;
	}

	public long randomSeed() {
		return randomSeed;
	}
}

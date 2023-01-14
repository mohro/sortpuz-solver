package org.none.logic;


import java.util.Random;

import org.none.model.Configuration;
import org.none.model.Tubes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//TODO:
//	1. Inefficient sorting algorithm.
public class Sorter {

	Logger logger = LoggerFactory.getLogger(Sorter.class);

	private final Tubes tubes;
	private Configuration configuration;
	private Random random;

	public Sorter(Tubes tubes, Configuration defaultConfiguration) {
		this.tubes = tubes;
		this.configuration = defaultConfiguration;
		this.random = new Random(configuration.randomSeed());
	}

	public Tubes sort() {
		int length = tubes.size();
		int counter = 0;
		while(true) {
			if (counter++ > configuration.maxIterations()) {
				break;
			}
			int source = random.nextInt(length);
			int destination = random.nextInt(length);

			if (source == destination) {
				continue;
			}
			if (tubes.isFull(destination)) {
				continue;
			}
			if (tubes.isSameColor(source)) {
				continue;
			}
			if(tubes.isNotCompatible(source, destination)) {
				continue;
			}
			tubes.transfer(source, destination);
		}
		return tubes;
	}
}

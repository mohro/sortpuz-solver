package org.none.logic;


import java.util.Random;
import java.util.logging.Logger;
import org.none.model.Configuration;
import org.none.model.Tubes;

public class Sorter {

	Logger logger = Logger.getLogger("Sorter");

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
			logger.info(source +" :: " + destination);
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

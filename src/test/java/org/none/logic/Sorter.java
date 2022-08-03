package org.none.logic;


import java.util.Random;
import org.none.model.Configuration;
import org.none.model.Tube;

public class Sorter {

	private final Tube[] tubes;
	private Configuration configuration;
	private Random random;

	public Sorter(Tube[] tubes) {
		this.tubes = tubes;
	}
	public Tube[] sort() {
		int length = tubes.length;
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
			if (tubes[destination].isFull()) {
				continue;
			}
		}
		return tubes;
	}
}

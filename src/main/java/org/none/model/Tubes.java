package org.none.model;

public class Tubes {

	Tube[] tubes;

	public Tubes(Tube... tubes) {
		check(tubes);
		this.tubes = tubes;
	}

	private void check(Tube[] tubes) {
		if (tubes == null) {
			throw new RuntimeException("Won't work with no tubes");
		}

		int depth = tubes[0].size();
		checkDepth(tubes, depth);
	}

	public boolean isFull(int index) {
		return tubes[index].isFull();
	}

	public boolean isPartial(int index) {
		return !tubes[index].isFull() && !tubes[index].isEmpty();
	}

	private void checkDepth(Tube[] tubes, int depth) {
		for (Tube tube : tubes) {
			if (tube.size() == depth){
				continue;
			}

			throw new RuntimeException("Tube not of same depth as other tubes : " + tube);
		}
	}

	public int size() {
		return tubes.length;
	}

	public int top(int index) {
		return tubes[index].topIndex();
	}

	public boolean isSameColor(int source) {
		return tubes[source].isSameColor();
	}

	public boolean isNotCompatible(int source, int destination) {
		return tubes[source].isNotCompatible(tubes[destination]);
	}

	public void transfer(int source, int destination) {
		tubes[source].transfer(tubes[destination]);
	}

	public boolean isEmpty(int index) {
		return tubes[index].isEmpty();
	}
}

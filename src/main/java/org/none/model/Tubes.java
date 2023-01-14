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

	private String formatString(int size) {
		String format = "";
		for (int i = 0; i < size; i++) {
			format += " %10s |";
		}

		return format;
	}

	public String toString() {
		int depth = depth();
		int size = size();
		String format = formatString(size);

		StringBuilder sb = new StringBuilder("\n");
		for (int i = 0; i < depth; i++) {
			Object[] colors = new Color[size];
			for (int j = 0; j < size; j++) {
				colors[j] = tubes[j].colorAt(i);
			}
			sb.append(String.format(format, colors)).append("\n");

		}
		return sb.toString();
	}

	public int depth() {
		return tubes[0].size();
	}
}

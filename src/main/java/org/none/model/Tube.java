package org.none.model;

import java.util.Arrays;

public class Tube {

	private Color[] colors;

	public Tube(Color... colors) {
		this.colors = colors;
	}

	public Tube(int depthOfTube) {
		colors = new Color[depthOfTube];
		Arrays.fill(colors, Color.NONE);
	}

	public static Tube of(Color... colors) {
		return new Tube(colors);
	}

	public static Tube of(int depth) {
		return new Tube(depth);
	}
	public boolean isSameColor() {
		for(int i = 1; i < colors.length; i++) {
			if (colors[i-1] != colors[i]) {
				return false;
			}
		}
		return true;
	}

	public boolean isFull() {
		for (Color color: colors) {
			if (color == Color.NONE) {
				return false;
			}
		}

		return true;
	}

	public int size() {
		return colors.length;
	}

	public boolean isCompatible(Tube tube) {
		Color tubeTopColor = tube.topColor();
		if (tubeTopColor == Color.NONE) {
			return true;
		}
		return this.topColor().equals(tube.topColor());
	}

	public boolean isNotCompatible(Tube tube) {
		return !isCompatible(tube);
	}

	 Color topColor() {
		for (Color color : colors) {
			if (color != Color.NONE) {
				return color;
			}
		}

		return Color.NONE;
	}

	int nextIndex() {
		for (int i = 0; i < colors.length; i++) {
			if (colors[i] != Color.NONE) {
				return i - 1;
			}
		}

		return colors.length - 1;
	}

	int topIndex() {
		return nextIndex() + 1;
	}

	public void transfer(Tube tube) {
		Color currentColor = this.topColor();
		Color topColor = tube.topColor();
		topColor = Color.NONE.equals(topColor) ? currentColor : topColor;
		while(topColor.equals(currentColor) && tube.nextIndex() >= 0) {
			int topIndex = topIndex();
			colors[topIndex] = Color.NONE;
			tube.add(tube.nextIndex(), topColor);
			currentColor = this.topColor();
		}
	}

	private void add(int index, Color color) {
		colors[index] = color;
	}

	@Override public String toString() {
		return "Tube{" +
						"colors=" + Arrays.toString(colors) +
						'}';
	}

	public boolean isEmpty() {
		for(Color color : colors) {
			if (color != Color.NONE) {
				return false;
			}
		}

		return true;
	}
}

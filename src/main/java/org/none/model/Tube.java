package org.none.model;

public class Tube {

	private Color[] colors;

	public Tube(Color... colors) {
		this.colors = colors;
	}

	public boolean isSameColor() {
		for(int i = 1; i < colors.length; i++) {
			if (colors[i-1] != colors[i]) {
				return false;
			}
		}
		return true;
	}
}

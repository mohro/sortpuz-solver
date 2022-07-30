package org.none.logic;

import org.none.model.Tube;

public class Sorter {

	private final Tube[] tubes;

	public Sorter(Tube[] tubes) {
		this.tubes = tubes;
	}
	public Tube[] sort() {
		return tubes;
	}
}

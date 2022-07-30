package org.none.utils;

import org.none.model.Tube;

public class Fixtures {

	public static boolean isEmptyOrSorted(Tube[] sorted) {
		for (Tube tube : sorted) {
			if (tube.isSameColor()) {
				continue;
			}
			return false;
		}
		return true;
	}
}

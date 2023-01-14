package org.none.utils;

import org.none.model.Color;
import org.none.model.Configuration;
import org.none.model.Tube;
import org.none.model.Tubes;

public class Fixtures {

	public static Configuration DEFAULT_CONFIGURATION = new Configuration(100, 100);
	public static boolean isEmptyOrSorted(Tubes tubes) {
		int size = tubes.size();
		for (int i = 0; i < size; i++) {
			if (tubes.isSameColor(i)) {
				continue;
			}
			return false;
		}
		return true;
	}

	public static Tube tube(Color ... colors) {
		return new Tube(colors);
	}
}

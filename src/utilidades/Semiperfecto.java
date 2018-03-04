package Ayuda;

import java.util.List;

public class Semiperfecto {

	public static boolean isSemiPerfect(int x, List<Integer> list) {
		if (x == 0)
			return true;
		for (int i = 0; i < list.size(); i++) {
			int temp = list.remove(i);
			if (isSemiPerfect(x - temp, list)) // using recursion
				return true;
			list.add(i, temp);
		}

		return false;
	}
}

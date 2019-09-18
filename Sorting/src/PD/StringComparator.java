package PD;

import java.util.Comparator;

public abstract class StringComparator<K> implements Comparator {

	
	public int compare(String a, String b) {
		
		return a.compareTo(b);
	}

}

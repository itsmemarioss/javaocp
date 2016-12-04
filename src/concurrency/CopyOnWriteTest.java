package concurrency;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteTest {
	public static void main(String[] args) {
		CopyOnWriteArrayList<Integer> cp = new CopyOnWriteArrayList<>(Arrays.asList(1,2,3,4));
		
		Iterator<Integer> i = cp.listIterator();
		// java.lang.UnsupportedOperationException
		//i.remove();
		
		for (Integer integer : cp) {
			cp.add(10);
			
		}
		System.out.println(cp.size());
	}
}

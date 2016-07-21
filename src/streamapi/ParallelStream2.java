package streamapi;

import java.util.ArrayList;
import java.util.List;

public class ParallelStream2 {
	
	public int processRecord(int value){
		try {
			Thread.sleep(10);//waiting for 10 miliseconds
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value +1;
		
	}

	public long processAll(List<Integer> list){
		return list.stream().map(i -> processRecord(i)).count();
	}
	
	public long processAllParallely(List<Integer> list){
		return list.parallelStream().map(i -> processRecord(i)).count();
	}
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < 40; i++) {
			list.add(i);
		}
		
		System.out.println("Starting sequencial Stream...");
		long time = System.currentTimeMillis();
		long result = new ParallelStream2().processAll(list);
		System.out.println((System.currentTimeMillis()-time));
		
		System.out.println("Starting Parallel Stream...");
		time = System.currentTimeMillis();
		new ParallelStream2().processAll(list);
		System.out.println((System.currentTimeMillis()-time));
	}

}

package concurrency;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class ForkJoinTest extends RecursiveAction	{

	private int start, end;
	private Integer[] weights;
	
	public ForkJoinTest(int start, int end, Integer[] weights) {
		super();
		this.start = start;
		this.end = end;
		this.weights = weights;
	}

	@Override
	protected void compute() {
		if (end-start<=3) {
			//pesar o animal
			int weight = 0;
			for (int i = start; i <= end; i++) {
				weight = new Random().nextInt(100);
				weights[i]= weight;
			}
		}else {
			//divide a tarefa
			int middle = start + ((end-start)/2);
			invokeAll(new ForkJoinTest(start, middle, weights),
					new ForkJoinTest(middle, end, weights));
		}
	}

	public static void main(String[] args) {
		
		System.out.println("processadores:"+Runtime.getRuntime().availableProcessors());
		
		Integer[] array = new Integer[100];
		
		ForkJoinTask<?> task = new ForkJoinTest(0, array.length-1, array);
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(task);
		
		Arrays.asList(array).stream().forEach(System.out::println);
	}
}
package streamapi;

import java.util.Arrays;

public class ParallelStream {
	public static void main(String[] args) {
		//ordem é mantida
		Arrays.asList(0,1,2,3,4,5,6,7,8,9).stream().forEach(System.out::print);
		System.out.println("");
		//ordem não é mantida
		Arrays.asList(0,1,2,3,4,5,6,7,8,9).parallelStream().forEach(System.out::print);
		System.out.println("");
		Arrays.asList(0,1,2,3,4,5,6,7,8,9).parallelStream().forEach(System.out::print);
		System.out.println("");
		//ordem é mantida independente se é um Parallel Stream
		Arrays.asList(0,1,2,3,4,5,6,7,8,9).parallelStream().forEachOrdered(System.out::print);
	}
}

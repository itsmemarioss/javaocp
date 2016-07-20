package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPools {

	public static void main(String[] args) {
		//retorna o número de processadores disponíveis para JVM
		int numberOfCPUs = Runtime.getRuntime().availableProcessors();
		System.out.println(numberOfCPUs);
		ExecutorService es = Executors.newScheduledThreadPool(numberOfCPUs);
	}
}

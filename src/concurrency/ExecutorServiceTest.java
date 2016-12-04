package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceTest {
	public static void main(String[] args) throws InterruptedException{
		System.out.println("Começou");
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.execute(()->System.out.println("primeira"));
		executor.execute(()->System.out.println("segunda"));
		executor.execute(()->System.out.println("terceira"));
		executor.execute(()->System.out.println("quarta"));
		
		//executor.shutdown();//java.util.concurrent.RejectedExecutionException runtime exception
		
		executor.execute(()->System.out.println("primeira"));
		executor.execute(()->System.out.println("segunda"));
		executor.execute(()->System.out.println("terceira"));
		executor.execute(()->System.out.println("quarta"));
		
		executor.shutdown();//java.util.concurrent.RejectedExecutionException runtime exception
		
		Future<Integer> f = executor.submit(()->5+6);
		
		System.out.println("Terminou?");
	}
}

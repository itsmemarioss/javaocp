package concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Classe baseada no blog Benjamin @@winterbe_
 * http://winterbe.com/posts/2015/04/07/java8-concurrency-tutorial-thread-executor-examples/
 * @author mario
 *
 */
public class ThreadAndExecutorsExamples {
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException{
		
		System.out.println(Runtime.getRuntime().availableProcessors());
		
//		Threads
//		printingThreadName();
//		puttingAThreadToSleep();
		
//		Excecutors
//		printingThreadNameWithExecutor();
//		usingCallableAndFuture();
//		invokeAll();
		invokeAny();
	}
	
	private static void printingThreadName(){
		Runnable task = () -> {
		    String threadName = Thread.currentThread().getName();
		    System.out.println("Hello " + threadName);
		};

		task.run();

		Thread thread = new Thread(task);
		thread.start();

		System.out.println("Done!");
	}
	
	private static void puttingAThreadToSleep(){
		Runnable runnable = () -> {
		    try {
		        String name = Thread.currentThread().getName();
		        System.out.println("Foo " + name);
		        //TimeUnit é um enum muito útil
		        TimeUnit.SECONDS.sleep(1); //pode ser substituido por Thread.sleep(1000)
		        System.out.println("Bar " + name);
		    }
		    catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		};

		Thread thread = new Thread(runnable);
		thread.start();
	}
	
	private static void printingThreadNameWithExecutor(){
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(() -> {
		    String threadName = Thread.currentThread().getName();
		    System.out.println("Hello " + threadName);
		});
		executor.submit(() -> {
		    String threadName = Thread.currentThread().getName();
		    System.out.println("Hello " + threadName);
		});
//		É necessário sempre finalizar o executor, caso contrário a aplicação não termina
//		executor.shutdown();
//		melhor maneira de finalizar um executor
		try {
		    System.out.println("attempt to shutdown executor");
		    executor.shutdown();
		    executor.awaitTermination(5, TimeUnit.SECONDS);
		}
		catch (InterruptedException e) {
		    System.err.println("tasks interrupted");
		}
		finally {
		    if (!executor.isTerminated()) {
		        System.err.println("cancel non-finished tasks");
		    }
		    executor.shutdownNow();
		    System.out.println("shutdown finished");
		}

	}
	
	private static void usingCallableAndFuture() throws InterruptedException, ExecutionException, TimeoutException{
//		Callable parece com Runnable porém pode retorar um valor e lançar uma checked exception
		Callable<Integer> task = () -> {
		    try {
		        TimeUnit.SECONDS.sleep(2);//esperando dois segundos para forçar o TimeoutException
		        return 123;
		    }
		    catch (InterruptedException e) {
		        throw new IllegalStateException("task interrupted", e);
		    }
		};
		
		ExecutorService executor = Executors.newFixedThreadPool(1);
//		Future é uma classe especial usada para recuperar o retorno de um Callable
		Future<Integer> future = executor.submit(task);

		System.out.println("future done? " + future.isDone());
//		future.get lança excpetion caso o executor.shutdownNow() tenha sido executado
//		executor.shutdownNow();
		
		Integer result = 0;
//		Any call to future.get() will block and wait until the underlying callable has been terminated
//		result = future.get();//lança InterruptedException, ExecutionException

		result = future.get(1, TimeUnit.SECONDS);//can throw a TimeoutException
		
		System.out.println("future done? " + future.isDone());
		System.out.print("result: " + result);
	}
	
	private static void invokeAll() throws InterruptedException{
		ExecutorService executor = Executors.newWorkStealingPool();

		List<Callable<String>> callables = Arrays.asList(
		        () -> "task1",
		        () -> "task2",
		        () -> "task3");

		executor.invokeAll(callables)//invoke a list of Callable
		    .stream()
		    .map(future -> {
		        try {
		            return future.get();
		        }
		        catch (Exception e) {
		            throw new IllegalStateException(e);
		        }
		    })
		    .forEach(System.out::println);
	}
	
	private static void invokeAny() throws InterruptedException, ExecutionException{
		//Instead of returning future objects this method blocks until the first callable terminates and returns the result of that callable.
		ExecutorService executor = Executors.newWorkStealingPool();
		
		/* Executors.newWorkStealingPool();
		 * This factory method is part of Java 8 and returns an executor of type ForkJoinPool 
		 * which works slightly different than normal executors. 
		 * Instead of using a fixed size thread-pool ForkJoinPools are created for a given parallelism size 
		 * which per default is the number of available cores of the hosts CPU.
		 * */

		List<Callable<String>> callables = Arrays.asList(
		    callable("task1", 2),
		    callable("task2", 1),
		    callable("task3", 3));

		String result = executor.invokeAny(callables);
		System.out.println(result);
	}
	
	/**
	 * The method returns a callable that sleeps for a certain amount of time until returning the given result:
	 * @param result
	 * @param sleepSeconds
	 * @return
	 */
	static Callable<String> callable(String result, long sleepSeconds) {
	    return () -> {
	        TimeUnit.SECONDS.sleep(sleepSeconds);
	        return result;
	    };
	}
	
}

package concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Todas as threads serão sincronizadas
 * Evita que uma tarefa comece antes da anterior.
 * Deve ser usado em casos que há dependência na execução
 * @author mario
 *
 */
public class CyclicBarrierTest {
	
	private void taskOne(){System.out.println("Performing task 1...");}
	private void taskTwo(){System.out.println("Performing task 2...");}
	private void taskThree(){System.out.println("Performing task 3...");}

	public void performTasks(CyclicBarrier c1, CyclicBarrier c2 ){
		try {
			taskOne();
			c1.await();//await until all thread reach this code...
			taskTwo();
			c2.await();//await until all thread reach this code...
			taskThree();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ExecutorService executor = null;
		try {
			
			//se esse número for menor que o do CyclicBarrier o programa travaria
			executor = Executors.newFixedThreadPool(4);
			CyclicBarrierTest test = new CyclicBarrierTest();
			
			//creating Cyclics Barriers
			CyclicBarrier c1 = new CyclicBarrier(4);
			CyclicBarrier c2 = new CyclicBarrier(4,() -> {System.out.println("ok, lets start task 3");});
			
			for (int i = 0; i < 4; i++) {
				executor.submit(() -> test.performTasks(c1, c2));
			}
		} finally{
			if (executor!=null) {
				executor.shutdown();
			}
		}
		
	}

}

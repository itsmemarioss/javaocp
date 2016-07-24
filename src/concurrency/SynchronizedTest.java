package concurrency;

import java.util.concurrent.*;

/**
 * Baseado no exemplo do livro OCP Java SE 8 Programmer II Study Guide
 * @author mario
 *Synchronizations is about protecting data integrity at the cost of performance
 */
public class SynchronizedTest {
	private int count = 0;

	private void incrementAndReport() {
		//bloco sincronizado toda thread que chega aqui tenta conseguir o bloqueio
		//caso não consiga ela aguarda... dessa forma os números são impressos na ordem
		synchronized (this) {
			System.out.println((++count) + " ");
		}
		//sem o synchronized os números podem ser impressos na ordem errada
		//poderia usar o synchronized no método como "modificador" da no mesmo 
	}
	
	public static void methodStaticSynchronized(){
		synchronized (SynchronizedTest.class) {//class object usado como monitor
			//.....
		}
	}

	public static synchronized void test(){}
	
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(20);
		try {
			SynchronizedTest st = new SynchronizedTest();

			for (int i = 0; i < 10; i++) {
				//criando threads com lambda que representa Runnable
				es.submit(() -> st.incrementAndReport());
			}
		} finally {
			//boa prática realizar shutdown no ExecutorService
			if(es!=null)es.shutdown();
		}
	}
}

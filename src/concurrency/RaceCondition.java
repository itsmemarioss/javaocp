package concurrency;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.*;

public class RaceCondition{
    static int count=0;
    //useful to perform atomic operations, it isn't necessery sync
    static AtomicInteger atomicCount = new AtomicInteger(0);
    
    public static void main(String []args) throws InterruptedException{
        ExecutorService exec = Executors.newFixedThreadPool(4);
        IntStream.range(0,2000).forEach(i -> exec.submit(RaceCondition::increment));
        exec.shutdown();//dont forget
        exec.awaitTermination(60, TimeUnit.SECONDS);
        System.out.println(count);
        System.out.println(atomicCount);
    }
    

	public static void increment(){
        count++;
        atomicCount.getAndIncrement();
    }
}

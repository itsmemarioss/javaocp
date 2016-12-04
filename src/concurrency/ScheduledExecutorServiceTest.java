package concurrency;

import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class ScheduledExecutorServiceTest {

	public static void main(String[] args) {
		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
		Runnable r = () -> System.out.println("inciando...");
		executor.schedule(r, 10, TimeUnit.SECONDS);
		executor.scheduleAtFixedRate(r, 5, 10, TimeUnit.SECONDS);
		//executor.shutdown();
		long a = 2;
		Stream<Long> s1 = Stream.of(2l,3l,4l,50l);
		Stream<Long> s = Arrays.asList(3,4,5,6).stream().mapToLong(x -> x).mapToObj(x -> x);
	}

}

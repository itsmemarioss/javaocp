package streamapi;

import java.util.Random;
import java.util.stream.Stream;

public class StreamTest {
	
	public static void main(String[] args) {
		Stream.generate(() -> new Random().nextInt(11)).distinct().limit(6).forEach(System.out::println);
		
	}

}

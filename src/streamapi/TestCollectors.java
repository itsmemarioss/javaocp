package streamapi;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestCollectors {
	public static void main(String[] args) {
		Stream<String> s = Stream.of("asdf","mário","leila","cachorras");
		int media = s.collect(Collectors.averagingInt(String::length)).intValue();
		System.out.println(media);
	}
}

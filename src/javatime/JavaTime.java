package javatime;

import java.time.ZoneId;

public class JavaTime {
	public static void main(String[] args) {
		ZoneId.getAvailableZoneIds()
			.stream()
			//.filter(s -> s.contains("BRA"))
			.forEach(System.out::println);
	}
}

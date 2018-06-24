package collections;

import java.util.HashMap;
import java.util.Map;


public class MapTest {
	public static void main(String[] args) {
		
		Map<String, Integer> map =  new HashMap<>();
		
		map.put("mario", 123);
		map.put("mario", 1234);
		
		map.put("santos", null);
		
		System.out.println(map);
		
		//new java 8 methods 
		map.putIfAbsent("julia", null);
		System.out.println(map);
		map.putIfAbsent("julia", 1234);
		map.putIfAbsent("julia", 5678);
		System.out.println(map);
		
		//merge
		map.merge("mario", 56789, Integer::sum);
		
		System.out.println(map);		
		
		//computeIfPresent //BiFunction
		map.computeIfPresent("mario", (k,v) -> v-1);
		System.out.println(map);
		//computeIfAbsent //Function
		//since there is no value already in the map, a Funciotn is used instead of a BiFunction
		map.computeIfAbsent("santos", (k) -> 1);
		System.out.println(map);
		
	}
}

package streamapi;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestCollectors {
	public static void main(String[] args) {

		/*Stream<String> s = Stream.of("asdf","mário","leila","cachorras");
		int media = s.collect(Collectors.averagingInt(String::length)).intValue();
		System.out.println(media);*/
		
		List<Book> l = Arrays.asList(new Book(4.5), new Book(5.8), new Book(13l));
		Stream<Book> books = l.stream();
		books.map(b->b.value).reduce(BigDecimal::add).ifPresent(System.out::println);
		
		double d = l.stream().map(b->b.value).reduce(0.0,(i,b)->i+b.doubleValue(),(d1,d2)->d1+d2);
		System.out.println(d);
		
		List<Book> list = l.stream().collect(ArrayList::new,(a,b)->a.add(b),(a1,a2)->a1.addAll(a2));
		System.out.println(list);
		
		List<String> strings = l.stream().map(Book::toString).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		strings.forEach(System.out::println);
	}
	
	static class Book{
		BigDecimal value;
		public Book (double value){
			this.value = new BigDecimal(value);
		}
	}
}

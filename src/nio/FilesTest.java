package nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FilesTest {

	public static void main(String[] args) throws IOException {
		Path p = Paths.get("/home/mario/Música");

		Stream<Path> stream = null;

		//stream = Files.list(p);
		//stream.forEach(System.out::println);
		
		//stream = Files.walk(p);
		//stream.forEach(System.out::println);
		
		stream = Files.find(p, Integer.MAX_VALUE, (ph,a) -> a.isDirectory());
		stream.forEach(System.out::println);
	}

}

package nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadingLinesOfFile {

	public static void main(String[] args) throws IOException {
		Path names = Paths.get("names");
		Files.lines(names).filter(s->s.length()>5).forEach(System.out::println);
	}

}

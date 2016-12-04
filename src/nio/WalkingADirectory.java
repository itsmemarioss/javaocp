package nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * iterates over a diretory and output all of the files that end with .java
 * @author mario
 *
 */
public class WalkingADirectory {

	public static void main(String[] args) throws IOException {
		Path p = Paths.get("");
		System.out.println(p.toAbsolutePath().normalize());
		
		System.out.println("listing only directories");
		//Return a lazily populated Stream, the elements of which are the entries in the directory. The listing is not recursive
		Files.list(p).filter(Files::isDirectory).forEach(System.out::println);
		System.out.println("walking...");
		
		Files.walk(p).filter(ph -> ph.toString().endsWith(".java")).forEach(System.out::println);
	}

}

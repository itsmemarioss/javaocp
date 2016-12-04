package nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CreatingDirectories {

	public static void main(String[] args) throws IOException {
		System.out.println("Creating /home/mario");
		Files.createDirectory(Paths.get("/home/mario"));
		
		System.out.println("Creating /home/mario/tmp");
		Files.createDirectories(Paths.get("/home/mario/tmp"));
	}
}

package io;

import java.io.Console;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class ConsoleTest {

	public static void main(String[] args) throws IOException {
		/*Console console = System.console();
		if(console==null) throw new IllegalStateException("No Console is available!");
		
		String name = console.readLine("Type your name:");
		console.format("your name is %",name);
		console.writer().println();*/

		
		boolean test = Paths.get("/user/tree/../monkey").equals(Paths.get("/user/monkey"));
		System.out.println(test);
		test=Files.isSameFile(Paths.get("/user/tree/../monkey"), Paths.get("/user/monkey"));
		System.out.println(test);
	}

}

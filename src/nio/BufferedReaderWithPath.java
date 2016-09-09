package nio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BufferedReaderWithPath {

	public static void main(String[] args) throws IOException {
		// reading a file
		Path p = Paths.get("names");
		try (BufferedReader br = Files.newBufferedReader(p, Charset.defaultCharset())) {
			String newLine = null;
			while ((newLine = br.readLine()) != null) {
				System.out.println(newLine);
			}
		}

		// writing in a file
		p = Paths.get("names");
		/*
		 * This is because the constructor of FileWriter you are using truncates
		 * the file if it already exists.
		 * 
		 * If you want to append the data instead, use:
		 * 
		 * new FileWriter(theFile, true);
		 */
		try (BufferedWriter bw = Files.newBufferedWriter(p, Charset.defaultCharset())) {
			// bw.append("new string");
			// bw.flush();
			//clear the file, truncate the file
		}

		List<String> lines = Files.readAllLines(p);
		lines.forEach(System.out::println);

	}

}

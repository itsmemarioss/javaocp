package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintWriterTest {
	public static void main(String[] args) {
		File f = new File("/home/mario/test.txt");
		try(PrintWriter pw = new PrintWriter(f)){
			pw.println("esse é o meu arquivo");
			pw.println("escrito com o");
			pw.print(PrintWriter.class);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

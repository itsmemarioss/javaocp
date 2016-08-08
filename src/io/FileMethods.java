package io;

import java.io.File;
import java.util.Arrays;

public class FileMethods {
	
	private static final String PATH = "/home/mario/Desenvolvimento/temp";
	
	public static void main(String[] args) {
		File f = new File(PATH);
		System.out.println("exists(): "+f.exists());
		System.out.println("lastModified(): "+f.lastModified());
		System.out.println("isDirectory(): "+f.isDirectory());
		System.out.println("isFile(): "+f.isFile());
		System.out.println("listFiles()");
		Arrays.stream(f.listFiles()).forEach(System.out::println);
	}

}

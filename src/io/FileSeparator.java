package io;

import java.io.File;

public class FileSeparator {

	public static void main(String[] args) {
		System.out.println(System.getProperty("file.separator"));
		System.out.println(File.separator);
	}
}

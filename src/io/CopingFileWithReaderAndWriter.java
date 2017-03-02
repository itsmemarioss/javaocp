package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopingFileWithReaderAndWriter {
	public static void main(String[] args) throws IOException {
		
		try(BufferedReader r = new BufferedReader( new FileReader("names"));
			BufferedWriter w= new BufferedWriter( new FileWriter("names_copy",true))){
		
		String line = null;

		
		while ((line = r.readLine())!=null) {
			System.out.println(line);
			w.write(line);
			w.newLine();
		}
		
		}
//		while ((line = r.readLine())!= null) {
//			w.append(line);
//			w.newLine();
//		}
//		w.close();
	}

}

package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * based on the book OCP
 * @author mario
 *
 */
public class CopyFileSample {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
//		if file already exists, it will be overridden by this code
		File source = new File("test");
		File destination = new File("test_copy");
		
//		the resources will be closed at the end by the try-with-resources
		try(InputStream is = new FileInputStream(source);
				OutputStream os = new FileOutputStream(destination)){
			int b = 0;
			while ( (b = is.read())!= -1 ) {
				os.write(b);
			}
		}
	}
}

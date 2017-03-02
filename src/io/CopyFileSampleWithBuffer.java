package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * based on the book OCP
 * Using Buffered{Input|Output}Stream
 * @author mario
 *
 */
public class CopyFileSampleWithBuffer {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
//		if file already exists, it will be overridden by this code
		File source = new File("test");
		File destination = new File("test_copy");
		
//		the resources will be closed at the end by the try-with-resources
		/*try(InputStream is = new BufferedInputStream( new FileInputStream(source));
				OutputStream os = new BufferedOutputStream(new FileOutputStream(destination))){
			byte[] buffer = new byte[1024];
			int lengthRead;
			while ( (lengthRead = is.read(buffer))> 0 ) {
				os.write(buffer, 0, lengthRead);
				os.flush();
			}
		}*/
	}
}

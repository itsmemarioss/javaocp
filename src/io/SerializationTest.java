package io;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author mario
 *
 */
public class SerializationTest implements Serializable{
	
	private int a;

	public SerializationTest(int a) {
		super();
		this.a = a;
	}
	
	@Override
	public String toString() {
		return "SerializationTest [a=" + a + "]";
	}
	
	public static void main(String[] args) {
		try(FileOutputStream fos = new FileOutputStream("test.ser");
			FileInputStream fis = new FileInputStream("test.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			ObjectInputStream ois = new ObjectInputStream(fis);) {
			
			oos.writeObject(new SerializationTest(10));
			while (true) {
				SerializationTest test = (SerializationTest) ois.readObject();
				System.out.println(test);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			System.out.println("fim do arquivo");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}

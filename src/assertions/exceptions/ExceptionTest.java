package assertions.exceptions;

import java.io.IOException;

public class ExceptionTest {
	public static void main(String[] args) throws Exception {
		try{
			throw new IOException("IO");
		}catch(IOException e){
			System.out.println(e.getMessage());
			throw new Exception("Exception thrown inside catch");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			System.out.println("finally");
		}
		
		System.out.println("terminou");
	}
}

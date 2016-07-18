package assertions.exceptions;

import java.io.IOException;

public class AssertTest {
	public static void main(String[] args) throws IOException{
		String n = null;
		assert n!= null:"n não é diferente de null";
	}
}

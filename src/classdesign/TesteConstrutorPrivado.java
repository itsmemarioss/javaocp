package classdesign;

import java.util.ArrayList;

public class TesteConstrutorPrivado {
	private TesteConstrutorPrivado(){}
	
	public interface MyIn{}
	
	public static void main(String[] args) {
		Object obj = "";
		
		if ( obj instanceof TesteConstrutorPrivado.MyIn){
			
		}
		
//		ArrayList<? extends Number> list = new ArrayList<Number>();
//		list.add(Integer.MAX_VALUE);
//		list.add(Double.MAX_VALUE);
//		
//		//with super you can add in the list
//		ArrayList<? super Number> list = new ArrayList<Number>();
//		list.add(Integer.MAX_VALUE);
//		list.add(Double.MAX_VALUE);
		
	}
}
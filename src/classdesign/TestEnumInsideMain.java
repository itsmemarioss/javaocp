package classdesign;

import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

public class TestEnumInsideMain {

	enum Teste{
		OI, OOI, OOOI
	}
	
	static class Oi{
		int i = 2;
		public Oi(int i){
			this.i = i;
		}
		@Override
		public String toString() {
			return i+"";
		}
	}
	
	public static void main(String[] args) {
		Teste t = Teste.OI;
		switch (t){
		case OI:break;
		}
		LongStream.of(2,3,5);
		
		List<Oi> dList = Arrays.asList(new Oi(1),new Oi(2)); 
		dList.stream().forEach(x->{ x = new Oi(5); }); 
		dList.stream().forEach(d->System.out.println(d));
		
	}
	
	

}

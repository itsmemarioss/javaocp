package classdesign;

/**
 * Classe baseada na questão enthuware.ocpjp.v8.2.1726
 * What will the following code print when compiled and run?
 * 
 * Adicionado outras inner classes baseadas na documentação Oracle
 * @author mario
 *
 */

public class Onion {
	private String data = "skin";

	
	// because an inner class is associated with an instance, it cannot define any static members itself.
	private class Layer extends Onion {
		String data = "thegoodpart";
		//sem a sobrescria a execução entra em loop, o que é um coportamento que gera exceção 
		/*public String getData() {
			return data;
		}*/
	}
	
	//Static nested classes do not have access to other members non-static
	private static class Teste{
		public void doIt(){
			//data = "";//doe not compile
		}
	}

	public String getData() {
		return new Layer().getData();
	}

	public static void main(String[] args) {
		Onion o = new Onion();
		System.out.println(o.getData());
		
		Onion.Teste t = new Onion.Teste();
		//To instantiate an inner class, you must first instantiate the outer class. Then, create the inner object within the outer object 
		Onion.Layer l = new Onion().new Layer();//strange but it is true
	}
}
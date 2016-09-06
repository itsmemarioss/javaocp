package classdesign;

/**
 * All enums implicitly extend java.lang.Enum. 
 * Because a class can only extend one parent, the Java language does not support multiple inheritance of state, 
 * and therefore an enum cannot extend anything else.
 * @author mario
 *
 */
public enum Planet{
	
	EARTH("Terra"), 
	MARS("Marte");
	
	private final String name;
	
	private Planet(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public static void main(String[] args) {
		Planet e = Planet.EARTH;
		System.out.println("new name: " +e.getName());
	}
	
	
}

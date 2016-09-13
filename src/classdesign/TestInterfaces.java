package classdesign;

public class TestInterfaces implements One, Two{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * deve sobrescrever os métodos para que não haja erro de compilação
	 * ao se sobrescrever acaba a ambiguidade
	 */
	
	@Override
	public void defaultMethod(){}

	@Override
	public void otherMethod() {}

}

interface One{
	int field = 0;
	default void defaultMethod(){}
	void otherMethod();
}

interface Two{
	int field = 0;
	default void defaultMethod(){}
	void otherMethod();
}
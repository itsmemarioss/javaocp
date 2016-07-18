package generics;

public interface TestGenerics {

	public <T> T teste(T t);
	
	class TestInterface<U> implements TestGenerics{
		
		@Override
		public<U> U teste(U u){
			return null;
		}
	} 
}

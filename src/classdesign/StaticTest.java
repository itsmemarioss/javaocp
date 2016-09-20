package classdesign;

public class StaticTest {
	//chamado uma vez quando JVM carrega a classes
	static
	{
		System.out.println("In static");
	}

	public StaticTest(){
		System.out.println("In constructor");
	}
	public static class StaticClass{}
	public class NonStaticClass{}
	//chamado sempre antes do construtor
	{ 
		System.out.println("In non - static");
	}
	//são executados na ordem em que aparecem
	{ 
		System.out.println("In non - static 2");
	}
	
	public static void main(String args[ ]){
		StaticTest st1;//1
		System.out.println(" 1 ");
		st1 = new StaticTest();//2
		System.out.println(" 2 ");
		StaticTest st2 = new StaticTest(); //3    
		new  StaticTest.StaticClass(); //correct way to create a inner static class
		
	} 
}

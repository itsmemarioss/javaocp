package classdesign;

public class SwitcheTestEnum {

	public enum Color{
		BLUE, RED, YELLOW
	}
	public static void main(String[] args) {
		Color c = Color.RED;
		switch (c) {
		case RED: System.out.println("red");
		case BLUE: System.out.println("red"); break;
		default:
			break;
		}
	}
}

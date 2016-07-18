package javatime;

import java.util.Locale;

public class LocaleTest {
	public static void main(String[] args) {
		Locale l = Locale.getDefault();
		System.out.println(l);
		l=new Locale.Builder().build();
		System.out.println(l);
	}
}

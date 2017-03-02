package i18n.l10n;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class ResourceBundleTest {
	public static void main(String[] args) {
		System.out.println(Locale.getDefault());
		
		ResourceBundle rm = ResourceBundle.getBundle("Zoo", new Locale("pt","PT"));
		
		//exception if there is no such property
		System.out.println(rm.getString("hello"));
		
		Properties prop = new Properties();
		rm.keySet().stream().forEach(k -> prop.put(k, rm.getString(k)));
		
		System.out.println(prop.getProperty("helllo"));//does not throw exception
		System.out.println(prop.getProperty("helllo","não encontrado"));
		System.out.println(prop.get("helllo"));//does not throw exception
	}
}

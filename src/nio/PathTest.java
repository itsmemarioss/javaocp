package nio;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {
	public static void main(String[] args) {
		Path current = FileSystems.getDefault().getPath(".");
		
		/*  
		  /home/mario/workspace/OCP/.  
		 */
		System.out.println(current.toAbsolutePath());
		
		Path p1 = Paths.get("/home/mario/workspace/OCP/test");
		Path p2 = Paths.get("test");
		
		System.out.println(p1.equals(p2));
		
		p1 = Paths.get("/home/user/../mario");
		p2 = Paths.get("/home/mario");
		
		System.out.println(p1.equals(p2));
		
		p1 = Paths.get(".");
		p2 = Paths.get("");
		
		System.out.println(p1.equals(p2));
		
		System.out.println("normalize");
		
	}
}

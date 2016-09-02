package nio;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreatingAPath {

	public static void main(String[] args) {
		Path p = null;
		
		//Using Paths helper class
		p = Paths.get("/home/mario");
		System.out.println(p);
		//create a relative path
		p = Paths.get("src/nio");
		System.out.println(p);
		//using path saparator
		System.out.println(System.getProperty("path.separator"));
		p = Paths.get("/","home","mario");
		System.out.println(p);
		//using an URI (Uniform Resource Identifier)
		//URI begins with a schema that indicates the resource
		// ftp:// file:// html://
		//URI should be absolute at runtime
		try {
			p =  Paths.get(new URI("file:///home/mario/temp.csv"));
			System.out.println(p);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//using FileSystem class
		//to construct FileSystem class I used the factory FileSystems
		//this class can construct FileSystem from a remote machine as well
		FileSystem fs = FileSystems.getDefault();
		
		p = fs.getPath("/", "tmp"); 
		
		//File can be converted to Path and vice versa
		p = new File("/home/mario/workspace").toPath();
		p.toFile();
		//returns the number of name elements
		System.out.println(p.getNameCount());//return 3
		for (int i = 0; i < p.getNameCount(); i++) {
			System.out.println(p.getName(i));//home,mario,workspace
		}
	}

}

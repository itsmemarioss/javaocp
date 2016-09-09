package nio;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;


public class FileAttributes {

	public static void main(String[] args) throws IOException {
		Path p = Paths.get("bin");
		// common attributes
		// does not throw exception
		System.out.println(Files.isDirectory(p));
		System.out.println(Files.isRegularFile(p));
		System.out.println(Files.isSymbolicLink(p));
		System.out.println(Files.isHidden(p));//throws IOException

		p = Paths.get("names");
		
		System.out.println(Files.isReadable(p));
		System.out.println(Files.isExecutable(p));
		
		System.out.println(Files.size(p)+" bytes");//throws IOException
		
		FileTime fileTime = Files.getLastModifiedTime(p);
		System.out.println(fileTime);
		System.out.println(fileTime.toMillis());
		
		FileTime newTime = FileTime.fromMillis(System.currentTimeMillis());
		Files.setLastModifiedTime(p, newTime);
		
		UserPrincipal owner = Files.getOwner(p);
		System.out.println(owner);
		
		FileSystem fs = p.getFileSystem(); //FileSystems.getDefault();
		
		UserPrincipal root = fs.getUserPrincipalLookupService().lookupPrincipalByName("root");
		System.out.println(root);
		
		//java.nio.file.FileSystemException
		//Files.setOwner(p, root);//opearção não permitida no meu notebook, talvez seja necessário executar como root
		
		//working with views
		BasicFileAttributes basic = Files.readAttributes(p, BasicFileAttributes.class);
		System.out.println("directory "+basic.isDirectory());
		System.out.println("regular file "+basic.isRegularFile());
		System.out.println("symbolic link "+basic.isSymbolicLink());
		System.out.println("other "+basic.isOther());
		//System.out.println(" "+basic);
		System.out.println("size "+basic.size());
		System.out.println("creation time "+basic.creationTime());
		System.out.println("accessed "+basic.lastAccessTime());
		System.out.println("modified "+basic.lastModifiedTime());
		System.out.println("file key "+basic.fileKey());
		
		//you can modificate the attributes by this object
		BasicFileAttributeView view = Files.getFileAttributeView(p, BasicFileAttributeView.class);
		view.setTimes(newTime, null, null);//the null values are used here to keep the current value
	}

}

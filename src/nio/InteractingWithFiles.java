package nio;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class InteractingWithFiles {
	public static void main(String[] args) throws IOException {
		Path p1 = Paths.get("names");
		Path p2 = Paths.get("test");
		
		//if the files have the same content but are in different locations
		//isSameFile() will return false
		boolean isSame = Files.isSameFile(p1, p2);
		System.out.println(isSame);
		
		//criando diretórios
		try {
			
			//Files.createDirectory(Paths.get("/home/mario/Desenvolvimento/temp/newdirectory"));
			//cria todos que precisarem 
			//Files.createDirectories(Paths.get("/home/mario/Desenvolvimento/temp/newdirectory"));
			
			//copia apenas o diretório mas não seu conteúdo 
			//sem a opção REPLACE_EXISTING lança exception caso já exista a pasta destino
			Files.copy(Paths.get("/home/mario"), Paths.get("/home/mario/mario_old"),StandardCopyOption.REPLACE_EXISTING);
			
			//moves or renames a file or directory
			Files.move(Paths.get("test"), Paths.get("test_2"));
			
			//if directory is not empty it will throw an exception
			Files.delete(Paths.get("test_2"));
			//return boolean to indicate the operation result
			Files.deleteIfExists(Paths.get(""));
			
		} catch (FileAlreadyExistsException e) {//caso o diretório já exista 
			e.printStackTrace();
		}
	}
}

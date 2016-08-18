package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Object{Input|Output}Stream teste
 * A classe Animail implementa Serializable
 * @author mario
 *
 */

public class ObjectStreamSample {

	public static List<Animal> getAnimals(File dataFile) throws IOException, ClassNotFoundException{
		List<Animal> animals = new ArrayList<>();
		try(ObjectInputStream in =  new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)))){
			while (true) {
				Object object = in.readObject();
				if(object instanceof Animal){
					animals.add((Animal)object);
				}
			}
		}catch (EOFException e) {
			// TODO: handle exception
		}
		return animals;
	}
	
	public static void createAnimalsFile(List<Animal> animals, File dataFile) throws IOException{
		try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)))){
			for (Animal animal : animals) {
				out.writeObject(animal);
			}
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		List<Animal> list = new ArrayList<>();
		list.add(new Animal("Gaviaion!!"));
		list.add(new Animal("Lion!!"));
		
		File dataFile = new File("file.data");
		createAnimalsFile(list, dataFile);
		System.out.println(getAnimals(dataFile));

	}

}

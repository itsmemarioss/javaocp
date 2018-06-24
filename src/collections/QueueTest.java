package collections;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * FIFO - offer/poll/peek
 * LIFO - push/poll/peek
 * 
 * @author mario
 *
 */
public class QueueTest {
	
	public static void main(String[] args) {
		//ArrayDeque is a double-ended queue
		Queue<String> myQ = new ArrayDeque<>();
		
		//insert
		System.out.println("Inserting...");
		myQ.add("Mario");
		myQ.add("Paulinha");
		
		myQ.offer("Mariana");
		
		System.out.println(myQ);
		
		//remove
		System.out.println("Removing...");
		System.out.println(myQ.remove());
		System.out.println(myQ.poll());//may return null
		
		System.out.println(myQ);
		
		//examine
		System.out.println("Examining...");
		System.out.println(myQ.element());
		System.out.println(myQ.peek());//may return null
		
		System.out.println(myQ);
		
	}

}

import java.util.Iterator;
import java.util.LinkedList;

/*
 * Created on 24.Ara.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author db2admin
 * A LIFO queue implementation...
 * 
 */
public class Queue {
	
	private LinkedList queue = new LinkedList();
	
	public void enqueue(Object o) {
		queue.addLast(o);
	}
	
	public Object dequeue() {
		return queue.removeFirst();
	}
	
	public boolean isEmpty() {
		return queue.isEmpty();
	}
	
	public String toString() {
		StringBuffer buf = new StringBuffer();
		Iterator it = queue.iterator();
		while(it.hasNext()) {
			buf.append((it.next()).toString());
		}
		return buf.toString();
	}
	
}

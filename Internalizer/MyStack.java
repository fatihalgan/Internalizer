import java.util.Stack;
/*
 * Created on 24.Ara.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author db2admin
 *
 * A simple stack implementation that wraps around java.util.Stack.
 * Replaces the peek() method of java.util.Stack with a method named top().
 */
public class MyStack {
	
	private Stack stack = new Stack();
	
	public Object top() {
		return stack.peek();
	}
	
	public Object pop() {
		return stack.pop();
	}
	
	public void push(Object o) {
		stack.push(o);
	}
	
	public boolean isEmpty() {
		return stack.isEmpty();
	}

}

/*
 * Created on 24.Ara.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author db2admin
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ConstantExpression extends Expression {

	private int value = 0; 
	/**
	 * 
	 */
	public ConstantExpression(int value) {
		super();
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see Expression#evaluate()
	 */
	public int evaluate() {
		return value;
	}

	/* (non-Javadoc)
	 * @see Expression#infix()
	 */
	public String infix() {
		return "" + value;
	}

	/* (non-Javadoc)
	 * @see Expression#prefix()
	 */
	public String prefix() {
		return "" + value;
	}

	/* (non-Javadoc)
	 * @see Expression#postfix()
	 */
	public String postfix() {
		return "" + value;
	}

}

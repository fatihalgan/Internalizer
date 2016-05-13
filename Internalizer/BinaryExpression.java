/*
 * Created on 24.Ara.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author db2admin
 * 
 */

public class BinaryExpression extends Expression {

	private Expression left;
	private Expression right;
	private OperatorToken token;
	/**
	 * 
	 */
	public BinaryExpression(Expression left, Expression right, OperatorToken token) {
		super();
		this.left = left;
		this.right = right;
		this.token = token;
	}

	/* (non-Javadoc)
	 * @see Expression#evaluate()
	 */
	public int evaluate() {
		int resLeft = left.evaluate();
		int resRight = right.evaluate();
		System.out.println("Evaluating: " + resLeft + " " + token + " " + resRight);
		return token.apply(resLeft, resRight);
	}

	/* (non-Javadoc)
	 * @see Expression#infix()
	 */
	public String infix() {
		return "(" + left.infix() + token.toString() + right.infix() + ")";
	}

	/* (non-Javadoc)
	 * @see Expression#prefix()
	 */
	public String prefix() {
		return token.toString() + left.prefix() + right.prefix();
	}

	/* (non-Javadoc)
	 * @see Expression#postfix()
	 */
	public String postfix() {
		return left.postfix() + right.postfix() + token.toString();
	}

}

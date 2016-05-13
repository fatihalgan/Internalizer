/*
 * Created on 24.Ara.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author db2admin
 *
 * The abstract representation of an Expression. An Expression
 * can be a ConstantExpression which represents a simple integer
 * value, or an instance of BinaryExpression which represents
 * a complex expression which includes operator(s) and operands
 * that eventually will be evaluated to a ConstantExpression. 
 */
public abstract class Expression {

	/**
	 * 
	 */
	public Expression() {
		super();
	}
	
	/**
	 * @return
	 * Evaluates the result of the operation recursively.
	 */
	public abstract int evaluate();
	
	/**
	 * @return
	 * Returns the infix representation of the expression as a String
	 * Generates additional paranthesis before and after the expression
	 * because of the wierd bugs the infix representation can result in some cases.
	 */
	public abstract String infix();
	
	/**
	 * @return
	 * Returns the prefix representation of the expression as a String
	 */
	public abstract String prefix();
	
	/**
	 * @return
	 * Returns the postfix representation of the expression as a String
	 */
	public abstract String postfix();

}

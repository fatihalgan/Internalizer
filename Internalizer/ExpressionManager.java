/*
 * Created on 24.Ara.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author db2admin
 *
 * The application manager class..
 */

public interface ExpressionManager {

		
	/**
	 * Converts the infix represantation of the expression to 
	 * postfix representation using a standart algorithm.
	 */
	public void infixToPostFix();
	
	/**
	 * @return returns an instance of Expression class from 
	 * a String which represents a postfix expression. Uses a
	 * standart algorithm.  
	 */
	public Expression buildExpression();
	
	/**
	 * @param tok 
	 * inserts a given token to the expression. Used to
	 * insert a special END of expression token which is used in 
	 * conversion algorithms.
	 */
	public void insertToken(Token tok);
	
	/**
	 * @return returns a String representing the postfix form of the Expression.
	 */
	public String toPostfixString();
		
}

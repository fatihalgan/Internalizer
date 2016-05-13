/*
 * Created on 24.Ara.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author db2admin
 *
 * The input expression is translated into a stream of tokens. 
 * A token is either an operator ( +, -, *, /, ^, (, ), or = ) or a number.  
 * So tokens are represented by the abstract interface Token, 
 * which has two concrete subclasses, 
 * OperatorToken and NumberToken.
 * 
 * The statement 
 * public static final int LEFTP = 1, RIGHTP = 2, PLUS = 3, MINUS = 4,
 * TIMES = 5, DIVIDE = 6, EXPON = 7, END = 8, NUMBER = 9;
 * is used to define named constants representing each of the seven operator types 
 */


public interface Token {
	
	public static final int LEFTP = 1, RIGHTP = 2, PLUS = 3, MINUS = 4,
	TIMES = 5, DIVIDE = 6, EXPON = 7, END = 8, NUMBER = 9;
	
	
	/**
	 * @return
	 * returns true if the token is an operator, otherwise false.
	 */
	public boolean isOperator();
	
	/**
	 * @return
	 * returns true if the token is a number, otherwise false
	 */
	public boolean isNumber();
	
	/**
	 * @return
	 * returns an int value representing the constant definitions
	 * explained above.
	 */
	public int getType();
	
	/**
	 * @return
	 * returns the incoming priority of the token while
	 * converting the Expression to postfix notation. The algorithm
	 * used is a standart algorithm which can be found in class ExpressionManager.
	 */
	public int getICP();
	
	/**
	 * @return
	 * returns the in stack priority of the token while
	 * converting the Expression to postfix notation. The algorithm
	 * used is a standart algorithm which can be found in class ExpressionManager.
	 */
	public int getISP();
	
	
	/**
	 * @return
	 * returns an int value. If the token is an operator the int
	 * representation of the operator is returned. If it is a
	 * number then the value of the number is returned.
	 */
	public int getValue();
}

/*
 * Created on 24.Ara.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author db2admin
 * 
 * This class represents an operator token.
 */
public class OperatorToken implements Token {

	private int operation;

	public OperatorToken() {
		super();
	}

	public OperatorToken(int op) {
		this.operation = op;
	}

	
	/**
	 * @param left expression on the left of the operator 
	 * @param right expression on the right of the operator
	 * @return applies the operator to the left and right expressions
	 * and returns the result.
	 */
	public int apply(int left, int right) {
		switch (operation) {
		case PLUS:
			return left + right;
		case MINUS:
			return left - right;
		case TIMES:
			return left * right;
		case DIVIDE:
			return left / right;
		case EXPON:
			return (int) Math.pow(left, right);
		default:
			return 0;
		}
	}

	public int getICP() {
		switch (operation) {
		case LEFTP: 
			return 100;
		case RIGHTP:
			return 0;
		case PLUS:
			return 1;
		case MINUS:
			return 1;
		case TIMES:
			return 3;
		case DIVIDE:
			return 3;
		case EXPON: 
			return 6;
		case END:
			return 0;
		default:
			return 0;
		}
	}

	public int getISP() {
		switch (operation) {
		case LEFTP:
			return 0;
		case RIGHTP:
			return 99;
		case PLUS:
			return 2;
		case MINUS:
			return 2;
		case TIMES:
			return 4;
		case DIVIDE:
			return 4;
		case EXPON:
			return 5;
		case END:
			return -1;
		default:
			return 0;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Token#isOperator()
	 */
	public boolean isOperator() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Token#isNumber()
	 */
	public boolean isNumber() {
		return false;
	}

	public int getValue() {
		return operation;
	}

	public String toString() {
		switch (operation) {
		case LEFTP:
			return "(";
		case RIGHTP:
			return ")";
		case PLUS:
			return "+";
		case MINUS:
			return "-";
		case TIMES:
			return "*";
		case DIVIDE:
			return "/";
		case EXPON:
			return "^";
		default:
			return "";
		}
	}

	/* (non-Javadoc)
	 * @see Token#getType()
	 */
	public int getType() {
		switch(operation) {
		case LEFTP:
			return Token.LEFTP;
		case RIGHTP:
			return Token.RIGHTP;
		case PLUS:
			return Token.PLUS;
		case MINUS:
			return Token.MINUS;
		case TIMES:
			return Token.TIMES;
		case DIVIDE:
			return Token.DIVIDE;
		case EXPON:
			return Token.EXPON;
		case END:
			return Token.END;
		default:
			return 0;
		}
	}

}
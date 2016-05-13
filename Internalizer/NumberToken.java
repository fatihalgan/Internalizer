/*
 * Created on 24.Ara.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author db2admin
 *
 * This class represents a NumberToken
 */
public class NumberToken implements Token {

	private int number;
	
	/**
	 * @return Returns the number.
	 */
	public int getValue() {
		return number;
	}
	/**
	 * @param number The number to set.
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	public NumberToken() {
		super();
	}
	
	public NumberToken(int number) {
		this.number = number;
	}
	
	/* (non-Javadoc)
	 * @see Token#isOperator()
	 */
	public boolean isOperator() {
		return false;
	}

	/* (non-Javadoc)
	 * @see Token#isNumber()
	 */
	public boolean isNumber() {
		return true;
	}
	
	public String toString() {
		return "" + number;
	}
	/* (non-Javadoc)
	 * @see Token#getType()
	 */
	public int getType() {
		return Token.NUMBER;
	}
	/* (non-Javadoc)
	 * @see Token#getICP()
	 */
	public int getICP() {
		return 0;
	}
	/* (non-Javadoc)
	 * @see Token#getISP()
	 */
	public int getISP() {
		return 0;
	}

}

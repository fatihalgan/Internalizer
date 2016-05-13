import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

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
public class ExpressionManagerImpl implements ExpressionManager {

	private MyStack opStack = new MyStack();
	private Queue infix = new Queue();
	private MyStack expressionStack = new MyStack();
	private Queue postFix = new Queue();
	private Token curValue;
	
	/**
	 * @return Returns the infix.
	 */
	public Queue getInfix() {
		return infix;
	}
	/**
	 * @param infix The infix to set.
	 */
	public void setInfix(Queue infix) {
		this.infix = infix;
	}
	/**
	 * @return Returns the postFix.
	 */
	public Queue getPostFix() {
		return postFix;
	}
	/**
	 * @param postFix The postFix to set.
	 */
	public void setPostFix(Queue postFix) {
		this.postFix = postFix;
	}
	
	/**
	 * 
	 */
	public ExpressionManagerImpl() {
		super();
	}
	/* (non-Javadoc)
	 * @see ExpressionManager#infixToPostFix(Queue)
	 */
	public void infixToPostFix() {
		Token newToken, op;
		opStack.push(new OperatorToken(Token.END));
		do {
			newToken = getToken(infix);
			if(newToken.getType() == Token.NUMBER) {
				postFix.enqueue(curValue);
			} else if(newToken.getType() == Token.RIGHTP) {
				op = (Token)opStack.top();
				while(op.getType() != Token.LEFTP) {
					postFix.enqueue(op);
					opStack.pop();
					op = (Token)opStack.top();
				}
				opStack.pop(); //remove LPAREN
			} else if(newToken.getType() == Token.END) {
				while(!opStack.isEmpty()) {
					op = (Token)opStack.top();
					postFix.enqueue(op);
					opStack.pop();
				}
			} else if(newToken.getType() == Token.LEFTP) {
				opStack.push(newToken);
			} else if((newToken.getType() == Token.EXPON) ||
					(newToken.getType() == Token.DIVIDE) ||
					(newToken.getType() == Token.TIMES) ||
					(newToken.getType() == Token.PLUS) ||
					(newToken.getType() == Token.MINUS)) {
						op = (Token)opStack.top();
						while(newToken.getICP() <= op.getISP()) {
							postFix.enqueue(op);
							opStack.pop();
							op = (Token)opStack.top();
						}
						opStack.push(newToken);
			}
		} while(newToken.getType() != Token.END);	
	} 
		
	private Token getToken(Queue queue) {
		Token t = (Token)queue.dequeue();
		curValue = t;
		return t;
	}
	
	public String toPostfixString() {
		return postFix.toString();
	}

	/* (non-Javadoc)
	 * @see ExpressionManager#buildExpression(Queue)
	 */
	public Expression buildExpression() {
		do {
			Token newToken = getToken(postFix);
			if(newToken.getType() == Token.END) break;
			if(newToken.isNumber()) {
				Expression e = new ConstantExpression(newToken.getValue());
				expressionStack.push(e);
			} if(newToken.isOperator()) {
				Expression e1 = (Expression)expressionStack.pop();
				Expression e2 = (Expression)expressionStack.pop();
				Expression newExpression = new BinaryExpression(e2, e1, (OperatorToken)newToken); 
				expressionStack.push(newExpression);
			}
		} while(true);
		return (Expression)expressionStack.pop();
	}
	
	public void insertToken(Token tok) {
		infix.enqueue(tok);
	}
	
	public static void main(String[] args) {
		ExpressionManager man = new ExpressionManagerImpl();
		File file = new File("expression.txt");
		if(!file.exists()) {
			System.out.println("File Not Found: expression.txt");
			System.exit(0);
		}
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String line = null;
		try {
			System.out.print("The infix expression is: ");
			while((line = reader.readLine()) != null) {
				System.out.println(line);
				for(int i = 0; i < line.length(); i++) {
					char c = line.charAt(i);
					Token token = null;
					switch((char)c) {
						case '(': {
							token = new OperatorToken(Token.LEFTP);
							break;
						}
						case ')': {
							token = new OperatorToken(Token.RIGHTP);
							break;
						}
						case '+': {
							token = new OperatorToken(Token.PLUS);
							break;
						}
						case '-': {
							token = new OperatorToken(Token.MINUS);
							break;
						}
						case '*': {
							token = new OperatorToken(Token.TIMES);
							break;
						}
						case '/': {
							token = new OperatorToken(Token.DIVIDE);
							break;
						}
						case '^': {
							token = new OperatorToken(Token.EXPON);
							break;
						}
						default : {
							token = new NumberToken(Integer.parseInt(line.substring(i, i + 1)));
							if(!((token.getValue() >= 0) && (token.getValue() <= 9))) throw new NumberFormatException("File could not be parsed... A digit between 0 and 9 is expected.. Please check your expression file..");
						}
					}
					man.insertToken(token);
				}
			}
			man.insertToken(new OperatorToken(Token.END));
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
		man.infixToPostFix();
		System.out.println("The postfix form of the infix expression is: " + man.toPostfixString());
		Expression ex = man.buildExpression();
		System.out.println(ex.infix());
		int value = ex.evaluate();
		System.out.println("The result is: " + value);
	}

}

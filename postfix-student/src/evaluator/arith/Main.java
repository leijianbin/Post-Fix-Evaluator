package evaluator.arith;

import language.Operand;
import language.Operator;
import language.arith.MultOperator;
import language.arith.NegateOperator;
import parser.arith.ArithPostFixParser;
import stack.LinkedStack;
import stack.StackInterface;
import stack.StackUnderflowException;
import evaluator.IllegalPostFixExpressionException;
import evaluator.PostFixEvaluator;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArithPostFixEvaluator evaluator = new ArithPostFixEvaluator();
		Integer result = evaluator.evaluate("1");
		result = evaluator.evaluate("1 2 -");
	}

}

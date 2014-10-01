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

/**
 * An {@link ArithPostFixEvaluator} is a post fix evaluator over simple arithmetic expressions.
 *
 */
public class ArithPostFixEvaluator implements PostFixEvaluator<Integer> {

	private final StackInterface<Operand<Integer>> stack;
	
	
	/**
	 * Constructs an {@link ArithPostFixEvaluator}
	 */
	public ArithPostFixEvaluator(){
		
		this.stack = new LinkedStack<Operand<Integer>>();
		//initalize new stack and set it to null 
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer evaluate(String expr) {
		// TODO Use all of the things they've built so far to 
		// create the algorithm to do post fix evaluation
		if (expr == null)
			throw new NullPointerException("The expression must be non-null.");
		
		
		ArithPostFixParser parser = new ArithPostFixParser(expr);
		while(parser.hasNext()){
			switch(parser.nextType()){ 
			case OPERAND:
				//TODO What do we do when we see an operand? // aka a number
				//if the item is a number push it on the stack
				stack.push(parser.nextOperand());
				break;
			case OPERATOR:
				//TODO What do we do when we see an operator? //aka a "+,-,*,/,"
				Operand<Integer> c = stack.pop();
				//checks if theres another thing on the stack
				//Operand<Integer> d = stack.pop();
				//TESTS FOR DIFFERENT CONDITIONS:
				//*********if its negate then we only pop one object********
				Operator<Integer> f = parser.nextOperator();
				if (f.getNumberOfArguments()==1){
					//stack.push(d);//if there is only one operand it pushes d back onto the stack
					f.setOperand(0, c);//set it to set operator

				}
				else if(f.getNumberOfArguments()==2) {
					Operand<Integer> d = stack.pop(); //notice the order of the c and d.
					f.setOperand(0, d);//set it to set operator
					f.setOperand(1, c);//set it to set operator
				}
				Operand<Integer> result = f.performOperation();//perform operation and get value
				stack.push(result); // pop back on stack
				break;
			}
		}
		
		//TODO What do we return?
		if(stack.size() > 1)
			throw new IllegalPostFixExpressionException("Illegal Post Fix Expression");
		expr = stack.pop().getValue().toString();
		Integer x = Integer.valueOf(expr);
		return x ; // we return the last item in the stack ( number ) . else we throw an exception if there is more than one thing left
	}

}

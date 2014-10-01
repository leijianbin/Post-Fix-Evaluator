package stack;

/**
 * A {@link LinkedStack} is a stack that is implemented using a Linked List structure
 * to allow for unbounded size.
 *
 * @param <T> the elements stored in the stack
 */
//---------------------------------------------------------------------------------------------------------//
public class LinkedStack<T> implements StackInterface<T> {
	public int size;    // Size of stack
	public Node head; // Head Node 


	public class Node{
	public Node theNextNode; // Next Node pointer reference to the next node in the stack
	public T elem; // T generic element 
	
	}

	public LinkedStack(){
	size = 0; // sets size to zero for inital size of stack
	head = null; // initiates variable firstT to null ( This wil be the head node set to null  ) 
	}
//---------------------------------------------------------------------------------------------------------//
/**
 * {@inheritDoc}
 */
@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (head==null);
	}


/**
 * {@inheritDoc}
 */
@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
//---------------------------------------------------------------------------------------------------------//

/**
 * {@inheritDoc}
 */
@Override
	public void push(T elem) {
		// TODO Auto-generated method stub
		Node oldNode = head; // creates new node and points it to head 
		head = new Node(); 
		head.elem = elem;
		head.theNextNode = oldNode;
		size++;
	}


/**
 * {@inheritDoc}
 */
@Override
	public T pop() throws StackUnderflowException {
		if (isEmpty()){throw new StackUnderflowException();} // if empty it will throw a new stack underflow exception
		T elem = head.elem; // sets the T element to be inside the head ( First element)
		head = head.theNextNode; // sets link of head to the next node
		size--; // decreases the size becuase object was popped off
		return elem;
			
	}

/**
 * {@inheritDoc}
 */
@Override
	public T top() throws StackUnderflowException { // throws  underflow
		// TODO Auto-generated method stub
		return head.elem; // returns T element at head ( top ) of stack
	}
}

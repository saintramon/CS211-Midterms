/**
 * NAME: JASMIN, Ramon Emmiel P.
 * DATE: 3 October 2023
 * CLASS CODE: CS 211 9342
 */

/**
 * This class implements a generic stack using a linked list.
 *
 * @param <T> The type of elements stored in the stack.
 */
public class MyStack<T> implements MyStackInterface<T> {
    private Node<T> top;
    private int size;

    /**
     * Adds an element to the top of the stack.
     *
     * @param data The element to be pushed onto the stack.
     */
    @Override
    public void push(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            this.top = newNode;
        } else {
            newNode.setNext(this.top);
            this.top = newNode;
        }

        ++size;
    }

    /**
     * Removes and returns the element from the top of the stack.
     *
     * @return The element removed from the top of the stack.
     * @throws StackUnderflowException If the stack is empty.
     */
    @Override
    public T pop() throws StackUnderflowException {
        if (isEmpty()) {
            throw new StackUnderflowException("The Stack is Empty");
        } else {
            T currTop = this.top.getData();
            if (size == 1) {
                this.top = null;
            } else {
                this.top = this.top.getNext();
            }
            --size;
            return currTop;
        }
    }

    /**
     * Returns the element at the top of the stack without removing it.
     *
     * @return The element at the top of the stack.
     * @throws StackUnderflowException If the stack is empty.
     */
    @Override
    public T peek() throws StackUnderflowException {
        if (isEmpty()) {
            throw new StackUnderflowException("The stack is empty");
        } else {
            return top.getData();
        }
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return The size of the stack.
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Checks if the stack is empty.
     *
     * @return True if the stack is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return this.top == null;
    }
}
/**
 * NAME: JASMIN, Ramon Emmiel P.
 * DATE: 3 October 2023
 * CLASS CODE: CS 211 9342
 */

/**
 * A generic interface for a stack data structure.
 *
 * @param <T> The type of elements stored in the stack.
 */
public interface MyStackInterface<T> {
    /**
     * Pushes an element onto the top of the stack.
     *
     * @param data The element to be pushed onto the stack.
     */
    public void push(T data);

    /**
     * Pops and returns the element from the top of the stack.
     *
     * @return The element removed from the top of the stack.
     * @throws StackUnderflowException If the stack is empty when pop is called.
     */
    public T pop() throws StackUnderflowException;

    /**
     * Returns the element at the top of the stack without removing it.
     *
     * @return The element at the top of the stack.
     * @throws StackUnderflowException If the stack is empty when peek is called.
     */
    public T peek() throws StackUnderflowException;

    /**
     * Returns the number of elements in the stack.
     *
     * @return The size of the stack.
     */
    public int size();

    /**
     * Checks if the stack is empty.
     *
     * @return True if the stack is empty, false otherwise.
     */
    public boolean isEmpty();
}

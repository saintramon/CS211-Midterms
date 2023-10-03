/**
 * NAME: JASMIN, Ramon Emmiel P.
 * DATE: 3 October 2023
 * CLASS CODE: CS 211 9342
 */

/**
 * A generic Node class used in various data structures.
 *
 * @param <T> The type of data stored in the node.
 */
public class Node<T> {
    private T data;
    private Node<T> next;

    /**
     * Default constructor for a Node.
     * Initializes data and next pointer to null.
     */
    public Node() {
        this.data = null;
        this.next = null;
    }

    /**
     * Constructor for a Node with initial data.
     * Initializes data to the provided value and next pointer to null.
     *
     * @param data The initial data to be stored in the node.
     */
    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    /**
     * Constructor for a Node with initial data and next node.
     * Initializes data to the provided value and next pointer to the provided node.
     *
     * @param data The initial data to be stored in the node.
     * @param next The next node in the linked structure.
     */
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Get the data stored in the node.
     *
     * @return The data stored in the node.
     */
    public T getData() {
        return data;
    }

    /**
     * Get the next node in the linked structure.
     *
     * @return The next node in the linked structure, or null if none.
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Set the data stored in the node.
     *
     * @param data The data to be stored in the node.
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Set the next node in the linked structure.
     *
     * @param next The next node in the linked structure.
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }
}
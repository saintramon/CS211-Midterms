/**
 * NAME: JASMIN, Ramon Emmiel P.
 * DATE: 3 October 2023
 * CLASS CODE: CS 211 9342
 */

/**
 * Custom exception class for stack underflow situations.
 */
public class StackUnderflowException extends Exception {
    /**
     * Constructs a new StackUnderflowException with the specified error message.
     *
     * @param prompt The error message describing the stack underflow situation.
     */
    public StackUnderflowException(String prompt) {
        super(prompt);
    }
}

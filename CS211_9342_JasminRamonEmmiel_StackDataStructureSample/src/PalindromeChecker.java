/**
 * NAME: Jasmin, Ramon Emmiel P.
 * DATE: 3 October 2023
 * CLASS CODE: CS 211 9342
 *
 *
 * SAMPLE RUN 1:
 * This application helps you evaluate if a string is a palindrome or not
 * Please enter the string: madam
 * madam is a palindrome.
 *
 * SAMPLE RUN 2:
 * This application helps you evaluate if a string is a palindrome or not
 * Please enter the string: redder
 * redder is a palindrome.
 *
 * SAMPLE RUN 3:
 * This application helps you evaluate if a string is a palindrome or not
 * Please enter the string: Depth First Search
 * Depth First Search is not a palindrome.
 */

import java.util.*;

public class PalindromeChecker {
    public static void main(String[] args) {
        try {
            PalindromeChecker program = new PalindromeChecker();
            program.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() throws Exception {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("This application helps you evaluate if a string is a palindrome or not");
        System.out.print("Please enter the string: ");
        String input = keyboard.nextLine();
        if (isPalindrome(input))
            System.out.println(input + " is a palindrome.");
        else
            System.out.println(input + " is not a palindrome.");
    }

    /**
     * Checks whether a given string is a palindrome.
     *
     * @param string The string to be checked for palindrome property.
     * @return True if the string is a palindrome, false otherwise.
     * @throws StackUnderflowException If there is an issue with the stack operations.
     */
    public boolean isPalindrome(String string) throws StackUnderflowException {
        MyStack<Character> stack = new MyStack<>();

        int mid = string.length() / 2;
        int i = 0;
        Character currTop = null;

        while (i < mid) {
            stack.push(string.charAt(i));
            ++i;
        }

        if (string.length() % 2 != 0) {
            ++i;
        }

        for (; i < string.length(); i++) {
            currTop = stack.pop();
            if (currTop.charValue() != string.charAt(i)) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}

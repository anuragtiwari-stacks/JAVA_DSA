package _2Stack.Basic;

import java.util.Stack;

public class _4STLStack
{
    public static void main(String[] args)
    {
        // Create a stack of integers using Java's built-in Stack class
        Stack<Integer> stack = new Stack<>();

        // Push elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Stack after pushing 1, 2, 3: " + stack);

        // Peek at the top element
        System.out.println("Top element: " + stack.peek());

        // Pop elements from the stack
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());

        // Display the remaining stack
        System.out.println("Stack after popping: " + stack);

        // Check if the stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty());

        // Check if the stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}

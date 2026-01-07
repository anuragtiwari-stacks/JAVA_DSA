package _2Stack.Questions;

import java.util.Stack;

public class _3PushAtBottom
{
    // Method to push element at the bottom of the stack
    public static void pushAtBottom(Stack<Integer> stack, int value)
    {
        if (stack.isEmpty())
        {
            stack.push(value);
            return;
        }

        int top = stack.pop();
        pushAtBottom(stack, value);
        stack.push(top);
    }

    public static void main(String[] args)
    {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Original Stack: " + stack);

        pushAtBottom(stack, 5);

        System.out.println("After pushing 5 at bottom: " + stack);
    }
}

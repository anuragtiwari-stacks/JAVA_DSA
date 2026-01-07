package _2Stack.Questions;

import java.util.Stack;

public class _4InsertAtIndex
{
    // Method to insert value at a given index in the stack
    public static void insertAtIndex(Stack<Integer> stack, int index, int value)
    {
        if (index == 0)
        {
            stack.push(value);
            return;
        }

        if (stack.isEmpty())
        {
            throw new IllegalArgumentException("Index out of bounds");
        }

        int top = stack.pop();
        insertAtIndex(stack, index - 1, value);
        stack.push(top);
    }

    public static void main(String[] args)
    {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Original Stack: " + stack);

        int index = 1;
        int value = 99;

        insertAtIndex(stack, stack.size() - index, value);

        System.out.println("After inserting " + value + " at index " + index + ": " + stack);
    }

}

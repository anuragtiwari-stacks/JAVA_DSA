package _2Stack.Questions;

import java.util.Stack;

public class _2CopyStackSameOrder
{
    public static void main(String[] args)
    {
        // Original stack
        Stack<Integer> original = new Stack<>();
        original.push(10);
        original.push(20);
        original.push(30);

        System.out.println("Original Stack: " + original);

        // Temporary stack
        Stack<Integer> temp = new Stack<>();

        // Step 1: Move to temp to reverse
        while (!original.isEmpty())
        {
            temp.push(original.pop());
        }

        // New stack to copy into
        Stack<Integer> copy = new Stack<>();

        // Step 2: Restore original and build copy
        while (!temp.isEmpty())
        {
            int value = temp.pop();
            original.push(value); // Restore
            copy.push(value);     // Copy
        }

        System.out.println("Original Restored: " + original);
        System.out.println("Copied Stack: " + copy);
    }
}

package _04Stack.Questions;

import java.util.Stack;

public class _1ReverseWithTwoStacks
{
    public static void main(String[] args)
    {
        // First stack (original)
        Stack<Integer> original = new Stack<>();

        // Push some elements
        original.push(10);
        original.push(20);
        original.push(30);

        System.out.println("Original Stack: " + original);

        // Second stack (to hold reversed elements)
        Stack<Integer> reversed = new Stack<>();

        // Pop from original and push into reversed
        while (!original.isEmpty())
        {
            reversed.push(original.pop());
        }

        System.out.println("Reversed Stack: " + reversed);
    }
}

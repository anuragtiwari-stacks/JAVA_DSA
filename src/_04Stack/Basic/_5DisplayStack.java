package _04Stack.Basic;

import java.util.Stack;

public class _5DisplayStack
{
    public static void main(String[] args)
    {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // 1. Using for loop (index-based)
        System.out.print("Display using for loop: ");
        for (int i = 0; i < stack.size(); i++)
        {
            System.out.print(stack.get(i) + " ");
        }
        System.out.println();

        // 2. Using for-each loop (enhanced for loop)
        System.out.print("Display using for-each loop: ");
        for (int val : stack)
        {
            System.out.print(val + " ");
        }
        System.out.println();

        // 3. Using STL (built-in toString method)
        System.out.println("Display using STL print: " + stack);
    }
}

package _04Stack.Questions;

import java.util.Stack;

public class _9PreviousGreaterElementStack
{

    public static void previousGreaterElement(int[] arr)
    {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++)
        {
            while (!stack.isEmpty() && stack.peek() <= arr[i])
            {
                stack.pop();
            }

            if (stack.isEmpty())
            {
                result[i] = -1;
            }
            else
            {
                result[i] = stack.peek();
            }

            stack.push(arr[i]);
        }

        System.out.println("Previous Greater Elements:");
        for (int i = 0; i < n; i++)
        {
            System.out.println(arr[i] + " -> " + result[i]);
        }
    }

    public static void main(String[] args)
    {
        int[] input = {4, 5, 2, 10, 8};
        previousGreaterElement(input);
    }

}

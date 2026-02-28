package _04Stack.Questions;

import java.util.Stack;

public class _9NextSmallerElementStack
{
    public static void nextSmallerElement(int[] arr)
    {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--)
        {
            while (!stack.isEmpty() && stack.peek() >= arr[i])
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

        System.out.println("Next Smaller Elements:");
        for (int i = 0; i < n; i++)
        {
            System.out.println(arr[i] + " -> " + result[i]);
        }
    }

    public static void main(String[] args)
    {
        int[] input = {4, 5, 2, 10, 8};
        nextSmallerElement(input);
    }
}

/*
DRY RUN:

arr = [4, 5, 2, 10, 8]
index    0  1  2  3   4

Start from right (i = n-1)

i = 4, arr[i] = 8
stack = []
stack empty → result[4] = -1
push 8
stack = [8]

i = 3, arr[i] = 10
stack.peek() = 8 < 10 → no pop
result[3] = 8
push 10
stack = [8, 10]

i = 2, arr[i] = 2
stack.peek() = 10 >= 2 → pop
stack.peek() = 8  >= 2 → pop
stack empty
result[2] = -1
push 2
stack = [2]

i = 1, arr[i] = 5
stack.peek() = 2 < 5 → no pop
result[1] = 2
push 5
stack = [2, 5]

i = 0, arr[i] = 4
stack.peek() = 5 >= 4 → pop
stack.peek() = 2 < 4 → stop
result[0] = 2
push 4
stack = [2, 4]

Final Result:
[2, 2, -1, 8, -1]
*/

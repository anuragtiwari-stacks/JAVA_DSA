package _04Stack.Questions;

import java.util.Stack;

public class _9PreviousSmallerElementStack
{
    public static void previousSmallerElement(int[] arr)
    {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++)
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

        for (int i = 0; i < n; i++)
        {
            System.out.println(arr[i] + " -> " + result[i]);
        }
    }

    public static void main(String[] args)
    {
        int[] arr = {4, 5, 2, 10, 8};
        previousSmallerElement(arr);
    }
}

/*
DRY RUN:

arr = [4, 5, 2, 10, 8]
index    0  1  2  3   4

Start from left (i = 0)

i = 0, arr[i] = 4
stack = []
stack empty → result[0] = -1
push 4
stack = [4]

i = 1, arr[i] = 5
stack.peek() = 4 < 5 → no pop
result[1] = 4
push 5
stack = [4, 5]

i = 2, arr[i] = 2
stack.peek() = 5 >= 2 → pop
stack.peek() = 4 >= 2 → pop
stack empty
result[2] = -1
push 2
stack = [2]

i = 3, arr[i] = 10
stack.peek() = 2 < 10 → no pop
result[3] = 2
push 10
stack = [2, 10]

i = 4, arr[i] = 8
stack.peek() = 10 >= 8 → pop
stack.peek() = 2 < 8 → stop
result[4] = 2
push 8
stack = [2, 8]

Final Result:
[-1, 4, -1, 2, 2]
*/

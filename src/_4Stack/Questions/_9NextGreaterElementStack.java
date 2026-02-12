/*
🔁 Step-by-Step Logic
For each arr[i] (from right to left):

→ Pop all elements from the stack that are ≤ arr[i]
   Because they’re not useful anymore (they can’t be the next greater for this or any earlier element).

→ If the stack is empty → No greater element → result[i] = -1

→ Else → Top of the stack is the next greater → result[i] = stack.peek()

→ Push arr[i] to stack → it might be useful for earlier elements
*/


package _4Stack.Questions;

import java.util.Stack;

public class _9NextGreaterElementStack
{

    public static void nextGreaterElement(int[] arr)
    {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--)
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

        System.out.println("Next Greater Elements:");
        for (int i = 0; i < n; i++)
        {
            System.out.println(arr[i] + " -> " + result[i]);
        }
    }

    public static void main(String[] args)
    {
        int[] input = {4, 5, 2, 10, 8};
        nextGreaterElement(input);
    }

}
/*
Input: {4, 5, 2, 10, 8}
stack = []
result = [0, 0, 0, 0, 0]

i = 4, arr[i] = 8
→ stack is empty → result[4] = -1
→ push 8 → stack = [8]

i = 3, arr[i] = 10
→ 8 <= 10 → pop
→ stack is empty → result[3] = -1
→ push 10 → stack = [10]

i = 2, arr[i] = 2
→ 10 > 2 → result[2] = 10
→ push 2 → stack = [10, 2]

i = 1, arr[i] = 5
→ 2 <= 5 → pop
→ 10 > 5 → result[1] = 10
→ push 5 → stack = [10, 5]

i = 0, arr[i] = 4
→ 5 > 4 → result[0] = 5
→ push 4 → stack = [10, 5, 4]

Final result: [5, 10, 10, -1, -1]
*/


package _2Stack.Questions;

import java.util.Stack;

public class _12VisiblePeopleInQueue
{
    public static int[] visiblePeople(int[] heights)
    {
        int n = heights.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++)
        {
            while (!stack.isEmpty() && heights[stack.peek()] < heights[i])
            {
                result[stack.peek()]++;
                stack.pop();
            }

            if (!stack.isEmpty())
            {
                result[stack.peek()]++;
            }

            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] heights = {10, 6, 8, 5, 11, 9};
        int[] ans = visiblePeople(heights);

        for (int i = 0; i < ans.length; i++)
        {
            System.out.println(heights[i] + " -> " + ans[i]);
        }
    }
}

/*
DRY RUN:

heights = [10, 6, 8, 5, 11, 9]
index       0   1  2  3   4   5

--------------------------------
i = 0, height = 10
stack = []
push 0
stack = [0]

--------------------------------
i = 1, height = 6
10 < 6 ? NO
stack not empty → result[0]++
result = [1, 0, 0, 0, 0, 0]
push 1
stack = [0, 1]

--------------------------------
i = 2, height = 8
6 < 8 → pop 1, result[1]++
result = [1, 1, 0, 0, 0, 0]

10 < 8 ? NO
stack not empty → result[0]++
result = [2, 1, 0, 0, 0, 0]
push 2
stack = [0, 2]

--------------------------------
i = 3, height = 5
8 < 5 ? NO
stack not empty → result[2]++
result = [2, 1, 1, 0, 0, 0]
push 3
stack = [0, 2, 3]

--------------------------------
i = 4, height = 11
5 < 11 → pop 3, result[3]++
8 < 11 → pop 2, result[2]++
10 < 11 → pop 0, result[0]++

result = [3, 1, 2, 1, 0, 0]
push 4
stack = [4]

--------------------------------
i = 5, height = 9
11 < 9 ? NO
stack not empty → result[4]++
result = [3, 1, 2, 1, 1, 0]
push 5
stack = [4, 5]

--------------------------------
FINAL RESULT:
[3, 1, 2, 1, 1, 0]
--------------------------------
*/

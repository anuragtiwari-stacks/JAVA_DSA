package _04Stack.Questions;

import java.util.Stack;

public class _11LargestRectangle
{
    public static int largestRectangleArea(int[] heights)
    {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Calculate Previous Smaller Element (left boundary)
        for (int i = 0; i < n; i++)
        {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i])
            {
                stack.pop();
            }

            if (stack.isEmpty())
            {
                left[i] = 0;
            }
            else
            {
                left[i] = stack.peek() + 1;
            }

            stack.push(i);
        }

        stack.clear();

        // Calculate Next Smaller Element (right boundary)
        for (int i = n - 1; i >= 0; i--)
        {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i])
            {
                stack.pop();
            }

            if (stack.isEmpty())
            {
                right[i] = n - 1;
            }
            else
            {
                right[i] = stack.peek() - 1;
            }

            stack.push(i);
        }

        // Calculate max area using width = right[i] - left[i] + 1
        int maxArea = 0;

        for (int i = 0; i < n; i++)
        {
            int width = right[i] - left[i] + 1;
            int area = heights[i] * width;

            if (area > maxArea)
            {
                maxArea = area;
            }
        }

        return maxArea;
    }

    public static void main(String[] args)
    {
        int[] heights = {2, 1, 5, 6, 2, 3};
        int maxArea = largestRectangleArea(heights);
        System.out.println("Largest Rectangle Area: " + maxArea);
    }

}

/*
INPUT:
heights = [2, 1, 5, 6, 2, 3]
index      0  1  2  3  4  5

--------------------------------
LEFT ARRAY (Previous Smaller + 1)
--------------------------------
left[0] = 0
left[1] = 0
left[2] = 2
left[3] = 3
left[4] = 2
left[5] = 5

LEFT = [0, 0, 2, 3, 2, 5]

--------------------------------
RIGHT ARRAY (Next Smaller - 1)
--------------------------------
right[0] = 0
right[1] = 5
right[2] = 3
right[3] = 3
right[4] = 5
right[5] = 5

RIGHT = [0, 5, 3, 3, 5, 5]

--------------------------------
AREA CALCULATION
--------------------------------
i = 0:
width = 0 - 0 + 1 = 1
area  = 2 * 1 = 2

i = 1:
width = 5 - 0 + 1 = 6
area  = 1 * 6 = 6

i = 2:
width = 3 - 2 + 1 = 2
area  = 5 * 2 = 10

i = 3:
width = 3 - 3 + 1 = 1
area  = 6 * 1 = 6

i = 4:
width = 5 - 2 + 1 = 4
area  = 2 * 4 = 8

i = 5:
width = 5 - 5 + 1 = 1
area  = 3 * 1 = 3

--------------------------------
MAX AREA = 10
--------------------------------
*/

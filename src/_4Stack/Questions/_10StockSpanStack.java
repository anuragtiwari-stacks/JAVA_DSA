package _4Stack.Questions;

import java.util.Stack;

public class _10StockSpanStack
{

    public static void calculateSpan(int[] prices)
    {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++)
        {
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i])
            {
                stack.pop();
            }

            if (stack.isEmpty())
            {
                span[i] = i + 1;
            }
            else
            {
                span[i] = i - stack.peek();
            }

            stack.push(i);
        }

        System.out.println("Stock Span (Stack Method):");
        for (int i = 0; i < n; i++)
        {
            System.out.println(prices[i] + " → " + span[i]);
        }
    }

    public static void main(String[] args)
    {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        calculateSpan(prices);
    }

}

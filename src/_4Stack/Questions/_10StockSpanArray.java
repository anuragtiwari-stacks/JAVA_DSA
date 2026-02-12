package _4Stack.Questions;

public class _10StockSpanArray
{
    public static void calculateSpan(int[] prices)
    {
        int n = prices.length;
        int[] span = new int[n];

        for (int i = 0; i < n; i++)
        {
            int count = 1;

            for (int j = i - 1; j >= 0; j--)
            {
                if (prices[j] <= prices[i])
                {
                    count++;
                }
                else
                {
                    break;
                }
            }

            span[i] = count;
        }

        System.out.println("Stock Span (Array Method):");
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

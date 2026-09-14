package OA.Accenture.Arrays;

import java.util.ArrayList;

// Question: Count growth days by comparing consecutive non-zero sales values

public class _24GrowthDays
{
    public static void main(String[] args)
    {
        int[] sales = {10, 0, 15, 0, 8, 0, 20, 25, 0, 30};
        int k = 5;

        System.out.println(countGrowthDays(sales, k));
    }

    static int countGrowthDays(int[] sales, int k)
    {
        ArrayList<Integer> list = new ArrayList<>();

        // Store only non-zero values
        for(int i = 0; i < sales.length; i++)
        {
            if(sales[i] != 0)
            {
                list.add(sales[i]);
            }
        }

        int count = 0;

        // Compare consecutive non-zero values
        for(int i = 0; i < list.size() - 1; i++)
        {
            if(list.get(i + 1) - list.get(i) >= k)
            {
                count++;
            }
        }

        return count;
    }
}
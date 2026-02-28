package _01Array;

import java.util.ArrayList;

//Leetcode 1390
public class _1SumFourDivisors
{
    public int sumFourDivisors(int[] nums)
    {
        int totalSum = 0;

        for (int num : nums)
        {
            ArrayList<Integer> result = new ArrayList<>();
            int count = 0;

            // find divisors
            for (int j = 1; j <= num; j++)
            {
                if (num % j == 0)
                {
                    count++;
                    result.add(j);
                }
            }

            // if exactly 4 divisors
            if (count == 4)
            {
                totalSum = totalSum + calculateSum(result);
            }
        }

        return totalSum;
    }

    private int calculateSum(ArrayList<Integer> result)
    {
        int sum = 0;
        for (int x : result)
        {
            sum = sum + x;
        }
        return sum;
    }

    public static void main(String[] args)
    {
        _1SumFourDivisors obj = new _1SumFourDivisors();

        int[] nums = {21, 4, 7};

        System.out.println(obj.sumFourDivisors(nums));
    }
}

/*
DRY RUN:

Input:
nums = [21, 4, 7]

-----------------------
num = 21
Divisors:
1 → count = 1 → result = [1]
3 → count = 2 → result = [1,3]
7 → count = 3 → result = [1,3,7]
21 → count = 4 → result = [1,3,7,21]

count == 4 ✔
sum = 1 + 3 + 7 + 21 = 32
totalSum = 32

-----------------------
num = 4
Divisors:
1, 2, 4 → count = 3 ❌
ignored

-----------------------
num = 7
Divisors:
1, 7 → count = 2 ❌
ignored

-----------------------
Final Output:
32
*/

// LeetCode 1561 - Maximum Number of Coins You Can Get

package _15Greedy.MIK;

import java.util.Arrays;

public class _20MaximumNumberOfCoinsYouCanGet
{
    public int maxCoins(int[] piles)
    {
        Arrays.sort(piles);
        int n = piles.length;
        int a = n - 1;
        int m = n - 2;
        int b = 0;
        int limit = n / 3;
        int sum = 0;
        for(int i = 0; i < limit; i++)
        {
            sum = sum + piles[m];
            a--;
            m--;
            b++;
        }
        return sum;
    }

    public static void main(String[] args)
    {
        _20MaximumNumberOfCoinsYouCanGet obj = new _20MaximumNumberOfCoinsYouCanGet();
        int[] piles = {2,4,1,2,7,8};
        int result = obj.maxCoins(piles);
        System.out.println(result);
    }
}

/*
==================== DRY RUN ====================

Input:
piles = [2,4,1,2,7,8]

After sort:
piles = [1,2,2,4,7,8]

Initial pointers:
a = 5 (value 8)
m = 4 (value 7)
b = 0 (value 1)
limit = 6/3 = 2
sum = 0

Iteration i = 0:
sum += piles[m] = 7
a = 4
m = 3
b = 1
sum = 7

Iteration i = 1:
sum += piles[m] = 4
a = 3
m = 2
b = 2
sum = 11

Loop ends

Output:
11

Console Output:
11

=================================================
*/

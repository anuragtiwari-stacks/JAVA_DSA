package _15Greedy.MIK;

import java.util.*;

public class _16Candy
{
    public int candy(int[] ratings)
    {
        int n = ratings.length;
        int[] candies = new int[n];

        // STEP-1: give all children 1 candy
        Arrays.fill(candies, 1);

        // STEP-2: Left to Right (check increasing slope)
        for(int i = 1; i < n; i++)
        {
            if(ratings[i] > ratings[i - 1])
            {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // STEP-3: Right to Left (check decreasing slope)
        for(int i = n - 2; i >= 0; i--)
        {
            if(ratings[i] > ratings[i + 1])
            {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // STEP-4: sum result
        int sum = 0;
        for(int c : candies)
        {
            sum += c;
        }

        return sum;
    }

    public static void main(String[] args)
    {
        _16Candy obj = new _16Candy();
        int[] ratings = {1,2,10,10,10,2,1};
        int ans = obj.candy(ratings);
        System.out.println(ans); // Expected Output: 13
    }
}


/*
===================== DRY RUN =====================

ratings = [1,2,10,10,10,2,1]
n = 7

STEP-1: Init candies all = 1
candies = [1,1,1,1,1,1,1]

---------------------------------------------------
STEP-2: LEFT → RIGHT (if right is greater)

i=1: 2 > 1 → candies[1] = 1+1 = 2
candies = [1,2,1,1,1,1,1]

i=2: 10 > 2 → candies[2] = 2+1 = 3
candies = [1,2,3,1,1,1,1]

i=3: 10 > 10? → NO → stays 1
candies = [1,2,3,1,1,1,1]

i=4: 10 > 10? → NO → stays 1
candies = [1,2,3,1,1,1,1]

i=5: 2 > 10? → NO → stays 1
candies = [1,2,3,1,1,1,1]

i=6: 1 > 2? → NO → stays 1
candies = [1,2,3,1,1,1,1]

---------------------------------------------------
STEP-3: RIGHT → LEFT (if left is greater)

i=5: ratings[5]=2 > ratings[6]=1 → yes
→ candies[5] = max(1, candies[6]+1)=max(1,2)=2
candies = [1,2,3,1,1,2,1]

i=4: 10 > 2 → yes
→ candies[4] = max(1, candies[5]+1)=max(1,3)=3
candies = [1,2,3,1,3,2,1]

i=3: 10 > 10? → NO → stays 1
candies = [1,2,3,1,3,2,1]

i=2: 10 > 10? → NO → stays 3
candies = [1,2,3,1,3,2,1]

i=1: 2 > 10? → NO → stays 2
candies = [1,2,3,1,3,2,1]

i=0: 1 > 2? → NO → stays 1
candies = [1,2,3,1,3,2,1]

---------------------------------------------------
STEP-4: SUM

sum = 1 + 2 + 3 + 1 + 3 + 2 + 1 = 13

===================== RESULT =====================
Output = 13

*/

package _02String;

// LeetCode 404. Number of Steps to Reduce a Number in Binary Representation to One

public class _5NumberOfStepsToReduceANumberInBinaryRepresentationToOne
{
    static class Solution
    {
        public int numSteps(String s)
        {
            int num = Integer.parseInt(s, 2);
            int count = 0;

            while (num != 1)
            {
                if (num % 2 != 0)
                {
                    num = num + 1;
                    count++;
                }

                if (num % 2 == 0)
                {
                    num = num / 2;
                    count++;
                }
            }

            return count;
        }
    }

    public static void main(String[] args)
    {
        Solution sol = new Solution();
        System.out.println(sol.numSteps("1101"));  // Expected Output: 6
    }
}


/*
DRY RUN

Input: s = "1101"

Step 1: Convert binary to decimal
"1101" = 13

Now apply rules:

13 (odd)  -> +1 -> 14   count = 1
14 (even) -> /2 -> 7    count = 2
7  (odd)  -> +1 -> 8    count = 3
8  (even) -> /2 -> 4    count = 4
4  (even) -> /2 -> 2    count = 5
2  (even) -> /2 -> 1    count = 6

Stop because num == 1

Final Answer = 6


NOTE:
This brute force works only when binary value fits in int (<= 31 bits).
For large inputs (up to 500 bits in LeetCode),
Integer.parseInt() will throw NumberFormatException.
*/
package _02String;

// LeetCode 1404. Number of Steps to Reduce a Number in Binary Representation to One

public class _5ReduceNumber
{
    static class Solution
    {
        public int numSteps(String s)
        {
            StringBuilder sb = new StringBuilder(s);
            int count = 0;

            while (sb.length() > 1)
            {
                int n = sb.length();

                if (sb.charAt(n - 1) == '0')   // Even
                {
                    sb.deleteCharAt(n - 1);
                    count++;
                }
                else                          // Odd
                {
                    addOne(sb);
                    count++;
                }
            }

            return count;
        }

        public void addOne(StringBuilder sb)
        {
            int i;

            for (i = sb.length() - 1; i >= 0; i--)
            {
                if (sb.charAt(i) == '1')
                {
                    sb.setCharAt(i, '0');
                }
                else
                {
                    sb.setCharAt(i, '1');
                    break;
                }
            }

            // If all bits were '1'
            if (i < 0)
            {
                sb.insert(0, '1');
            }
        }
    }

    public static void main(String[] args)
    {
        Solution sol = new Solution();
        System.out.println(sol.numSteps("1101"));   // Expected Output: 6
    }
}


/*
DRY RUN

Input: s = "1101"

Initial:
sb = "1101"
count = 0

1) Last bit = 1 (Odd)
   addOne("1101") → "1110"
   count = 1

2) Last bit = 0 (Even)
   remove last → "111"
   count = 2

3) Last bit = 1 (Odd)
   addOne("111") → "1000"
   count = 3

4) Last bit = 0
   → "100"
   count = 4

5) Last bit = 0
   → "10"
   count = 5

6) Last bit = 0
   → "1"
   count = 6

Stop (length == 1)

Final Answer = 6


Time Complexity:
Worst case O(n²) because addOne may traverse entire string multiple times.

Space Complexity:
O(n)
*/
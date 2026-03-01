package _02String;

/*
LeetCode 1689
Partitioning Into Minimum Number Of Deci-Binary Numbers

Concept:
A deci-binary number contains only digits 0 or 1.
To form the given number n, each deci-binary number can contribute
at most 1 in each digit position.

Therefore,
Minimum number of deci-binary numbers required =
Maximum digit present in the string.

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class _6PartitioningIntoMinimumNumberOfDeciBinaryNumbers
{
    public static int minPartitions(String n)
    {
        int maxDigit = 0;

        for (int i = 0; i < n.length(); i++)
        {
            int digit = n.charAt(i) - '0';
            maxDigit = Math.max(maxDigit, digit);
        }

        return maxDigit;
    }

    public static void main(String[] args)
    {
        String n = "32";
        int result = minPartitions(n);
        System.out.println("Minimum deci-binary numbers needed: " + result);
    }
}

/*
Dry Run:

Input: n = "32"

Step 1:
i = 0
digit = '3' - '0' = 3
maxDigit = max(0,3) = 3

Step 2:
i = 1
digit = '2' - '0' = 2
maxDigit = max(3,2) = 3

Loop ends

Return 3

Output:
Minimum deci-binary numbers needed: 3
*/
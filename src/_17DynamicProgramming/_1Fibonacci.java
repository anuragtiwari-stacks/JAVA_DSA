package _17DynamicProgramming;

// LeetCode 509 - Fibonacci Number (Recursion Only)
public class _1Fibonacci
{
    public static int fibonacci(int n)
    {
        // base cases
        if (n == 0)
        {
            return 0;
        }
        if (n == 1)
        {
            return 1;
        }

        // recursive calls
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args)
    {
        int n = 6;
        System.out.println("Fibonacci of " + n + " is: " + fibonacci(n));
    }
}

/*
==================== DRY RUN ====================

Input:
n = 6

Call Stack:

fibonacci(6)
= fibonacci(5) + fibonacci(4)

fibonacci(5)
= fibonacci(4) + fibonacci(3)

fibonacci(4)
= fibonacci(3) + fibonacci(2)

fibonacci(3)
= fibonacci(2) + fibonacci(1)

fibonacci(2)
= fibonacci(1) + fibonacci(0)
= 1 + 0 = 1

fibonacci(3)
= 1 + 1 = 2

fibonacci(4)
= 2 + 1 = 3

fibonacci(5)
= 3 + 2 = 5

fibonacci(6)
= 5 + 3 = 8

Output:
Fibonacci of 6 is: 8
*/

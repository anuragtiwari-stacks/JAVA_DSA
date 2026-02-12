package _11BitManipulation._2QUESTIONS;

public class _3NumberOf1Bits
{

    public static int hammingWeight(int n)
    {

        int count = 0;

        while (n != 0)
        {
            count++;
            n = n & (n - 1);
        }

        return count;
    }

    public static void main(String[] args)
    {

        int n = 11;
        System.out.println(hammingWeight(n));
    }

    /*
     Dry Run

     Example:
     n = 11

     Binary of n 1011

     Iteration 1:
     n = 1011
     n - 1 = 1010
     n & (n - 1) = 1010
     count = 1

     Iteration 2:
     n = 1010
     n - 1 = 1001
     n & (n - 1) = 1000
     count = 2

     Iteration 3:
     n = 1000
     n - 1 = 0111
     n & (n - 1) = 0000
     count = 3

     n = 0 loop stops

     Result 3
    */
}

package _11BitManipulation._2QUESTIONS;

public class _4MinimumBitFlips
{

    public static int minBitFlips(int start, int goal)
    {

        int xor = start ^ goal;
        int count = 0;

        while (xor != 0)
        {
            count++;
            xor = xor & (xor - 1);
        }

        return count;
    }

    public static void main(String[] args)
    {

        int start = 10;
        int goal = 7;

        System.out.println(minBitFlips(start, goal));
    }

    /*
     Dry Run

     start = 10
     goal = 7

     Binary of start 1010
     Binary of goal  0111

     start ^ goal
     1010
     ^0111
     ----
     1101

     xor = 1101

     Iteration 1:
     xor = 1101
     xor - 1 = 1100
     xor & (xor - 1) = 1100
     count = 1

     Iteration 2:
     xor = 1100
     xor - 1 = 1011
     xor & (xor - 1) = 1000
     count = 2

     Iteration 3:
     xor = 1000
     xor - 1 = 0111
     xor & (xor - 1) = 0000
     count = 3

     xor = 0 loop stops

     Result 3
    */
}

package _11BitManipulation._2QUESTIONS;

public class _5PowerOfFour
{

    public static boolean isPowerOfFour(int n)
    {

        if (n <= 0)
        {
            return false;
        }

        if ((n & (n - 1)) != 0)
        {
            return false;
        }

        return (n & 0x55555555) != 0;
    }

    public static void main(String[] args)
    {

        int n = 16;
        System.out.println(isPowerOfFour(n));
    }

    /*
     Dry Run

     Example 1:
     n = 16

     Binary of n 0001 0000

     Step 1:
     n > 0 true

     Step 2:
     n & (n - 1)
     10000
     &01111
     ------
     00000

     Step 3:
     Mask 0x55555555
     Binary mask has 1s at even positions

     10000
     &01010101
     --------
     10000

     Result true

     Example 2:
     n = 8

     Binary of n 1000

     n & (n - 1) = 0
     But

     1000
     &0101
     ----
     0000

     Result false
    */
}

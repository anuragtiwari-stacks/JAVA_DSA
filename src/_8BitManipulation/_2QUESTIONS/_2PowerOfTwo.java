package _8BitManipulation._2QUESTIONS;

public class _2PowerOfTwo
{

    public static boolean isPowerOfTwo(int n)
    {

        if (n <= 0)
        {
            return false;
        }

        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args)
    {

        int n = 16;
        System.out.println(isPowerOfTwo(n));
    }

    /*
     Dry Run

     Example 1:
     n = 16

     Binary of n     10000
     Binary of n - 1 01111

     n & (n - 1)
     10000
     &01111
     ------
     00000

     Result true

     Example 2:
     n = 18

     Binary of n     10010
     Binary of n - 1 10001

     n & (n - 1)
     10000

     Result false

     Example 3:
     n = 0

     n <= 0
     Result false
    */
}

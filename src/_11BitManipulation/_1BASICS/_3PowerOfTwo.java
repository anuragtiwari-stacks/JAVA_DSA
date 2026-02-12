package _11BitManipulation._1BASICS;

public class _3PowerOfTwo
{
    public static void main(String[] args)
    {
        int n = 16; // You can change this number to test other values

        /*
            ✅ Concept:

            A number is a power of 2 if it has only ONE set bit in its binary form.
            For example:
                1  -> 0001 → Power of 2 (2^0)
                2  -> 0010 → Power of 2 (2^1)
                4  -> 0100 → Power of 2 (2^2)
                8  -> 1000 → Power of 2 (2^3)
                16 -> 10000 → Power of 2 (2^4)

            Brian Kernighan's Trick:
                n & (n - 1) will be 0 for powers of 2.
                Because:
                - n has only one set bit.
                - n - 1 flips all bits after the set bit.
                - ANDing them results in 0.

            So, condition:
                n > 0 && (n & (n - 1)) == 0
         */

        /*
            🧪 Dry Run for n = 16:

            Binary of 16  = 10000
            Binary of 15  = 01111
            n & (n - 1)   = 10000 & 01111 = 00000

            → Result is 0 ⇒ Yes, 16 is a power of 2.
         */

        System.out.println(n + " is power of two: " + isPowerOfTwo(n));
    }

    public static boolean isPowerOfTwo(int n)
    {
        return n > 0 && (n & (n - 1)) == 0;
    }
}

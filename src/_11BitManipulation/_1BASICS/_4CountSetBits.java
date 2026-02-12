package _11BitManipulation._1BASICS;

public class _4CountSetBits
{
    public static void main(String[] args)
    {
        int n = 29;

        /*
            👉 Concept:

            We are counting how many '1's (set bits) are present in the binary
            representation of the number using Brian Kernighan’s Algorithm.

            Idea:
            - Do: n = n & (n - 1)
              → This removes the rightmost set bit (1).
              → We repeat until n becomes 0.
              → Count how many times this happens.

            ✅ Why this works:
            - When you subtract 1 from a number, all bits after the rightmost set bit flip.
            - ANDing that with the original number turns off the rightmost 1.

            Efficient because it runs only as many times as the number of set bits (1s).
        */

        System.out.println("Number of set bits in " + n + ": " + countSetBits(n));
    }

    public static int countSetBits(int n)
    {
        int count = 0;

        /*
            🧪 Dry Run for n = 29:
            Binary of 29 = 11101

            Step 1:
                n      = 11101 (29)
                n - 1  = 11100
                n & n-1= 11100
                count  = 1

            Step 2:
                n      = 11100 (28)
                n - 1  = 11011
                n & n-1= 11000
                count  = 2

            Step 3:
                n      = 11000 (24)
                n - 1  = 10111
                n & n-1= 10000
                count  = 3

            Step 4:
                n      = 10000 (16)
                n - 1  = 01111
                n & n-1= 00000
                count  = 4

            Loop ends when n becomes 0.
            So, total set bits = 4
        */

        while (n != 0)
        {
            n = n & (n - 1); // Remove the rightmost set bit
            count++;
        }

        return count;
    }
}

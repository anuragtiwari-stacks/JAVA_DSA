package _8BitManipulation._1BASICS;

public class _9CheckKthBitSet
{
    public static void main(String[] args)
    {
        int n = 13; // binary = 1101
        int k = 2;  // 0-based index from right

        /*
            Dry Run:
            n = 13 → binary = 1101
            Check 2nd bit from right:
            mask = (1 << 2) = 0100
            n & mask = 1101 & 0100 = 0100 → non-zero → bit is set
         */

        if (isKthBitSet(n, k))
        {
            System.out.println("Bit at position " + k + " is set in " + n);
        }
        else
        {
            System.out.println("Bit at position " + k + " is not set in " + n);
        }
    }

    public static boolean isKthBitSet(int n, int k)
    {
        return (n & (1 << k)) != 0;
    }
}

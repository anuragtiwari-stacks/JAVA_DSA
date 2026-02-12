package _11BitManipulation._2QUESTIONS;

public class _7ReverseBits
{

    public static int reverseBits(int n)
    {

        int result = 0;

        for (int i = 0; i < 32; i++)
        {
            result = (result << 1) | (n & 1);
            n = n >>> 1;
        }

        return result;
    }

    public static void main(String[] args)
    {

        int n = 43261596;
        System.out.println(reverseBits(n));
    }

    /*
     Dry Run

     n = 43261596

     Binary of n
     00000010100101000001111010011100

     Iteration idea:
     - n & 1 -> last bit
     - result << 1 -> space
     - add bit
     - n >>> 1 -> shift right

     After 32 iterations

     result binary
     00111001011110000010100101000000

     Result
     964176192
    */
}

package _11BitManipulation._1BASICS;

public class _1EvenOdd
{
    public static void main(String[] args)
    {
        int n1 = 5;
        int n2 = 8;

        /*
            Dry Run for Odd:
            n1 = 5 → binary = 101
            n1 & 1 = 101 & 001 = 001 → 1 → ODD

            Dry Run for Even:
            n2 = 8 → binary = 1000
            n2 & 1 = 1000 & 0001 = 0000 → 0 → EVEN
         */

        if ((n1 & 1) == 0)
        {
            System.out.println(n1 + " is Even");
        }
        else
        {
            System.out.println(n1 + " is Odd");
        }

        if ((n2 & 1) == 0)
        {
            System.out.println(n2 + " is Even");
        }
        else
        {
            System.out.println(n2 + " is Odd");
        }
    }
}

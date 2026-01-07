package _8BitManipulation._1BASICS;

public class _10IsNumberOddWithoutMod
{
    public static void main(String[] args)
    {
        int[] testNumbers = {0, 1, 2, 3, 4, 5};

        for (int n : testNumbers)
        {
            /*
                Dry Run for n = 3:
                binary = 11
                n & 1 = 1 → Odd

                For n = 4:
                binary = 100
                n & 1 = 0 → Even
             */
            if ((n & 1) == 1)
            {
                System.out.println(n + " is Odd");
            }
            else
            {
                System.out.println(n + " is Even");
            }
        }
    }
}

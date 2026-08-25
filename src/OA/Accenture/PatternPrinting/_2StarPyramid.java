package OA.Accenture.PatternPrinting;

// Question: Print the star pyramid pattern
// Input: n = 4
// Output:
//    *
//   ***
//  *****
// *******

public class _2StarPyramid
{
    public static void main(String[] args)
    {
        int n = 4;

        printPattern(n);
    }

    static void printPattern(int n)
    {
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= n - i; j++)
            {
                System.out.print(" ");
            }

            for(int j = 1; j <= 2 * i - 1; j++)
            {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
package OA.Accenture.PatternPrinting;

// Question: Print the inverted star pyramid pattern
// Input: n = 4
// Output:
// *******
//  *****
//   ***
//    *

public class _3InvertedStarPyramid
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
            for(int j = 1; j < i; j++)
            {
                System.out.print(" ");
            }

            for(int j = 1; j <= 2 * (n - i) + 1; j++)
            {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
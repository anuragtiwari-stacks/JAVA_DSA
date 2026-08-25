package OA.Accenture.PatternPrinting;

// Question: Print the pattern
// Input: n = 4
// Output:
// 1
// 1 2
// 1 2 3
// 1 2 3 4

public class _1NumberPattern
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
            for(int j = 1; j <= i; j++)
            {
                System.out.print(j + " ");
            }

            System.out.println();
        }
    }
}
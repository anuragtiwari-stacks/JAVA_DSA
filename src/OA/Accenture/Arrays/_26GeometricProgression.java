package OA.Accenture.Arrays;

// Question: Print the Geometric Progression series

public class _26GeometricProgression
{
    public static void main(String[] args)
    {
        int first = 2;
        int ratio = 3;
        int n = 5;

        printGP(first, ratio, n);
    }

    static void printGP(int first, int ratio, int n)
    {
        for(int i = 0; i < n; i++)
        {
            System.out.print(first + " ");

            first *= ratio;
        }
    }
}
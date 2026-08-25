package OA.Accenture.Arrays;

// Question: Print the Arithmetic Progression series

public class _25ArithmeticProgression
{
    public static void main(String[] args)
    {
        int first = 2;
        int difference = 3;
        int n = 5;

        printAP(first, difference, n);
    }

    static void printAP(int first, int difference, int n)
    {
        for(int i = 0; i < n; i++)
        {
            System.out.print(first + " ");

            first += difference;
        }
    }
}
package OA.Accenture.Numbers;

// Question: Print the Fibonacci series up to N terms

public class _3FibonacciSeries
{
    public static void main(String[] args)
    {
        int n = 7;

        printFibonacci(n);
    }

    static void printFibonacci(int n)
    {
        int first = 0;
        int second = 1;

        for(int i = 0; i < n; i++)
        {
            System.out.print(first + " ");

            int third = first + second;

            first = second;
            second = third;
        }
    }
}
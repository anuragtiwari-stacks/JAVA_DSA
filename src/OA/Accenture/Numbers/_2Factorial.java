package OA.Accenture.Numbers;

// Question: Find the factorial of a number (iterative and recursive)

public class _2Factorial
{
    public static void main(String[] args)
    {
        int n = 5;

        System.out.println(factorial(n));
    }

    static int factorial(int n)
    {
        int result = 1;

        for(int i = 1; i <= n; i++)
        {
            result *= i;
        }

        return result;
    }
}
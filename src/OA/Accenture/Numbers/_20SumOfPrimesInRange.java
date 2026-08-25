package OA.Accenture.Numbers;

// Question: Sum of all prime numbers between two given numbers

public class _20SumOfPrimesInRange
{
    public static void main(String[] args)
    {
        int a = 10;
        int b = 30;

        System.out.println(findSum(a, b));
    }

    static int findSum(int a, int b)
    {
        int sum = 0;

        for(int i = a; i <= b; i++)
        {
            if(isPrime(i))
            {
                sum += i;
            }
        }

        return sum;
    }

    static boolean isPrime(int n)
    {
        if(n <= 1)
        {
            return false;
        }

        for(int i = 2; i * i <= n; i++)
        {
            if(n % i == 0)
            {
                return false;
            }
        }

        return true;
    }
}
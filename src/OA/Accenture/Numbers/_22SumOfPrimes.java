package OA.Accenture.Numbers;

// Question: Find the sum of prime numbers between start and end

public class _22SumOfPrimes
{
    public static void main(String[] args)
    {
        int start = 10;
        int end = 20;

        System.out.println(sumOfPrimes(start, end));
    }

    static int sumOfPrimes(int start, int end)
    {
        int sum = 0;

        for(int i = start; i <= end; i++)
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
        if(n < 2)
        {
            return false;
        }

        for(int i = 2; i <= Math.sqrt(n); i++)
        {
            if(n % i == 0)
            {
                return false;
            }
        }

        return true;
    }
}
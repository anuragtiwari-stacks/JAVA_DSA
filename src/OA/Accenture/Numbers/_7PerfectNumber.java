package OA.Accenture.Numbers;

// Question: Check whether a number is a perfect number

public class _7PerfectNumber
{
    public static void main(String[] args)
    {
        int n = 28;

        System.out.println(isPerfect(n));
    }

    static boolean isPerfect(int n)
    {
        int sum = 0;

        for(int i = 1; i < n; i++)
        {
            if(n % i == 0)
            {
                sum += i;
            }
        }

        return sum == n;
    }
}
package OA.Accenture.Numbers;

// Question: Sum of numbers in a range divisible by n vs. not divisible by n, then return the difference of the two sums

public class _11DivisibleDifference
{
    public static void main(String[] args)
    {
        int m = 10;
        int n = 3;

        System.out.println(findDifference(m, n));
    }

    static int findDifference(int m, int n)
    {
        int divisibleSum = 0;
        int nonDivisibleSum = 0;

        for(int i = 1; i <= m; i++)
        {
            if(i % n == 0)
            {
                divisibleSum += i;
            }
            else
            {
                nonDivisibleSum += i;
            }
        }

        return nonDivisibleSum - divisibleSum;
    }
}
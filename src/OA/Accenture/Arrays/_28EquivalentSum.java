package OA.Accenture.Arrays;

// Question: Calculate the Equivalent Sum of a number

public class _28EquivalentSum
{
    public static void main(String[] args)
    {
        int n = 112;

        int rev = reverse(n);

        System.out.println(prefixSum(rev));
    }

    static int reverse(int n)
    {
        int rev = 0;

        while(n > 0)
        {
            rev = rev * 10 + n % 10;
            n /= 10;
        }

        return rev;
    }

    static int prefixSum(int n)
    {
        int prefix = 0;
        int sum = 0;

        while(n > 0)
        {
            int digit = n % 10;

            prefix = prefix * 10 + digit;
            sum += prefix;

            n /= 10;
        }

        return sum;
    }
}
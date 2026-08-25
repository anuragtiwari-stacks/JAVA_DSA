package OA.Accenture.Numbers;

// Question: Difference between the digit-sums of numbers divisible by 4 vs. numbers divisible by 7, in a range

public class _21DigitSumDifference
{
    public static void main(String[] args)
    {
        int a = 1;
        int b = 50;

        System.out.println(findDifference(a, b));
    }

    static int findDifference(int a, int b)
    {
        int sum4 = 0;
        int sum7 = 0;

        for(int i = a; i <= b; i++)
        {
            if(i % 4 == 0)
            {
                sum4 += digitSum(i);
            }

            if(i % 7 == 0)
            {
                sum7 += digitSum(i);
            }
        }

        return sum4 - sum7;
    }

    static int digitSum(int n)
    {
        int sum = 0;

        while(n > 0)
        {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }
}
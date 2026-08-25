package OA.Accenture.Numbers;

// Question: Check whether a number is an Armstrong number

public class _4ArmstrongNumber
{
    public static void main(String[] args)
    {
        int n = 153;

        System.out.println(isArmstrong(n));
    }

    static boolean isArmstrong(int n)
    {
        int original = n;
        int digits = 0;
        int temp = n;

        while(temp > 0)
        {
            digits++;
            temp /= 10;
        }

        int sum = 0;
        temp = n;

        while(temp > 0)
        {
            int digit = temp % 10;

            int power = 1;

            for(int i = 0; i < digits; i++)
            {
                power *= digit;
            }

            sum += power;
            temp /= 10;
        }

        return sum == original;
    }
}
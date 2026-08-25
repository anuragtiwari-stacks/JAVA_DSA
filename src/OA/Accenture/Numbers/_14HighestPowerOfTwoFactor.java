package OA.Accenture.Numbers;

// Question: Find the number in a range [a, b] whose highest power-of-2 factor is the largest

public class _14HighestPowerOfTwoFactor
{
    public static void main(String[] args)
    {
        int a = 10;
        int b = 20;

        System.out.println(findNumber(a, b));
    }

    static int findNumber(int a, int b)
    {
        int result = a;
        int maxPower = 0;

        for(int i = a; i <= b; i++)
        {
            int temp = i;
            int power = 0;

            while(temp % 2 == 0)
            {
                power++;
                temp /= 2;
            }

            if(power > maxPower)
            {
                maxPower = power;
                result = i;
            }
        }

        return result;
    }
}
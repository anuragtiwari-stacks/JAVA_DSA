package OA.Accenture.Numbers;

// Question: Count how many carries occur when adding two numbers digit by digit

public class _12CountCarries
{
    public static void main(String[] args)
    {
        int a = 555;
        int b = 555;

        System.out.println(countCarries(a, b));
    }

    static int countCarries(int a, int b)
    {
        int carry = 0;
        int count = 0;

        while(a > 0 || b > 0)
        {
            int digit1 = a % 10;
            int digit2 = b % 10;

            int sum = digit1 + digit2 + carry;

            if(sum >= 10)
            {
                carry = 1;
                count++;
            }
            else
            {
                carry = 0;
            }

            a /= 10;
            b /= 10;
        }

        return count;
    }
}
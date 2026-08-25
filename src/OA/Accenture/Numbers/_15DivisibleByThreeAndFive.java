package OA.Accenture.Numbers;

// Question: Sum of all numbers in a range that are divisible by both 3 and 5

public class _15DivisibleByThreeAndFive
{
    public static void main(String[] args)
    {
        int a = 1;
        int b = 100;

        System.out.println(findSum(a, b));
    }

    static int findSum(int a, int b)
    {
        int sum = 0;

        for(int i = a; i <= b; i++)
        {
            if(i % 3 == 0 && i % 5 == 0)
            {
                sum += i;
            }
        }

        return sum;
    }
}
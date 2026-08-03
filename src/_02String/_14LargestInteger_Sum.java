package _02String;

// LeetCode 4000 - Largest Integer With Given Digit Sum

public class _14LargestInteger_Sum
{
    public static int largestInteger(int n, int s)
    {
        String Stmax = generate(n + 1);
        int max = Integer.valueOf(Stmax) - 1;

        for(int i = max; i >= 0; i--)
        {
            int sum = digitSum(i);

            if(sum == s)
            {
                return i;
            }
        }

        return -1;
    }

    public static String generate(int n)
    {
        StringBuilder sb = new StringBuilder("1");

        while(sb.length() < n)
        {
            sb.append("0");
        }

        return sb.toString();
    }

    public static int digitSum(int n)
    {
        int sum = 0;

        while(n != 0)
        {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }

    public static void main(String[] args)
    {
        int n = 3;
        int s = 20;

        int ans = largestInteger(n, s);

        System.out.println(ans);
    }
}
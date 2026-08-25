package OA.Accenture.Numbers;

// Question: Check whether a number is autobiographical

public class _19AutobiographicalNumber
{
    public static void main(String[] args)
    {
        int n = 1210;

        System.out.println(isAutobiographical(n));
    }

    static boolean isAutobiographical(int n)
    {
        String s = String.valueOf(n);

        // count[i] = digit i kitni baar aaya
        int[] count = new int[s.length()];

        // Count frequency of each digit
        for(int i = 0; i < s.length(); i++)
        {
            int digit = s.charAt(i) - '0';

            count[digit]++;
        }

        // Check:
        // position i par jo digit hai,
        // wahi batana chahiye ki digit i kitni baar aaya
        for(int i = 0; i < s.length(); i++)
        {
            int digit = s.charAt(i) - '0';

            if(count[i] != digit)
            {
                return false;
            }
        }

        return true;
    }
}
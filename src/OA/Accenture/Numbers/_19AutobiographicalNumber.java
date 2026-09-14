package OA.Accenture.Numbers;

// Question: Check whether a number is autobiographical

public class _19AutobiographicalNumber
{
    public static void main(String[] args)
    {
        int num = 1210;

        System.out.println(isAutobiographical(num));
    }

    public static boolean isAutobiographical(int num)
    {
        String st = String.valueOf(num);

        int n = st.length();
        int []freq = new int[n];


        for(int i=0;i<n;i++)
        {
            int digit = st.charAt(i)-'0';
            freq[digit]++;
        }

        for(int i=0;i<n;i++)
        {
            int digit = st.charAt(i)-'0';
            if(digit != freq[i])
            {
                return false;
            }
        }
        return true;
    }
}
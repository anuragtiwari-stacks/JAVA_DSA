package OA.Accenture.Strings;

public class _20CountDigitSubstrings
{
    public static int countDigitSubstrings(String s)
    {
        int count = 0;
        int n = s.length();

        for(int i=0;i<n;i++)
        {
            if(Character.isLetter(s.charAt(i)))
            {
                int start = i;
                int j = i+1;

                while(j<n && Character.isDigit(s.charAt(j)))
                {
                    j++;
                }

                if(j<n && j>start+1 && Character.isLetter(s.charAt(j)))
                {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        String str="29a367s2b";

        System.out.println(countDigitSubstrings(str));
    }
}
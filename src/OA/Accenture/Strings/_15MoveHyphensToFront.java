package OA.Accenture.Strings;

// Question: Move every hyphen in a string to the front, keeping the relative order of the other characters

public class _15MoveHyphensToFront
{
    public static void main(String[] args)
    {
        String s = "a-b-cd-e";

        System.out.println(moveHyphens(s));
    }

    static String moveHyphens(String s)
    {
        String result = "";
        int count = 0;

        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '-')
            {
                count++;
            }
            else
            {
                result += s.charAt(i);
            }
        }

        String hyphens = "";

        for(int i = 0; i < count; i++)
        {
            hyphens += "-";
        }

        return hyphens + result;
    }
}
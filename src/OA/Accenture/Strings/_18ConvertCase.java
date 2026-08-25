package OA.Accenture.Strings;

// Question: Convert an entire string to uppercase or lowercase, whichever case appears more frequently in it

public class _18ConvertCase
{
    public static void main(String[] args)
    {
        String s = "HeLLo";

        System.out.println(convertCase(s));
    }

    static String convertCase(String s)
    {
        int upper = 0;
        int lower = 0;

        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);

            if(Character.isUpperCase(ch))
            {
                upper++;
            }
            else if(Character.isLowerCase(ch))
            {
                lower++;
            }
        }

        if(upper > lower)
        {
            return s.toUpperCase();
        }
        else
        {
            return s.toLowerCase();
        }
    }
}
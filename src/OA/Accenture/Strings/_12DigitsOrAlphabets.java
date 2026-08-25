package OA.Accenture.Strings;

// Question: Check whether a string contains only digits or only alphabets

public class _12DigitsOrAlphabets
{
    public static void main(String[] args)
    {
        String s = "12345";

        checkString(s);
    }

    static void checkString(String s)
    {
        boolean digits = true;
        boolean alphabets = true;

        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);

            if(ch < '0' || ch > '9')
            {
                digits = false;
            }

            if((ch < 'A' || ch > 'Z') && (ch < 'a' || ch > 'z'))
            {
                alphabets = false;
            }
        }

        if(digits)
        {
            System.out.println("Only Digits");
        }
        else if(alphabets)
        {
            System.out.println("Only Alphabets");
        }
        else
        {
            System.out.println("Contains Both");
        }
    }
}
/*
static void checkString(String s)
{
    boolean digits = true;
    boolean alphabets = true;

    for(int i = 0; i < s.length(); i++)
    {
        char ch = s.charAt(i);

        if(!Character.isDigit(ch))
        {
            digits = false;
        }

        if(!Character.isLetter(ch))
        {
            alphabets = false;
        }
    }

    if(digits)
    {
        System.out.println("Only Digits");
    }
    else if(alphabets)
    {
        System.out.println("Only Alphabets");
    }
    else
    {
        System.out.println("Contains Both");
    }
}
*/
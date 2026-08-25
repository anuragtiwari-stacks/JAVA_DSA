package OA.Accenture.Strings;

// Question: Swap every occurrence of one character with another throughout a string (and vice versa)

public class _16SwapCharacters
{
    public static void main(String[] args)
    {
        String s = "apple";

        char ch1 = 'a';
        char ch2 = 'e';

        System.out.println(swapCharacters(s, ch1, ch2));
    }

    static String swapCharacters(String s, char ch1, char ch2)
    {
        String result = "";

        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);

            if(ch == ch1)
            {
                result += ch2;
            }
            else if(ch == ch2)
            {
                result += ch1;
            }
            else
            {
                result += ch;
            }
        }

        return result;
    }
}
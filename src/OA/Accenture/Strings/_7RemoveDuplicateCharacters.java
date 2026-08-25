package OA.Accenture.Strings;

// Question: Remove duplicate characters from a string

import java.util.HashSet;
import java.util.Set;

public class _7RemoveDuplicateCharacters
{
    public static void main(String[] args)
    {
        String str = "programming";

        System.out.println(removeDuplicates(str));
    }

    static String removeDuplicates(String str)
    {
        Set<Character> set = new HashSet<>();
        String result = "";

        for(int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);

            if(!set.contains(ch))
            {
                set.add(ch);
                result += ch;
            }
        }

        return result;
    }
}
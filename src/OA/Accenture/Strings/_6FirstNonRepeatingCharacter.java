package OA.Accenture.Strings;

// Question: Find the first non-repeating character in a string

import java.util.HashMap;

public class _6FirstNonRepeatingCharacter
{
    public static void main(String[] args)
    {
        String str = "swiss";

        System.out.println(findFirstNonRepeating(str));
    }

    static char findFirstNonRepeating(String str)
    {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);

            if(map.containsKey(ch))
            {
                map.put(ch, map.get(ch) + 1);
            }
            else
            {
                map.put(ch, 1);
            }
        }

        for(int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);

            if(map.get(ch) == 1)
            {
                return ch;
            }
        }

        return '-';
    }
}
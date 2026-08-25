package OA.Accenture.Strings;

// Question: Find the frequency of each character in a string

import java.util.HashMap;

public class _11CharacterFrequency
{
    public static void main(String[] args)
    {
        String s = "programming";

        findFrequency(s);
    }

    static void findFrequency(String s)
    {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);

            if(map.containsKey(ch))
            {
                map.put(ch, map.get(ch) + 1);
            }
            else
            {
                map.put(ch, 1);
            }
        }

        System.out.println(map);
    }
}
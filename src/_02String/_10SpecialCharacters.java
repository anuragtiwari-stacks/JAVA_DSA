package _02String;

import java.util.*;

public class _10SpecialCharacters
{
    public static int numberOfSpecialChars(String word)
    {
        HashSet<Character> lower = new HashSet<>();
        HashSet<Character> upper = new HashSet<>();

        int n = word.length();

        for (int i = 0; i < n; i++)
        {
            char ch = word.charAt(i);

            if (Character.isLowerCase(ch))
            {
                lower.add(ch);
            }

            if (Character.isUpperCase(ch))
            {
                char low = Character.toLowerCase(ch);

                upper.add(low);
            }
        }

        int count = 0;

        for (char ch : lower)
        {
            if (upper.contains(ch))
            {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args)
    {
        String word = "aaAbcBC";

        int ans = numberOfSpecialChars(word);

        System.out.println(ans);
    }
}

package _02String;

import java.util.ArrayList;
import java.util.HashMap;

// LeetCode 500
public class _1KeyboardRow
{

    public static void main(String[] args)
    {
        _1KeyboardRow obj = new _1KeyboardRow();

        String[] words = {"Hello", "Alaska", "Dad", "Peace"};

        String[] result = obj.findWords(words);

        for (int i = 0; i < result.length; i++)
        {
            System.out.println(result[i]);
        }
    }

    public String[] findWords(String[] words)
    {
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";

        HashMap<Integer, ArrayList<String>> map = new HashMap<>();

        map.put(1, new ArrayList<>());
        map.put(2, new ArrayList<>());
        map.put(3, new ArrayList<>());

        for (int i = 0; i < words.length; i++)
        {
            String word = words[i].toLowerCase();

            boolean match = true;

            for (int j = 0; j < word.length(); j++)
            {
                if (row1.indexOf(word.charAt(j)) == -1)
                {
                    match = false;
                    break;
                }
            }

            if (match)
            {
                map.get(1).add(words[i]);
                continue;
            }

            match = true;

            for (int j = 0; j < word.length(); j++)
            {
                if (row2.indexOf(word.charAt(j)) == -1)
                {
                    match = false;
                    break;
                }
            }

            if (match)
            {
                map.get(2).add(words[i]);
                continue;
            }

            match = true;

            for (int j = 0; j < word.length(); j++)
            {
                if (row3.indexOf(word.charAt(j)) == -1)
                {
                    match = false;
                    break;
                }
            }

            if (match)
            {
                map.get(3).add(words[i]);
            }
        }

        ArrayList<String> resultList = new ArrayList<>();

        resultList.addAll(map.get(1));
        resultList.addAll(map.get(2));
        resultList.addAll(map.get(3));

        String[] result = new String[resultList.size()];

        for (int i = 0; i < resultList.size(); i++)
        {
            result[i] = resultList.get(i);
        }

        return result;
    }
}

/*
Dry Run:

Input:
words = {"Hello", "Alaska", "Dad", "Peace"}

"Hello" → contains letters from multiple rows → not added
"Alaska" → all letters in row2 → added
"Dad" → all letters in row2 → added
"Peace" → contains multiple rows → not added

Result:
["Alaska", "Dad"]
*/

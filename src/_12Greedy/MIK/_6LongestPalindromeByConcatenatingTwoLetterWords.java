package _12Greedy.MIK;

import java.util.HashMap;

// LeetCode 2131 — Longest Palindrome by Concatenating Two Letter Words

public class _6LongestPalindromeByConcatenatingTwoLetterWords
{
    public int longestPalindrome(String[] words)
    {
        HashMap<String, Integer> mp = new HashMap<>();

        for(String word : words)
        {
            if(mp.containsKey(word))
            {
                mp.put(word, mp.get(word) + 1);
            }
            else
            {
                mp.put(word, 1);
            }
        }

        boolean centerUsed = false;
        int result = 0;

        for(String word : words)
        {
            if(!mp.containsKey(word) || mp.get(word) == 0)
            {
                continue;
            }

            StringBuilder sb = new StringBuilder(word);
            sb.reverse();
            String rev = sb.toString();

            if(!rev.equals(word))
            {
                if(mp.containsKey(rev) && mp.get(word) > 0 && mp.get(rev) > 0)
                {
                    mp.put(word, mp.get(word) - 1);
                    mp.put(rev, mp.get(rev) - 1);
                    result = result + 4;
                }
            }
            else
            {
                int freq = mp.get(word);

                if(freq >= 2)
                {
                    mp.put(word, freq - 2);
                    result = result + 4;
                }
                else if(freq == 1 && centerUsed == false)
                {
                    mp.put(word, freq - 1);
                    result = result + 2;
                    centerUsed = true;
                }
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
        _6LongestPalindromeByConcatenatingTwoLetterWords obj = new _6LongestPalindromeByConcatenatingTwoLetterWords();

        String[] words = {"lc", "cl", "gg"};
        System.out.println(obj.longestPalindrome(words)); // Output: 6
    }
}

/*
---------------------- DRY RUN ----------------------

Input:
words = ["lc", "cl", "gg"]

freq:
"lc"=1, "cl"=1, "gg"=1

centerUsed=false
result=0

Iteration: "lc"
rev="cl"
pair exists → result=4
mp["lc"]=0, mp["cl"]=0

Iteration: "cl"
mp["cl"]=0 → skip

Iteration: "gg"
rev="gg"
freq=1, centerUsed=false
use center → result=6, centerUsed=true, mp["gg"]=0

FINAL = 6

-----------------------------------------------------
*/

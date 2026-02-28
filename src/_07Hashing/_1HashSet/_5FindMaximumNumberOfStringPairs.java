/*
2744. Find Maximum Number of String Pairs

You are given a 0-indexed array words consisting of distinct strings.

The string words[i] can be paired with the string words[j] if:
- words[i] is equal to the reversed string of words[j]
- 0 <= i < j < words.length

Each string can belong to at most one pair.

Return the maximum number of pairs that can be formed.
*/

package _07Hashing._1HashSet;

import java.util.HashSet;

public class _5FindMaximumNumberOfStringPairs
{
    public static int maximumNumberOfStringPairs(String[] words)
    {
        HashSet<String> set = new HashSet<>();
        int pairs = 0;

        for (String word : words)
        {
            String reversed = reverseString(word);

            if (set.contains(reversed))
            {
                pairs++;
                set.remove(reversed);
            }
            else
            {
                set.add(word);
            }
        }

        return pairs;
    }

    private static String reverseString(String word)
    {
        StringBuilder sb = new StringBuilder(word);
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args)
    {
        String[] words = {"cd", "ac", "dc", "ca", "zz"};

        int result = maximumNumberOfStringPairs(words);

        System.out.println("Maximum number of pairs: " + result);
    }
}

/*
Dry Run:

Input: words = ["cd","ac","dc","ca","zz"]

HashSet = {}
pairs = 0

1) word = "cd"
   reverse = "dc"
   not in set → add "cd"
   set = {"cd"}

2) word = "ac"
   reverse = "ca"
   not in set → add "ac"
   set = {"cd", "ac"}

3) word = "dc"
   reverse = "cd"
   found in set → pair formed
   pairs = 1
   remove "cd"
   set = {"ac"}

4) word = "ca"
   reverse = "ac"
   found in set → pair formed
   pairs = 2
   remove "ac"
   set = {}

5) word = "zz"
   reverse = "zz"
   not in set → add "zz"
   set = {"zz"}

Final Answer = 2
*/

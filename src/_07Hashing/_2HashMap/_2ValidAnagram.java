/*
242. Valid Anagram

Given two strings s and t, return true if t is an anagram of s,
and false otherwise.

Approach:
- Create frequency map for string s
- Create frequency map for string t
- Compare both maps
*/

package _07Hashing._2HashMap;

import java.util.HashMap;

public class _2ValidAnagram
{
    public static boolean isAnagram(String s, String t)
    {
        if (s.length() != t.length())
        {
            return false;
        }

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (char ch : s.toCharArray())
        {
            if (map1.containsKey(ch))
            {
                map1.put(ch, map1.get(ch) + 1);
            }
            else
            {
                map1.put(ch, 1);
            }
        }

        for (char ch : t.toCharArray())
        {
            if (map2.containsKey(ch))
            {
                map2.put(ch, map2.get(ch) + 1);
            }
            else
            {
                map2.put(ch, 1);
            }
        }

        return map1.equals(map2);
    }

    public static void main(String[] args)
    {
        String s1 = "anagram";
        String t1 = "nagaram";

        String s2 = "rat";
        String t2 = "car";

        System.out.println(isAnagram(s1, t1));
        System.out.println(isAnagram(s2, t2));
    }
}

/*
Dry Run:

Example 1:
s = "anagram"
t = "nagaram"

map1 (s):
a -> 3
n -> 1
g -> 1
r -> 1
m -> 1

map2 (t):
n -> 1
a -> 3
g -> 1
r -> 1
m -> 1

map1.equals(map2) → true

--------------------------------

Example 2:
s = "rat"
t = "car"

map1:
r -> 1
a -> 1
t -> 1

map2:
c -> 1
a -> 1
r -> 1

map1 ≠ map2 → false
*/

package _07Hashing.Questions;

/*
3. Longest Substring Without Repeating Characters

Given a string s, find the length of the longest
substring without repeating characters.
*/

import java.util.*;

public class _3LongestSubstringWithoutRepeatingCharacters
{

    public int lengthOfLongestSubstring(String s)
    {

        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++)
        {

            while (set.contains(s.charAt(right)))
            {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));

            maxLength = Math.max(maxLength, right - left + 1);

        }

        return maxLength;

    }


    // 🔥 IDE Runnable Main
    public static void main(String[] args)
    {

        _3LongestSubstringWithoutRepeatingCharacters obj =
                new _3LongestSubstringWithoutRepeatingCharacters();

        String s = "abcabcbb";

        int result = obj.lengthOfLongestSubstring(s);

        System.out.println(result);

        // Output:
        // 3

    }

}


/*
==================== FULL DRY RUN ====================

Input:
s = "abcabcbb"

------------------------------------------------------
Initial State:

left = 0
maxLength = 0
set = {}

------------------------------------------------------

right = 0 → 'a'
set = {a}
length = 1
maxLength = 1

------------------------------------------------------

right = 1 → 'b'
set = {a, b}
length = 2
maxLength = 2

------------------------------------------------------

right = 2 → 'c'
set = {a, b, c}
length = 3
maxLength = 3

------------------------------------------------------

right = 3 → 'a' (repeat)

Remove 'a'
left = 1
set = {b, c}

Add 'a'
set = {b, c, a}
length = 3
maxLength = 3

------------------------------------------------------

right = 4 → 'b' (repeat)

Remove 'b'
left = 2
set = {c, a}

Add 'b'
set = {c, a, b}
length = 3
maxLength = 3

------------------------------------------------------

right = 5 → 'c' (repeat)

Remove 'c'
left = 3
set = {a, b}

Add 'c'
set = {a, b, c}
length = 3
maxLength = 3

------------------------------------------------------

right = 6 → 'b' (repeat)

Remove 'a'
left = 4
set = {b, c}

Still repeat

Remove 'b'
left = 5
set = {c}

Add 'b'
set = {c, b}
length = 2
maxLength = 3

------------------------------------------------------

right = 7 → 'b' (repeat)

Remove 'c'
left = 6
set = {b}

Still repeat

Remove 'b'
left = 7
set = {}

Add 'b'
set = {b}
length = 1
maxLength = 3

------------------------------------------------------

Final Answer:
3

======================================================
*/
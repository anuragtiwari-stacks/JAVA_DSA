/*
3. Longest Substring Without Repeating Characters

Given a string s, find the length of the longest substring
without repeating characters.
*/

package _7Hashing.Questions;

import java.util.HashMap;

public class _3LongestSubstringWithoutRepeatingCharacters
{
    public static int lengthOfLongestSubstring(String s)
    {
        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++)
        {
            char ch = s.charAt(right);

            if (map.containsKey(ch) && map.get(ch) >= left)
            {
                left = map.get(ch) + 1;
            }

            map.put(ch, right);

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args)
    {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";

        System.out.println(lengthOfLongestSubstring(s1));
        System.out.println(lengthOfLongestSubstring(s2));
    }
}

/*
==================== FULL DRY RUN ====================

Example 1:
s = "abcabcbb"

Initial:
map = {}
left = 0
maxLength = 0

----------------------------------------------------
right = 0, ch = 'a'
'a' not in map
put ('a', 0)
window = [0..0] → "a"
length = 1
maxLength = 1

----------------------------------------------------
right = 1, ch = 'b'
'b' not in map
put ('b', 1)
window = [0..1] → "ab"
length = 2
maxLength = 2

----------------------------------------------------
right = 2, ch = 'c'
'c' not in map
put ('c', 2)
window = [0..2] → "abc"
length = 3
maxLength = 3

----------------------------------------------------
right = 3, ch = 'a'
'a' found in map at index 0
0 >= left(0) → true

move left:
left = 0 + 1 = 1

put ('a', 3)
window = [1..3] → "bca"
length = 3
maxLength = 3

----------------------------------------------------
right = 4, ch = 'b'
'b' found at index 1
1 >= left(1) → true

left = 1 + 1 = 2

put ('b', 4)
window = [2..4] → "cab"
length = 3
maxLength = 3

----------------------------------------------------
right = 5, ch = 'c'
'c' found at index 2
2 >= left(2) → true

left = 2 + 1 = 3

put ('c', 5)
window = [3..5] → "abc"
length = 3
maxLength = 3

----------------------------------------------------
right = 6, ch = 'b'
'b' found at index 4
4 >= left(3) → true

left = 4 + 1 = 5

put ('b', 6)
window = [5..6] → "cb"
length = 2
maxLength = 3

----------------------------------------------------
right = 7, ch = 'b'
'b' found at index 6
6 >= left(5) → true

left = 6 + 1 = 7

put ('b', 7)
window = [7..7] → "b"
length = 1
maxLength = 3

Final Answer = 3
----------------------------------------------------

Example 2:
s = "bbbbb"

Every time duplicate comes, left moves forward.
Longest substring = "b"
Answer = 1
====================================================
*/

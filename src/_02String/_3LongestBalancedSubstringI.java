package _02String;

// LeetCode 3713
public class _3LongestBalancedSubstringI
{

    public static void main(String[] args)
    {
        _3LongestBalancedSubstringI obj = new _3LongestBalancedSubstringI();

        String s = "abbac";

        int result = obj.longestBalanced(s);

        System.out.println(result);
    }

    public int longestBalanced(String s)
    {
        int n = s.length();
        int maxLen = 0;

        for (int i = 0; i < n; i++)
        {
            int[] freq = new int[26];

            for (int j = i; j < n; j++)
            {
                freq[s.charAt(j) - 'a']++;

                if (isBalanced(freq))
                {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

    public boolean isBalanced(int[] freq)
    {
        int expected = 0;

        for (int i = 0; i < 26; i++)
        {
            if (freq[i] > 0)
            {
                expected = freq[i];
                break;
            }
        }

        for (int i = 0; i < 26; i++)
        {
            if (freq[i] > 0 && freq[i] != expected)
            {
                return false;
            }
        }

        return true;
    }
}

/*
Dry Run:

Input:
s = "abbac"

i = 0
  j = 0 → "a" → a=1 → balanced → max=1
  j = 1 → "ab" → a=1,b=1 → balanced → max=2
  j = 2 → "abb" → a=1,b=2 → not balanced
  j = 3 → "abba" → a=2,b=2 → balanced → max=4
  j = 4 → "abbac" → a=2,b=2,c=1 → not balanced

Maximum Length = 4

Output: 4
*/

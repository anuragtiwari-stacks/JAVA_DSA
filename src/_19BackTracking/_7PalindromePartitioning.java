package _19BackTracking;

// LeetCode 131: Palindrome Partitioning
import java.util.*;

public class _7PalindromePartitioning
{
    public List<List<String>> partition(String s)
    {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(String s, int index, List<String> current, List<List<String>> result)
    {
        if (index == s.length())
        {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < s.length(); i++)
        {
            if (isPalindrome(s, index, i))
            {
                current.add(s.substring(index, i + 1));   // choose
                backtrack(s, i + 1, current, result);     // explore
                current.remove(current.size() - 1);       // unchoose
            }
        }
    }

    public boolean isPalindrome(String s, int left, int right)
    {
        while (left < right)
        {
            if (s.charAt(left) != s.charAt(right))
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args)
    {
        _7PalindromePartitioning obj = new _7PalindromePartitioning();

        String s = "aab";

        System.out.println(obj.partition(s));
    }
}

/*
---------------- DRY RUN ----------------

Input:
s = "aab"

Start index = 0
current = []

Check "a" → palindrome
current = ["a"]
index = 1

Check "a" → palindrome
current = ["a","a"]
index = 2

Check "b" → palindrome
current = ["a","a","b"]
index = 3 → store ["a","a","b"]

Backtrack to ["a"]

Check "ab" → not palindrome

Backtrack to []

Check "aa" → palindrome
current = ["aa"]
index = 2

Check "b" → palindrome
current = ["aa","b"]
index = 3 → store ["aa","b"]

Final Output:
[
 ["a","a","b"],
 ["aa","b"]
]

----------------------------------------
*/

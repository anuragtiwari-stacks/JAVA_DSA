package _15Greedy.MIK;

// LeetCode 1328 — Break a Palindrome

public class _3BreakAPalindrome
{
    public String breakPalindrome(String palindrome)
    {
        int n = palindrome.length();

        if(n == 1)
        {
            return "";
        }

        char[] arr = palindrome.toCharArray();

        for(int i = 0; i < n / 2; i = i + 1)
        {
            if(arr[i] != 'a')
            {
                arr[i] = 'a';
                return new String(arr);
            }
        }

        arr[n - 1] = 'b';

        return new String(arr);
    }

    public static void main(String[] args)
    {
        _3BreakAPalindrome obj = new _3BreakAPalindrome();

        System.out.println(obj.breakPalindrome("abba")); // Output: "a b ba" => "a b ba" simplified as "abba" -> corrected logic output: "a b ba"? Actually expected "a b ba"? Just trust main
        System.out.println(obj.breakPalindrome("aaa"));  // Output: "aab"
        System.out.println(obj.breakPalindrome("a"));    // Output: ""
    }
}

/*
---------------- DRY RUN ----------------

Example 1:
palindrome = "abba"
n = 4

arr = ['a','b','b','a']

Loop i < n/2 => i < 2

i = 0:
arr[0] == 'a' so continue

i = 1:
arr[1] = 'b' != 'a'
So replace arr[1] = 'a'
Return "aaba"

FINAL ANSWER = "aaba"

------------------------------------------

Example 2:
palindrome = "aaa"
n = 3

arr = ['a','a','a']

Loop i < n/2 => i < 1

i = 0:
arr[0] == 'a' so loop ends

No replacement happened in loop
So arr[n-1] = 'b' => arr[2] = 'b'

FINAL ANSWER = "aab"

------------------------------------------

Example 3:
palindrome = "a"
n = 1

Return "" directly

------------------------------------------
*/

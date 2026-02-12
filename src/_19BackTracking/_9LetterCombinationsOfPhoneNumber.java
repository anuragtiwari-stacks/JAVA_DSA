package _19BackTracking;

// LeetCode 17: Letter Combinations of a Phone Number
import java.util.*;

public class _9LetterCombinationsOfPhoneNumber
{
    public List<String> letterCombinations(String digits)
    {
        List<String> result = new ArrayList<>();

        if (digits.length() == 0)
        {
            return result;
        }

        String[] map =
                {
                        "",     // 0
                        "",     // 1
                        "abc",  // 2
                        "def",  // 3
                        "ghi",  // 4
                        "jkl",  // 5
                        "mno",  // 6
                        "pqrs", // 7
                        "tuv",  // 8
                        "wxyz"  // 9
                };

        backtrack(digits, 0, new StringBuilder(), result, map);
        return result;
    }

    public void backtrack(String digits, int idx, StringBuilder current, List<String> result, String[] map)
    {
        if (idx == digits.length())
        {
            result.add(current.toString());
            return;
        }

        String letters = map[digits.charAt(idx) - '0'];

        for (int i = 0; i < letters.length(); i++)
        {
            current.append(letters.charAt(i));        // choose
            backtrack(digits, idx + 1, current, result, map); // explore
            current.deleteCharAt(current.length() - 1); // unchoose
        }
    }

    public static void main(String[] args)
    {
        _9LetterCombinationsOfPhoneNumber obj =
                new _9LetterCombinationsOfPhoneNumber();

        String digits = "23";

        System.out.println(obj.letterCombinations(digits));
    }
}

/*
---------------- DRY RUN ----------------

digits = "23"

map[2] = "abc"
map[3] = "def"

Start:
current = ""

Pick 'a'
→ pick 'd' → "ad"
→ pick 'e' → "ae"
→ pick 'f' → "af"

Pick 'b'
→ "bd", "be", "bf"

Pick 'c'
→ "cd", "ce", "cf"

Final Output:
[ad, ae, af, bd, be, bf, cd, ce, cf]

----------------------------------------
*/

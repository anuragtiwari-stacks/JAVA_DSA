package _19BackTracking;

// LeetCode 1593: Split a String Into the Max Number of Unique Substrings
import java.util.*;

public class _14MaxUniqueSplit
{
    public int maxUniqueSplit(String s)
    {
        Set<String> used = new HashSet<>();
        return backtrack(0, s, used);
    }

    public int backtrack(int index, String s, Set<String> used)
    {
        if (index == s.length())
        {
            return 0;
        }

        int max = 0;

        for (int end = index + 1; end <= s.length(); end++)
        {
            String sub = s.substring(index, end);

            if (used.contains(sub))
            {
                continue;
            }

            used.add(sub);                           // choose
            int count = 1 + backtrack(end, s, used); // explore
            max = Math.max(max, count);
            used.remove(sub);                        // unchoose
        }

        return max;
    }

    public static void main(String[] args)
    {
        _14MaxUniqueSplit obj = new _14MaxUniqueSplit();

        String s = "ababccc";

        System.out.println(obj.maxUniqueSplit(s));
    }
}

/*
---------------- DRY RUN ----------------

s = "ababccc"

Start index = 0
used = {}

Pick "a"
used = {a}

Pick "b"
used = {a, b}

Pick "ab"
used = {a, b, ab}

Pick "c"
used = {a, b, ab, c}

Pick "cc"
used = {a, b, ab, c, cc}

Pick "c"
→ already used, skip

Maximum unique split count = 5

One valid split:
["a","b","ab","c","cc"]

----------------------------------------
*/

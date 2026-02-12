package _18Recursion;

/*
QUESTION (LeetCode 22 - Generate Parentheses):

Given n pairs of parentheses,
write a recursive program to generate all combinations
of well-formed parentheses.

Conditions:
- Use ONLY recursion
- No backtracking (no remove operation)
*/

import java.util.ArrayList;
import java.util.List;

public class _4GenerateParentheses
{
    public static void main(String[] args)
    {
        int n = 3;

        List<String> ans = new ArrayList<>();

        generate(n, 0, 0, "", ans);

        System.out.println(ans);
    }

    static void generate(int n, int open, int close, String path, List<String> ans)
    {
        if (open == n && close == n)
        {
            ans.add(path);
            return;
        }

        if (open < n)
        {
            generate(n, open + 1, close, path + "(", ans);
        }

        if (close < open)
        {
            generate(n, open, close + 1, path + ")", ans);
        }
    }
}

/*
==================== SIMPLE DRY RUN (BEGINNER FRIENDLY) ====================

Input:
n = 3

Meaning:
Total "(" = 3
Total ")" = 3
At any time:
")" count <= "(" count

---------------------------------------------------------------------------
STEP 1:
generate(n=3, open=0, close=0, path="")

Only "(" allowed
→ path = "("

---------------------------------------------------------------------------
STEP 2:
open=1, close=0, path="("

Two choices:
1) "(" → "(("
2) ")" → "()"

---------------------------------------------------------------------------
STEP 3:
Path = "(("

open=2, close=0

Choices:
1) "(" → "((("
2) ")" → "(()"

---------------------------------------------------------------------------
STEP 4:
Path = "((("

open=3, close=0

Only ")" allowed:
→ "((()"
→ "((())"
→ "((()))"  ✅ PRINT

---------------------------------------------------------------------------
STEP 5:
Path = "(()"

open=2, close=1

Choices:
1) "(" → "(()("
2) ")" → "(())"

Both paths continue similarly and valid ones get printed.

---------------------------------------------------------------------------
FINAL OUTPUT:
((()))
(()())
(())()
()(())
()()()

---------------------------------------------------------------------------
IMPORTANT RULES (YAAD RAKHO):
- "(" tabhi add karo jab open < n
- ")" tabhi add karo jab close < open
- Jab open == close == n → valid answer

===========================================================================
*/

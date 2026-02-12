package _18Recursion;

/*
QUESTION (LeetCode 38 - Count and Say):

The count-and-say sequence is defined as:
1. countAndSay(1) = "1"
2. countAndSay(n) is obtained by describing countAndSay(n - 1)

Example:
n = 4

countAndSay(1) = "1"
countAndSay(2) = "11"      (one 1)
countAndSay(3) = "21"      (two 1s)
countAndSay(4) = "1211"    (one 2, one 1)
*/

public class _5CountAndSay
{
    public static void main(String[] args)
    {
        int n = 4;

        String ans = countAndSay(n);

        System.out.println(ans);
    }

    static String countAndSay(int n)
    {
        if (n == 1)
        {
            return "1";
        }

        String say = countAndSay(n - 1);

        String result = "";

        for (int i = 0; i < say.length(); i++)
        {
            char ch = say.charAt(i);
            int count = 1;

            while (i < say.length() - 1 && say.charAt(i) == say.charAt(i + 1))
            {
                count++;
                i++;
            }

            result = result + count + ch;
        }

        return result;
    }
}

/*
==================== SIMPLE DRY RUN (BEGINNER FRIENDLY) ====================

Input:
n = 4

---------------------------------------------------------------------------
STEP 1:
countAndSay(4)
→ calls countAndSay(3)

---------------------------------------------------------------------------
STEP 2:
countAndSay(3)
→ calls countAndSay(2)

---------------------------------------------------------------------------
STEP 3:
countAndSay(2)
→ calls countAndSay(1)

---------------------------------------------------------------------------
STEP 4:
countAndSay(1)
Base case → return "1"

---------------------------------------------------------------------------
STEP 5:
say = "1"
Process:
one '1'
result = "11"

Return "11"

---------------------------------------------------------------------------
STEP 6:
say = "11"
Process:
two '1'
result = "21"

Return "21"

---------------------------------------------------------------------------
STEP 7:
say = "21"
Process:
one '2' → "12"
one '1' → "11"

result = "1211"

---------------------------------------------------------------------------
FINAL OUTPUT:
1211

---------------------------------------------------------------------------
IMPORTANT RULE YAAD RAKHO:
- Pehle n-1 ka answer banta hai
- Fir us string ko read karke n-th string banti hai
- Same characters ko count karte jao (while loop)

===========================================================================
*/

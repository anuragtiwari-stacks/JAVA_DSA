package _15Recursion;

/*
QUESTION:
Given an integer n,
generate and print all binary strings of length n
such that there are NO consecutive 1s.

A binary string contains only:
0 and 1

Example:
n = 3

Valid Output:
000
001
010
100
101
*/

public class _6BinaryStringsNoConsecutiveOne
{
    public static void main(String[] args)
    {
        int n = 3;

        generateBinaryStrings(n, "", '0');
    }

    static void generateBinaryStrings(int n, String path, char lastChar)
    {
        if (path.length() == n)
        {
            System.out.println(path);
            return;
        }

        // Always allowed to add '0'
        generateBinaryStrings(n, path + "0", '0');

        // Add '1' only if last character is NOT '1'
        if (lastChar != '1')
        {
            generateBinaryStrings(n, path + "1", '1');
        }
    }
}

/*
==================== SIMPLE DRY RUN (BEGINNER FRIENDLY) ====================

Input:
n = 3

Rule:
- "0" can be added anytime
- "1" can be added ONLY if previous character was not '1'

---------------------------------------------------------------------------
STEP 1:
generateBinaryStrings(3, "", '0')

path = ""

Choices:
add 0 → "0"
add 1 → "1"

---------------------------------------------------------------------------
STEP 2:
Path = "0", lastChar = '0'

Choices:
add 0 → "00"
add 1 → "01"

---------------------------------------------------------------------------
STEP 3:
Path = "01", lastChar = '1'

Choices:
add 0 → "010"
add 1 ❌ (not allowed, consecutive 1)

"010" → PRINT

---------------------------------------------------------------------------
STEP 4:
Path = "00"

Choices:
"000" → PRINT
"001" → PRINT

---------------------------------------------------------------------------
STEP 5:
Path = "1", lastChar = '1'

Choices:
add 0 → "10"
add 1 ❌

---------------------------------------------------------------------------
STEP 6:
Path = "10"

Choices:
"100" → PRINT
"101" → PRINT

---------------------------------------------------------------------------
FINAL OUTPUT:
000
001
010
100
101

---------------------------------------------------------------------------
IMPORTANT RULE YAAD RAKHO:
- Base case: length == n → print
- "0" always allowed
- "1" only if previous character ≠ '1'

===========================================================================
*/

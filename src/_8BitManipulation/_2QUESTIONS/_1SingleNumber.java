package _8BitManipulation._2QUESTIONS;

public class _1SingleNumber
{
    public static void main(String[] args)
    {
        int[] nums = {4, 1, 2, 1, 2};

        System.out.println("Single Number: " + singleNumber(nums));
    }

    public static int singleNumber(int[] nums)
    {
        int xor = 0;

        for (int num : nums)
        {
            xor ^= num;
        }

        return xor;
    }
}

/*
=====================================================
LEETCODE 136 – Single Number
PURE CONCEPT + COMPLETE DRY RUN
=====================================================

PROBLEM:
---------
Array me:
- Har number exactly 2 baar aata hai
- Sirf 1 number aisa hai jo 1 baar aata hai
Us unique number ko find karna hai

Example:
---------
nums = [4, 1, 2, 1, 2]

Expected Output:
----------------
4

-----------------------------------------------------
CORE CONCEPT (ONE LINE):
-----------------------------------------------------
XOR duplicates ko cancel kar deta hai,
aur unique number bach jaata hai

-----------------------------------------------------
XOR PROPERTIES:
-----------------------------------------------------
a ^ a = 0
a ^ 0 = a
XOR associative & commutative hota hai

-----------------------------------------------------
DRY RUN (STEP BY STEP):
-----------------------------------------------------

nums = [4, 1, 2, 1, 2]

Initial:
xor = 0

----------------------------------
Iteration 1:
num = 4
xor = 0 ^ 4 = 4

----------------------------------
Iteration 2:
num = 1
xor = 4 ^ 1 = 5

----------------------------------
Iteration 3:
num = 2
xor = 5 ^ 2 = 7

----------------------------------
Iteration 4:
num = 1
xor = 7 ^ 1 = 6

----------------------------------
Iteration 5:
num = 2
xor = 6 ^ 2 = 4

----------------------------------
Loop ends

Final xor = 4

-----------------------------------------------------
FINAL ANSWER:
-----------------------------------------------------
Single Number = 4

-----------------------------------------------------
WHY THIS WORKS?
-----------------------------------------------------
(1 ^ 1) = 0
(2 ^ 2) = 0

Remaining:
0 ^ 0 ^ 4 = 4

-----------------------------------------------------
TIME & SPACE:
-----------------------------------------------------
Time Complexity: O(n)
Space Complexity: O(1)

-----------------------------------------------------
INTERVIEW ONE-LINER:
-----------------------------------------------------
"XOR cancels duplicates, unique number survives."

=====================================================
END
=====================================================
*/

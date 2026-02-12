package _11BitManipulation._1BASICS;

public class _8MissingNumber
{
    public static void main(String[] args)
    {
        int[] nums = {0, 1, 3};

        /*
            ✅ Concept:
            In an array of size n containing distinct numbers from 0 to n (one number is missing),
            use XOR to find the missing number efficiently.

            🔑 XOR Properties:
            - a ^ a = 0
            - a ^ 0 = a
            - XOR is associative and commutative

            🧠 Logic:
            - XOR all numbers from 0 to n (expected full range)
            - XOR all elements in the array
            - XOR both results → the missing number remains

            ✅ Time: O(n)
            ✅ Space: O(1)

            🧪 Dry Run:
            Array: {0, 1, 3}
            Expected range: 0 to 3

            Step-by-step:

            Initial xor = 0

            i = 0 → xor = 0 ^ 0 ^ 0 = 0
            i = 1 → xor = 0 ^ 1 ^ 1 = 0
            i = 2 → xor = 0 ^ 2 ^ 3 = 1

            Add last index (n): xor = 1 ^ 3 = 2 ✅
         */

        System.out.println("Missing number: " + missingNumber(nums));  // Output should be 2
    }

    public static int missingNumber(int[] nums)
    {
        int xor = 0;

        // XOR all indices and values in the array
        for (int i = 0; i < nums.length; i++)
        {
            xor = xor ^ i ^ nums[i];
        }

        // Include the last index (n)
        xor = xor ^ nums.length;

        // Final result is the missing number
        return xor;
    }
}

/*
=====================================================
LEETCODE 268 – Missing Number
PURE CONCEPT + COMPLETE DRY RUN (STEP BY STEP)
=====================================================

PROBLEM:
---------
Array me numbers 0 se n tak hote hain (distinct),
lekin ek number missing hota hai.

Array size = n
Numbers range = [0, n]

Example:
---------
nums = [0, 1, 3]
n = 3

Expected Output:
----------------
2

-----------------------------------------------------
CORE CONCEPT (ONE LINE):
-----------------------------------------------------
XOR duplicates ko cancel kar deta hai,
isliye jo number missing hota hai wahi bach jaata hai

-----------------------------------------------------
XOR PROPERTIES (VERY IMPORTANT):
-----------------------------------------------------
a ^ a = 0
a ^ 0 = a
XOR associative & commutative hota hai

-----------------------------------------------------
IDEA / LOGIC:
-----------------------------------------------------
1. 0 se n tak ke saare numbers ka XOR lena
2. Array ke saare elements ka XOR lena
3. Dono XOR ko XOR kar dena
4. Jo number missing hai wahi result hoga

-----------------------------------------------------
DRY RUN (STEP BY STEP):
-----------------------------------------------------

nums = [0, 1, 3]
length = 3
Expected numbers = 0, 1, 2, 3

Initialize:
xor = 0

----------------------------------
Loop over array (i from 0 to n-1)
----------------------------------

i = 0
xor = xor ^ i ^ nums[i]
xor = 0 ^ 0 ^ 0
xor = 0

i = 1
xor = 0 ^ 1 ^ 1
xor = 0

i = 2
xor = 0 ^ 2 ^ 3
xor = 1

----------------------------------
Include last number (n)
----------------------------------

xor = 1 ^ 3
xor = 2

-----------------------------------------------------
FINAL ANSWER:
-----------------------------------------------------
Missing Number = 2

-----------------------------------------------------
WHY THIS WORKS?
-----------------------------------------------------

Array values:    0, 1, 3
Expected values: 0, 1, 2, 3

XOR all:
(0 ^ 0) ^ (1 ^ 1) ^ (3) ^ (2)
= 0 ^ 0 ^ 3 ^ 2
= 1 ^ 2
= 2

Sab duplicates cancel ho gaye,
sirf missing number bacha

-----------------------------------------------------
TIME & SPACE:
-----------------------------------------------------
Time Complexity: O(n)
Space Complexity: O(1)

-----------------------------------------------------
INTERVIEW ONE-LINER:
-----------------------------------------------------
"XOR cancels duplicates, missing number survives."

=====================================================
END
=====================================================
*/


package _8BitManipulation._1BASICS;

import java.util.Arrays;

public class _6TwoSingleNumbers
{
    public static void main(String[] args)
    {
        int[] arr = {2, 4, 6, 2, 5, 4};

        /*
            ✅ Concept:

            In an array where every number appears twice except for **two unique numbers**,
            we can use **bitwise XOR** to find those two numbers.

            🔑 Steps:
            1. XOR all elements → result will be XOR of the two unique numbers: x ^ y
            2. Find the **rightmost set bit** in the result → this bit is different in x and y
            3. Split numbers into two groups based on this set bit:
               - Group A: where that bit is 0
               - Group B: where that bit is 1
            4. XOR within each group → duplicates cancel out, and we get x and y

            ✅ Time: O(n)
            ✅ Space: O(1)
         */

        /*
            🧪 Dry Run:
            Input array = {2, 4, 6, 2, 5, 4}

            Step 1: XOR all numbers
            xor = 2 ^ 4 ^ 6 ^ 2 ^ 5 ^ 4
                = (2 ^ 2) ^ (4 ^ 4) ^ 6 ^ 5
                = 0 ^ 0 ^ 6 ^ 5
                = 6 ^ 5 = 3 (binary: 0011)

            Step 2: Find rightmost set bit
            rightmostSetBit = 3 & -3 = 0001

            Step 3: Divide into 2 groups based on this bit:
            Group A (bit not set at pos 0): 2, 2, 6
            Group B (bit set at pos 0):     4, 4, 5

            Step 4: XOR each group:
            Group A: 2 ^ 2 ^ 6 = 6
            Group B: 4 ^ 4 ^ 5 = 5

            ✅ Answer = {6, 5}
         */

        System.out.println("Two unique numbers: " + Arrays.toString(findTwoSingles(arr)));
    }

    public static int[] findTwoSingles(int[] nums)
    {
        int xor = 0;

        // Step 1: XOR of all elements = a ^ b (two unique numbers)
        for (int num : nums)
        {
            xor ^= num;
        }

        // Step 2: Find the rightmost set bit (used to separate the two numbers)
        int rightmostSetBit = xor & -xor;

        int a = 0, b = 0;

        // Step 3: Divide elements into two groups and XOR separately
        for (int num : nums)
        {
            if ((num & rightmostSetBit) == 0)
            {
                a = a ^ num;
            }
            else
            {
                b = b ^ num;
            }
        }

        return new int[]{a, b}; // These are the two unique numbers
    }
}
/*
=====================================================
LEETCODE 260 – Single Number III
PURE CONCEPT + COMPLETE DRY RUN (STEP BY STEP)
=====================================================

PROBLEM:
---------
Array me:
- Har number exactly 2 baar aata hai
- Sirf 2 numbers aise hain jo 1-1 baar aate hain
Un dono unique numbers ko find karna hai.

Example:
---------
nums = [2, 4, 6, 2, 5, 4]

Expected Output:
----------------
[6, 5]

-----------------------------------------------------
CORE CONCEPT (ONE LINE):
-----------------------------------------------------
XOR duplicates ko cancel kar deta hai
aur (xor & -xor) unique numbers ko alag-alag group me baant deta hai

-----------------------------------------------------
STEP 1: XOR OF ALL ELEMENTS
-----------------------------------------------------

XOR properties:
x ^ x = 0
x ^ 0 = x
order matter nahi karta

Calculation:
xor = 2 ^ 4 ^ 6 ^ 2 ^ 5 ^ 4

Rearrange:
= (2 ^ 2) ^ (4 ^ 4) ^ 6 ^ 5
= 0 ^ 0 ^ 6 ^ 5
= 6 ^ 5
= 3

Binary:
6 = 0110
5 = 0101
---------
xor = 0011

Matlab:
xor = a ^ b
(jahan a aur b wahi 2 unique numbers hain)

-----------------------------------------------------
STEP 2: RIGHTMOST SET BIT NIKALNA
-----------------------------------------------------

Code:
rightmostSetBit = xor & -xor;

Samjho -xor kya hota hai:
-x = (~x) + 1   (Two’s Complement)

xor  = 0011
~xor = 1100
+1   = 1101  → -xor

Ab AND:
0011
1101
----
0001

rightmostSetBit = 0001

Matlab:
Ye bit a aur b me different hai
ek me 0 hoga
dusre me 1 hoga

-----------------------------------------------------
STEP 3: NUMBERS KO 2 GROUPS ME DIVIDE KARNA
-----------------------------------------------------

Rule:
(num & rightmostSetBit) == 0  → Group A
else                          → Group B

Check each number:

2  = 0010 & 0001 = 0 → Group A
4  = 0100 & 0001 = 0 → Group A
6  = 0110 & 0001 = 0 → Group A
2  = 0010 & 0001 = 0 → Group A
5  = 0101 & 0001 = 1 → Group B
4  = 0100 & 0001 = 0 → Group A

Groups:
Group A = [2, 4, 6, 2, 4]
Group B = [5]

-----------------------------------------------------
STEP 4: GROUP-WISE XOR
-----------------------------------------------------

Group A XOR:
2 ^ 4 ^ 6 ^ 2 ^ 4
= (2 ^ 2) ^ (4 ^ 4) ^ 6
= 0 ^ 0 ^ 6
= 6

Group B XOR:
5 = 5

-----------------------------------------------------
FINAL ANSWER:
-----------------------------------------------------
[6, 5]

-----------------------------------------------------
KYU YE APPROACH KAAM KARTA HAI?
-----------------------------------------------------

1. XOR duplicates ko hata deta hai
2. xor = a ^ b milta hai
3. rightmost set bit a aur b ko alag karta hai
4. duplicates same group me jaate hain → cancel
5. unique alag groups me jaate hain → mil jaate hain

-----------------------------------------------------
INTERVIEW ONE-LINER:
-----------------------------------------------------
"XOR removes duplicates, and xor & -xor separates the two unique numbers"

=====================================================
END
=====================================================
*/

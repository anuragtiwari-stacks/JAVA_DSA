package _11BitManipulation._2QUESTIONS;

public class _6SingleNumberIII
{

    public static int[] singleNumber(int[] nums)
    {

        int xor = 0;

        for (int num : nums)
        {
            xor = xor ^ num;
        }

        int diffBit = xor & (-xor);

        int a = 0;
        int b = 0;

        for (int num : nums)
        {
            if ((num & diffBit) == 0)
            {
                a = a ^ num;
            }
            else
            {
                b = b ^ num;
            }
        }

        return new int[]{a, b};
    }

    public static void main(String[] args)
    {

        int[] nums = {1, 2, 1, 3, 2, 5};

        int[] result = singleNumber(nums);

        System.out.println(result[0] + " " + result[1]);
    }

    /*
     Dry Run

     nums = [1, 2, 1, 3, 2, 5]

     Step 1: XOR of all elements

     1 ^ 2 ^ 1 ^ 3 ^ 2 ^ 5
     = (1 ^ 1) ^ (2 ^ 2) ^ (3 ^ 5)
     = 0 ^ 0 ^ 6
     = 6

     xor = 6
     Binary of xor = 110

     Step 2: Find rightmost set bit

     diffBit = xor & (-xor)
     diffBit = 110 & 010
     diffBit = 010

     Step 3: Divide numbers into two groups

     Group 1 (bit = 0): 1, 1, 2, 2
     XOR → 0

     Group 2 (bit = 1): 3, 5
     XOR → 6 ^ 3 ^ 5 = 3 ^ 5 = 6

     Final numbers
     a = 3
     b = 5
    */
}

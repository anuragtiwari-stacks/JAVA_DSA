package _8BitManipulation._1BASICS;

public class _5SingleNumber
{
    public static void main(String[] args)
    {
        int[] arr = {2, 3, 2, 4, 4};

        /*
            ✅ Concept:

            - If every number appears twice except one, we can find the unique number using XOR.
            - Property of XOR (^):
                a ^ a = 0
                a ^ 0 = a
                XOR is commutative and associative:
                a ^ b ^ a = (a ^ a) ^ b = 0 ^ b = b

            So, if we XOR all elements:
                duplicates cancel each other
                and only the single number remains

            ✅ Time Complexity: O(n)
            ✅ Space Complexity: O(1)
        */

        /*
            🧪 Dry Run:
            Input array = {2, 3, 2, 4, 4}

            Step-by-step:
            ans = 0
            ans = 0 ^ 2 = 2
            ans = 2 ^ 3 = 1
            ans = 1 ^ 2 = 3
            ans = 3 ^ 4 = 7
            ans = 7 ^ 4 = 3

            Final Answer = 3 (which appears only once)
        */

        System.out.println("Single number: " + findSingle(arr));
    }

    public static int findSingle(int[] nums)
    {
        int ans = 0;
        for (int num : nums)
        {
            ans =ans ^ num; // XOR with each element
        }
        return ans;
    }
}

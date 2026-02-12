package _15Greedy.PW;

public class _4MinimumProductSubset
{
    public static int minProductSubset(int[] arr)
    {
        int n = arr.length;

        // Step 1: Count values and find key numbers
        int countNegative = 0;
        int countZero = 0;
        int maxNegative = Integer.MIN_VALUE; // largest negative
        int minPositive = Integer.MAX_VALUE; // smallest positive
        int product = 1;

        for (int num : arr)
        {
            if (num == 0)
            {
                countZero++;
                continue;
            }
            if (num < 0)
            {
                countNegative++;
                if (num > maxNegative)
                {
                    maxNegative = num;
                }
            }
            if (num > 0 && num < minPositive)
            {
                minPositive = num;
            }
            product *= num;
        }

        // Step 2: Apply rules

        // Zeros + positives + no negatives
        if (countNegative == 0 && countZero > 0)
        {
            return 0;
        }

        // Exceptional case: All positives, no zeros
        if (countNegative == 0 && countZero == 0)
        {
            return minPositive;
        }

        // Even negatives, no zero
        if (countNegative % 2 == 0 && countZero == 0)
        {
            return product / maxNegative;
        }

        // Odd negatives, no zero
        if (countNegative % 2 != 0 && countZero == 0)
        {
            return product;
        }

        // Zeros present + negatives
        if (countZero > 0 && countNegative > 0)
        {
            return 0;
        }

        return product; // Fallback
        //     If none of the earlier specific cases are matched, we return this default value.
    }

    public static void main(String[] args)
    {
        int[] arr1 = {-1, -1, -2, 4, 3};  // Odd negatives
        int[] arr2 = {-1, -2, 4, 3};      // Even negatives
        int[] arr3 = {0, 4, 3};           // Zeros + positives
        int[] arr4 = {5, 2, 8};           // All positives
        int[] arr5 = {-1, -2, 0, 4};      // Negatives + zero

        System.out.println(minProductSubset(arr1)); // -24
        System.out.println(minProductSubset(arr2)); // -24
        System.out.println(minProductSubset(arr3)); // 0
        System.out.println(minProductSubset(arr4)); // 2
        System.out.println(minProductSubset(arr5)); // 0
    }
}

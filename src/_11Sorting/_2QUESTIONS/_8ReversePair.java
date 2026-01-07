package _11Sorting._2QUESTIONS;

/*
QUESTION:
LeetCode 493 – Reverse Pairs

A reverse pair is a pair (i, j) such that:
1) 0 <= i < j < nums.length
2) nums[i] > 2 * nums[j]

LOGIC:
We use a modified Merge Sort.

Steps:
1) Divide the array using merge sort.
2) After sorting left and right halves, count reverse pairs.
3) Since halves are sorted:
   - If left[i] > 2 * right[j],
     then all elements from i to end of left also satisfy the condition.
4) Add (left.length - i) to count.
5) Use long to avoid integer overflow.

Time Complexity: O(n log n)
Space Complexity: O(n)
*/

public class _8ReversePair
{
    private int count = 0;

    public static void main(String[] args)
    {
        _8ReversePair obj = new _8ReversePair();

        int[] nums = {1, 3, 2, 3, 1};

        int result = obj.reversePairs(nums);

        System.out.println("Reverse Pairs Count = " + result);
    }
    // -------------------------------------------------

    public int reversePairs(int[] nums)
    {
        mergeSort(nums);
        return count;
    }

    private void mergeSort(int[] arr)
    {
        if (arr.length <= 1)
        {
            return;
        }

        int mid = arr.length / 2;

        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        for (int i = 0; i < mid; i++)
        {
            left[i] = arr[i];
        }

        for (int i = 0; i < right.length; i++)
        {
            right[i] = arr[i + mid];
        }

        mergeSort(left);
        mergeSort(right);

        countPairs(left, right);
        merge(left, right, arr);
    }

    private void countPairs(int[] left, int[] right)
    {
        int i = 0, j = 0;

        while (i < left.length && j < right.length)
        {
            if ((long) left[i] > 2L * right[j])
            {
                count += (left.length - i);
                j++;
            }
            else
            {
                i++;
            }
        }
    }

    private void merge(int[] left, int[] right, int[] arr)
    {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length)
        {
            if (left[i] <= right[j])
            {
                arr[k++] = left[i++];
            }
            else
            {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length)
        {
            arr[k++] = left[i++];
        }

        while (j < right.length)
        {
            arr[k++] = right[j++];
        }
    }
}

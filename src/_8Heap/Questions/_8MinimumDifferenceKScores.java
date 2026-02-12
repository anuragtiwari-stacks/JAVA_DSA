package _8Heap.Questions;

import java.util.Arrays;

public class _8MinimumDifferenceKScores
{
    public int minimumDifference(int[] arr, int k)
    {
        if (k == 1)
        {
            return 0;
        }

        Arrays.sort(arr);

        int n = arr.length;

        int i = 0;
        int j = k - 1;

        int minDiff = arr[j] - arr[i];

        i++;
        j++;

        while (j < n)
        {
            int diff = arr[j] - arr[i];
            minDiff = Math.min(minDiff, diff);

            i++;
            j++;
        }

        return minDiff;
    }

    public static void main(String[] args)
    {
        _8MinimumDifferenceKScores obj = new _8MinimumDifferenceKScores();

        int[] arr = {9, 4, 1, 7};
        int k = 2;

        System.out.println(obj.minimumDifference(arr, k));
    }
}

/*
Input:
arr = [9, 4, 1, 7]
k = 2

After sort:
[1, 4, 7, 9]

Initial window:
i = 0, j = 1
diff = 4 - 1 = 3
minDiff = 3

Slide window:

i = 1, j = 2
diff = 7 - 4 = 3
minDiff = 3

i = 2, j = 3
diff = 9 - 7 = 2
minDiff = 2

Output:
2
*/

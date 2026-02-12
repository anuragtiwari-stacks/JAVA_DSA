package _14Sorting._2QUESTIONS;

/*
        ✅ What is Inversion Count?

        A pair (i, j) is an inversion if:
            - i < j
            - arr[i] > arr[j]

        This optimized approach uses merge sort to count inversions in O(n log n) time.
*/
public class _7InversionCountOptimized
{

    static int count = 0;

    // Counts inversions between two sorted arrays a and b
    public static void inversion(int[] a, int[] b)
    {
        int i = 0, j = 0;

        while (i < a.length && j < b.length)
        {
            if (a[i] >  b[j])
            {
                count += (a.length - i); // key logic
                j++;
            }
            else
            {
                i++;
            }
        }
    }

    // Merge sort function
    public static void mergeSort(int[] arr)
    {
        int n = arr.length;
        if (n == 1)
        {
            return;
        }

        int mid = n / 2;

        int[] a = new int[mid];
        int[] b = new int[n - mid];

        // copy elements
        for (int i = 0; i < mid; i++)
        {
            a[i] = arr[i];
        }

        for (int i = 0; i < n - mid; i++)
        {
            b[i] = arr[i + mid];
        }

        mergeSort(a);
        mergeSort(b);

        // count inversions between a and b
        inversion(a, b);

        // merge arrays
        merge(a, b, arr);
    }

    // Merge two sorted arrays
    public static void merge(int[] a, int[] b, int[] arr)
    {
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length)
        {
            if (a[i] <= b[j])
            {
                arr[k++] = a[i++];
            }
            else
            {
                arr[k++] = b[j++];
            }
        }

        while (i < a.length)
        {
            arr[k++] = a[i++];
        }

        while (j < b.length)
        {
            arr[k++] = b[j++];
        }
    }

    public static void main(String[] args)
    {
        int[] arr = {2, 4, 1, 3, 5};

        mergeSort(arr);

        System.out.println("Inversion Count: " + count);
    }
}


/*
====================================================
DRY RUN : Inversion Count using Merge Sort
Input : [2, 4, 1, 3, 5]
====================================================
----------------------------------------------------
STEP 1: Initial mergeSort call
----------------------------------------------------
mergeSort([2, 4, 1, 3, 5])

Split into:
Left  = [2, 4]
Right = [1, 3, 5]

----------------------------------------------------
STEP 2: mergeSort on Left part [2, 4]
----------------------------------------------------
Split into:
[2] and [4]

Both are single elements → base case

inversion([2], [4]):
2 > 4 ? ❌
No inversion

Merged array → [2, 4]
Inversion count so far = 0

----------------------------------------------------
STEP 3: mergeSort on Right part [1, 3, 5]
----------------------------------------------------
Split into:
[1] and [3, 5]

mergeSort([3, 5]):
Split into:
[3] and [5]

inversion([3], [5]):
3 > 5 ? ❌
No inversion

Merged → [3, 5]

inversion([1], [3, 5]):
1 > 3 ? ❌
No inversion

Merged → [1, 3, 5]
Inversion count so far = 0

----------------------------------------------------
STEP 4: MAIN inversion between [2, 4] and [1, 3, 5]
----------------------------------------------------

Left array  a = [2, 4]
Right array b = [1, 3, 5]

i = 0, j = 0, count = 0

Comparison 1:
a[i] = 2, b[j] = 1
2 > 1 ✔️

count += (a.length - i)
count += (2 - 0) = 2

Inversion pairs:
(2,1), (4,1)

j++

count = 2

----------------------------------------------------
Comparison 2:
a[i] = 2, b[j] = 3
2 > 3 ❌
i++

----------------------------------------------------
Comparison 3:
a[i] = 4, b[j] = 3
4 > 3 ✔️

count += (2 - 1) = 1

Inversion pair:
(4,3)

j++

count = 3

----------------------------------------------------
Comparison 4:
a[i] = 4, b[j] = 5
4 > 5 ❌
i++

Loop ends

----------------------------------------------------
FINAL RESULT
----------------------------------------------------
Total Inversion Count = 3

Inversion pairs are:
(2,1), (4,1), (4,3)

Sorted array after merge sort:
[1, 2, 3, 4, 5]

====================================================
*/

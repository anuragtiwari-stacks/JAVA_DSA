package _10Searching;

/*
LOWER BOUND:
Lower Bound = first index i such that arr[i] >= x
If no such element exists, return arr.length
*/

public class _3LowerBound
{
    public static int lowerBound(int[] arr, int x)
    {
        int lo = 0;
        int hi = arr.length - 1;
        int lb = arr.length;

        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;

            if (arr[mid] >= x)
            {
                lb = mid;
                hi = mid - 1;
            }
            else
            {
                lo = mid + 1;
            }
        }
        return lb;
    }

    public static void main(String[] args)
    {
        int[] arr = {10, 20, 30, 30, 40, 50, 60, 700};
        int[] targets = {5, 10, 20, 25, 30, 80, 900};

        for (int target : targets)
        {
            int index = lowerBound(arr, target);

            if (index < arr.length)
                System.out.println("LB(" + target + ") = index " + index + ", value = " + arr[index]);
            else
                System.out.println("LB(" + target + ") = not found");
        }
    }
}

/*
==================== DRY RUN ====================

Array: {10, 20, 30, 30, 40, 50, 60, 700}

-----------------------------------------------
Target = 10
lo=0, hi=7, lb=8
mid=3 → arr[3]=30 >= 10 → lb=3, hi=2
mid=1 → arr[1]=20 >= 10 → lb=1, hi=0
mid=0 → arr[0]=10 >= 10 → lb=0, hi=-1
END → LB = 0 (value = 10)

-----------------------------------------------
Target = 25
lo=0, hi=7, lb=8
mid=3 → arr[3]=30 >= 25 → lb=3, hi=2
mid=1 → arr[1]=20 < 25 → lo=2
mid=2 → arr[2]=30 >= 25 → lb=2, hi=1
END → LB = 2 (value = 30)

-----------------------------------------------
Target = 80
lo=0, hi=7, lb=8
mid=3 → 30 < 80 → lo=4
mid=5 → 50 < 80 → lo=6
mid=6 → 60 < 80 → lo=7
mid=7 → 700 >= 80 → lb=7, hi=6
END → LB = 7 (value = 700)

-----------------------------------------------
Target = 900
lo=0, hi=7, lb=8
mid=3 → 30 < 900 → lo=4
mid=5 → 50 < 900 → lo=6
mid=6 → 60 < 900 → lo=7
mid=7 → 700 < 900 → lo=8
END → LB = 8 → not found

================================================
*/

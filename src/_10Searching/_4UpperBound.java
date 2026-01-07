package _10Searching;

public class _4UpperBound
{
    public static int upperBound(int[] arr, int x)
    {
        int lo = 0;
        int hi = arr.length - 1;
        int ub = arr.length; // Default: not found

        while (lo <= hi)
        {
            int mid = (lo + hi) / 2;

            if (arr[mid] > x)
            {
                ub = Math.min(ub, mid); // Candidate for upper bound
                hi = mid - 1;           // Try earlier
            }
            else
            {
                lo = mid + 1;           // Move right
            }
        }

        return ub;
    }

    public static void main(String[] args)
    {
        int[] arr = {10, 20, 30, 30, 40, 50, 60, 700};
        int[] targets = {10, 20, 25, 30, 900, 80};

        for (int target : targets)
        {
            int index = upperBound(arr, target);

            if (index < arr.length)
            {
                System.out.println("Upper Bound of " + target + " is at index: " + index + " → value: " + arr[index]);
            }
            else
            {
                System.out.println("Upper Bound of " + target + " not found. No element > " + target);
            }
        }
    }
}

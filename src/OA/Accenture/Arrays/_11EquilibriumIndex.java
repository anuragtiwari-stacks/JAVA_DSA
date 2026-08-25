package OA.Accenture.Arrays;

// Question: Find the equilibrium index of an array (sum of left equals sum of right)

public class _11EquilibriumIndex
{
    public static void main(String[] args)
    {
        int[] nums = {1, 7, 3, 6, 5, 6};

        System.out.println(pivotIndex(nums));
    }

    static int pivotIndex(int[] nums)
    {
        int n = nums.length;

        int[] prefix = new int[n];

        prefix[0] = nums[0];

        for(int i = 1; i < n; i++)
        {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        int left = 0;
        int right = n - 1;

        if(prefix[right] - prefix[left] == 0)
        {
            return 0;
        }

        for(int i = 1; i < n - 1; i++)
        {
            left = prefix[i - 1];
            right = prefix[n - 1] - prefix[i];

            if(left == right)
            {
                return i;
            }
        }

        if(prefix[n - 2] == 0)
        {
            return n - 1;
        }

        return -1;
    }
}
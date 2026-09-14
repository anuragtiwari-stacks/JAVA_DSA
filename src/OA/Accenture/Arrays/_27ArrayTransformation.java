package OA.Accenture.Arrays;

// Question: Transform each array element based on its 0-based index
// 1. Subtract (i % 7) * 3 from the element
// 2. If the original element is divisible by 11, add original element / 11
// Return the total sum of all elements after transformation

public class _27ArrayTransformation
{
    public static void main(String[] args)
    {
        int[] nums = {22, 5, 14};

        System.out.println(transform(nums));
    }

    static int transform(int[] nums)
    {
        int sum = 0;

        for(int i = 0; i < nums.length; i++)
        {
            int original = nums[i];

            nums[i] = nums[i] - (i % 7) * 3;

            if(original % 11 == 0)
            {
                nums[i] += original / 11;
            }

            sum += nums[i];
        }

        return sum;
    }
}
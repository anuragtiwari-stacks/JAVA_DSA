package OA.Accenture.Arrays;

// Question: Find two numbers in an array that add up to a given target

import java.util.HashMap;

public class _8TwoSum
{
    public static void main(String[] args)
    {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);

        System.out.println(result[0] + " " + result[1]);
    }

    static int[] twoSum(int[] nums, int target)
    {
        HashMap<Integer, Integer> map = new HashMap<>();

        int n = nums.length;

        for(int i = 0; i < n; i++)
        {
            int need = target - nums[i];

            if(map.containsKey(need))
            {
                int[] result = new int[2];

                result[0] = map.get(need);
                result[1] = i;

                return result;
            }
            else
            {
                map.put(nums[i], i);
            }
        }

        int[] result = new int[2];

        result[0] = -1;
        result[1] = -1;

        return result;
    }
}
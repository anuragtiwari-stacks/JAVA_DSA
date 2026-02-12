// LeetCode 2971 - Find Polygon With the Largest Perimeter

package _15Greedy.MIK;

import java.util.Arrays;

public class _22FindPolygonWithTheLargestPerimeter
{
    public long largestPerimeter(int[] nums)
    {
        Arrays.sort(nums);
        int cumSum = 0;
        int ans = -1;
        for(int i = 0; i < nums.length; i++)
        {
            int edge = nums[i];
            if(cumSum > edge)
            {
                ans = cumSum + edge;
            }
            cumSum = cumSum + edge;
        }
        return ans;
    }

    public static void main(String[] args)
    {
        _22FindPolygonWithTheLargestPerimeter obj = new _22FindPolygonWithTheLargestPerimeter();
        int[] nums = {1,12,1,2,5,50,3};
        long result = obj.largestPerimeter(nums);
        System.out.println(result);
    }
}

/*
==================== DRY RUN (USING YOUR CONCEPT) ====================

Input:
nums = [1,12,1,2,5,50,3]

Step-1: sort
nums = [1,1,2,3,5,12,50]

cumSum = 0
ans = -1

i = 0:
edge = 1
cumSum > edge ? 0 > 1 = false
cumSum = 0 + 1 = 1

i = 1:
edge = 1
cumSum > edge ? 1 > 1 = false
cumSum = 1 + 1 = 2

i = 2:
edge = 2
cumSum > edge ? 2 > 2 = false
cumSum = 2 + 2 = 4

i = 3:
edge = 3
cumSum > edge ? 4 > 3 = true
ans = 4 + 3 = 7
cumSum = 4 + 3 = 7

i = 4:
edge = 5
cumSum > edge ? 7 > 5 = true
ans = 7 + 5 = 12
cumSum = 7 + 5 = 12

i = 5:
edge = 12
cumSum > edge ? 12 > 12 = false
cumSum = 12 + 12 = 24

i = 6:
edge = 50
cumSum > edge ? 24 > 50 = false
cumSum = 24 + 50 = 74

Loop ends

Final ans = 12

Console Output:
12

=================================================
*/

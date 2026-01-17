// LeetCode 1846 - Maximum Element After Decreasing and Rearranging

package _12Greedy.MIK;

import java.util.Arrays;

public class _19MaximumElementAfterDecreasingAndRearranging
{
    public int maximumElementAfterDecreasingAndRearranging(int[] arr)
    {
        int n = arr.length;
        Arrays.sort(arr);
        arr[0] = 1;
        for(int i = 1; i < n; i++)
        {
            if(Math.abs(arr[i] - arr[i - 1]) >= 1)
            {
                arr[i] = arr[i - 1] + 1;
            }
        }
        return arr[n - 1];
    }

    public static void main(String[] args)
    {
        _19MaximumElementAfterDecreasingAndRearranging obj = new _19MaximumElementAfterDecreasingAndRearranging();
        int[] arr = {100,1,1000,10};
        int result = obj.maximumElementAfterDecreasingAndRearranging(arr);
        System.out.println(result);
    }
}

/*
==================== DRY RUN (AS PER UPDATED CODE LOGIC) ====================

Input:
arr = [100,1,1000,10]

After sort:
arr = [1,10,100,1000]

arr[0] = 1
arr = [1,10,100,1000]

Loop:

i = 1:
abs(10 - 1) = 9 >= 1 → true
arr[1] = arr[0] + 1 = 1 + 1 = 2
arr = [1,2,100,1000]

i = 2:
abs(100 - 2) = 98 >= 1 → true
arr[2] = arr[1] + 1 = 2 + 1 = 3
arr = [1,2,3,1000]

i = 3:
abs(1000 - 3) = 997 >= 1 → true
arr[3] = arr[2] + 1 = 3 + 1 = 4
arr = [1,2,3,4]

Final result:
arr[n-1] = 4

Console Output:
4

=================================================
*/

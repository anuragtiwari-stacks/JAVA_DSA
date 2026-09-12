package _07Hashing.Questions;

import java.util.*;

public class _6LongestSubarrayKDistinct
{
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 1, 2, 3};
        int k = 2;

        System.out.println(longestSubarray(arr, k));
    }

    public static int longestSubarray(int[] arr, int k)
    {
        HashSet<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;

        int n = arr.length;

        for(int i=0;i<n;i++)
        {
            set.clear();
            int count = 0;

            for(int j=i;j<n;j++)
            {
                if(!set.contains(arr[j]))
                {
                    set.add(arr[j]);
                    count++;
                }

                if(count > k)
                {
                    break;
                }

                if(count <= k)
                {
                    int len = j-i+1;
                    max = Math.max(max,len);
                }
            }
        }

        return max;
    }
}
package _05Queue._2QUESTIONS;

import java.util.*;

public class _4SlidingWindowMax_Bruteforce
{
    public static List<Integer> slidingWindowMax(int[] arr, int k)
    {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i <= arr.length - k; i++)
        {
            int max = arr[i];

            for (int j = i; j < i + k; j++)
            {
                if (arr[j] > max)
                {
                    max = arr[j];
                }
            }

            result.add(max);
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;

        List<Integer> res = slidingWindowMax(arr, k);

        System.out.print("Sliding Window Maximums: ");
        for (int val : res)
        {
            System.out.print(val + " ");
        }
    }
}

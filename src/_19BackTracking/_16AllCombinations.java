package _19BackTracking;

package _01ARRAY_1D._19Combinations;

import java.util.*;

public class _16Combinations
{
    public static void generate(int[] arr, int r, int index, ArrayList<Integer> current)
    {
        // base case
        if(current.size() == r)
        {
            System.out.println(current);
            return;
        }

        // loop
        for(int i = index; i < arr.length; i++)
        {
            current.add(arr[i]);          // choose
            generate(arr, r, i + 1, current); // explore
            current.remove(current.size() - 1); // undo
        }
    }

    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 4};
        int r = 2;

        generate(arr, r, 0, new ArrayList<>());
    }
}
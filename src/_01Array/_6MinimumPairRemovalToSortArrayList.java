package _01Array;

// LeetCode 3507: Minimum Pair Removal to Sort Array I
import java.util.ArrayList;

public class _6MinimumPairRemovalToSortArrayList
{
    public int minimumPairRemoval(int[] nums)
    {
        ArrayList<Integer> list = new ArrayList<>();

        for (int x : nums)
        {
            list.add(x);
        }

        int operations = 0;

        while (!isSorted(list))
        {
            int minSum = Integer.MAX_VALUE;
            int idx = 0;

            for (int i = 0; i < list.size() - 1; i++)
            {
                int sum = list.get(i) + list.get(i + 1);

                if (sum < minSum)
                {
                    minSum = sum;
                    idx = i;
                }
            }

            int merged = minSum;

            list.remove(idx);
            list.remove(idx);
            list.add(idx, merged);

            operations++;
        }

        return operations;
    }

    private boolean isSorted(ArrayList<Integer> list)
    {
        for (int i = 1; i < list.size(); i++)
        {
            if (list.get(i) < list.get(i - 1))
            {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args)
    {
        int[] nums = {5, 2, 3, 1};

        _6MinimumPairRemovalToSortArrayList obj = new _6MinimumPairRemovalToSortArrayList();

        System.out.println(obj.minimumPairRemoval(nums));
    }
}


/*
---------------- DRY RUN (Example) ----------------

Input:
nums = [5, 2, 3, 1]

Initial list:
[5, 2, 3, 1]

Iteration 1:
Adjacent sums:
(5,2)=7 , (2,3)=5 , (3,1)=4
minSum = 4, idx = 2

Remove elements at index 2 and 3
Add merged value 4 at index 2

List becomes:
[5, 2, 4]
operations = 1

Iteration 2:
Adjacent sums:
(5,2)=7 , (2,4)=6
minSum = 6, idx = 1

Remove elements at index 1 and 2
Add merged value 6 at index 1

List becomes:
[5, 6]
operations = 2

List is non-decreasing.
Loop stops.

Output: 2

---------------------------------------------------
*/

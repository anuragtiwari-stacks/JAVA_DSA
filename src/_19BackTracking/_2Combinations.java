package _19BackTracking;

// LeetCode 77: Combinations
import java.util.ArrayList;
import java.util.List;

public class _2Combinations
{
    public List<List<Integer>> combine(int n, int k)
    {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(int start, int n, int k, List<Integer> curr, List<List<Integer>> result)
    {
        if (curr.size() == k)
        {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i <= n; i++)
        {
            curr.add(i);
            backtrack(i + 1, n, k, curr, result);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args)
    {
        _2Combinations obj = new _2Combinations();

        int n = 4;
        int k = 2;

        System.out.println(obj.combine(n, k));
    }
}

/*
---------------- DRY RUN ----------------

Input:
n = 4, k = 2

curr = []

Pick 1 → curr = [1]
Pick 2 → curr = [1,2] → store

Backtrack → curr = [1]
Pick 3 → curr = [1,3] → store
Pick 4 → curr = [1,4] → store

Backtrack → curr = []
Pick 2 → curr = [2]
Pick 3 → curr = [2,3] → store
Pick 4 → curr = [2,4] → store

Pick 3 → curr = [3]
Pick 4 → curr = [3,4] → store

----------------------------------------
*/

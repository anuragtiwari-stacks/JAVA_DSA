package _1Array;

import java.util.HashSet;

// LeetCode 3719: Longest Balanced Subarray I
public class _16LongestBalancedSubarrayI
{

    public int longestBalanced(int[] arr)
    {
        int n = arr.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++)
        {
            HashSet<Integer> set = new HashSet<>();

            int evenCount = 0;
            int oddCount = 0;

            for (int j = i; j < n; j++)
            {
                if (!set.contains(arr[j]))
                {
                    set.add(arr[j]);

                    if (arr[j] % 2 == 0)
                    {
                        evenCount++;
                    }
                    else
                    {
                        oddCount++;
                    }
                }

                if (evenCount == oddCount)
                {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 4, 5, 6};

        _16LongestBalancedSubarrayI obj = new _16LongestBalancedSubarrayI();
        System.out.println(obj.longestBalanced(arr));
    }
}


/*
---------------- DRY RUN (Example) ----------------

Input:
arr = {1, 2, 3, 4, 5, 6}

i = 0
  j = 0 → {1} → odd=1 even=0
  j = 1 → {1,2} → odd=1 even=1 → balanced → len=2
  j = 2 → {1,2,3} → odd=2 even=1
  j = 3 → {1,2,3,4} → odd=2 even=2 → balanced → len=4
  j = 4 → {1,2,3,4,5} → odd=3 even=2
  j = 5 → {1,2,3,4,5,6} → odd=3 even=3 → balanced → len=6

Max length = 6

Output: 6

---------------------------------------------------
*/

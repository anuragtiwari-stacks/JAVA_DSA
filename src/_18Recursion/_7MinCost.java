package _18Recursion;

/*
LeetCode 2712
Minimum Cost to Make All Characters Equal

*/

public class _7MinCost
{

    public int minCost(int n)
    {
        if(n == 1) return 0;

        if(n == 2) return 1;

        int a = 1;
        int b = n - 1;

        int cost = a * b + minCost(b);

        return cost;
    }


    public static void main(String[] args)
    {
        _7MinCost obj = new _7MinCost();

        int n = 5;

        int result = obj.minCost(n);

        System.out.println("Minimum Cost: " + result);
    }

}


/*
Possible Pattern

n = 5
split -> 1 * 4 + minCost(4)

4 -> 1 * 3 + minCost(3)
3 -> 1 * 2 + minCost(2)
2 -> 1

Total cost builds recursively


Time Complexity  : O(n)
Space Complexity : O(n)   // recursion stack
*/
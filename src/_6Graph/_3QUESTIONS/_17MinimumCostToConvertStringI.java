package _6Graph._3QUESTIONS;

// LeetCode 2976 : Minimum Cost to Convert String I

public class _17MinimumCostToConvertStringI
{
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost)
    {
        int n = 26;
        long INF = (long) 1e15;

        long[][] dist = new long[n][n];

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (i == j)
                {
                    dist[i][j] = 0;
                }
                else
                {
                    dist[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < original.length; i++)
        {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';

            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        for (int k = 0; k < n; k++)
        {
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                    {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        long answer = 0;

        for (int i = 0; i < source.length(); i++)
        {
            int s = source.charAt(i) - 'a';
            int t = target.charAt(i) - 'a';

            if (dist[s][t] == INF)
            {
                return -1;
            }

            answer += dist[s][t];
        }

        return answer;
    }

    public static void main(String[] args)
    {
        _17MinimumCostToConvertStringI obj = new _17MinimumCostToConvertStringI();

        String source = "abcd";
        String target = "acbe";

        char[] original = { 'a', 'b', 'c' };
        char[] changed  = { 'c', 'c', 'b' };
        int[] cost      = { 2, 1, 3 };

        long result = obj.minimumCost(source, target, original, changed, cost);

        System.out.println(result);
    }

    /*
    DRY RUN

    source = "abcd"
    target = "acbe"

    original = ['a','b','c']
    changed  = ['c','c','b']
    cost     = [2,1,3]

    Initial dist:
    a->a = 0, b->b = 0, ..., others = INF

    Direct edges:
    a -> c = 2
    b -> c = 1
    c -> b = 3

    After Floyd Warshall:
    a -> b = a->c->b = 2 + 3 = 5
    b -> b = 0
    c -> c = 0

    Conversion:
    a -> a = 0
    b -> c = 1
    c -> b = 3
    d -> e = impossible

    Since d -> e does not exist, return -1
    */
}

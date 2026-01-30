package _6Graph._3QUESTIONS;

import java.util.*;

// LeetCode 2977 : Minimum Cost to Convert String II
public class _18MinimumCostToConvertStringII
{
    static final long INF = Long.MAX_VALUE;

    public long minimumCost(String source, String target,
                            String[] original, String[] changed, int[] cost)
    {
        int m = original.length;
        int n = source.length();

        // STEP 1: Index all unique strings
        Map<String, Integer> id = new HashMap<>();
        List<String> nodes = new ArrayList<>();
        int idx = 0;

        for (int i = 0; i < m; i++)
        {
            if (!id.containsKey(original[i]))
            {
                id.put(original[i], idx++);
                nodes.add(original[i]);
            }

            if (!id.containsKey(changed[i]))
            {
                id.put(changed[i], idx++);
                nodes.add(changed[i]);
            }
        }

        // STEP 2: Floyd–Warshall graph
        long[][] dist = new long[idx][idx];

        for (int i = 0; i < idx; i++)
        {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < m; i++)
        {
            int u = id.get(original[i]);
            int v = id.get(changed[i]);

            if (cost[i] < dist[u][v])
            {
                dist[u][v] = cost[i];
            }
        }

        // STEP 3: Floyd–Warshall
        for (int k = 0; k < idx; k++)
        {
            for (int i = 0; i < idx; i++)
            {
                if (dist[i][k] == INF) continue;

                for (int j = 0; j < idx; j++)
                {
                    if (dist[k][j] == INF) continue;

                    long newCost = dist[i][k] + dist[k][j];
                    if (newCost < dist[i][j])
                    {
                        dist[i][j] = newCost;
                    }
                }
            }
        }

        // STEP 4: DP (Tabulation)
        long[] dp = new long[n + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < n; i++)
        {
            if (dp[i] == INF) continue;

            // Case 1: characters already equal
            if (source.charAt(i) == target.charAt(i))
            {
                if (dp[i] < dp[i + 1])
                {
                    dp[i + 1] = dp[i];
                }
            }

            // Case 2: apply transformations
            for (int r = 0; r < m; r++)
            {
                String from = original[r];
                int lenFrom = from.length();

                if (i + lenFrom > n) continue;
                if (!source.startsWith(from, i)) continue;

                int u = id.get(from);

                // IMPORTANT FIX:
                // try ALL possible targets reachable via Floyd–Warshall
                for (int v = 0; v < idx; v++)
                {
                    long d = dist[u][v];
                    if (d == INF) continue;

                    String to = nodes.get(v);
                    int lenTo = to.length();

                    if (i + lenTo > n) continue;

                    if (target.startsWith(to, i))
                    {
                        long newCost = dp[i] + d;
                        if (newCost < dp[i + lenTo])
                        {
                            dp[i + lenTo] = newCost;
                        }
                    }
                }
            }
        }

        if (dp[n] == INF)
        {
            return -1;
        }

        return dp[n];
    }

    // ---------------- MAIN (RUNNABLE) ----------------
    public static void main(String[] args)
    {
        _18MinimumCostToConvertStringII obj =
                new _18MinimumCostToConvertStringII();

        String source = "abcdefgh";
        String target = "acdeeghh";

        String[] original = { "bcd", "fgh", "thh" };
        String[] changed  = { "cde", "thh", "ghh" };
        int[] cost        = { 1, 3, 5 };

        long ans = obj.minimumCost(
                source, target, original, changed, cost
        );

        System.out.println(ans);
    }

    /*
    ======================= DRY RUN =======================

    source = "abcdefgh"
    target = "acdeeghh"

    rules:
    bcd -> cde (1)
    fgh -> thh (3)
    thh -> ghh (5)

    Floyd–Warshall result:
    fgh -> ghh = 3 + 5 = 8

    DP:
    dp[0]=0
    a == a  -> dp[1]=0
    bcd->cde cost 1 -> dp[4]=1
    e == e -> dp[5]=1
    fgh->ghh cost 8 -> dp[8]=9

    ANSWER = 9

    ======================================================
    */
}

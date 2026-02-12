package _9Graph._3QUESTIONS;

import java.util.*;

public class _10PathWithMinimumEffort
{
    static class Triplet
    {
        int row;
        int col;
        int effort;

        Triplet(int row, int col, int effort)
        {
            this.row = row;
            this.col = col;
            this.effort = effort;
        }
    }

    public int minimumEffortPath(int[][] arr)
    {
        int n = arr.length;
        int m = arr[0].length;

        int[][] ans = new int[n][m];

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                ans[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Triplet> pq =
                new PriorityQueue<>((a, b) -> a.effort - b.effort);

        ans[0][0] = 0;
        pq.add(new Triplet(0, 0, 0));

        while (!pq.isEmpty())
        {
            Triplet top = pq.remove();
            int row = top.row;
            int col = top.col;
            int effort = top.effort;

            if (row == n - 1 && col == m - 1)
            {
                return effort;
            }

            // going up
            if (row > 0)
            {
                int e = Math.abs(arr[row][col] - arr[row - 1][col]);
                e = Math.max(e, effort);

                if (e < ans[row - 1][col])
                {
                    ans[row - 1][col] = e;
                    pq.add(new Triplet(row - 1, col, e));
                }
            }

            // going left
            if (col > 0)
            {
                int e = Math.abs(arr[row][col] - arr[row][col - 1]);
                e = Math.max(e, effort);

                if (e < ans[row][col - 1])
                {
                    ans[row][col - 1] = e;
                    pq.add(new Triplet(row, col - 1, e));
                }
            }

            // going down
            if (row < n - 1)
            {
                int e = Math.abs(arr[row][col] - arr[row + 1][col]);
                e = Math.max(e, effort);

                if (e < ans[row + 1][col])
                {
                    ans[row + 1][col] = e;
                    pq.add(new Triplet(row + 1, col, e));
                }
            }

            // going right
            if (col < m - 1)
            {
                int e = Math.abs(arr[row][col] - arr[row][col + 1]);
                e = Math.max(e, effort);

                if (e < ans[row][col + 1])
                {
                    ans[row][col + 1] = e;
                    pq.add(new Triplet(row, col + 1, e));
                }
            }
        }

        return 0;
    }

    public static void main(String[] args)
    {
        _10PathWithMinimumEffort obj = new _10PathWithMinimumEffort();

        int[][] arr =
                {
                        {1, 2, 2},
                        {3, 8, 2},
                        {5, 3, 5}
                };

        System.out.println(obj.minimumEffortPath(arr));
    }
}

/*
DRY RUN (Path With Minimum Effort)

Grid:
1 2 2
3 8 2
5 3 5

n = 3 , m = 3

------------------------------------
Initialization:

ans =
0   INF INF
INF INF INF
INF INF INF

PQ = [(0,0,0)]

------------------------------------
Step 1: pop (row=0,col=0,effort=0)

going up → row>0 ❌
going left → col>0 ❌

going down:
|1-3| = 2
e = max(0,2) = 2 < INF
ans[1][0] = 2
push (1,0,2)

going right:
|1-2| = 1
e = max(0,1) = 1 < INF
ans[0][1] = 1
push (0,1,1)

ans =
0   1   INF
2   INF INF
INF INF INF

PQ = [(0,1,1),(1,0,2)]

------------------------------------
Step 2: pop (0,1,1)

going up → ❌

going left:
|2-1| = 1
e = max(1,1) = 1 > ans[0][0] → ignore

going down:
|2-8| = 6
e = max(1,6) = 6 < INF
ans[1][1] = 6
push (1,1,6)

going right:
|2-2| = 0
e = max(1,0) = 1 < INF
ans[0][2] = 1
push (0,2,1)

ans =
0   1   1
2   6   INF
INF INF INF

PQ = [(0,2,1),(1,0,2),(1,1,6)]

------------------------------------
Step 3: pop (0,2,1)

going up → ❌

going left:
|2-2| = 0
e = max(1,0) = 1 == ans[0][1] → ignore

going down:
|2-2| = 0
e = max(1,0) = 1 < INF
ans[1][2] = 1
push (1,2,1)

going right → ❌

ans =
0   1   1
2   6   1
INF INF INF

PQ = [(1,2,1),(1,0,2),(1,1,6)]

------------------------------------
Step 4: pop (1,2,1)

going up:
|2-2| = 0
e = max(1,0) = 1 == ans[0][2] → ignore

going left:
|2-8| = 6
e = max(1,6) = 6 == ans[1][1] → ignore

going down:
|2-5| = 3
e = max(1,3) = 3 < INF
ans[2][2] = 3
push (2,2,3)

going right → ❌

ans =
0   1   1
2   6   1
INF INF 3

PQ = [(1,0,2),(2,2,3),(1,1,6)]

------------------------------------
Step 5: pop (1,0,2)

going up:
|3-1| = 2
e = max(2,2) = 2 > ans[0][0] → ignore

going left → ❌

going down:
|3-5| = 2
e = max(2,2) = 2 < INF
ans[2][0] = 2
push (2,0,2)

going right:
|3-8| = 5
e = max(2,5) = 5 < 6
ans[1][1] = 5
push (1,1,5)

ans =
0   1   1
2   5   1
2   INF 3

PQ = [(2,0,2),(2,2,3),(1,1,5),(1,1,6)]

------------------------------------
Step 6: pop (2,0,2)

going up:
|5-3| = 2
e = max(2,2) = 2 == ans[1][0] → ignore

going left → ❌

going down → ❌

going right:
|5-3| = 2
e = max(2,2) = 2 < INF
ans[2][1] = 2
push (2,1,2)

ans =
0   1   1
2   5   1
2   2   3

PQ = [(2,1,2),(2,2,3),(1,1,5),(1,1,6)]

------------------------------------
Step 7: pop (2,1,2)

going up:
|3-8| = 5
e = max(2,5) = 5 == ans[1][1] → ignore

going left:
|3-5| = 2
e = max(2,2) = 2 == ans[2][0] → ignore

going down → ❌

going right:
|3-5| = 2
e = max(2,2) = 2 < 3
ans[2][2] = 2
push (2,2,2)

ans =
0   1   1
2   5   1
2   2   2

PQ = [(2,2,2),(2,2,3),(1,1,5),(1,1,6)]

------------------------------------
Step 8: pop (2,2,2)

Destination reached.

------------------------------------
Final Answer:
Minimum Effort = 2
*/

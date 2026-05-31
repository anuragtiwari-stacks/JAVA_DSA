package _09Graph._3QUESTIONS;

// Logic:
// 1. Undirected graph → Floyd–Warshall lagao (all pairs shortest path).
// 2. dist[i][j] = min(dist[i][j], dist[i][via] + dist[via][j]).
// 3. Har city ke liye count karo:
//    dist <= distanceThreshold.
// 4. Minimum count wali city answer.
// 5. Tie me larger index return karo.


// 1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance
public class _16FindTheCity
{
    static final int INF = 1000000000;

    public int findTheCity(int n, int[][] edges, int distanceThreshold)
    {
        int[][] dist = new int[n][n];

        // initialize
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

        // undirected edges
        for (int[] e : edges)
        {
            dist[e[0]][e[1]] = e[2];
            dist[e[1]][e[0]] = e[2];
        }

        // Floyd–Warshall
        for (int via = 0; via < n; via++)
        {
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                }
            }
        }

        int []totalCity = new int[n];

        for(int i=0;i<n;i++)
        {
            int count = 0;
            for(int j=0;j<n;j++)
            {
                if(dist[i][j] <= distanceThreshold)
                {
                    count++;
                }
            }
            totalCity[i]=count;
        }

        int minCount = Integer.MAX_VALUE;
        int city = -1;
        for(int i=totalCity.length-1 ;i>=0; i--)
        {
            if(totalCity[i]<minCount)
            {
                minCount = totalCity[i];
                city = i;
            }
        }

        return city;
    }

    public static void main(String[] args)
    {
        _16FindTheCity obj = new _16FindTheCity();

        int n = 4;
        int[][] edges =
                {
                        {0, 1, 3},
                        {1, 2, 1},
                        {1, 3, 4},
                        {2, 3, 1}
                };

        int distanceThreshold = 4;

        System.out.println(obj.findTheCity(n, edges, distanceThreshold));
    }
}

/*
for (int via = 0; via < n; via++)
{
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
        if i need to use Integer.MAX_VALUE then it may cause overflow so that's why i have used

            if (dist[i][via] != Integer.MAX_VALUE && dist[via][j] != Integer.MAX_VALUE)
            {
                dist[i][j] = Math.min(dist[i][j],dist[i][via] + dist[via][j]);
            }
        }
    }
}
*/
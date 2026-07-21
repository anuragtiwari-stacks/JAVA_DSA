package OA.TCS;

import java.util.*;

public class DijkstraAlgorithm
{
    static class Edge
    {
        int v;
        int wt;

        Edge(int v, int wt)
        {
            this.v = v;
            this.wt = wt;
        }
    }

    static class Pair
    {
        int node;
        int dist;

        Pair(int node, int dist)
        {
            this.node = node;
            this.dist = dist;
        }
    }

    public static int[] dijkstra(ArrayList<ArrayList<Edge>> graph, int src)
    {
        int n = graph.size();

        int[] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);

        dist[src] = 0;

        pq.add(new Pair(src, 0));

        while(!pq.isEmpty())
        {
            Pair current = pq.remove();

            int u = current.node;
            int currentDist = current.dist;

            if(currentDist > dist[u])
            {
                continue;
            }

            for(Edge edge : graph.get(u))
            {
                int v = edge.v;
                int wt = edge.wt;

                if(dist[u] + wt < dist[v])
                {
                    dist[v] = dist[u] + wt;

                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Number of vertices
        int V = sc.nextInt();

        // Number of edges
        int E = sc.nextInt();

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        for(int i = 0; i < V; i++)
        {
            graph.add(new ArrayList<>());
        }

        // Input edges
        for(int i = 0; i < E; i++)
        {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int wt = sc.nextInt();

            graph.get(u).add(new Edge(v, wt));

            // For Undirected Graph
            graph.get(v).add(new Edge(u, wt));
        }

        // Source vertex
        int src = sc.nextInt();

        int[] dist = dijkstra(graph, src);

        for(int i = 0; i < V; i++)
        {
            System.out.println(dist[i]);
        }

        sc.close();
    }
}
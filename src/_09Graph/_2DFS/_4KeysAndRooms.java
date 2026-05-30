package _09Graph._2DFS;

import java.util.*;

public class _4KeysAndRooms
{
    /*
        🔗 Problem: Keys and Rooms (LeetCode 841)

        Example:
        Input: rooms = [[1],[2],[3],[]]
        Output: true
    */

    public static void main(String[] args)
    {
        List<List<Integer>> rooms = new ArrayList<>();

        // Room 0 has key to 1
        rooms.add(Arrays.asList(1));

        // Room 1 has key to 2
        rooms.add(Arrays.asList(2));

        // Room 2 has key to 3
        rooms.add(Arrays.asList(3));

        // Room 3 has no key
        rooms.add(new ArrayList<>());

        boolean result = canVisitAllRooms(rooms);

        System.out.println(result);
    }

    static boolean canVisitAllRooms(List<List<Integer>> rooms)
    {
        int n = rooms.size();

        boolean[] visited = new boolean[n];

        dfs(rooms, visited, 0);

        for (int i = 0; i < n; i++)
        {
            if (visited[i] == false)
            {
                return false;
            }
        }

        return true;
    }

    private static void dfs(List<List<Integer>> rooms, boolean[] visited, int start)
    {
        Stack<Integer> stack = new Stack<>();

        stack.push(start);

        visited[start] = true;

        while (!stack.isEmpty())
        {
            int room = stack.pop();

            for (int key : rooms.get(room))
            {
                if (!visited[key])
                {
                    visited[key] = true;

                    stack.push(key);
                }
            }
        }
    }
}
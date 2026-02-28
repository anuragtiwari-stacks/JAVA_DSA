package _09Graph._2DFS;

import java.util.*;

public class _4KeysAndRooms_DFS
{

    /*
        🔗 Problem: Keys and Rooms (LeetCode 841)

        - There are `n` rooms numbered from 0 to n - 1.
        - Each room has keys to other rooms.
        - Initially, you start in room 0.
        - You can only enter a room if you have its key.
        - Goal: Return true if you can visit all rooms, else false.
    */

    public static void main(String[] args)
    {
        List<List<Integer>> rooms = new ArrayList<>();

        rooms.add(Arrays.asList(1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(3));
        rooms.add(new ArrayList<>());

        boolean result = canVisitAllRooms(rooms);

        System.out.println("Can visit all rooms: " + result);
    }

    static boolean canVisitAllRooms(List<List<Integer>> rooms)
    {
        int n = rooms.size();
        boolean[] visited = new boolean[n];

        dfs(0, rooms, visited);

        for (boolean roomVisited : visited)
        {
            if (!roomVisited)
            {
                return false;
            }
        }

        return true;
    }

    static void dfs(int room, List<List<Integer>> rooms, boolean[] visited)
    {
        visited[room] = true;

        for (int key : rooms.get(room))
        {
            if (!visited[key])
            {
                dfs(key, rooms, visited);
            }
        }
    }
}

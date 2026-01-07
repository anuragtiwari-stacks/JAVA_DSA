package _6Graph._1BFS;

import java.util.*;

public class _4KeysAndRooms
{

    /*
        🔗 Problem: Keys and Rooms (LeetCode 841)

        - There are `n` rooms numbered from 0 to n - 1.
        - Each room has keys to other rooms.
        - Initially, you start in room 0.
        - You can only enter a room if you have its key.
        - Goal: Return true if you can visit all rooms, else false.

        Example:
        Input: rooms = [[1],[2],[3],[]]
        Output: true

        Explanation:
        Start from room 0 → key to room 1 → key to room 2 → key to room 3.
        ✅ All rooms are visited.
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

        System.out.println("Can visit all rooms: " + result);
    }

    static boolean canVisitAllRooms(List<List<Integer>> rooms)
    {
        int n = rooms.size();
        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();

        // Start from room 0
        queue.add(0);
        visited[0] = true;
        int visitedCount = 1; // How many rooms visited so far

        while (!queue.isEmpty())
        {
            int currentRoom = queue.remove();

            // Collect keys from the current room
            for (int key : rooms.get(currentRoom))
            {
                if (!visited[key])
                {
                    queue.add(key);
                    visited[key] = true;
                    visitedCount++;
                }
            }
        }

        // If we visited all rooms
        return visitedCount == n;
    }
}

/*
    🔍 Logic Explanation:

    - Each room is a node in the graph.
    - Keys inside a room represent edges to other rooms.
    - BFS starts from room 0 (we have its key).
    - For every visited room, collect its keys and enqueue them.
    - Track visited[] to avoid revisiting rooms.
    - If after BFS, visitedCount == total rooms, return true.
    - Otherwise, return false.
*/

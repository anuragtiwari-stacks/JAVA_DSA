package _9Graph._3QUESTIONS;

// Logic:
// 1. Courses ko directed graph maan lo.
//    Edge: prerequisite → course
// 2. Har course ka indegree (incoming edges) calculate karo.
// 3. Jinka indegree 0 ho, unhe queue me daalo.
// 4. BFS (Topological Sort):
//    - queue se course nikalo
//    - count (topo size) badhao
//    - uske neighbors ki indegree -- karo
//    - agar indegree 0 ho jaaye, queue me daalo
// 5. End me agar count == total courses
//    → cycle nahi hai → return true
//    warna cycle hai → return false

import java.util.*;

public class _4CourseSchedule
{
    public boolean canFinish(int numCourses, int[][] prerequisites)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++)
        {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for (int[] pre : prerequisites)
        {
            int course = pre[0];
            int prereq = pre[1];

            adj.get(prereq).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++)
        {
            if (indegree[i] == 0)
            {
                queue.add(i);
            }
        }

        int count = 0;

        while (!queue.isEmpty())
        {
            int node = queue.remove();
            count++;

            for (int neighbor : adj.get(node))
            {
                indegree[neighbor]--;

                if (indegree[neighbor] == 0)
                {
                    queue.add(neighbor);
                }
            }
        }

        return count == numCourses;
    }

    public static void main(String[] args)
    {
        _4CourseSchedule obj = new _4CourseSchedule();

        int numCourses = 4;
        int[][] prerequisites =
                {
                        {1, 0},
                        {2, 1},
                        {3, 2},
                        {1, 3}
                };

        System.out.println(obj.canFinish(numCourses, prerequisites));
    }
}

/*
Dry Run (Cycle Present Case):

numCourses = 4
prerequisites:
[1,0] → 0 → 1
[2,1] → 1 → 2
[3,2] → 2 → 3
[1,3] → 3 → 1

Graph:
0 → 1 → 2 → 3
      ↑       |
      └───────┘

Step 1: Indegree calculation

Initial indegree:
course : indegree
0 : 0
1 : 0
2 : 0
3 : 0

After processing edges:
0 → 1 → indegree[1] = 1
1 → 2 → indegree[2] = 1
2 → 3 → indegree[3] = 1
3 → 1 → indegree[1] = 2

Final indegree:
0 : 0
1 : 2
2 : 1
3 : 1

Step 2: Push indegree = 0 courses into queue
Queue = [0]
count = 0

Step 3: BFS / Topo processing

Process 0
count = 1
neighbor = 1
indegree[1] = 2 → 1
Queue = []

Queue empty but
count = 1 < numCourses (4)

Conclusion:
All courses process nahi ho paaye
Cycle exists

Return false
*/

package _9Graph._3QUESTIONS;

// Logic:
// 1. Hume alien language ka order find karna hai (characters ka order).
// 2. Given words ko dictionary order me compare karte hain.
// 3. Har adjacent word pair me pehla mismatching character
//    ek directed edge banata hai: c1 → c2.
// 4. Isse ek directed graph banta hai (characters = nodes).
// 5. Ab Topological Sort (BFS / Kahn’s Algorithm) lagate hain:
//    - indegree calculate
//    - indegree 0 nodes ko queue me daalo
//    - queue se nikaal kar answer me add karo
//    - neighbors ki indegree -- karo
// 6. Queue se nikla hua order hi alien dictionary ka order hota hai.

import java.util.*;

public class _6AlienDictionary
{
    public String findOrder(String[] words, int N, int K)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < K; i++)
        {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++)
        {
            String w1 = words[i];
            String w2 = words[i + 1];

            int len = Math.min(w1.length(), w2.length());

            for (int j = 0; j < len; j++)
            {
                if (w1.charAt(j) != w2.charAt(j))
                {
                    int u = w1.charAt(j) - 'a';
                    int v = w2.charAt(j) - 'a';
                    adj.get(u).add(v);
                    break;
                }
            }
        }

        int[] indegree = new int[K];

        for (int i = 0; i < K; i++)
        {
            for (int neighbor : adj.get(i))
            {
                indegree[neighbor]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < K; i++)
        {
            if (indegree[i] == 0)
            {
                queue.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty())
        {
            int node = queue.remove();
            sb.append((char)(node + 'a'));

            for (int neighbor : adj.get(node))
            {
                indegree[neighbor]--;

                if (indegree[neighbor] == 0)
                {
                    queue.add(neighbor);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args)
    {
        _6AlienDictionary obj = new _6AlienDictionary();

        String[] words =
                {
                        "baa",
                        "abcd",
                        "abca",
                        "cab",
                        "cad"
                };

        int N = words.length;
        int K = 4;

        System.out.println(obj.findOrder(words, N, K));
    }
}

/*
Dry Run:

words = ["baa","abcd","abca","cab","cad"]
K = 4 (a, b, c, d)

Step 1: Build graph by comparing adjacent words

Compare "baa" & "abcd"
b != a → edge: b → a

Compare "abcd" & "abca"
d != a → edge: d → a

Compare "abca" & "cab"
a != c → edge: a → c

Compare "cab" & "cad"
b != d → edge: b → d

Graph edges:
b → a
d → a
a → c
b → d

Step 2: Indegree calculation

a : 2 (b, d)
b : 0
c : 1 (a)
d : 1 (b)

Step 3: Queue init (indegree 0)
Queue = [b]

Step 4: BFS / Topo

Process b
order = "b"
decrease indegree of a (2 → 1)
decrease indegree of d (1 → 0) → push d

Queue = [d]

Process d
order = "bd"
decrease indegree of a (1 → 0) → push a

Queue = [a]

Process a
order = "bda"
decrease indegree of c (1 → 0) → push c

Queue = [c]

Process c
order = "bdac"

Final Alien Dictionary Order:
"bdac"
*/

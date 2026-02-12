package _3LinkedList._3PW;

import java.util.HashMap;

class Nodes
{
    int val;
    Nodes next;
    Nodes random;

    Nodes(int val)
    {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class _22CopyListWithRandomPointer
{
    public Nodes copyRandomList(Nodes head)
    {
        if (head == null)
        {
            return null;
        }

        HashMap<Nodes, Nodes> map = new HashMap<>();
        Nodes current = head;

        // Step 1: Create copies of each node and store in map
        while (current != null)
        {
            Nodes copy = new Nodes(current.val);
            map.put(current, copy);
            current = current.next;
        }

        // Step 2: Assign next and random pointers
        current = head;

        while (current != null)
        {
            Nodes copy = map.get(current);

            if (current.next != null)
            {
                copy.next = map.get(current.next);
            }

            if (current.random != null)
            {
                copy.random = map.get(current.random);
            }

            current = current.next;
        }

        return map.get(head);
    }

    public void printList(Nodes head)
    {
        Nodes current = head;

        while (current != null)
        {
            String randomVal;

            if (current.random != null)
            {
                randomVal = String.valueOf(current.random.val);
            }
            else
            {
                randomVal = "null";
            }

            System.out.println("Node: " + current.val + ", Random: " + randomVal);
            current = current.next;
        }
    }

    public static void main(String[] args)
    {
        _22CopyListWithRandomPointer solution = new _22CopyListWithRandomPointer();

        Nodes node0 = new Nodes(7);
        Nodes node1 = new Nodes(13);
        Nodes node2 = new Nodes(11);
        Nodes node3 = new Nodes(10);
        Nodes node4 = new Nodes(1);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        node0.random = null;
        node1.random = node0;
        node2.random = node4;
        node3.random = node2;
        node4.random = node0;

        Nodes copied = solution.copyRandomList(node0);

        System.out.println("Original list:");
        solution.printList(node0);

        System.out.println("\nCopied list:");
        solution.printList(copied);
    }
}

/* ___________________________________________
   ✅ Concept: Deep Copy of Linked List with Random Pointers

   1. Traverse the original linked list.
      - For each node, create a new node (deep copy).
      - Store the mapping from original node → new node using a HashMap.

   2. Traverse the original list again:
      - Set the `next` pointer of copied nodes using: map.get(original.next)
      - Set the `random` pointer of copied nodes using: map.get(original.random)

   3. Return the copied head: map.get(head)

   ✅ Time Complexity: O(n)
   ✅ Space Complexity: O(n) due to the HashMap

   👉 This ensures a true deep copy where no node in the new list points to any node in the original list.
______________________________________________ */


/*
==================== DRY RUN ====================
Problem: Copy List with Random Pointer (HashMap approach)
Using EXACT code given above.

------------------------------------------------
Original List (with random pointers)
------------------------------------------------
Nodes created:

node0 = 7
node1 = 13
node2 = 11
node3 = 10
node4 = 1

Next pointers:
7  -> 13 -> 11 -> 10 -> 1 -> null

Random pointers:
7.random  -> null
13.random -> 7
11.random -> 1
10.random -> 11
1.random  -> 7

------------------------------------------------
Step 1: Create copy of each node and store in map
------------------------------------------------
current = head (7)

Iteration 1:
current = 7
copy = new Nodes(7)
map.put(7, 7')
current = 13

Iteration 2:
current = 13
copy = new Nodes(13)
map.put(13, 13')
current = 11

Iteration 3:
current = 11
copy = new Nodes(11)
map.put(11, 11')
current = 10

Iteration 4:
current = 10
copy = new Nodes(10)
map.put(10, 10')
current = 1

Iteration 5:
current = 1
copy = new Nodes(1)
map.put(1, 1')
current = null → stop

Map contents:
Original → Copy
7  → 7'
13 → 13'
11 → 11'
10 → 10'
1  → 1'

------------------------------------------------
Step 2: Assign next and random pointers
------------------------------------------------
current = head (7)

Iteration 1 (current = 7):
copy = map.get(7) → 7'

next:
7.next = 13
7'.next = map.get(13) → 13'

random:
7.random = null
7'.random = null

current = 13

-----------------------------------------------
Iteration 2 (current = 13):
copy = 13'

next:
13.next = 11
13'.next = 11'

random:
13.random = 7
13'.random = 7'

current = 11

-----------------------------------------------
Iteration 3 (current = 11):
copy = 11'

next:
11.next = 10
11'.next = 10'

random:
11.random = 1
11'.random = 1'

current = 10

-----------------------------------------------
Iteration 4 (current = 10):
copy = 10'

next:
10.next = 1
10'.next = 1'

random:
10.random = 11
10'.random = 11'

current = 1

-----------------------------------------------
Iteration 5 (current = 1):
copy = 1'

next:
1.next = null
1'.next = null

random:
1.random = 7
1'.random = 7'

current = null → stop

------------------------------------------------
Final Copied List Structure
------------------------------------------------
Copied next pointers:
7'  -> 13' -> 11' -> 10' -> 1' -> null

Copied random pointers:
7'.random  -> null
13'.random -> 7'
11'.random -> 1'
10'.random -> 11'
1'.random  -> 7'

------------------------------------------------
Verification
------------------------------------------------
✔ All nodes are NEW (deep copy)
✔ No copied node points to original list
✔ next & random structure exactly same as original

------------------------------------------------
Final Return:
map.get(head) → 7' (head of copied list)
================================================
*/

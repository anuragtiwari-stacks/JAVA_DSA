package _5Queue._2QUESTIONS;

import java.util.*;

/*
LOGIC:
1. Students are standing in a queue with preferences:
   0 → circular sandwich
   1 → square sandwich
2. Sandwiches are arranged in a stack order (array).
3. If the front student likes the top sandwich:
   - Student leaves the queue
   - Move to next sandwich
4. If the student does NOT like the sandwich:
   - Move student to the end of the queue
5. If all students are rotated once and no one eats:
   - Stop the process
6. Return the number of students unable to eat.
*/

public class _2StudentsLunch
{

    public static int countStudents(int[] students, int[] sandwiches)
    {
        Queue<Integer> queue = new LinkedList<>();

        for (int s : students)
        {
            queue.add(s);
        }

        int index = 0;
        int count = 0;

        while (!queue.isEmpty())
        {
            if (queue.peek() == sandwiches[index])
            {
                queue.remove();
                index++;
                count = 0;
            }
            else
            {
                queue.add(queue.remove());
                count++;
            }

            if (count == queue.size())
            {
                break;
            }
        }

        return queue.size();
    }

    public static void main(String[] args)
    {
        // Pre-taken input
        int[] students = { 1, 1, 0, 0 };
        int[] sandwiches = { 0, 1, 0, 1 };

        int result = countStudents(students, sandwiches);

        System.out.println("Number of students unable to eat lunch: " + result);
    }
}

/*
========================
DRY RUN
========================

students   = [1, 1, 0, 0]
sandwiches = [0, 1, 0, 1]

Queue = [1, 1, 0, 0]
index = 0 (sandwich = 0)
count = 0

1) Front = 1 ≠ 0 → move to back
   Queue = [1, 0, 0, 1]
   count = 1

2) Front = 1 ≠ 0 → move to back
   Queue = [0, 0, 1, 1]
   count = 2

3) Front = 0 == 0 → eats
   Queue = [0, 1, 1]
   index = 1
   count = 0

4) Front = 0 ≠ 1 → move to back
   Queue = [1, 1, 0]
   count = 1

5) Front = 1 == 1 → eats
   Queue = [1, 0]
   index = 2
   count = 0

6) Front = 1 ≠ 0 → move to back
   Queue = [0, 1]
   count = 1

7) Front = 0 == 0 → eats
   Queue = [1]
   index = 3
   count = 0

8) Front = 1 == 1 → eats
   Queue = []
   index = 4

Final Queue Size = 0

========================
END
========================
*/

/*
========================
DRY RUN
========================

students   = [1, 1, 1, 0]
sandwiches = [0, 0, 0, 1]

Initial Queue = [1, 1, 1, 0]
index = 0 → sandwich = 0
count = 0

Step 1:
Front = 1 ≠ 0
rotate
Queue = [1, 1, 0, 1]
count = 1

Step 2:
Front = 1 ≠ 0
rotate
Queue = [1, 0, 1, 1]
count = 2

Step 3:
Front = 1 ≠ 0
rotate
Queue = [0, 1, 1, 1]
count = 3

Step 4:
Front = 0 == 0
eats
Queue = [1, 1, 1]
index = 1
count = 0

Now:
sandwich = 0
Queue = [1, 1, 1]

Rotate all students:
count becomes 3
count == queue.size()

STOP

Final Queue Size = 3

OUTPUT:
Students unable to eat lunch: 3
========================
END
========================
*/
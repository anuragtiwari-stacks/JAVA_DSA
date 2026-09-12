/*
Question:
There are N students standing in a line. Each student has a requirement
specifying how many consecutive Good (G) chocolates they need.

You are given:
1. An integer array req[] containing the requirements of the students.
2. A string C containing only 'G' (Good chocolate) and 'R' (Ruined chocolate).

Process the students in order.

For each student:
1. Starting from the current position in C, skip all 'R' chocolates.
2. The student can be satisfied only if the required number of consecutive
   'G' chocolates is available.
3. If enough consecutive 'G' chocolates are available, give them to the
   student and move the current position forward.
4. Skipped 'R' chocolates are not counted.
5. Stop processing at the first student whose requirement cannot be fulfilled.

Return the total number of students who can be satisfied.

Example:
req[] = {1, 1, 2, 3}
C = "RGRGGGGGRGR"

Output:
3
*/
package OA.Accenture.Strings;

public class _19
{
    static int solve(int[] req, String C)
    {
        char[] arr = C.toCharArray();

        int start = 0;

        int available = 0;
        int count = 0;
        for(int i=0;i<arr.length && start<req.length;i++)
        {
            int required = req[start];

            if(arr[i]=='R')
            {
                available = 0;
            }

            if(arr[i]=='G')
            {
                available++;
                if(available==required)
                {
                    count++;
                    start++;

                    available=0;
                }
            }
        }

        return count;
    }

    public static void main(String[] args)
    {

        int[] req = {1, 1, 2, 3};
        String C = "RGRGGGGGRGR";

        System.out.println(solve(req, C));
    }
}

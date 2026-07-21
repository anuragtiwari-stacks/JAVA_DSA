package OA.Infosys;

/*
QUESTION: Shortest Subarray Containing All Colors

You are given an integer array A of size N.
Each element represents a color numbered from 1 to C.

Find the length of the shortest contiguous subarray that contains
all the colors from 1 to C at least once.

If no such subarray exists, return -1.


INPUT FORMAT:

N
C
A[0]
A[1]
...
A[N-1]


EXAMPLE INPUT:

5
3
3
1
1
2
1


EXAMPLE OUTPUT:

4


EXPLANATION:

Array = [3, 1, 1, 2, 1]

We need all C = 3 colors:

1, 2, 3

Subarray:

[3, 1, 1, 2]

contains all colors 1, 2, 3.

Length = 4

Therefore Output = 4


APPROACH:

1. Start from every index i.

2. Create a boolean array of size C + 1.

3. When a color is found for the first time,
   mark it true and increase count.

4. When count == C, it means all colors
   are present in the current subarray.

5. Calculate:

   length = j - i + 1

6. Store the minimum length.

7. If no valid subarray exists, print -1.
*/

import java.util.*;

class Main2
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

            int minLength = Integer.MAX_VALUE;

            int n = sc.nextInt();
            int c = sc.nextInt();

            int []arr = new int[n];

            for(int i=0;i<n;i++)
            {
                arr[i] = sc.nextInt();
            }

            for(int i=0;i<n;i++)
            {
                boolean [] freq = new boolean[c+1];
                int count = 0;

                for(int j=i;j<n;j++)
                {
                    if(freq[arr[j]]==false)
                    {
                        freq[arr[j]]=true;
                        count++;
                    }

                    if(count == c)
                    {
                        minLength = Math.min(minLength,j-i+1);
                    }
                }
            }

        if(minLength == Integer.MAX_VALUE)
        {
            System.out.println(-1);
        }
        else
        {
            System.out.println(minLength);
        }
    }
}




















//
//import java.util.*;
//
//class Main2
//{
//    public static void main(String[] args)
//    {
//        Scanner sc = new Scanner(System.in);
//
//        int N = sc.nextInt();
//        int C = sc.nextInt();
//
//        int[] arr = new int[N];
//
//        for(int i = 0; i < N; i++)
//        {
//            arr[i] = sc.nextInt();
//        }
//
//
//        int minLength = Integer.MAX_VALUE;
//
//
//        // Starting point of subarray
//        for(int i = 0; i < N; i++)
//        {
//            // C + 1 because colors are from 1 to C
//            boolean[] freq = new boolean[C + 1];
//
//            int count = 0;
//
//
//            // Ending point of subarray
//            for(int j = i; j < N; j++)
//            {
//                // If this color is found for first time
//                if(freq[arr[j]] == false)
//                {
//                    freq[arr[j]] = true;
//
//                    count++;
//                }
//
//
//                // If all C colors are found
//                if(count == C)
//                {
//                    int length = j - i + 1;
//
//                    minLength = Math.min(minLength, length);
//                }
//            }
//        }
//
//
//        // If all colors were never found
//        if(minLength == Integer.MAX_VALUE)
//        {
//            System.out.println(-1);
//        }
//        else
//        {
//            System.out.println(minLength);
//        }
//    }
//}
//

/*
DRY RUN:

Input:

5
3
3
1
1
2
1


N = 5
C = 3

arr = [3, 1, 1, 2, 1]


-----------------------------------

i = 0

boolean freq:

index     0       1       2       3

        false   false   false   false


j = 0

arr[j] = 3

freq[3] == false

So:

freq[3] = true
count = 1


j = 1

arr[j] = 1

freq[1] == false

So:

freq[1] = true
count = 2


j = 2

arr[j] = 1

freq[1] is already true

count remains 2


j = 3

arr[j] = 2

freq[2] == false

So:

freq[2] = true
count = 3


Now:

count == C

3 == 3

All colors found.


length = j - i + 1

       = 3 - 0 + 1

       = 4


minLength = Math.min(Integer.MAX_VALUE, 4)

minLength = 4


Final Output:

4


TIME COMPLEXITY:

O(N^2)


SPACE COMPLEXITY:

O(C)
*/
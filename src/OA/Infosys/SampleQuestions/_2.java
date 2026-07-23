package OA.Infosys.SampleQuestions;

import java.util.*;

class Main2
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] a = new int[n];

        for(int i = 0; i < n; i++)
        {
            a[i] = sc.nextInt();
        }

        int p = sc.nextInt();
        int q = sc.nextInt();
        int two = sc.nextInt();

        // Step 1: Take all queries as input first
        int[][] queries = new int[q][2];

        for(int k = 0; k < q; k++)
        {
            queries[k][0] = sc.nextInt();
            queries[k][1] = sc.nextInt();
        }

        // Step 2: Now start processing
        int yesCount = 0;

        for(int k = 0; k < q; k++)
        {
            int i = queries[k][0];
            int j = queries[k][1];

            // Update array
            a[i - 1] = j;

            boolean found = false;

            // Check single element
            for(int x = 0; x < n; x++)
            {
                if(a[x] == p)
                {
                    found = true;
                    break;
                }
            }

            // Check other possibilities
            if(!found)
            {
                for(int x = 0; x < n; x++)
                {
                    int gcd = 0;
                    int count = 0;

                    for(int y = x; y < n; y++)
                    {
                        gcd = findGCD(gcd, a[y]);
                        count++;

                        if(gcd == p && count < n)
                        {
                            found = true;
                            break;
                        }
                    }

                    if(found)
                    {
                        break;
                    }
                }
            }

            if(found)
            {
                yesCount++;
            }
        }

        System.out.println(yesCount);
    }

    public static int findGCD(int a, int b)
    {
        while(b != 0)
        {
            int rem = a % b;

            a = b;
            b = rem;
        }

        return a;
    }
}
package OA.Infosys.SampleQuestions;

import java.util.*;

class Main1
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] par = new int[n];

        for(int i = 0; i < n; i++)
        {
            par[i] = sc.nextInt();
        }

        int[] a = new int[n];

        for(int i = 0; i < n; i++)
        {
            a[i] = sc.nextInt();
        }

        int total = 0;

        for(int i = 0; i < a.length; i++)
        {
            for(int j = i + 1; j < a.length; j++)
            {
                long product = (long)a[i] * a[j];

                long root = (long)Math.sqrt(product);

                if(root * root == product)
                {
                    total++;
                }
            }
        }

        System.out.println(total);
    }
}
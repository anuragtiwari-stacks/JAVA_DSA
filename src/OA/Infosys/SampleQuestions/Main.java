package OA.Infosys.SampleQuestions;

import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int min = Math.min(a, b);
        int max = Math.max(a, b);

        int hcf = 1;
        int lcm = 0;

        // HCF
        for(int i = min; i >= 1; i--)
        {
            if(a % i == 0 && b % i == 0)
            {
                hcf = i;
                break;
            }
        }

        // LCM
        for(int i = max; i <= a * b; i = i + max)
        {
            if(i % a == 0 && i % b == 0)
            {
                lcm = i;
                break;
            }
        }

        System.out.println("HCF = " + hcf);
        System.out.println("LCM = " + lcm);
    }
}
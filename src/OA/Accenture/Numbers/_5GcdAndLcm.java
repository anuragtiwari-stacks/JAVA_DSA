package OA.Accenture.Numbers;

// Question: Find the GCD and LCM of two numbers

public class _5GcdAndLcm
{
    public static void main(String[] args)
    {
        int a = 12;
        int b = 18;

        System.out.println("HCF:" +findHcf(a,b));
        System.out.println("LCM:" +findLcm(a,b));

    }

    static int findHcf(int a, int b)
    {
        while(b!=0)
        {
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }

    static int findLcm(int a, int b)
    {
        return (a*b)/findHcf(a,b);
    }
}
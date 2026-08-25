package OA.Accenture.Numbers;

// Question: Swap two numbers without using a third/temporary variable

public class _9SwapNumbers
{
    public static void main(String[] args)
    {
        int a = 10;
        int b = 20;

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println(a);
        System.out.println(b);
    }
}
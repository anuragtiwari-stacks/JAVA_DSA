package OA.Accenture.Numbers;

// Question: Print a number's multiplication table up to 10 and the sum of the printed multiples

public class _16MultiplicationTable
{
    public static void main(String[] args)
    {
        int n = 5;

        printTable(n);
    }

    static void printTable(int n)
    {
        int sum = 0;

        for(int i = 1; i <= 10; i++)
        {
            int value = n * i;

            System.out.println(n + " x " + i + " = " + value);

            sum += value;
        }

        System.out.println("Sum = " + sum);
    }
}
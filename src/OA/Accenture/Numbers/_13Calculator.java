package OA.Accenture.Numbers;

// Question: Given a code 1–4, perform addition, subtraction, multiplication, or division on two numbers

public class _13Calculator
{
    public static void main(String[] args)
    {
        int code = 3;
        int a = 10;
        int b = 5;

        System.out.println(calculate(code, a, b));
    }

    static double calculate(int code, int a, int b)
    {
        if(code == 1)
        {
            return a + b;
        }
        else if(code == 2)
        {
            return a - b;
        }
        else if(code == 3)
        {
            return a * b;
        }
        else if(code == 4)
        {
            return (double)a / b;
        }

        return -1;
    }
}
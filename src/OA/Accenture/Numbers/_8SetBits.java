package OA.Accenture.Numbers;

// Question: Count the number of set bits in an integer's binary representation

public class _8SetBits
{
    public static void main(String[] args)
    {
        int n = 13;

        System.out.println(countSetBits(n));
    }

    static int countSetBits(int n)
    {
        // Convert number to binary
        String binary = Integer.toBinaryString(n);

        // Count 1s
        int count = 0;

        for(int i = 0; i < binary.length(); i++)
        {
            if(binary.charAt(i) == '1')
            {
                count++;
            }
        }

        return count;
    }
}
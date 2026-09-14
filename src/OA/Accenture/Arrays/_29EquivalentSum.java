package OA.Accenture.Arrays;

// Question: Find all X such that 1 <= X < N and EqSum(X) > N

public class _29EquivalentSum
{
    public static void main(String[] args)
    {
        int n = 112;

        printNumbers(n);
    }

    static void printNumbers(int n)
    {
        for(int x = 1; x < n; x++)
        {
            int rev = reverse(x);
            int sum = prefixSum(rev);

            if(sum > n)
            {
                System.out.print(x + " ");
            }
        }
    }

    static int reverse(int n)
    {
        int rev = 0;

        while(n > 0)
        {
            rev = rev * 10 + n % 10;
            n /= 10;
        }

        return rev;
    }

    static int prefixSum(int n)
    {
        int prefix = 0;
        int sum = 0;

        while(n > 0)
        {
            int digit = n % 10;

            prefix = prefix * 10 + digit;
            sum += prefix;

            n /= 10;
        }

        return sum;
    }
}

/*
Dry Run:

N = 112

Condition:
1 <= X < 112
EqSum(X) > 112


X = 101

reverse(101) = 101

prefixSum(101):

digit = 1
prefix = 1
sum = 1

digit = 0
prefix = 10
sum = 11

digit = 1
prefix = 101
sum = 112

112 > 112 ❌
101 is NOT valid


X = 102

reverse(102) = 201

prefixSum(201):

digit = 1
prefix = 1
sum = 1

digit = 0
prefix = 10
sum = 11

digit = 2
prefix = 102
sum = 113

113 > 112 ✅
102 is valid


Similarly:

103 → 1 + 10 + 103 = 114 ✅
104 → 1 + 10 + 104 = 115 ✅
105 → 1 + 10 + 105 = 116 ✅
106 → 1 + 10 + 106 = 117 ✅
107 → 1 + 10 + 107 = 118 ✅
108 → 1 + 10 + 108 = 119 ✅
109 → 1 + 10 + 109 = 120 ✅

110 → 1 + 11 + 110 = 122 ✅
111 → 1 + 11 + 111 = 123 ✅


Final Output:

102 103 104 105 106 107 108 109 110 111
*/
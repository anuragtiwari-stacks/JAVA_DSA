package _02String;

/*
LeetCode 1758
Minimum Changes To Make Alternating Binary String

File Name: _7AlternatingBinaryString.java
*/

public class _7AlternatingBinaryString
{

    public int minOperations(String s)
    {
        int n = s.length();

        StringBuilder s1 = new StringBuilder(); // 010101...
        StringBuilder s2 = new StringBuilder(); // 101010...

        int count1 = 0;
        int count2 = 0;

        for(int i = 0; i < n; i++)
        {
            if(i % 2 == 0)
            {
                s1.append('0');
                s2.append('1');
            }

            else
            {
                s1.append('1');
                s2.append('0');
            }
        }

        for(int i = 0; i < n; i++)
        {
            if(s.charAt(i) != s1.charAt(i))
            {
                count1++;
            }

            if(s.charAt(i) != s2.charAt(i))
            {
                count2++;
            }
        }

        return Math.min(count1, count2);
    }


    public static void main(String[] args)
    {
        _7AlternatingBinaryString obj = new _7AlternatingBinaryString();

        String s = "0100";

        int result = obj.minOperations(s);

        System.out.println("Minimum Operations: " + result);
    }

}


/*

DRY RUN

Input:
s = "0100"

Step 1: Generate two alternating strings

s1 = 0101
s2 = 1010


Step 2: Compare with original string

Original = 0100

Compare with s1
0100
0101
   ^
count1 = 1


Compare with s2
0100
1010
^^ ^
count2 = 3


Step 3: Return minimum

min(1 , 3) = 1


Output
Minimum Operations: 1

Time Complexity  : O(n)
Space Complexity : O(n)

*/
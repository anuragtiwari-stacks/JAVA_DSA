package _02String;

/*
LeetCode 1784
Check if Binary String Has at Most One Segment of Ones

File Name: _8CheckOnesSegment.java
*/

public class _8CheckOnesSegment
{

    public boolean checkOnesSegment(String s)
    {
        int n = s.length();

        for(int i = 0; i < n-1; i++)
        {
            if(s.charAt(i) == '0' && s.charAt(i+1) == '1')
            {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args)
    {
        _8CheckOnesSegment obj = new _8CheckOnesSegment();

        String s = "110011";

        boolean result = obj.checkOnesSegment(s);

        System.out.println("Has At Most One Segment of Ones: " + result);
    }

}


/*
NOTE -> it always start with 1 (given)

possible pattern
10  -> 11111111000000
11  -> 111 -> 1110 -> 11101  jeshe hi 01 aayaa ye consecutive 1 nhi rhaaa


Time Complexity  : O(n)
Space Complexity : O(1)

*/
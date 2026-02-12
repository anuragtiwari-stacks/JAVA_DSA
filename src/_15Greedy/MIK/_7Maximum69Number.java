package _15Greedy.MIK;

// LeetCode 1323 — Maximum 69 Number

public class _7Maximum69Number
{
    public int maximum69Number(int num)
    {
        String s = Integer.toString(num); // number -> string
        char[] arr = s.toCharArray();     // string -> char array

        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] == '6')
            {
                arr[i] = '9';
                break;
            }
        }

        String ans = new String(arr);     // char[] -> string
        return Integer.parseInt(ans);     // string -> int
    }

    public static void main(String[] args)
    {
        _7Maximum69Number obj = new _7Maximum69Number();
        System.out.println(obj.maximum69Number(9669));
        System.out.println(obj.maximum69Number(9996));
        System.out.println(obj.maximum69Number(9999));
    }
}

/*
---------------- DRY RUN ----------------

Input: num = 9669

Step 1: s = "9669"
Step 2: arr = ['9','6','6','9']

Loop:
i=0 -> '9' != '6' -> continue
i=1 -> '6' found -> change to '9'
arr becomes ['9','9','6','9']
break

Step 3: ans = "9969"
Step 4: return 9969

Output = 9969

-----------------------------------------

Input: num = 9996

s = "9996"
arr = ['9','9','9','6']

Loop:
i=0 no
i=1 no
i=2 no
i=3 yes -> arr = ['9','9','9','9']

ans = "9999"
return 9999

-----------------------------------------

Input: num = 9999

arr has no '6'
loop ends

ans = "9999"
return 9999

-----------------------------------------
*/

package OA.Infosys;

import java.util.*;

class Main1
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        String st = sc.nextLine();
        int open = sc.nextInt();
        int close = sc.nextInt();

        char[] arr = st.toCharArray();
        Stack<Character> s = new Stack<>();

        s.push(arr[0]);

        int n = arr.length;
        for(int i=1;i<n;i++)
        {
            if(!s.isEmpty() && s.peek()=='(' && arr[i]==')')
            {
                s.pop();
            }
            else
            {
                s.push(arr[i]);
            }
        }

        int total = 0;
        while(!s.isEmpty())
        {
            char ch = s.pop();
            if(ch == '(')
            {
                total = total + open;
            }
            else
            {
                total = total + close;
            }
        }
        System.out.println(total);
    }

}

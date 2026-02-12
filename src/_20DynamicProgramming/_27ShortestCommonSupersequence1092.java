package _20DynamicProgramming;

// LeetCode 1092

public class _27ShortestCommonSupersequence1092
{
    public static String shortestCommonSupersequence(String s1,String s2)
    {
        String lcs=getLCS(s1,s2);
        int i=0;
        int j=0;
        int k=0;
        StringBuilder sb=new StringBuilder();
        while(k<lcs.length())
        {
            while(i<s1.length() && s1.charAt(i)!=lcs.charAt(k))
            {
                sb.append(s1.charAt(i));
                i++;
            }
            while(j<s2.length() && s2.charAt(j)!=lcs.charAt(k))
            {
                sb.append(s2.charAt(j));
                j++;
            }
            sb.append(lcs.charAt(k));
            i++;
            j++;
            k++;
        }
        while(i<s1.length())
        {
            sb.append(s1.charAt(i));
            i++;
        }
        while(j<s2.length())
        {
            sb.append(s2.charAt(j));
            j++;
        }
        return sb.toString();
    }

    public static String getLCS(String s1,String s2)
    {
        int n=s1.length();
        int m=s2.length();
        String[][] dp=new String[n+1][m+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=m;j++)
            {
                dp[i][j]="";
            }
        }
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    dp[i][j]=dp[i-1][j-1]+s1.charAt(i-1);
                }
                else
                {
                    dp[i][j]=dp[i-1][j].length()>=dp[i][j-1].length()?dp[i-1][j]:dp[i][j-1];
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args)
    {
        String s1="adbefc";
        String s2="zgahbicmn";
        String scs=shortestCommonSupersequence(s1,s2);
        System.out.println(scs);
    }
}

/*
DRY RUN:

s1 = adbefc
s2 = zgahbicmn

BUILDING LCS USING STRING-DP:

dp table last cell = "abc"
So LCS = "abc"

NOW BUILD SCS USING LCS = "abc"

i=0, j=0, k=0

s2[j]=z != a  → add z
j=1

s2[j]=g != a  → add g
j=2

s2[j]=a == a AND s1[i]!=a
s1[i]=a so match
append 'a'
i=1, j=3, k=1

Next LCS char = 'b'

s1[i]=d != b → add d
i=2

s1[i]=b == b AND s2[j]!=b
s2[j]=h != b → add h
j=4

s2[j]=b == b AND s1[i]==b
append 'b'
i=3, j=5, k=2

Next LCS char = 'c'

s1[i]=e != c → add e
i=4

s1[i]=f != c → add f
i=5

s2[j]=i != c → add i
j=6

s2[j]=c == c AND s1[i]==c
append 'c'
i=6, j=7, k=3

Append remaining s1 or s2 (none left for s1, s2 has mn → append m,n)

FINAL SCS = z g a d h b e f i c m n

OUTPUT:
zgadhbeficmn
*/

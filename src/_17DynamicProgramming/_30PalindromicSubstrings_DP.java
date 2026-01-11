package _17DynamicProgramming;

// LeetCode 647. Palindromic Substrings
public class _30PalindromicSubstrings_DP
{
    public static int countSubstrings(String s)
    {
        int n = s.length();
        int[][] dp = new int[n][n];
        int count = 0;

        // gap-based DP (diagonal filling)
        for(int k = 0; k < n; k++)
        {
            int i = 0, j = k;

            while(j < n)
            {
                if(i == j)
                {
                    // single character palindrome
                    dp[i][j] = 1;
                    count++;
                }
                else if(j == i + 1)
                {
                    // length 2 substring
                    if(s.charAt(i) == s.charAt(j))
                    {
                        dp[i][j] = 1;
                        count++;
                    }
                }
                else
                {
                    // length >= 3
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == 1)
                    {
                        dp[i][j] = 1;
                        count++;
                    }
                }

                i++;
                j++;
            }
        }

        return count;
    }

    public static void main(String[] args)
    {
        String s = "gabcbab";
        int ans = countSubstrings(s);
        System.out.println("Total Palindromic Substrings = " + ans);
    }
}

/*
------------------------------------------------------------
                   DRY RUN (For s = "gabcbab")
------------------------------------------------------------
Indexes: g(0) a(1) b(2) c(3) b(4) a(5) b(6)

dp[i][j] = 1 means s[i..j] is palindrome.

We fill diagonally using gap (k = j - i):

k = 0 (len 1 substrings)
dp[0][0] = 1  (g)
dp[1][1] = 1  (a)
dp[2][2] = 1  (b)
dp[3][3] = 1  (c)
dp[4][4] = 1  (b)
dp[5][5] = 1  (a)
dp[6][6] = 1  (b)

k = 1 (len 2 substrings)
Check pairs:
g a  -> no
a b  -> no
b c  -> no
c b  -> no
b a  -> no
a b  -> no

k = 2 (len 3 substrings)
Check triples:
g a b -> no
a b c -> no
b c b -> YES (bcb)
c b a -> no
b a b -> YES (bab)

k = 3 (len 4 substrings)
g a b c -> no
a b c b -> no
b c b a -> no
c b a b -> no

k = 4 (len 5 substrings)
g a b c b -> no
a b c b a -> YES (abcba)
b c b a b -> YES (cbabc)

k = 5 (len 6 substrings)
g a b c b a -> no
a b c b a b -> no

k = 6 (len 7 substrings)
g a b c b a b -> no

------------------------------------------------------------
Final DP Table (1 = palindrome):
     0 1 2 3 4 5 6
   -----------------
0 |  1 0 0 0 0 0 0
1 |  X 1 0 0 0 0 0
2 |  X X 1 0 1 0 0
3 |  X X X 1 0 0 0
4 |  X X X X 1 0 1
5 |  X X X X X 1 0
6 |  X X X X X X 1

Palindromic substrings counted = 10

------------------------------------------------------------
*/

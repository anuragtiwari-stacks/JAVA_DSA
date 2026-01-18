// LeetCode 3085 - Minimum Deletions to Make Character Frequencies K-Different

package _12Greedy.MIK;

public class _24MinimumDeletions
{
    public int minimumDeletions(String word, int k)
    {
        int[] freq = new int[26];
        for(char ch : word.toCharArray())
        {
            freq[ch - 'a']++;
        }

        int result = word.length();

        for(int i = 0; i < 26; i++)
        {
            int del = 0;

            for(int j = 0; j < 26; j++)
            {
                if(i == j) continue;

                if(freq[j] < freq[i])
                {
                    del += freq[j];
                }
                else if(Math.abs(freq[j] - freq[i]) > k)
                {
                    del += Math.abs(freq[j] - (freq[i] + k));
                }
            }

            result = Math.min(result, del);
        }

        return result;
    }

    public static void main(String[] args)
    {
        _24MinimumDeletions obj = new _24MinimumDeletions();

        String word = "aabcddd";
        int k = 1;

        int result = obj.minimumDeletions(word, k);
        System.out.println("Minimum Deletions: " + result);
    }
}

/*
==================== DRY RUN ====================

Input:
word = "aabcddd"
k = 1

Step-1: Frequency Count
a -> 2
b -> 1
c -> 1
d -> 3
others -> 0

freq array (only non-zero):
[a=2, b=1, c=1, d=3]

result initially = length = 7

Now for each i in 0..25 (target freq = freq[i]):

Case i = 'a' (freq = 2):
j='b' freq=1 <2 → del +=1 (remove b)
j='c' freq=1 <2 → del +=1 (remove c)
j='d' freq=3; |3-2| = 1 <= k → OK, no deletion
Total del = 2 → result = min(7,2)=2

Case i = 'b' (freq = 1):
j='a' freq=2 >=1; |2-1|=1 <=k OK
j='c' freq=1==1 skip
j='d' freq=3; |3-1|=2 > k => del+= |3-(1+k)|=|3-2|=1
Total del =1 → result = min(2,1)=1

Case i = 'c' same as b → del=1 → result stays 1

Case i = 'd' (freq=3):
j='a' freq=2<3 → del+=2
j='b' freq=1<3 → del+=1
j='c' freq=1<3 → del+=1
Total del=4 → result stays 1

Final Answer:
1

Console:
Minimum Deletions: 1

=================================================
*/

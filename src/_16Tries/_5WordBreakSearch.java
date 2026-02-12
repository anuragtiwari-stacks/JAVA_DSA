package _16Tries;

public class _5WordBreakSearch
{
    private TrieNodes root;

    public _5WordBreakSearch()
    {
        root = new TrieNodes();
    }

    // INSERT WORD INTO TRIE
    public void insert(String word)
    {
        TrieNodes current = root;

        for (int i = 0; i < word.length(); i++)
        {
            int index = word.charAt(i) - 'a';

            if (current.children[index] == null)
            {
                current.children[index] = new TrieNodes();
            }

            current = current.children[index];
        }

        current.isEndOfWord = true;
    }

    // WORD BREAK USING TRIE
    public boolean wordBreak(String s, int start)
    {
        if (start == s.length())
        {
            return true;
        }

        TrieNodes current = root;

        for (int i = start; i < s.length(); i++)
        {
            int index = s.charAt(i) - 'a';

            if (current.children[index] == null)
            {
                return false;
            }

            current = current.children[index];

            if (current.isEndOfWord)
            {
                if (wordBreak(s, i + 1))
                {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args)
    {
        _5WordBreakSearch trie = new _5WordBreakSearch();

        trie.insert("leet");
        trie.insert("code");
        trie.insert("apple");
        trie.insert("pen");

        System.out.println(trie.wordBreak("leetcode", 0));        // true
        System.out.println(trie.wordBreak("applepenapple", 0));  // true
        System.out.println(trie.wordBreak("catsandog", 0));       // false
    }
}
/*
Simple DRY RUN for wordBreak("leetcode", 0)

Dictionary words in Trie:
leet
code

s = "leetcode"

Call 1:
wordBreak("leetcode", 0)

start = 0
current = root

i = 0  -> 'l'  -> path exists
i = 1  -> 'e'  -> path exists
i = 2  -> 'e'  -> path exists
i = 3  -> 't'  -> path exists
          isEndOfWord = true  ("leet")

Recursive call:
wordBreak("leetcode", 4)

--------------------------------

Call 2:
wordBreak("leetcode", 4)

start = 4
current = root

i = 4  -> 'c'  -> path exists
i = 5  -> 'o'  -> path exists
i = 6  -> 'd'  -> path exists
i = 7  -> 'e'  -> path exists
          isEndOfWord = true  ("code")

Recursive call:
wordBreak("leetcode", 8)

--------------------------------

Call 3:
wordBreak("leetcode", 8)

start == s.length()
return true

--------------------------------

Return flow:
wordBreak(8)  -> true
wordBreak(4)  -> true
wordBreak(0)  -> true

Final Answer:
true
*/

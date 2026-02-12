package _16Tries;

import java.util.Arrays;

public class _8LongestWordAllPrefixes
{
    private TrieNodes root;

    public _8LongestWordAllPrefixes()
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

    // CHECK IF ALL PREFIXES OF WORD EXIST
    public boolean hasAllPrefixes(String word)
    {
        TrieNodes current = root;

        for (int i = 0; i < word.length(); i++)
        {
            int index = word.charAt(i) - 'a';

            current = current.children[index];

            if (current == null || !current.isEndOfWord)
            {
                return false;
            }
        }

        return true;
    }

    // FIND LONGEST WORD WITH ALL PREFIXES
    public String longestWord(String[] words)
    {
        String answer = "";

        for (String word : words)
        {
            if (hasAllPrefixes(word))
            {
                if (word.length() > answer.length())
                {
                    answer = word;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args)
    {
        _8LongestWordAllPrefixes trie =
                new _8LongestWordAllPrefixes();

        String[] words =
                {
                        "a", "ap", "app", "appl", "apple", "apply"
                };

        Arrays.sort(words);

        for (String word : words)
        {
            trie.insert(word);
        }

        System.out.println(trie.longestWord(words)); // apple
    }
}

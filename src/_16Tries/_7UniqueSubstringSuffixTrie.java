package _16Tries;

public class _7UniqueSubstringSuffixTrie
{
    private TrieNodes root;

    public _7UniqueSubstringSuffixTrie()
    {
        root = new TrieNodes();
    }

    // Count unique substrings using Suffix Trie
    public int countUniqueSubstrings(String s)
    {
        int count = 0;

        // generate all suffixes
        for (int i = 0; i < s.length(); i++)
        {
            TrieNodes current = root;

            // insert each suffix character by character
            for (int j = i; j < s.length(); j++)
            {
                int index = s.charAt(j) - 'a';

                if (current.children[index] == null)
                {
                    current.children[index] = new TrieNodes();
                    count++; // new node = new unique substring
                }

                current = current.children[index];
            }
        }

        return count;
    }

    public static void main(String[] args)
    {
        _7UniqueSubstringSuffixTrie trie = new _7UniqueSubstringSuffixTrie();

        String s = "ababa";

        System.out.println(trie.countUniqueSubstrings(s)); // 9
    }
}

/*
DRY RUN for s = "ababa"

All suffixes:
i = 0 → "ababa"
i = 1 → "baba"
i = 2 → "aba"
i = 3 → "ba"
i = 4 → "a"

--------------------------------
Suffix 1: "ababa"

a     → new node (count = 1)
ab    → new node (count = 2)
aba   → new node (count = 3)
abab  → new node (count = 4)
ababa → new node (count = 5)

--------------------------------
Suffix 2: "baba"

b     → new node (count = 6)
ba    → new node (count = 7)
bab   → new node (count = 8)
baba  → new node (count = 9)

--------------------------------
Suffix 3: "aba"

a     → already exists
ab    → already exists
aba   → already exists

--------------------------------
Suffix 4: "ba"

b     → already exists
ba    → already exists

--------------------------------
Suffix 5: "a"

a     → already exists

--------------------------------
Total unique substrings = 9

Unique substrings are:
a, b, ab, ba, aba, bab, abab, baba, ababa
*/

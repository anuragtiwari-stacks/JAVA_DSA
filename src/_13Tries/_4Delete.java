package _13Tries;

public class _4Delete
{
    private TrieNodes root;

    public _4Delete()
    {
        root = new TrieNodes();
    }

    // INSERT (needed to test delete)
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
            current.freq++;
        }

        current.isEndOfWord = true;
    }

    // SEARCH (to verify delete)
    public boolean search(String word)
    {
        TrieNodes current = root;

        for (int i = 0; i < word.length(); i++)
        {
            int index = word.charAt(i) - 'a';

            if (current.children[index] == null)
            {
                return false;
            }

            current = current.children[index];
        }

        return current.isEndOfWord;
    }

    // DELETE (freq based)
    public void delete(String word)
    {
        TrieNodes current = root;

        for (int i = 0; i < word.length(); i++)
        {
            int index = word.charAt(i) - 'a';

            if (current.children[index] == null)
            {
                return; // word not present
            }

            current = current.children[index];
            current.freq--;
        }

        current.isEndOfWord = false;
    }

    public static void main(String[] args)
    {
        _4Delete trie = new _4Delete();

        trie.insert("apple");
        trie.insert("app");
        trie.insert("bat");

        System.out.println(trie.search("app"));    // true
        System.out.println(trie.search("apple")); // true

        trie.delete("app");
        trie.delete("bat");

        System.out.println(trie.search("app"));    // false
        System.out.println(trie.search("apple")); // true
        System.out.println(trie.search("bat"));   // false
    }
}

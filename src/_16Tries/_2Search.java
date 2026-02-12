package _16Tries;

public class _2Search
{
    private TrieNode root;

    public _2Search()
    {
        root = new TrieNode();
    }

    public void insert(String word)
    {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++)
        {
            int index = word.charAt(i) - 'a';

            if (current.children[index] == null)
            {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.isEndOfWord = true;
    }

    public boolean search(String word)
    {
        TrieNode current = root;

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

    public static void main(String[] args)
    {
        _2Search trie = new _2Search();

        trie.insert("apple");
        trie.insert("app");
        trie.insert("bat");

        System.out.println(trie.search("apple")); // true
        System.out.println(trie.search("app"));   // true
        System.out.println(trie.search("bat"));   // true
        System.out.println(trie.search("bad"));   // false
    }
}

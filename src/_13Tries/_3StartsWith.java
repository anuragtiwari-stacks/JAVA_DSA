package _13Tries;

public class _3StartsWith
{
    private TrieNode root;

    public _3StartsWith()
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

    public boolean startsWith(String prefix)
    {
        TrieNode current = root;

        for (int i = 0; i < prefix.length(); i++)
        {
            int index = prefix.charAt(i) - 'a';

            if (current.children[index] == null)
            {
                return false;
            }

            current = current.children[index];
        }

        return true;
    }

    public static void main(String[] args)
    {
        _3StartsWith trie = new _3StartsWith();

        trie.insert("apple");
        trie.insert("app");
        trie.insert("bat");

        System.out.println(trie.startsWith("app")); // true
        System.out.println(trie.startsWith("ba"));  // true
        System.out.println(trie.startsWith("cat")); // false
    }
}

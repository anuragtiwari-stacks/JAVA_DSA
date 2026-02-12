package _16Tries;

public class _6PrefixFreq
{
    private TrieNodes root;

    public _6PrefixFreq()
    {
        root = new TrieNodes();
    }

    // INSERT WITH FREQ
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

    // PREFIX USING freq == 1 CONCEPT
    public String getPrefix(String word)
    {
        StringBuilder prefix = new StringBuilder();
        TrieNodes current = root;

        for (int i = 0; i < word.length(); i++)
        {
            int index = word.charAt(i) - 'a';
            current = current.children[index];

            prefix.append(word.charAt(i));

            // ⭐ MAIN CONDITION
            if (current.freq == 1)
            {
                return prefix.toString();
            }
        }

        return prefix.toString();
    }

    public static void main(String[] args)
    {
        _6PrefixFreq trie = new _6PrefixFreq();

        String[] words = { "zebra", "dog", "duck", "dove" };

        for (String word : words)
        {
            trie.insert(word);
        }

        for (String word : words)
        {
            System.out.println(word + " -> " + trie.getPrefix(word));
        }
    }
}

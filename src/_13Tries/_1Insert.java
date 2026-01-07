package _13Tries;

public class _1Insert
{
    private TrieNode root;

    public _1Insert()
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

    public static void main(String[] args)
    {
        _1Insert trie = new _1Insert();

        trie.insert("apple");
        trie.insert("app");
        trie.insert("bat");

        System.out.println("Insert operation done");
    }
}


/*
DRY RUN FOR INSERTING "apple"

Initial:
current = root

Word = "apple"

i = 0
char = 'a'
index = 'a' - 'a' = 0
root.children[0] == null
→ create new TrieNode
→ current = root.children[0]

Structure:
root
 |
 a

i = 1
char = 'p'
index = 'p' - 'a' = 15
a.children[15] == null
→ create new TrieNode
→ current = a.children[15]

Structure:
root
 |
 a
 |
 p

i = 2
char = 'p'
index = 15
p.children[15] == null
→ create new TrieNode
→ current = p.children[15]

Structure:
root
 |
 a
 |
 p
 |
 p

i = 3
char = 'l'
index = 'l' - 'a' = 11
p.children[11] == null
→ create new TrieNode
→ current = p.children[11]

Structure:
root
 |
 a
 |
 p
 |
 p
 |
 l

i = 4
char = 'e'
index = 'e' - 'a' = 4
l.children[4] == null
→ create new TrieNode
→ current = l.children[4]

Structure:
root
 |
 a
 |
 p
 |
 p
 |
 l
 |
 e

After loop:
current.isEndOfWord = true
→ "apple" is stored in Trie
*/

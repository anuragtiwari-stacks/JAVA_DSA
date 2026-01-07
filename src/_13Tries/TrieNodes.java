package _13Tries;

public class TrieNodes
{
    TrieNodes[] children;
    boolean isEndOfWord;
    int freq;

    public TrieNodes()
    {
        children = new TrieNodes[26];
        isEndOfWord = false;
        freq = 0;
    }
}

package OA.Accenture.Strings;

// Question: Find the starting index of one string inside another (substring search)

public class _17SubstringSearch
{
    public static void main(String[] args)
    {
        String str = "sadbutsad";
        String target = "sad";

        System.out.println(findIndex(str, target));
    }

    static int findIndex(String str, String target)
    {
        return str.indexOf(target);
    }
}
package OA.Accenture.Strings;

// Question: Check if one string is a rotation of another string

public class _4StringRotation
{
    public static void main(String[] args)
    {
        String str1 = "ABCD";
        String str2 = "CDAB";

        System.out.println(isRotation(str1, str2));
    }

    static boolean isRotation(String str1, String str2)
    {
        if(str1.length() != str2.length())
        {
            return false;
        }

        String combined = str1 + str1;

        return combined.contains(str2);
    }
}
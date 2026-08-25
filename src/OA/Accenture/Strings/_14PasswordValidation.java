package OA.Accenture.Strings;

// Question: Validate a password (min 4 characters, at least one digit, at least one capital letter, no space or slash, must not start with a digit)

public class _14PasswordValidation
{
    public static void main(String[] args)
    {
        String password = "Abcd1234";

        System.out.println(isValid(password));
    }

    static boolean isValid(String password)
    {
        if(password.length() < 4)
        {
            return false;
        }

        if(Character.isDigit(password.charAt(0)))
        {
            return false;
        }

        boolean digit = false;
        boolean capital = false;

        for(int i = 0; i < password.length(); i++)
        {
            char ch = password.charAt(i);

            if(ch == ' ' || ch == '/')
            {
                return false;
            }

            if(Character.isDigit(ch))
            {
                digit = true;
            }

            if(Character.isUpperCase(ch))
            {
                capital = true;
            }
        }

        return digit && capital;
    }
}
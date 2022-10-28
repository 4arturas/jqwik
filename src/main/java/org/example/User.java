package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User
{
    private static final String EMAIL_PATTERN = "^(.+)@(\\S+)$";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    public static boolean isValid(final String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    String email;

    public User(String email)
    {
        assert email != null && email.length() > 0 && isValid(email);
//        assert isValid(email);
        this.email = email;
    }
}

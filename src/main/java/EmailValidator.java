
public class EmailValidator {

    // Email validation regex
    private static final String EMAIL_REGEX =
            "^[A-Za-z0-9]+(?:[._+-][A-Za-z0-9]+)*"
                    + "@[A-Za-z0-9]+\\.[A-Za-z]{2,}"
                    + "(?:\\.[A-Za-z]{2,})?$";

    // Validate email address
    public static boolean isValidEmail(String email) {

        if (email == null || email.isEmpty()) {
            return false;
        }

        return email.matches(EMAIL_REGEX);
    }
}

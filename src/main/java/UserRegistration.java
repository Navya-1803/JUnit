
public class UserRegistration {

    // UC1: Validate first name
    // First name must start with a capital letter and have at least 3 characters.
    public static boolean validateFirstName(String firstName) {

        return firstName != null &&
                firstName.matches("^[A-Z][a-zA-Z]{2,}$");
    }

    // UC2: Validate last name
    // Last name must start with a capital letter and have at least 3 characters.
    public static boolean validateLastName(String lastName) {

        return lastName != null &&
                lastName.matches("^[A-Z][a-zA-Z]{2,}$");
    }

    // UC3: Validate email address
    // Supports an optional username section and an optional country suffix.
    // Examples: abc@bl.co and abc.xyz@bl.co.in
    public static boolean validateEmail(String email) {

        String emailRegex =
                "^[A-Za-z0-9]+(?:[._+-][A-Za-z0-9]+)*"
                        + "@[A-Za-z0-9]+\\.[A-Za-z]{2,}"
                        + "(?:\\.[A-Za-z]{2,})?$";

        return email != null && email.matches(emailRegex);
    }

    // UC4: Validate mobile number
    // Format: country code, one space, and 10-digit mobile number.
    // Example: 91 9919819801
    public static boolean validateMobile(String mobile) {

        return mobile != null &&
                mobile.matches("^[0-9]{1,3} [0-9]{10}$");
    }

    // UC5: Password must contain at least 8 characters.
    public static boolean validatePasswordLength(String password) {

        return password != null && password.length() >= 8;
    }

    // UC6: Password must contain at least one uppercase letter.
    public static boolean validatePasswordUppercase(String password) {

        return password != null &&
                password.matches(".*[A-Z].*");
    }

    // UC7: Password must contain at least one numeric digit.
    public static boolean validatePasswordDigit(String password) {

        return password != null &&
                password.matches(".*[0-9].*");
    }

    // UC8: Password must contain exactly one special character.
    public static boolean validatePasswordSpecialCharacter(String password) {

        if (password == null) {
            return false;
        }

        int specialCharacterCount = 0;

        for (char character : password.toCharArray()) {

            if (!Character.isLetterOrDigit(character)) {
                specialCharacterCount++;
            }
        }

        return specialCharacterCount == 1;
    }

    // UC5 to UC8: Validate all password rules together.
    public static boolean validatePassword(String password) {

        return validatePasswordLength(password)
                && validatePasswordUppercase(password)
                && validatePasswordDigit(password)
                && validatePasswordSpecialCharacter(password);
    }

    // UC9: Validate all user details together.
    public static boolean validateUser(
            String firstName,
            String lastName,
            String email,
            String mobile,
            String password) {

        return validateFirstName(firstName)
                && validateLastName(lastName)
                && validateEmail(email)
                && validateMobile(mobile)
                && validatePassword(password);
    }

    public static void main(String[] args) {

        String firstName = "Navya";
        String lastName = "Raj";
        String email = "abc.xyz@bl.co.in";
        String mobile = "91 9919819801";
        String password = "Navya@123";

        if (validateUser(firstName, lastName, email, mobile, password)) {
            System.out.println("User registration successful!");
        } else {
            System.out.println("User registration failed!");
        }
    }
}

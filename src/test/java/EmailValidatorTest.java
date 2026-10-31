
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmailValidatorTest {

    // =====================================================
    // UC1: Test all valid email addresses
    // =====================================================

    @ParameterizedTest
    @CsvSource({
            "abc@yahoo.com, true",
            "abc-100@yahoo.com, true",
            "abc.100@yahoo.com, true",
            "abc111@abc.com, true",
            "abc-100@abc.net, true",
            "abc.100@abc.com.au, true",
            "abc@1.com, true",
            "abc@gmail.com.com, true",
            "abc+100@gmail.com, true"
    })
    void testValidEmails(String email, boolean expected) {

        assertEquals(
                expected,
                EmailValidator.isValidEmail(email),
                "Failed for valid email: " + email
        );
    }

    // =====================================================
    // UC2: Test all invalid email addresses
    // =====================================================

    @ParameterizedTest
    @CsvSource({
            "abc, false",
            "abc@.com.my, false",
            "abc123@gmail.a, false",
            "abc123@.com, false",
            "abc123@.com.com, false",
            ".abc@abc.com, false",
            "abc()*@gmail.com, false",
            "abc@%*.com, false",
            "abc..2002@gmail.com, false",
            "abc.@gmail.com, false",
            "abc@abc@gmail.com, false",
            "abc@gmail.com.1a, false",
            "abc@gmail.com.aa.au, false"
    })
    void testInvalidEmails(String email, boolean expected) {

        assertEquals(
                expected,
                EmailValidator.isValidEmail(email),
                "Failed for invalid email: " + email
        );
    }

    // =====================================================
    // UC3: Test null and empty email addresses
    // Additional boundary test cases
    // =====================================================

    @ParameterizedTest
    @CsvSource({
            "'', false"
    })
    void testEmptyEmail(String email, boolean expected) {

        assertEquals(expected, EmailValidator.isValidEmail(email));
    }

    @org.junit.jupiter.api.Test
    void testNullEmail() {

        assertEquals(false, EmailValidator.isValidEmail(null));
    }
}

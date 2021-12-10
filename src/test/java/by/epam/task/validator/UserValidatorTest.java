package by.epam.task.validator;

import by.epam.task.model.validator.UserValidator;
import jakarta.xml.bind.ValidationException;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class UserValidatorTest {

    @Test(groups = "validator" , priority = 1)
    public void nameIsNullValidatorTest() throws ValidationException{
        boolean result = UserValidator.getInstance().isNameValid(null);
        assertFalse(result);
    }

    @Test(groups = "validator" , priority = 2)
    public void nameWithNumberValidatorTest() throws ValidationException{
        String name = "name1";
        boolean result = UserValidator.getInstance().isNameValid(name);
        assertFalse(result);
    }

    @Test(groups = "validator" , priority = 3)
    public void nameWithDifferentLettersValidatorTest() throws ValidationException{
        String name = "zxcфйц";
        boolean result = UserValidator.getInstance().isNameValid(name);
        assertFalse(result);
    }

    @Test(groups = "validator" , priority = 4)
    public void longerThanCorrectNameValidatorTest() throws ValidationException{
        String name = "иваниваниваниваниваниваниваниваниваниваниваниван";
        boolean result = UserValidator.getInstance().isNameValid(name);
        assertFalse(result);
    }

    @Test(groups = "validator" , priority = 5)
    public void shorterThanCorrectNameValidatorTest() throws ValidationException{
        String name = "To";
        boolean result = UserValidator.getInstance().isNameValid(name);
        assertFalse(result);
    }

    @Test(groups = "validator" , priority = 6)
    public void rusLettersNameValidatorTest() throws ValidationException{
        String name = "Никита";
        boolean result = UserValidator.getInstance().isNameValid(name);
        assertTrue(result);
    }

    @Test(groups = "validator" , priority = 7)
    public void engLettersNameValidatorTest() throws ValidationException{
        String name = "Tom";
        boolean result = UserValidator.getInstance().isNameValid(name);
        assertTrue(result);
    }

    @Test(groups = "validator" , priority = 8)
    public void surnameIsNullValidatorTest() throws ValidationException{
        boolean result = UserValidator.getInstance().isSurnameValid(null);
        assertFalse(result);
    }

    @Test(groups = "validator" , priority = 9)
    public void surnameWithNumberValidatorTest() throws ValidationException{
        String surname = "surname1";
        boolean result = UserValidator.getInstance().isSurnameValid(surname);
        assertFalse(result);
    }

    @Test(groups = "validator" , priority = 10)
    public void surnameWithDifferentLettersValidatorTest() throws ValidationException{
        String surname = "zxcфйц";
        boolean result = UserValidator.getInstance().isSurnameValid(surname);
        assertFalse(result);
    }

    @Test(groups = "validator" , priority = 11)
    public void longerThanCorrectSurnameValidatorTest() throws ValidationException{
        String surname = "ИвановИвановИвановИвановИвановИвановИванов";
        boolean result = UserValidator.getInstance().isSurnameValid(surname);
        assertFalse(result);
    }

    @Test(groups = "validator" , priority = 12)
    public void shorterThanCorrectSurnameValidatorTest() throws ValidationException{
        String surname = "Ив";
        boolean result = UserValidator.getInstance().isSurnameValid(surname);
        assertFalse(result);
    }

    @Test(groups = "validator" , priority = 13)
    public void rusLettersSurnameValidatorTest() throws ValidationException{
        String surname = "Иванов";
        boolean result = UserValidator.getInstance().isSurnameValid(surname);
        assertTrue(result);
    }

    @Test(groups = "validator" , priority = 14)
    public void engLettersSurnameValidatorTest() throws ValidationException{
        String surname = "Brown";
        boolean result = UserValidator.getInstance().isSurnameValid(surname);
        assertTrue(result);
    }

    @Test(groups = "validator" , priority = 15)
    public void incorrectEmailValidatorTest() throws ValidationException{
        String email = "dwqwdwdw@greger";
        boolean result = UserValidator.getInstance().isEmailValid(email);
        assertFalse(result);
    }

    @Test(groups = "validator" , priority = 16)
    public void correctEmailValidatorTest() throws ValidationException{
        String email = "dwqwdwdw@gmail.com";
        boolean result = UserValidator.getInstance().isEmailValid(email);
        assertTrue(result);
    }

    @Test(groups = "validator" , priority = 17)
    public void loginIsNullValidatorTest() throws ValidationException{
        boolean result = UserValidator.getInstance().isLoginValid(null);
        assertFalse(result);
    }

    @Test(groups = "validator" , priority = 18)
    public void incorrectLoginValidatorTest() throws ValidationException{
        String login = "некорректныйЛогин";
        boolean result = UserValidator.getInstance().isLoginValid(login);
        assertFalse(result);
    }

    @Test(groups = "validator" , priority = 19)
    public void correctLoginValidatorTest() throws ValidationException{
        String login = "newuser999";
        boolean result = UserValidator.getInstance().isLoginValid(login);
        assertTrue(result);
    }

    @Test(groups = "validator" , priority = 20)
    public void passwordIsNullValidatorTest() throws ValidationException{
        boolean result = UserValidator.getInstance().isPasswordValid(null);
        assertFalse(result);
    }

    @Test(groups = "validator" , priority = 21)
    public void incorrectSurnameValidatorTest() throws ValidationException{
        String password = "incorrectPassword_";
        boolean result = UserValidator.getInstance().isPasswordValid(password);
        assertFalse(result);
    }

    @Test(groups = "validator" , priority = 22)
    public void correctPasswordValidatorTest() throws ValidationException{
        String password = "pass123";
        boolean result = UserValidator.getInstance().isPasswordValid(password);
        assertTrue(result);
    }

    @Test(groups = "validator" , priority = 23)
    public void phoneIsNullValidatorTest() throws ValidationException{
        boolean result = UserValidator.getInstance().isPhoneNumberValid(null);
        assertFalse(result);
    }

    @Test(groups = "validator" , priority = 24)
    public void incorrectPhoneValidatorTest() throws ValidationException{
        String phone = "phone1312321";
        boolean result = UserValidator.getInstance().isPhoneNumberValid(phone);
        assertFalse(result);
    }

    @Test(groups = "validator" , priority = 25)
    public void correctPhoneValidatorTest() throws ValidationException{
        String phone = "251234567";
        boolean result = UserValidator.getInstance().isPhoneNumberValid(phone);
        assertTrue(result);
    }

}


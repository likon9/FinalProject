package by.epam.task.model.validator;

import org.apache.commons.validator.routines.EmailValidator;

/**
 * The type User validator.
 */
public class UserValidator {


	private static final UserValidator instance = new UserValidator();

	private static final String LOGIN_REGEX = "[a-zA-Z0-9].{5,24}";

	private static final String PASSWORD_REGEX = ".{6,24}";

	private static final String NAME_REGEX = "[a-zA-Z]*|[ЁёА-я]*";

	private static final int MAX_LENGTH_NAME = 24;

	private static final int PHONE_LENGTH = 9;


	private UserValidator() { }

	/**
	 * Gets instance.
	 *
	 * @return the instance
	 */
	public static UserValidator getInstance() {
		return instance;
	}


	/**
	 * Is email valid boolean.
	 *
	 * @param email the email
	 * @return the boolean
	 */
	public boolean isEmailValid(String email) {
		EmailValidator validator = EmailValidator.getInstance();
		return  !(email == null || email.isBlank()) && validator.isValid(email);
	}

	/**
	 * Is login valid boolean.
	 *
	 * @param login the login
	 * @return the boolean
	 */
	public boolean isLoginValid(String login) {
		return !(login == null || login.isBlank()) && login.matches(LOGIN_REGEX);
	}

	/**
	 * Is password valid boolean.
	 *
	 * @param password the password
	 * @return the boolean
	 */
	public boolean isPasswordValid(String password) { return !(password == null || password.isBlank()) && password.matches(PASSWORD_REGEX); }

	/**
	 * Is name valid boolean.
	 *
	 * @param name the name
	 * @return the boolean
	 */
	public boolean isNameValid(String name) { return !(name == null || name.isBlank()) && name.length() <= MAX_LENGTH_NAME && name.matches(NAME_REGEX); }

	/**
	 * Is surname valid boolean.
	 *
	 * @param surname the surname
	 * @return the boolean
	 */
	public boolean isSurnameValid(String surname) { return !(surname == null || surname.isBlank()) && surname.length() <= MAX_LENGTH_NAME && surname.matches(NAME_REGEX); }

	/**
	 * Is phone number valid boolean.
	 *
	 * @param phone the phone
	 * @return the boolean
	 */
	public boolean isPhoneNumberValid(String phone) { return !(phone == null || phone.isBlank()) && phone.length() == PHONE_LENGTH; }
}

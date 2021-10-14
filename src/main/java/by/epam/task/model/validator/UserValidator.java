package by.epam.task.model.validator;

import org.apache.commons.validator.routines.EmailValidator;

public class UserValidator {


	private static final UserValidator instance = new UserValidator();

	private static final String LOGIN_REGEX = "[a-zA-Z1-9].{6,64}";

	private static final String PASSWORD_REGEX = ".{6,64}";

	private static final String NAME_REGEX = "[a-zA-Z]*|[ЁёА-я]*";

	private static final int MAX_LENGTH_NAME = 24;

	private static final int PHONE_LENGTH = 9;


	private UserValidator() {
	}

	public static UserValidator getInstance() {
		return instance;
	}


	public boolean isEmailValid(String email) {
		if (email == null || email.isBlank()) {
			return false;
		}
		EmailValidator validator = EmailValidator.getInstance();
		return validator.isValid(email);
	}

	public boolean isLoginValid(String login) {
		if (login == null || login.isBlank()) {
			return false;
		}
		return login.matches(LOGIN_REGEX);
	}

	public boolean isPasswordValid(String password) {
		if (password == null || password.isBlank()) {
			return false;
		}
		return password.matches(PASSWORD_REGEX);
	}

	public boolean isNameValid(String name) {
		if (name == null || name.isBlank()) {
			return false;
		}
		return name.length() <= MAX_LENGTH_NAME && name.matches(NAME_REGEX);
	}

	public boolean isSurnameValid(String surname) {
		if (surname == null || surname.isBlank()) {
			return false;
		}
		return surname.length() <= MAX_LENGTH_NAME && surname.matches(NAME_REGEX);
	}

	public boolean isPhoneNumberValid(String phone) {
		if (phone == null || phone.isBlank()) {
			return false;
		}
		System.out.println(phone.length());
		return phone.length() == PHONE_LENGTH;
	}
}

package by.epam.task.model.validator;

import org.apache.commons.validator.routines.EmailValidator;

public class TariffPlanValidator {

    private static final TariffPlanValidator instance = new TariffPlanValidator();

    private static final String NAME_REGEX = "[a-zA-Z1-9А-Яа-я].{3,24}";

    private TariffPlanValidator() {
    }

    public static TariffPlanValidator getInstance() {
        return instance;
    }

    public boolean isNameValid(String name) {
        return !(name == null || name.isBlank()) && name.matches(NAME_REGEX);
    }

}

package by.epam.task.model.validator;

/**
 * The type Tariff plan validator.
 */
public class TariffPlanValidator {

    private static final TariffPlanValidator instance = new TariffPlanValidator();

    private static final String NAME_REGEX = "[a-zA-ZА-Яа-я].{3,24}";

    private TariffPlanValidator() { }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static TariffPlanValidator getInstance() {
        return instance;
    }

    /**
     * Is name valid boolean.
     *
     * @param name the name
     * @return the boolean
     */
    public boolean isNameValid(String name) {
        return !(name == null || name.isBlank()) && name.matches(NAME_REGEX);
    }

}

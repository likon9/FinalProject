package by.epam.task.model.dao;

/**
 * The class provides string constants that represent database column names
 */
public final class ColumnName {
    /**
     * Tables users
     */
    public static final String USER_ID = "user_id";
    public static final String EMAIL = "email";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String NAME = "name";
    public static final String SURNAME = "surname";
    public static final String PHONE = "phone";
    public static final String BALANCE = "balance";
    public static final String REGISTRATION_DATE = "registration_date";
    public static final String USER_STATUS = "status";
    public static final String USER_ROLE = "role";
    public static final String DISCOUNT = "discount";
    /**
     * Tables users_roles
     */
    public static final String USER_ROLE_ID = "user_role_id";
    public static final String ROLE = "role";
    /**
     * Tables user_statuses
     */
    public static final String USER_STATUS_ID = "user_id_status";
    public static final String STATUS = "status";
    /**
     * Tables tariff_plans
     */
    public static final String TARIFF_PLAN_ID = "tariff_plan_id";
    public static final String NAME_TARIFF_PLAN = "name_tariff_plan";
    public static final String PRICE = "price";
    public static final String INTERNET_CONNECTION_SPEED = "internet_connection_speed";
    /**
     * Tables tariff_plans
     */
    public static final String CONTRACT_ID = "contract_id";
    public static final String CONNECTION_DATE = "connection_date";
    public static final String CONTRACT_USER_ID = "users_user_id";
    public static final String CONTRACT_TARIFF_PLAN_ID = "tariff_plans_tariff_plan_id";
    public static final String CONTRACT_STATUS = "contract_status";

    private ColumnName() {
    }
}

package by.epam.task.controller.command;

public enum CommandType {

    LOGIN,
    GO_TO_LOGIN,
    REGISTRATION,
    GO_TO_REGISTRATION,
    CODE,
    HOME,
    TARIFF,
    SETTING_USER,
    USER_CONTRACT,
    USER_MANAGEMENT,
    USER_SELECT,
    BLOCK_USER,
    SELECT_BY_ID,
    SELECT_BY_LOGIN,
    SELECT_BY_EMAIL,
    SELECT_BY_NAME,
    SELECT_BY_SURNAME,
    SELECT_BY_PHONE,
    GO_TO_ADD_TARIFF_PLAN,
    TARIFF_PLAN_MANAGEMENT,
    UPDATE_TARIFF_PLAN,
    SELECT_BY_NAME_TARIFF_PLAN,
    SELECT_BY_PRICE,
    SELECT_BY_INTERNET_CONNECTION_SPEED,
    CHANGE_LANGUAGE_COMMAND,
    NEW_CONTRACT,
    CONNECT_TARIFF,
    DISCONNECT_TARIFF,
    NULLIFICATION_CONTRACT,
    FIRST_PAGE,
    EXIT_USER,
    UPDATE_USER,
    GO_TO_DELETE_USER,
    DELETE_USER,
    GO_TO_CONTRACT_MANAGEMENT,
    CONTRACT_SELECT,
    FIND_CONTRACTS_FROM_PARAMETER,
    TOP_UP_BALANCE,
    GO_TO_TOP_UP_BALANCE,
    USER_RECOVERY,
    TO_ERROR_PAGE,
    NEW_USER_DISCOUNT,
    WRITE_OF_ACCOUNT,
    ADD_TARIFF_PLAN;
}
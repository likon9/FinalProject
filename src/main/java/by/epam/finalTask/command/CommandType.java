package by.epam.finalTask.command;

import by.epam.finalTask.command.impl.ChangeLanguageCommand;
import by.epam.finalTask.command.impl.LoginCommand;
import by.epam.finalTask.command.impl.RegistrationCommand;
import by.epam.finalTask.command.impl.admin.*;
import by.epam.finalTask.command.impl.admin.userManagement.*;
import by.epam.finalTask.command.impl.page.GoToAddTariffPlanCommand;
import by.epam.finalTask.command.impl.page.GoToFirstPage;
import by.epam.finalTask.command.impl.page.GoToLoginCommand;
import by.epam.finalTask.command.impl.page.GoToRegistrationCommand;
import by.epam.finalTask.command.impl.user.*;

public enum CommandType {

    LOGIN(new LoginCommand()),
    GO_TO_LOGIN(new GoToLoginCommand()),
    REGISTRATION(new RegistrationCommand()),
    GO_TO_REGISTRATION(new GoToRegistrationCommand()),
    CODE(new CodeCommand()),
    HOME(new HomeCommand()),
    TARIFF(new TariffCommand()),
    SETTING_USER(new SettingUserCommand()),
    UPDATE_EMAIL(new UpdateEmailCommand()),
    UPDATE_NAME(new UpdateNameCommand()),
    UPDATE_SURNAME(new UpdateSurnameCommand()),
    UPDATE_PHONE(new UpdatePhoneCommand()),
    USER_CONTRACT(new UserContractCommand()),
    USER_MANAGEMENT(new UserManagementCommand()),
    USER_SELECT(new UserSelectCommand()),
    BLOCK_USER(new BlockUserCommand()),
    SELECT_BY_ID(new SelectByUserIdCommand()),
    SELECT_BY_LOGIN(new SelectByUserLoginCommand()),
    SELECT_BY_NAME(new SelectByUserNameCommand()),
    SELECT_BY_SURNAME(new SelectByUserSurnameCommand()),
    SELECT_BY_PHONE(new SelectByUserPhoneCommand()),
    GO_TO_ADD_TARIFF_PLAN(new GoToAddTariffPlanCommand()),
    TARIFF_PLAN_MANAGEMENT(new TariffPlanManagementCommand()),
    UPDATE_TARIFF_PLAN(new UpdateTariffPlanCommand()),
    SELECT_BY_PRICE(new SelectByPriceCommand()),
    SELECT_BY_INTERNET_CONNECTION_SPEED(new SelectByInternetConnectionSpeedCommand()),
    CHANGE_LANGUAGE_COMMAND(new ChangeLanguageCommand()),
    NEW_CONTRACT(new NewContractCommand()),
    CONNECT_TARIFF(new ConnectTariffCommand()),
    DISCONNECT_TARIFF(new DisconnectTariffCommand()),
    FIRST_PAGE(new GoToFirstPage()),
    ADD_TARIFF_PLAN(new AddTariffPlanCommand());


    Command command;

    CommandType(Command command) {

        System.out.println(command);
        this.command = command;
    }

    public static Command takeCommand(String commandName){
        //check
        CommandType type = null;
        try {
            type = CommandType.valueOf(commandName.toUpperCase()); }
        catch (IllegalArgumentException e) {
          //error command
        }
     return type.command;
    }
}

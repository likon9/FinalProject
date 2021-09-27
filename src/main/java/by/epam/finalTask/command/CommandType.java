package by.epam.finalTask.command;

import by.epam.finalTask.command.impl.LoginCommand;
import by.epam.finalTask.command.impl.RegistrationCommand;
import by.epam.finalTask.command.impl.Test1Page;
import by.epam.finalTask.command.impl.TestPage;
import by.epam.finalTask.command.impl.admin.*;
import by.epam.finalTask.command.impl.page.GoToLoginCommand;
import by.epam.finalTask.command.impl.page.GoToRegistrationCommand;
import by.epam.finalTask.command.impl.user.*;

public enum CommandType {

    LOGIN(new LoginCommand()),
    GO_TO_LOGIN(new GoToLoginCommand()),
    REGISTRATION(new RegistrationCommand()),
    TEST(new TestPage()),
    TEST1(new Test1Page()),
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
    GO_TO_REGISTRATION(new GoToRegistrationCommand());

    Command command;

    CommandType(Command command) {
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

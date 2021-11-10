package by.epam.task.controller.command;

import by.epam.task.controller.command.impl.ChangeLanguageCommand;
import by.epam.task.controller.command.impl.LoginCommand;
import by.epam.task.controller.command.impl.RegistrationCommand;
import by.epam.task.controller.command.impl.UserRecoveryCommand;
import by.epam.task.controller.command.impl.admin.*;
import by.epam.task.controller.command.impl.admin.userManagement.*;
import by.epam.task.controller.command.impl.page.*;
import by.epam.task.controller.command.impl.user.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.EnumMap;

import static by.epam.task.controller.command.CommandType.*;

/**
 * The type Command provider.
 */
public class CommandProvider {

    private static final Logger logger = LogManager.getLogger();
    private static final CommandProvider INSTANCE = new CommandProvider();
    private final EnumMap<CommandType, Command> commands = new EnumMap(CommandType.class);

    private CommandProvider() {

        commands.put(LOGIN, new LoginCommand());
        commands.put(GO_TO_LOGIN, new GoToLoginCommand());
        commands.put(GO_TO_REGISTRATION, new GoToRegistrationCommand());
        commands.put(REGISTRATION, new RegistrationCommand());
        commands.put(CODE, new CodeCommand());
        commands.put(HOME, new HomeCommand());
        commands.put(SETTING_USER, new SettingUserCommand());
        commands.put(TARIFF, new TariffCommand());
        commands.put(USER_CONTRACT, new UserContractCommand());
        commands.put(USER_MANAGEMENT, new UserManagementCommand());
        commands.put(USER_SELECT, new UserSelectCommand());
        commands.put(BLOCK_USER, new BlockUserCommand());
        commands.put(SELECT_BY_ID, new SelectByUserIdCommand());
        commands.put(SELECT_BY_LOGIN, new SelectByUserLoginCommand());
        commands.put(SELECT_BY_EMAIL, new SelectByUserEmailCommand());
        commands.put(SELECT_BY_NAME, new SelectByUserNameCommand());
        commands.put(SELECT_BY_SURNAME, new SelectByUserSurnameCommand());
        commands.put(SELECT_BY_PHONE, new SelectByUserPhoneCommand());
        commands.put(GO_TO_ADD_TARIFF_PLAN, new GoToAddTariffPlanCommand());
        commands.put(TARIFF_PLAN_MANAGEMENT, new TariffPlanManagementCommand());
        commands.put(UPDATE_TARIFF_PLAN, new UpdateTariffPlanCommand());
        commands.put(SELECT_BY_NAME_TARIFF_PLAN, new SelectByNameTariffPlanCommand());
        commands.put(SELECT_BY_PRICE, new SelectByPriceCommand());
        commands.put(SELECT_BY_INTERNET_CONNECTION_SPEED, new SelectByInternetConnectionSpeedCommand());
        commands.put(CHANGE_LANGUAGE_COMMAND, new ChangeLanguageCommand());
        commands.put(NEW_CONTRACT, new NewContractCommand());
        commands.put(CONNECT_TARIFF, new ConnectTariffCommand());
        commands.put(DISCONNECT_TARIFF, new DisconnectTariffCommand());
        commands.put(NULLIFICATION_CONTRACT, new NullificationContractCommand());
        commands.put(FIRST_PAGE, new GoToFirstPage());
        commands.put(EXIT_USER, new ExitUserCommand());
        commands.put(UPDATE_USER, new UpdateUserCommand());
        commands.put(GO_TO_DELETE_USER, new GoToDeleteUserCommand());
        commands.put(DELETE_USER, new DeleteUserCommand());
        commands.put(GO_TO_CONTRACT_MANAGEMENT, new GoToContractManagementCommand());
        commands.put(CONTRACT_SELECT, new SelectByStatusContractCommand());
        commands.put(FIND_CONTRACTS_FROM_PARAMETER, new FindContractsFromParameterCommand());
        commands.put(ADD_TARIFF_PLAN, new AddTariffPlanCommand());
        commands.put(TOP_UP_BALANCE, new TopUpBalanceCommand());
        commands.put(GO_TO_TOP_UP_BALANCE, new GoToTopUpBalanceCommand());
        commands.put(USER_RECOVERY, new UserRecoveryCommand());
        commands.put(NEW_USER_DISCOUNT, new NewUserDiscountCommand());
        commands.put(WRITE_OF_ACCOUNT, new WriteOfAccountCommand());
        commands.put(TO_ERROR_PAGE, new GoToErrorPageCommand());
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static CommandProvider getInstance() {
        return INSTANCE;
    }

    /**
     * Gets command.
     *
     * @param commandName the command name
     * @return the command
     */
    public Command getCommand(String commandName) {
        if (commandName == null) {
            logger.warn("command name is null. The command was assigned the default value");
            return commands.get(TO_ERROR_PAGE);
        }
        CommandType commandType;
        try {
            commandType = CommandType.valueOf(commandName.toUpperCase());
            logger.info("command type - {}", commandType);
        } catch (IllegalArgumentException e) {
            commandType = TO_ERROR_PAGE;
            logger.error( "error! The command was assigned the default value. ", e);
        }
        return commands.get(commandType);

    }
}

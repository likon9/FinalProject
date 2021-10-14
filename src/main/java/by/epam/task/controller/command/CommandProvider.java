package by.epam.task.controller.command;

import by.epam.task.controller.command.impl.ChangeLanguageCommand;
import by.epam.task.controller.command.impl.LoginCommand;
import by.epam.task.controller.command.impl.RegistrationCommand;
import by.epam.task.controller.command.impl.UserRecoveryCommand;
import by.epam.task.controller.command.impl.admin.*;
import by.epam.task.controller.command.impl.admin.userManagement.*;
import by.epam.task.controller.command.impl.page.*;
import by.epam.task.controller.command.impl.user.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.EnumMap;

import static by.epam.task.controller.command.CommandType.TO_ERROR_PAGE;

public class CommandProvider {

    private static final Logger logger = LogManager.getLogger();
    private static final CommandProvider INSTANCE = new CommandProvider();
    private final EnumMap<CommandType, Command> commands = new EnumMap(CommandType.class);

    private CommandProvider() {

        commands.put(CommandType.LOGIN, new LoginCommand());
        commands.put(CommandType.GO_TO_LOGIN, new GoToLoginCommand());
        commands.put(CommandType.GO_TO_REGISTRATION, new GoToRegistrationCommand());
        commands.put(CommandType.REGISTRATION, new RegistrationCommand());
        commands.put(CommandType.CODE, new CodeCommand());
        commands.put(CommandType.HOME, new HomeCommand());
        commands.put(CommandType.SETTING_USER, new SettingUserCommand());
        commands.put(CommandType.TARIFF, new TariffCommand());
        commands.put(CommandType.USER_CONTRACT, new UserContractCommand());
        commands.put(CommandType.USER_MANAGEMENT, new UserManagementCommand());
        commands.put(CommandType.USER_SELECT, new UserSelectCommand());
        commands.put(CommandType.BLOCK_USER, new BlockUserCommand());
        commands.put(CommandType.SELECT_BY_ID, new SelectByUserIdCommand());
        commands.put(CommandType.SELECT_BY_LOGIN, new SelectByUserLoginCommand());
        commands.put(CommandType.SELECT_BY_EMAIL, new SelectByUserEmailCommand());
        commands.put(CommandType.SELECT_BY_NAME, new SelectByUserNameCommand());
        commands.put(CommandType.SELECT_BY_SURNAME, new SelectByUserSurnameCommand());
        commands.put(CommandType.SELECT_BY_PHONE, new SelectByUserPhoneCommand());
        commands.put(CommandType.GO_TO_ADD_TARIFF_PLAN, new GoToAddTariffPlanCommand());
        commands.put(CommandType.TARIFF_PLAN_MANAGEMENT, new TariffPlanManagementCommand());
        commands.put(CommandType.UPDATE_TARIFF_PLAN, new UpdateTariffPlanCommand());
        commands.put(CommandType.SELECT_BY_NAME_TARIFF_PLAN, new SelectByNameTariffPlanCommand());
        commands.put(CommandType.SELECT_BY_PRICE, new SelectByPriceCommand());
        commands.put(CommandType.SELECT_BY_INTERNET_CONNECTION_SPEED, new SelectByInternetConnectionSpeedCommand());
        commands.put(CommandType.CHANGE_LANGUAGE_COMMAND, new ChangeLanguageCommand());
        commands.put(CommandType.NEW_CONTRACT, new NewContractCommand());
        commands.put(CommandType.CONNECT_TARIFF, new ConnectTariffCommand());
        commands.put(CommandType.DISCONNECT_TARIFF, new DisconnectTariffCommand());
        commands.put(CommandType.NULLIFICATION_CONTRACT, new NullificationContractCommand());
        commands.put(CommandType.FIRST_PAGE, new GoToFirstPage());
        commands.put(CommandType.EXIT_USER, new ExitUserCommand());
        commands.put(CommandType.UPDATE_USER, new UpdateUserCommand());
        commands.put(CommandType.GO_TO_DELETE_USER, new GoToDeleteUserCommand());
        commands.put(CommandType.DELETE_USER, new DeleteUserCommand());
        commands.put(CommandType.GO_TO_CONTRACT_MANAGEMENT, new GoToContractManagementCommand());
        commands.put(CommandType.CONTRACT_SELECT, new SelectByStatusContractCommand());
        commands.put(CommandType.FIND_CONTRACTS_FROM_PARAMETER, new FindContractsFromParameterCommand());
        commands.put(CommandType.ADD_TARIFF_PLAN, new AddTariffPlanCommand());
        commands.put(CommandType.TOP_UP_BALANCE, new TopUpBalanceCommand());
        commands.put(CommandType.GO_TO_TOP_UP_BALANCE, new GoToTopUpBalanceCommand());
        commands.put(CommandType.USER_RECOVERY, new UserRecoveryCommand());
        commands.put(TO_ERROR_PAGE, new GoToErrorPageCommand());


    }

    public static CommandProvider getInstance() {
        return INSTANCE;
    }

    public Command getCommand(String commandName) {
        if (commandName == null) {
            logger.log(Level.WARN, "command name is null. The command was assigned the default value");
            return commands.get(TO_ERROR_PAGE);
        }
        CommandType commandType;
        try {
            commandType = CommandType.valueOf(commandName.toUpperCase());
            logger.log(Level.INFO, "command type - {}", commandType);
        } catch (IllegalArgumentException e) {
            commandType = TO_ERROR_PAGE;
            logger.log(Level.ERROR, "error! The command was assigned the default value. ", e);
        }
        return commands.get(commandType);

    }
}

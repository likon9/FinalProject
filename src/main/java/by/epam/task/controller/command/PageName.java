package by.epam.task.controller.command;

/**
 * The type Page name.
 */
public final class PageName {

    /**
     * Commons page paths
     */
    public static final String INDEX = ("pages/index.jsp");
    public static final String LOGIN = ("pages/login.jsp");
    public static final String REGISTRATION = ("pages/registration.jsp");
    public static final String USER_RECOVERY = ("pages/user_recovery.jsp");
    /**
     * User page paths
     */
    public static final String CODE = ("pages/user/code.jsp");
    public static final String HOME = ("pages/user/home.jsp");
    public static final String TARIFF =  ("pages/user/list_tariff_plan.jsp");
    public static final String SETTING_USER = ("pages/user/setting_user.jsp");
    public static final String USER_CONTRACT= ("pages/user/user_contract.jsp");
    public static final String CONNECT_TARIFF =  ("pages/user/connect_tariff.jsp");
    public static final String DISCONNECT_TARIFF = ("pages/user/disconnect_tariff.jsp");
    public static final String TOP_UP_BALANCE = ("pages/user/top_up_balance.jsp");
    public static final String DELETE_USER = ("pages/user/delete_user.jsp");
    /**
     * Administrator page paths
     */
    public static final String HOME_ADMIN = ("pages/admin/home_admin.jsp");
    public static final String USER_LIST = ("pages/admin/user_list.jsp");
    public static final String ADD_TARIFF_PLAN = ("pages/admin/add_tariff_plan.jsp");
    public static final String CONTRACT_MANAGEMENT = ("pages/admin/contract_management.jsp");
    public static final String TARIFF_PLAN_MANAGEMENT= ("pages/admin/tariff_plan_management.jsp");
    /**
     * Error page paths
     */
    public static final String ERROR_404 = ("pages/error/error404.jsp");
    public static final String ERROR_500 = ("pages/error/error500.jsp");

    private String path;

    private PageName() { }

    PageName(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}

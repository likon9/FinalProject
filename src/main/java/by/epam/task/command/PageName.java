package by.epam.task.command;

public class PageName {

    public static final String INDEX = ("pages/index.jsp");
    public static final String LOGIN = ("pages/login.jsp");
    public static final String REGISTRATION = ("pages/registration.jsp");
    public static final String CODE = ("pages/user/code.jsp");
    public static final String HOME = ("pages/user/home.jsp");
    public static final String TARIFF =  ("pages/user/list_tariff_plan.jsp");
    public static final String SETTING_USER = ("pages/user/setting_user.jsp");
    public static final String USER_CONTRACT= ("pages/user/user_contract.jsp");
    public static final String CONNECT_TARIFF =  ("pages/user/connect_tariff.jsp");
    public static final String DISCONNECT_TARIFF = ("pages/user/disconnect_tariff.jsp");

    public static final String DELETE_USER = ("pages/user/delete_user.jsp");
    public static final String HOME_ADMIN = ("pages/admin/home_admin.jsp");
    public static final String USER_LIST = ("pages/admin/user_list.jsp");
    public static final String BLOCK_USER = ("pages/admin/block_user.jsp");
    public static final String SELECT_BY_PARAMETER = ("pages/admin/select_by_parameter.jsp");
    public static final String ADD_TARIFF_PLAN = ("pages/admin/add_tariff_plan.jsp");
    public static final String CONTRACT_MANAGEMENT = ("pages/admin/contract_management.jsp");
    public static final String TARIFF_PLAN_MANAGEMENT= ("pages/admin/tariff_plan_management.jsp");
    public static final String UPDATE_SELECT_TARIFF_PLAN = ("pages/admin/update_select_tariff_plan.jsp");
    public static final String ERROR = ("pages/error.jsp");

    private String path;

    PageName(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}

package by.epam.finalTask.command;

public enum PageName {

    INDEX("pages/index.jsp"),
    LOGIN("pages/login.jsp"),
    REGISTRATION("pages/registration.jsp"),
    TEST("pages/test.jsp"),
    TEST1("pages/test1.jsp"),
    CODE("pages/user/code.jsp"),
    HOME("pages/user/home.jsp"),
    TARIFF("pages/user/list_tariff_plan.jsp"),
    SETTING_USER("pages/user/setting_user.jsp"),
    USER_CONTRACT("pages/user/user_contract.jsp"),
    HOME_ADMIN("pages/admin/home_admin.jsp"),
    USER_LIST("pages/admin/user_list.jsp"),
    BLOCK_USER("pages/admin/block_user.jsp"),
    SELECT_BY_PARAMETER("pages/admin/select_by_parameter.jsp"),
    ERROR("pages/error.jsp");

    private String path;

    PageName(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}

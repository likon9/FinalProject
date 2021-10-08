package by.epam.task.model.builder;

import by.epam.task.model.entity.User;
import by.epam.task.model.entity.UserRole;
import by.epam.task.model.entity.UserStatus;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class UserBuilder {


    private Long userId;
    private String email;
    private String login;
    private String password;
    private String name;
    private String surname;
    private int phone;
    private BigDecimal balance;
    private Timestamp registrationDate;
    private UserStatus userStatus;
    private UserRole userRole;

   public static UserBuilder builder(){return new UserBuilder();}

    public User build() {
        User user = new User(userId,
                email,
                login,
                password,
                name,
                surname,
                phone,
                balance,
                registrationDate,
                userStatus,
                userRole);

        this.userId = null;
        this.email = null;
        this.login = null;
        this.password = null;
        this.name = null;
        this.surname = null;
        this.phone = 0;
        this.balance = null;
        this.registrationDate = null;
        this.userStatus = null;
        this.userRole = null;
        return user;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Timestamp getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Timestamp registrationDate) {
        this.registrationDate = registrationDate;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}

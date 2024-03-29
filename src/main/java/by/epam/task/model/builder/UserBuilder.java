package by.epam.task.model.builder;

import by.epam.task.model.entity.User;
import by.epam.task.model.entity.UserRole;
import by.epam.task.model.entity.UserStatus;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserBuilder {


    private Long userId;
    private String email;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String phone;
    private BigDecimal balance;
    private LocalDate registrationDate;
    private BigDecimal discount;
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
                discount,
                userStatus,
                userRole);

        this.userId = null;
        this.email = null;
        this.login = null;
        this.password = null;
        this.name = null;
        this.surname = null;
        this.phone = null;
        this.balance = null;
        this.registrationDate = null;
        this.discount = null;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public BigDecimal getDiscount() { return discount; }

    public void setDiscount(BigDecimal discount) { this.discount = discount; }

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

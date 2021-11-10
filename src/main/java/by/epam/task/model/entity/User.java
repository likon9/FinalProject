package by.epam.task.model.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class User {

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

    public User(){ }

    public User(Long userId,
                String email,
                String login,
                String password,
                String name,
                String surname,
                String phone,
                BigDecimal balance,
                LocalDate registrationDate,
                BigDecimal discount,
                UserStatus userStatus,
                UserRole userRole
               )
                {
        this.userId = userId;
        this.email = email;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.balance = balance;
        this.registrationDate = registrationDate;
        this.discount = discount;
        this.userStatus = userStatus;
        this.userRole = userRole;
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

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append(userId);
        builder.append(" ");
        builder.append(email);
        builder.append(" ");
        builder.append(login);
        builder.append(" ");
        builder.append(password);
        builder.append(" ");
        builder.append(name);
        builder.append(" ");
        builder.append(surname);
        builder.append(" ");
        builder.append(phone);
        builder.append(" ");
        builder.append(balance);
        builder.append(" ");
        builder.append(registrationDate);
        builder.append(" ");
        builder.append(discount);
        builder.append(" ");
        builder.append(userStatus);
        builder.append(" ");
        builder.append(userRole);

        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getUserId() != null ? !getUserId().equals(user.getUserId()) : user.getUserId() != null) return false;
        if (getEmail() != null ? !getEmail().equals(user.getEmail()) : user.getEmail() != null) return false;
        if (getLogin() != null ? !getLogin().equals(user.getLogin()) : user.getLogin() != null) return false;
        if (getPassword() != null ? !getPassword().equals(user.getPassword()) : user.getPassword() != null)
            return false;
        if (getName() != null ? !getName().equals(user.getName()) : user.getName() != null) return false;
        if (getSurname() != null ? !getSurname().equals(user.getSurname()) : user.getSurname() != null) return false;
        if (getPhone() != null ? !getPhone().equals(user.getPhone()) : user.getPhone() != null) return false;
        if (getBalance() != null ? !getBalance().equals(user.getBalance()) : user.getBalance() != null) return false;
        if (getRegistrationDate() != null ? !getRegistrationDate().equals(user.getRegistrationDate()) : user.getRegistrationDate() != null)
            return false;
        if (getDiscount() != null ? !getDiscount().equals(user.getDiscount()) : user.getDiscount() != null)
            return false;
        if (getUserStatus() != user.getUserStatus()) return false;
        return getUserRole() == user.getUserRole();
    }

    @Override
    public int hashCode() {
        int result = getUserId() != null ? getUserId().hashCode() : 0;
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getLogin() != null ? getLogin().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getSurname() != null ? getSurname().hashCode() : 0);
        result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
        result = 31 * result + (getBalance() != null ? getBalance().hashCode() : 0);
        result = 31 * result + (getRegistrationDate() != null ? getRegistrationDate().hashCode() : 0);
        result = 31 * result + (getDiscount() != null ? getDiscount().hashCode() : 0);
        result = 31 * result + (getUserStatus() != null ? getUserStatus().hashCode() : 0);
        result = 31 * result + (getUserRole() != null ? getUserRole().hashCode() : 0);
        return result;
    }
}

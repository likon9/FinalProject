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
        return "User{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone=" + phone +
                ", balance=" + balance +
                ", registrationDate=" + registrationDate +
                ", discount=" + discount +
                ", userStatus=" + userStatus +
                ", userRole=" + userRole +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getUserId(), user.getUserId())
                && Objects.equals(getEmail(), user.getEmail())
                && Objects.equals(getLogin(), user.getLogin())
                && Objects.equals(getPassword(), user.getPassword())
                && Objects.equals(getName(), user.getName())
                && Objects.equals(getSurname(), user.getSurname())
                && Objects.equals(getPhone(), user.getPhone())
                && Objects.equals(getBalance(), user.getBalance())
                && Objects.equals(getRegistrationDate(), user.getRegistrationDate())
                && Objects.equals(getDiscount(), user.getDiscount())
                && getUserStatus() == user.getUserStatus()
                && getUserRole() == user.getUserRole();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result += 37 * result + Long.hashCode(getUserId());
        result += 37 * result + (getEmail().hashCode());
        result += 37 * result + (getLogin().hashCode());
        result += 37 * result + (getPassword().hashCode());
        result += 37 * result + (getName().hashCode());
        result += 37 * result + (getSurname().hashCode());
        result += 37 * result + (getPhone().hashCode());
        result += 37 * result + (getBalance().hashCode());
        result += 37 * result + (getDiscount().hashCode());
        result += 37 * result + (getUserStatus().hashCode());
        result += 37 * result + (getUserRole().hashCode());

        return result;
    }
}

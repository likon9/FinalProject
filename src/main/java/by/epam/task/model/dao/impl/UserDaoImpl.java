package by.epam.task.model.dao.impl;

import by.epam.task.exception.DaoException;
import by.epam.task.model.builder.UserBuilder;
import by.epam.task.model.dao.UserDao;
import by.epam.task.model.entity.User;
import by.epam.task.model.entity.UserRole;
import by.epam.task.model.entity.UserStatus;
import by.epam.task.model.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static by.epam.task.model.dao.ColumnName.*;

public class UserDaoImpl implements UserDao{


    private static final Logger logger = LogManager.getLogger();

    private static UserDaoImpl instance;

    public UserDaoImpl(){}

    public static UserDaoImpl getInstance(){
        if (instance == null) {
            instance = new UserDaoImpl();
        }
        return instance;
    }
    //CREATE REGEX
    private static final String CREATE_USER = """
            INSERT INTO users (email, login, password, name, surname,
            phone, balance, registration_date, discount, status_id, role_id)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)""";
    //FIND REGEX
    private static final String FIND_USER = """
            SELECT user_id, email, login, password, name, surname, 
            phone, balance, registration_date, discount, user_statuses.status, user_roles.role
            FROM users
            JOIN user_statuses ON users.status_id   = user_statuses.user_status_id
            JOIN user_roles ON users.role_id = user_roles.user_role_id
            WHERE login=? and password=?""";
    private static final String FIND_BY_ID = """
            SELECT user_id, email, login, password, name, surname, 
            phone, balance, registration_date, discount, user_statuses.status, user_roles.role
            FROM users
            JOIN user_statuses ON users.status_id   = user_statuses.user_status_id
            JOIN user_roles ON users.role_id = user_roles.user_role_id
            WHERE user_id=?""";
    private static final String FIND_BY_EMAIL = """
            SELECT user_id, email, login, password, name, surname, 
            phone, balance, registration_date, discount, user_statuses.status, user_roles.role
            FROM users
            JOIN user_statuses ON users.status_id   = user_statuses.user_status_id
            JOIN user_roles ON users.role_id = user_roles.user_role_id
            WHERE email=?""";
    private static final String FIND_BY_LOGIN = """
            SELECT user_id, email, login, password, name, surname, 
            phone, balance, registration_date, discount, user_statuses.status, user_roles.role
            FROM users
            JOIN user_statuses ON users.status_id   = user_statuses.user_status_id
            JOIN user_roles ON users.role_id = user_roles.user_role_id
            WHERE login=?""";
    private static final String FIND_BY_NAME = """
            SELECT user_id, email, login, password, name, surname, 
            phone, balance, registration_date, discount, user_statuses.status, user_roles.role
            FROM users
            JOIN user_statuses ON users.status_id   = user_statuses.user_status_id
            JOIN user_roles ON users.role_id = user_roles.user_role_id
            WHERE name=?""";
    private static final String FIND_BY_SURNAME = """
            SELECT user_id, email, login, password, name, surname, 
            phone, balance, registration_date, discount, user_statuses.status, user_roles.role
            FROM users
            JOIN user_statuses ON users.status_id   = user_statuses.user_status_id
            JOIN user_roles ON users.role_id = user_roles.user_role_id
            WHERE surname=?""";
    private static final String FIND_BY_PHONE= """
            SELECT user_id, email, login, password, name, surname, 
            phone, balance, registration_date, discount, user_statuses.status, user_roles.role
            FROM users
            JOIN user_statuses ON users.status_id   = user_statuses.user_status_id
            JOIN user_roles ON users.role_id = user_roles.user_role_id
            WHERE phone=?""";
    private static final String FIND_BY_STATUS= """
            SELECT user_id, email, login, password, name, surname, 
            phone, balance, registration_date, discount, user_statuses.status, user_roles.role
            FROM users
            JOIN user_statuses ON users.status_id   = user_statuses.user_status_id
            JOIN user_roles ON users.role_id = user_roles.user_role_id
            WHERE user_statuses.status=? AND user_roles.role=? """;
    private static final String FIND_ALL_USERS = """
            SELECT user_id, email, login, password, name, surname, 
            phone, balance, registration_date, discount, user_statuses.status, user_roles.role
            FROM users
            JOIN user_statuses ON users.status_id   = user_statuses.user_status_id
            JOIN user_roles ON users.role_id = user_roles.user_role_id
            WHERE user_roles.role=?""";

    //UPDATE REGEX
    private static final String UPDATE_EMAIL = "UPDATE users SET email=? WHERE user_id=?";
    private static final String UPDATE_NAME = "UPDATE users SET name=? WHERE user_id=?";
    private static final String UPDATE_SURNAME = "UPDATE users SET surname=? WHERE user_id=?";
    private static final String UPDATE_PHONE = "UPDATE users SET phone=? WHERE user_id=?";
    private static final String UPDATE_BALANCE = "UPDATE users SET balance=? WHERE user_id=?";
    private static final String UPDATE_DISCOUNT = "UPDATE users SET discount=? WHERE user_id=?";
    private static final String UPDATE_STATUS = "UPDATE users SET status_id=? WHERE user_id=?";

    public boolean addUser(Map<String, String> parameters) throws DaoException {
        boolean result = false;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_USER)) {
            statement.setString(1, parameters.get(EMAIL));
            statement.setString(2, parameters.get(LOGIN));
            statement.setString(3, parameters.get(PASSWORD));
            statement.setString(4, parameters.get(NAME));
            statement.setString(5, parameters.get(SURNAME));
            statement.setString(6, (parameters.get(PHONE)));
            statement.setBigDecimal(7, BigDecimal.valueOf(0.0));
            statement.setTimestamp(8, Timestamp.valueOf(parameters.get(REGISTRATION_DATE)));
            statement.setDouble(9, 0);
            statement.setLong(10, 1);
            statement.setLong(11, 1);
            result = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error("Error during adding user.", e);
            throw new DaoException("Error during adding user.", e);
        }
        return result;
    }

    public boolean updateEmail(Map<String, String> parameters, Long userId) throws DaoException {
        boolean result = false;
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_EMAIL)){
            statement.setString(1, parameters.get(EMAIL));
            statement.setLong(2, userId);
            result = statement.executeUpdate()>0;
        } catch (SQLException e){
            logger.error("Error during updating email of user with id = " + userId, e);
            throw new DaoException("Error during updating email of user with id = " + userId, e);
        }
        return result;
    }

    public boolean updateName(Map<String, String> parameters, Long userId) throws DaoException {
        boolean result = false;
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_NAME)){
            statement.setString(1, parameters.get(NAME));
            statement.setLong(2, userId);
            result = statement.executeUpdate()>0;
        } catch (SQLException e){
            logger.error("Error during updating name of user with id = " + userId, e);
            throw new DaoException("Error during updating name of user with id = " + userId, e);
        }
        return result;
    }

    public boolean updateSurname(Map<String, String> parameters, Long userId) throws DaoException {
        boolean result = false;
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_SURNAME)){
            statement.setString(1, parameters.get(SURNAME));
            statement.setLong(2, userId);
            result = statement.executeUpdate()>0;
        } catch (SQLException e){
            logger.error("Error during updating surname of user with id = " + userId, e);
            throw new DaoException("Error during updating surname of user with id = " + userId, e);
        }
        return result;
    }

    public boolean updatePhone(Map<String, String> parameters, Long userId) throws DaoException {
        boolean result = false;
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_PHONE)){
            statement.setString(1, parameters.get(PHONE));
            statement.setLong(2, userId);
            result = statement.executeUpdate()>0;
        } catch (SQLException e){
            logger.error("Error during updating phone of user with id = " + userId, e);
            throw new DaoException("Error during updating phone of user with id = " + userId, e);
        }
        return result;
    }

    public boolean updateBalance(Map<String, String> parameters, Long userId) throws DaoException {
        boolean result = false;
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_BALANCE)){
            statement.setString(1, parameters.get(BALANCE));
            statement.setLong(2, userId);
            result = statement.executeUpdate()>0;
        } catch (SQLException e){
            logger.error("Error during updating balance of user with id = " + userId, e);
            throw new DaoException("Error during updating balance of user with id = " + userId, e);
        }
        return result;
    }

    @Override
    public boolean updateDiscount(Map<String, String> parameters, Long userId) throws DaoException {
        boolean result = false;
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_DISCOUNT)){
            statement.setDouble(1, Double.parseDouble(parameters.get(DISCOUNT)));
            statement.setLong(2, userId);
            result = statement.executeUpdate()>0;
        } catch (SQLException e){
            logger.error("Error during updating discount of user with id = " + userId, e);
            throw new DaoException("Error during updating discount of user with id = " + userId, e);
        }
        return result;
    }

    public boolean updateStatus(Map<String, String> parameters, Long userId) throws DaoException {
        boolean result = false;
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_STATUS)){
            statement.setLong(1, Long.parseLong(parameters.get(STATUS)));
            statement.setLong(2, userId);
            result = statement.executeUpdate()>0;
        } catch (SQLException e){
            logger.error("Error during updating status of user with id = " + userId, e);
            throw new DaoException("Error during updating status of user with id = " + userId, e);
        }
        return result;
    }

    public boolean findUser(String login, String password) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_USER)) {
            statement.setString(1, login);
            statement.setString(2, password);
            try (ResultSet resultSet = statement.executeQuery()){
                Optional<User> resultUser = Optional.empty();
                if (resultSet.next()) {
                    UserBuilder userBuilder = new UserBuilder();
                    userBuilder.setUserId(resultSet.getLong(USER_ID));
                    userBuilder.setEmail(resultSet.getString(EMAIL));
                    userBuilder.setLogin(resultSet.getString(LOGIN));
                    userBuilder.setPassword(resultSet.getString(PASSWORD));
                    userBuilder.setName(resultSet.getString(NAME));
                    userBuilder.setSurname(resultSet.getString(SURNAME));
                    userBuilder.setPhone(resultSet.getString(PHONE));
                    userBuilder.setBalance(resultSet.getBigDecimal(BALANCE));
                    userBuilder.setRegistrationDate(LocalDate.parse(resultSet.getString(REGISTRATION_DATE)));
                    userBuilder.setDiscount(resultSet.getBigDecimal(DISCOUNT));
                    userBuilder.setUserStatus(UserStatus.valueOf(resultSet.getString(USER_STATUS)));
                    userBuilder.setUserRole(UserRole.valueOf(resultSet.getString(USER_ROLE)));
                    resultUser = Optional.of(userBuilder.build());
                    return true;
                }
                else return false;
            }
        } catch (SQLException e) {
            logger.error("Error during searching user.", e);
            throw new DaoException("Error during searching user.", e);
        }
    }

    public Optional<User> findById(Long id) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()){
                Optional<User> resultUser = Optional.empty();
                if (resultSet.next()) {
                    UserBuilder userBuilder = new UserBuilder();
                    userBuilder.setUserId(resultSet.getLong(USER_ID));
                    userBuilder.setEmail(resultSet.getString(EMAIL));
                    userBuilder.setLogin(resultSet.getString(LOGIN));
                    userBuilder.setName(resultSet.getString(NAME));
                    userBuilder.setSurname(resultSet.getString(SURNAME));
                    userBuilder.setPhone(resultSet.getString(PHONE));
                    userBuilder.setBalance(resultSet.getBigDecimal(BALANCE));
                    userBuilder.setRegistrationDate(LocalDate.parse(resultSet.getString(REGISTRATION_DATE)));
                    userBuilder.setDiscount(resultSet.getBigDecimal(DISCOUNT));
                    userBuilder.setUserStatus(UserStatus.valueOf(resultSet.getString(USER_STATUS)));
                    userBuilder.setUserRole(UserRole.valueOf(resultSet.getString(USER_ROLE)));
                    resultUser = Optional.of(userBuilder.build());
                }
                return resultUser;
            }
        } catch (SQLException e) {
            logger.error("Error during searching user by id.", e);
            throw new DaoException("Error during searching user by id.", e);
        }
    }

    public Optional<User> findByLogin(String login) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_LOGIN)) {
            statement.setString(1, login);
            try (ResultSet resultSet = statement.executeQuery()){
                Optional<User> resultUser = Optional.empty();
                if (resultSet.next()) {
                    UserBuilder userBuilder = new UserBuilder();
                    userBuilder.setUserId(resultSet.getLong(USER_ID));
                    userBuilder.setEmail(resultSet.getString(EMAIL));
                    userBuilder.setLogin(resultSet.getString(LOGIN));
                    userBuilder.setName(resultSet.getString(NAME));
                    userBuilder.setSurname(resultSet.getString(SURNAME));
                    userBuilder.setPhone(resultSet.getString(PHONE));
                    userBuilder.setBalance(resultSet.getBigDecimal(BALANCE));
                    userBuilder.setRegistrationDate(LocalDate.parse(resultSet.getString(REGISTRATION_DATE)));
                    userBuilder.setDiscount(resultSet.getBigDecimal(DISCOUNT));
                    userBuilder.setUserStatus(UserStatus.valueOf(resultSet.getString(USER_STATUS)));
                    userBuilder.setUserRole(UserRole.valueOf(resultSet.getString(USER_ROLE)));
                    resultUser = Optional.of(userBuilder.build());
                }
                return resultUser;
            }
        } catch (SQLException e) {
            logger.error("Error during searching user by login.", e);
            throw new DaoException("Error during searching user by login.", e);
        }
    }

    public List<User> findByEmail(String email) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_EMAIL)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()){
                return createUsers(resultSet);
            }
        } catch (SQLException e) {
            logger.error("Error during searching user by name.", e);
            throw new DaoException("Error during searching user by name.", e);
        }
    }

    public List<User> findByName(String name) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_NAME)) {
            statement.setString(1, name);
            try (ResultSet resultSet = statement.executeQuery()){
                return createUsers(resultSet);
            }
        } catch (SQLException e) {
            logger.error("Error during searching user by name.", e);
            throw new DaoException("Error during searching user by name.", e);
        }
    }

    public List<User> findBySurname(String surname) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_SURNAME)) {
            statement.setString(1, surname);
            try (ResultSet resultSet = statement.executeQuery()){
                return createUsers(resultSet);
            }
        } catch (SQLException e) {
            logger.error("Error during searching user by surname.", e);
            throw new DaoException("Error during searching user by surname.", e);
        }
    }

    public List<User> findByPhone(int phone) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_PHONE)) {
            statement.setInt(1, phone);
            try (ResultSet resultSet = statement.executeQuery()){
                return createUsers(resultSet);
            }
        } catch (SQLException e) {
            logger.error("Error during searching user by phone.", e);
            throw new DaoException("Error during searching user by phone.", e);
        }
    }

    public List<User> findByStatus(String status) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_STATUS)) {
            statement.setString(1, status);
            statement.setString(2, "USER");
            try (ResultSet resultSet = statement.executeQuery()){
                return createUsers(resultSet);
            }
        } catch (SQLException e) {
            logger.error("Error during searching for all users.", e);
            throw new DaoException("Error during searching for all users.", e);
        }
    }

    public List<User> findAll() throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_USERS)) {
            statement.setString(1, String.valueOf(UserRole.USER));
            try (ResultSet resultSet = statement.executeQuery()){
                return createUsers(resultSet);
            }
        } catch (SQLException e) {
            logger.error("Error during searching for all users.", e);
            throw new DaoException("Error during searching for all users.", e);
        }
    }

    private List<User> createUsers(ResultSet resultSet) throws SQLException {
        List<User> userList = new ArrayList<>();
        while (resultSet.next()) {
            UserBuilder userBuilder = new UserBuilder();
            userBuilder.setUserId(resultSet.getLong(USER_ID));
            userBuilder.setEmail(resultSet.getString(EMAIL));
            userBuilder.setLogin(resultSet.getString(LOGIN));
            userBuilder.setPassword(resultSet.getString(PASSWORD));
            userBuilder.setName(resultSet.getString(NAME));
            userBuilder.setSurname(resultSet.getString(SURNAME));
            userBuilder.setPhone(resultSet.getString(PHONE));
            userBuilder.setBalance(resultSet.getBigDecimal(BALANCE));
            userBuilder.setRegistrationDate(LocalDate.parse(resultSet.getString(REGISTRATION_DATE)));
            userBuilder.setDiscount(resultSet.getBigDecimal(DISCOUNT));
            userBuilder.setUserStatus(UserStatus.valueOf(resultSet.getString(USER_STATUS)));
            userBuilder.setUserRole(UserRole.valueOf(resultSet.getString(USER_ROLE)));
         userList.add(userBuilder.build());
        }
        return userList;
    }

}




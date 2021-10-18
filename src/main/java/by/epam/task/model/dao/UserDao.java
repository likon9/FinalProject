package by.epam.task.model.dao;

import by.epam.task.exception.DaoException;
import by.epam.task.model.builder.UserBuilder;
import by.epam.task.model.entity.User;
import by.epam.task.model.entity.UserRole;
import by.epam.task.model.entity.UserStatus;
import by.epam.task.model.pool.ConnectionPool;

import java.math.BigDecimal;
import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static by.epam.task.model.dao.ColumnName.*;

/**
 * The interface User dao.
 */
public interface UserDao {

    /**
     * Add user boolean.
     *
     * @param parameters the parameters
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean addUser(Map<String, String> parameters) throws DaoException;

    /**
     * Update email boolean.
     *
     * @param parameters the parameters
     * @param userId     the user id
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean updateEmail(Map<String, String> parameters, Long userId) throws DaoException;

    /**
     * Update name boolean.
     *
     * @param parameters the parameters
     * @param userId     the user id
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean updateName(Map<String, String> parameters, Long userId) throws DaoException;

    /**
     * Update surname boolean.
     *
     * @param parameters the parameters
     * @param userId     the user id
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean updateSurname(Map<String, String> parameters, Long userId) throws DaoException;

    /**
     * Update phone boolean.
     *
     * @param parameters the parameters
     * @param userId     the user id
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean updatePhone(Map<String, String> parameters, Long userId) throws DaoException;

    /**
     * Update balance boolean.
     *
     * @param parameters the parameters
     * @param userId     the user id
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean updateBalance(Map<String, String> parameters, Long userId) throws DaoException;

    /**
     * Update discount boolean.
     *
     * @param parameters the parameters
     * @param userId     the user id
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean updateDiscount(Map<String, String> parameters, Long userId) throws DaoException;

    /**
     * Update status boolean.
     *
     * @param parameters the parameters
     * @param userId     the user id
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean updateStatus(Map<String, String> parameters, Long userId) throws DaoException;

    /**
     * Find user boolean.
     *
     * @param login    the login
     * @param password the password
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean findUser(String login, String password) throws DaoException;

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     * @throws DaoException the dao exception
     */
    Optional<User> findById(Long id) throws DaoException;

    /**
     * Find by login optional.
     *
     * @param login the login
     * @return the optional
     * @throws DaoException the dao exception
     */
    Optional<User> findByLogin(String login) throws DaoException;

    /**
     * Find by email list.
     *
     * @param email the email
     * @return the list
     * @throws DaoException the dao exception
     */
    List<User> findByEmail(String email) throws DaoException;

    /**
     * Find by name list.
     *
     * @param name the name
     * @return the list
     * @throws DaoException the dao exception
     */
    List<User> findByName(String name) throws DaoException;

    /**
     * Find by surname list.
     *
     * @param surname the surname
     * @return the list
     * @throws DaoException the dao exception
     */
    List<User> findBySurname(String surname) throws DaoException;

    /**
     * Find by phone list.
     *
     * @param phone the phone
     * @return the list
     * @throws DaoException the dao exception
     */
    List<User> findByPhone(int phone) throws DaoException;

    /**
     * Find by status list.
     *
     * @param status the status
     * @return the list
     * @throws DaoException the dao exception
     */
    List<User> findByStatus(String status) throws DaoException;

    /**
     * Find all list.
     *
     * @return the list
     * @throws DaoException the dao exception
     */
    List<User> findAll() throws DaoException;
}

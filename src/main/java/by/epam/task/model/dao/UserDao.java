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

public interface UserDao {

    boolean addUser(Map<String, String> parameters) throws DaoException;

    boolean updateEmail(Map<String, String> parameters, Long userId) throws DaoException;

    boolean updateName(Map<String, String> parameters, Long userId) throws DaoException;

    boolean updateSurname(Map<String, String> parameters, Long userId) throws DaoException;

    boolean updatePhone(Map<String, String> parameters, Long userId) throws DaoException;

    boolean updateBalance(Map<String, String> parameters, Long userId) throws DaoException;

    boolean updateDiscount(Map<String, String> parameters, Long userId) throws DaoException;

    boolean updateStatus(Map<String, String> parameters, Long userId) throws DaoException;

    boolean findUser(String login, String password) throws DaoException;

    Optional<User> findById(Long id) throws DaoException;

    Optional<User> findByLogin(String login) throws DaoException;

    List<User> findByEmail(String email) throws DaoException;

    List<User> findByName(String name) throws DaoException;

    List<User> findBySurname(String surname) throws DaoException;

    List<User> findByPhone(int phone) throws DaoException;

    List<User> findByStatus(String status) throws DaoException;

    List<User> findAll() throws DaoException;
}

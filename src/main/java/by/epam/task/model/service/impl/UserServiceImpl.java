package by.epam.task.model.service.impl;

import by.epam.task.exception.DaoException;
import by.epam.task.model.dao.ColumnName;
import by.epam.task.model.dao.impl.UserDaoImpl;
import by.epam.task.model.entity.User;
import by.epam.task.model.service.UserService;
import by.epam.task.model.validator.UserValidator;
import by.epam.task.util.HashGenerator;
import com.google.protobuf.ServiceException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.List;
import java.util.Map;
import java.util.Optional;

import static by.epam.task.controller.command.ParameterName.*;

public class UserServiceImpl implements UserService {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public boolean addUser(Map<String, String> parameters) throws ServiceException {
        boolean result = true;
        if(result) {
            UserDaoImpl userDaoImpl = UserDaoImpl.getInstance();
            HashGenerator hashGenerator = HashGenerator.getInstance();
            String login = parameters.get(LOGIN);
            String email = parameters.get(EMAIL);
            String password = parameters.get(PASSWORD);
            String name = parameters.get(NAME);
            String surname = parameters.get(SURNAME);
            String phone = parameters.get(PHONE);
            UserValidator validator = UserValidator.getInstance();

            if (validator.isLoginValid(login)
                    && validator.isEmailValid(email)
                    && validator.isPasswordValid(password)
                    && validator.isNameValid(name)
                    && validator.isSurnameValid(surname)
                    && validator.isPhoneNumberValid(phone)
           ) {
                try {
                    System.out.println("tyt");
                    String hashPassword = hashGenerator.hashPassword(parameters.get(ColumnName.PASSWORD));
                    parameters.computeIfPresent(ColumnName.PASSWORD, (key, value) -> value = hashPassword);
                    result = userDaoImpl.addUser(parameters);
                } catch (DaoException e) {
                    logger.log(Level.ERROR, "exception in method registerUser()", e);
                    throw new ServiceException("Exception when registration user", e);
                }
            }
            else {
                result = false;
            }
        }
        System.out.println(result);
        return result;
    }

    @Override
    public boolean updateEmail(Map<String, String> parameters, Long userId) throws ServiceException {
        boolean result = true;
        if(result) {
            UserDaoImpl userDaoImpl = UserDaoImpl.getInstance();
            String email = parameters.get(EMAIL);
            UserValidator validator = UserValidator.getInstance();
            if ( validator.isEmailValid(email)) {
                try {
                    result = userDaoImpl.updateEmail(parameters, userId);
                } catch (DaoException e) {
                throw new ServiceException(e);
                }
            }
        }
        return result;
    }

    @Override
    public boolean updatePassword(Map<String, String> parameters, Long userId) throws ServiceException {
        return false;
    }

    @Override
    public boolean updateName(Map<String, String> parameters, Long userId) throws ServiceException {
        boolean result = true;
        if(result) {

            UserDaoImpl userDaoImpl = UserDaoImpl.getInstance();
            String name = parameters.get(NAME);
            UserValidator validator = UserValidator.getInstance();
            if ( validator.isEmailValid(name)) {
                try {
                    result = userDaoImpl.updateName(parameters, userId);
                } catch (DaoException e) {
                    throw new ServiceException(e);
                }
            }
        }
        return result;
    }

    @Override
    public boolean updateSurname(Map<String, String> parameters, Long userId) throws ServiceException {
        boolean result = true;
        if(result) {
            UserDaoImpl userDaoImpl = UserDaoImpl.getInstance();
            String surname = parameters.get(SURNAME);
            UserValidator validator = UserValidator.getInstance();
            if ( validator.isEmailValid(surname)) {
                try {
                    result = userDaoImpl.updateSurname(parameters, userId);
                } catch (DaoException e) {
                    throw new ServiceException(e);
                }
            }
        }
        return result;
    }

    @Override
    public boolean updatePhone(Map<String, String> parameters, Long userId) throws ServiceException {
        boolean result = true;
        if(result) {
            UserDaoImpl userDaoImpl = UserDaoImpl.getInstance();
            String phone = parameters.get(PHONE);
            UserValidator validator = UserValidator.getInstance();
            if (validator.isEmailValid(phone)) {
                try {
                    result = userDaoImpl.updatePhone(parameters, userId);
                } catch (DaoException e) {
                    throw new ServiceException(e);
                }
            }
        }
        return result;
    }

    @Override
    public boolean updateBalance(Map<String, String> parameters, Long userId) throws ServiceException {
        boolean result = true;
        if(result) {
            UserDaoImpl userDaoImpl = UserDaoImpl.getInstance();
            String balance = parameters.get(BALANCE);
            UserValidator validator = UserValidator.getInstance();
            if ( validator.isEmailValid(balance)) {
            try {
                result = userDaoImpl.updateBalance(parameters, userId);
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
            }
        }
        return result;
    }

    @Override
    public boolean updateStatus(Map<String, String> parameters, Long userId) throws ServiceException {
        boolean result = true;
        if(result) {
            UserDaoImpl userDaoImpl = UserDaoImpl.getInstance();
            String balance = parameters.get(BALANCE);
            UserValidator validator = UserValidator.getInstance();
            if ( validator.isEmailValid(balance)) {
            try {
                result = userDaoImpl.updateStatus(parameters, userId);
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
            }
        }
        return result;
    }

    @Override
    public boolean findUser(String login, String password) throws ServiceException {
        boolean result = true;
        if(result) {
            UserDaoImpl userDaoImpl = UserDaoImpl.getInstance();
            HashGenerator hashGenerator = HashGenerator.getInstance();
            try {
                String hashPassword = hashGenerator.hashPassword(password);
                result = userDaoImpl.findUser(login, hashPassword);
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        }
        return result;
    }

    @Override
    public Optional<User> findById(Long userId) throws ServiceException {
        UserDaoImpl userDaoImpl = UserDaoImpl.getInstance();
        try {
            Optional<User> user = userDaoImpl.findById(userId);
            return user;
        } catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<User> findByLogin(String login) throws ServiceException {
        UserDaoImpl userDaoImpl = UserDaoImpl.getInstance();
        try {
            Optional<User> user = userDaoImpl.findByLogin(login);
            return user;
        } catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> findByEmail(String email) throws ServiceException {
        UserDaoImpl userDaoImpl = UserDaoImpl.getInstance();
        try {
            List<User> user = userDaoImpl.findByEmail(email);
            return user;
        } catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> findByName(String name) throws ServiceException {
        UserDaoImpl userDaoImpl = UserDaoImpl.getInstance();
        try {
            List<User> user = userDaoImpl.findByName(name);
            return user;
        } catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> findBySurname(String surname) throws ServiceException {
        UserDaoImpl userDaoImpl = UserDaoImpl.getInstance();
        try {
            List<User> user = userDaoImpl.findBySurname(surname);
            return user;
        } catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> findByPhone(int phone) throws ServiceException {
        UserDaoImpl userDaoImpl = UserDaoImpl.getInstance();
        try {
            List<User> user = userDaoImpl.findByPhone(phone);
            return user;
        } catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> findByStatus(String status) throws ServiceException {
        UserDaoImpl userDaoImpl = UserDaoImpl.getInstance();
        try {
            List<User> user = userDaoImpl.findByStatus(status);
            return user;
        } catch (DaoException e){
            throw new ServiceException(e);
        }
    }


    @Override
    public List<User> findAll() throws ServiceException {
        UserDaoImpl userDaoImpl = UserDaoImpl.getInstance();
        try {
            List<User> userList = userDaoImpl.findAll();
            return userList;
        } catch (DaoException e){
            throw new ServiceException(e);
        }
    }
}

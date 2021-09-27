package by.epam.finalTask.model.service.impl;

import by.epam.finalTask.exception.DaoException;
import by.epam.finalTask.model.dao.ColumnName;
import by.epam.finalTask.model.dao.UserDao;
import by.epam.finalTask.model.entity.User;
import by.epam.finalTask.model.service.UserService;
import by.epam.finalTask.util.HashGenerator;
import com.google.protobuf.ServiceException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    @Override
    public boolean addUser(Map<String, String> parameters) throws ServiceException {
        boolean result = true;
        if(result) {
            UserDao userDao = UserDao.getInstance();
            try {
                String password = HashGenerator.generatePassword(parameters.get(ColumnName.PASSWORD));
                parameters.computeIfPresent(ColumnName.PASSWORD, (key, value) -> value = password);
                result = userDao.addUser(parameters);
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        }
        return result;
    }

    @Override
    public boolean updateEmail(Map<String, String> parameters, Long userId) throws ServiceException {
        boolean result = true;
        if(result) {
            UserDao userDao = UserDao.getInstance();
            try {
                result = userDao.updateEmail(parameters, userId);
            } catch (DaoException e) {
                throw new ServiceException(e);
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
            UserDao userDao = UserDao.getInstance();
            try {
                result = userDao.updateName(parameters, userId);
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        }
        return result;
    }

    @Override
    public boolean updateSurname(Map<String, String> parameters, Long userId) throws ServiceException {
        boolean result = true;
        if(result) {
            UserDao userDao = UserDao.getInstance();
            try {
                result = userDao.updateSurname(parameters, userId);
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        }
        return result;
    }

    @Override
    public boolean updatePhone(Map<String, String> parameters, Long userId) throws ServiceException {
        boolean result = true;
        if(result) {
            UserDao userDao = UserDao.getInstance();
            try {
                result = userDao.updatePhone(parameters, userId);
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        }
        return result;
    }

    @Override
    public boolean updateBalance(Map<String, String> parameters, Long userId) throws ServiceException {
        boolean result = true;
        if(result) {
            UserDao userDao = UserDao.getInstance();
            try {
                result = userDao.updateBalance(parameters, userId);
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        }
        return result;
    }

    @Override
    public boolean updateStatus(Map<String, String> parameters, Long userId) throws ServiceException {
        boolean result = true;
        if(result) {
            UserDao userDao = UserDao.getInstance();
            try {
                result = userDao.updateStatus(parameters, userId);
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        }
        return result;
    }

    @Override
    public boolean findUser(String login, String password) throws ServiceException {
        boolean result = true;
        if(result) {
            UserDao userDao = UserDao.getInstance();
            try {
                String hashPassword = HashGenerator.generatePassword(password);
                result = userDao.findUser(login, hashPassword);
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        }
        return result;
    }

    @Override
    public Optional<User> findById(Long userId) throws ServiceException {
        UserDao userDao = UserDao.getInstance();
        try {
            Optional<User> user = userDao.findById(userId);
            return user;
        } catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<User> findByLogin(String login) throws ServiceException {
        UserDao userDao = UserDao.getInstance();
        try {
            Optional<User> user = userDao.findByLogin(login);
            return user;
        } catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> findBEmail(String email) throws ServiceException {
        UserDao userDao = UserDao.getInstance();
        try {
            List<User> user = userDao.findByEmail(email);
            return user;
        } catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> findByName(String name) throws ServiceException {
        UserDao userDao = UserDao.getInstance();
        try {
            List<User> user = userDao.findByName(name);
            return user;
        } catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> findBySurname(String surname) throws ServiceException {
        UserDao userDao = UserDao.getInstance();
        try {
            List<User> user = userDao.findBySurname(surname);
            return user;
        } catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> findByPhone(int phone) throws ServiceException {
        UserDao userDao = UserDao.getInstance();
        try {
            List<User> user = userDao.findByPhone(phone);
            return user;
        } catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> findByStatus(String status) throws ServiceException {
        UserDao userDao = UserDao.getInstance();
        try {
            List<User> user = userDao.findByStatus(status);
            return user;
        } catch (DaoException e){
            throw new ServiceException(e);
        }
    }


    @Override
    public List<User> findAll() throws ServiceException {
        UserDao userDao = UserDao.getInstance();
        try {
            List<User> userList = userDao.findAll();
            return userList;
        } catch (DaoException e){
            throw new ServiceException(e);
        }
    }
}

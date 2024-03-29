package by.epam.task.model.service;


import by.epam.task.exception.ServiceException;
import by.epam.task.model.entity.User;


import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService {
    boolean addUser(Map<String, String> parameters) throws ServiceException;

    boolean updateEmail(Map<String, String> parameters, Long userId) throws ServiceException;

    boolean updateName(Map<String, String> parameters, Long userId) throws ServiceException;

    boolean updateSurname(Map<String, String> parameters, Long userId) throws ServiceException;

    boolean updatePhone(Map<String, String> parameters, Long userId) throws ServiceException;

    boolean updateBalance(Map<String, String> parameters, Long userId) throws ServiceException;

    boolean updateDiscount(Map<String, String> parameters, Long userId) throws ServiceException;

    boolean updateStatus(Map<String, String> parameters, Long userId) throws ServiceException;

    boolean findUser(String login, String password) throws ServiceException;

    Optional<User> findById(Long soughtId) throws ServiceException;

    Optional<User> findByLogin(String login) throws ServiceException;

    List<User> findByEmail(String email) throws ServiceException;

    List<User> findByName(String name) throws ServiceException;

    List<User> findByPhone(int phone) throws ServiceException;

    List<User> findBySurname(String surname) throws ServiceException;

    List<User> findByStatus(String status) throws ServiceException;

    List<User> findAll() throws ServiceException;

}

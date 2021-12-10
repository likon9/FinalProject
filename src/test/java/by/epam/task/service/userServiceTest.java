package by.epam.task.service;

import by.epam.task.controller.command.ParameterName;
import by.epam.task.exception.ServiceException;
import by.epam.task.model.service.impl.UserServiceImpl;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class userServiceTest {

    private long idTestngUser = 1l;
    private String nameTestngUser = "testnguser";
    private String surnameTestngUser = "testnguser";
    private String emailTestngUser = "testnguser@gmail.com";
    private String phoneTestngUser = "251234567";
    private String incorrectPhoneTestngUser = "1251234567";

    @Test(groups = "service" , priority = 1)
    public void updateUserNameTest(){
        UserServiceImpl userService = new UserServiceImpl();
        Map<String, String> parameterUser = new HashMap<>();
        parameterUser.put(ParameterName.NAME , nameTestngUser);
        boolean result = false;
        try {
            result = userService.updateName(parameterUser,idTestngUser);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        assertTrue(result);
    }

    @Test(groups = "service" , priority = 2)
    public void newNameIsNullTest(){
        UserServiceImpl userService = new UserServiceImpl();
        Map<String, String> parameterUser = new HashMap<>();
        parameterUser.put(ParameterName.NAME , null);
        boolean result = false;
        try {
            result = userService.updateName(parameterUser,idTestngUser);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        assertFalse(result);
    }

    @Test(groups = "service" , priority = 3)
    public void updateUserSurnameTest(){
        UserServiceImpl userService = new UserServiceImpl();
        Map<String, String> parameterUser = new HashMap<>();
        parameterUser.put(ParameterName.SURNAME , surnameTestngUser);
        boolean result = false;
        try {
            result = userService.updateSurname(parameterUser,idTestngUser);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        assertTrue(result);
    }

    @Test(groups = "service" , priority = 4)
    public void newSurnameIsNullTest(){
        UserServiceImpl userService = new UserServiceImpl();
        Map<String, String> parameterUser = new HashMap<>();
        parameterUser.put(ParameterName.SURNAME , null);
        boolean result = false;
        try {
            result = userService.updateSurname(parameterUser,idTestngUser);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        assertFalse(result);
    }

    @Test(groups = "service" , priority = 5)
    public void updateUserEmailTest(){
        UserServiceImpl userService = new UserServiceImpl();
        Map<String, String> parameterUser = new HashMap<>();
        parameterUser.put(ParameterName.EMAIL , emailTestngUser);
        boolean result = false;
        try {
            result = userService.updateEmail(parameterUser,idTestngUser);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        assertTrue(result);
    }

    @Test(groups = "service" , priority = 6)
    public void newEmailIsNullTest(){
        UserServiceImpl userService = new UserServiceImpl();
        Map<String, String> parameterUser = new HashMap<>();
        parameterUser.put(ParameterName.EMAIL , null);
        boolean result = false;
        try {
            result = userService.updateEmail(parameterUser,idTestngUser);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        assertFalse(result);
    }

    @Test(groups = "service" , priority = 7)
    public void updateUserPhoneTest(){
        UserServiceImpl userService = new UserServiceImpl();
        Map<String, String> parameterUser = new HashMap<>();
        parameterUser.put(ParameterName.PHONE , phoneTestngUser);
        boolean result = false;
        try {
            result = userService.updatePhone(parameterUser,idTestngUser);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        assertTrue(result);
    }

    @Test(groups = "service" , priority = 8)
    public void newPhoneIsNullTest(){
        UserServiceImpl userService = new UserServiceImpl();
        Map<String, String> parameterUser = new HashMap<>();
        parameterUser.put(ParameterName.PHONE , null);
        boolean result = false;
        try {
            result = userService.updatePhone(parameterUser,idTestngUser);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        assertFalse(result);
    }

    @Test(groups = "service" , priority = 9)
    public void incorrectNewPhoneTest(){
        UserServiceImpl userService = new UserServiceImpl();
        Map<String, String> parameterUser = new HashMap<>();
        parameterUser.put(ParameterName.PHONE , incorrectPhoneTestngUser);
        boolean result = false;
        try {
            result = userService.updatePhone(parameterUser,idTestngUser);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        assertFalse(result);
    }

}

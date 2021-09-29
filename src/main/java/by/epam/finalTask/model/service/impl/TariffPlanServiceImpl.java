package by.epam.finalTask.model.service.impl;

import by.epam.finalTask.exception.DaoException;
import by.epam.finalTask.model.dao.ColumnName;
import by.epam.finalTask.model.dao.TariffPlanDao;
import by.epam.finalTask.model.dao.UserDao;
import by.epam.finalTask.model.entity.TariffPlan;
import by.epam.finalTask.model.entity.User;
import by.epam.finalTask.model.service.TariffPlanService;
import by.epam.finalTask.util.HashGenerator;
import com.google.protobuf.ServiceException;
import com.google.protobuf.Syntax;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TariffPlanServiceImpl implements TariffPlanService {

    @Override
    public boolean updateNameTariffPlan(Map<String, String> parameters, Long tariffPlanId) throws ServiceException {
        boolean result = true;

        if(result) {
            TariffPlanDao tariffPlanDao = TariffPlanDao.getInstance();
            try {
                result = tariffPlanDao.updateNameTariffPlan(parameters, tariffPlanId);
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        }
        return result;
    }

    @Override
    public boolean updatePrice(Map<String, String> parameters, Long tariffPlanId) throws ServiceException {
        boolean result = true;
        if(result) {
            TariffPlanDao tariffPlanDao = TariffPlanDao.getInstance();
            try {
                result = tariffPlanDao.updatePrice(parameters, tariffPlanId);
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        }
        return result;
    }

    @Override
    public boolean updateInternetConnectionSpeed(Map<String, String> parameters, Long tariffPlanId) throws ServiceException {
        boolean result = true;
        if(result) {
            TariffPlanDao tariffPlanDao = TariffPlanDao.getInstance();
            try {
                result = tariffPlanDao.updateInternetConnectionSpeed(parameters, tariffPlanId);
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        }
        return result;
    }

    @Override
    public boolean addTariffPlan(Map<String, String> parameters) throws ServiceException {
        boolean result = true;
        if(result) {
            TariffPlanDao tariffPlanDao = TariffPlanDao.getInstance();
            try {
                result = tariffPlanDao.addTariffPlan(parameters);
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        }
        return result;
    }

    @Override
    public Optional<TariffPlan> findByIdTariffPlan(Long tariffPlanId) throws ServiceException {
        TariffPlanDao tariffPlanDao = TariffPlanDao.getInstance();
        try {
            Optional<TariffPlan> tariffPlanList = tariffPlanDao.findByIdTariffPlan(tariffPlanId);
            return tariffPlanList;
        } catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<TariffPlan> findByNameTariffPlan(String nameTariffPlan) throws ServiceException {
        TariffPlanDao tariffPlanDao = TariffPlanDao.getInstance();
        try {
            Optional<TariffPlan> tariffPlanList = tariffPlanDao.findByNameTariffPlan(nameTariffPlan);
            return tariffPlanList;
        } catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public List<TariffPlan> findByPrice(BigDecimal price) throws ServiceException {
        TariffPlanDao tariffPlanDao = TariffPlanDao.getInstance();
        try {
            List<TariffPlan> tariffPlanList = tariffPlanDao.findByPrice(price);
            return tariffPlanList;
        } catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public List<TariffPlan> findByInternetConnectionSpeed(int speed) throws ServiceException {
        TariffPlanDao tariffPlanDao = TariffPlanDao.getInstance();
        try {
            List<TariffPlan> tariffPlanList = tariffPlanDao.findByInternetConnectionSpeed(speed);
            return tariffPlanList;
        } catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public List<TariffPlan> findAllTariffPlan() throws ServiceException {
        TariffPlanDao tariffPlanDao = TariffPlanDao.getInstance();
        try {
            List<TariffPlan> tariffPlanList = tariffPlanDao.findAllTariffPlan();
            return tariffPlanList;
        } catch (DaoException e){
            throw new ServiceException(e);
        }
    }
}

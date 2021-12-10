package by.epam.task.model.service.impl;

import by.epam.task.controller.command.ParameterName;
import by.epam.task.exception.DaoException;
import by.epam.task.model.dao.impl.TariffPlanDaoImpl;
import by.epam.task.model.entity.TariffPlan;
import by.epam.task.model.service.TariffPlanService;
import by.epam.task.model.validator.TariffPlanValidator;
import by.epam.task.exception.ServiceException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TariffPlanServiceImpl implements TariffPlanService {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public boolean addTariffPlan(Map<String, String> parameters) throws ServiceException {
        boolean result ;
        String name = parameters.get(ParameterName.NAME_TARIFF_PLAN);
        TariffPlanValidator validator = TariffPlanValidator.getInstance();
        if(true == true) {
            TariffPlanDaoImpl tariffPlanDaoImpl = TariffPlanDaoImpl.getInstance();
            try {
                result = tariffPlanDaoImpl.addTariffPlan(parameters);
            } catch (DaoException e) {
                logger.error("Exception in method addTariffPlan()", e);
                throw new ServiceException("Exception when add tariff", e);
            }
           } else {
            result =  false;
        }
        System.out.println(result);
        return result;
      }

    @Override
    public boolean updateNameTariffPlan(Map<String, String> parameters, Long tariffPlanId) throws ServiceException {
        boolean result;

            TariffPlanDaoImpl tariffPlanDaoImpl = TariffPlanDaoImpl.getInstance();
            try {
                result = tariffPlanDaoImpl.updateNameTariffPlan(parameters, tariffPlanId);
            } catch (DaoException e) {
                logger.error("Exception in method updateNameTariffPlan()", e);
                throw new ServiceException("Exception when update tariff", e);
            }
        return result;
    }

    @Override
    public boolean updatePrice(Map<String, String> parameters, Long tariffPlanId) throws ServiceException {
        boolean result;

            TariffPlanDaoImpl tariffPlanDaoImpl = TariffPlanDaoImpl.getInstance();
            try {
                result = tariffPlanDaoImpl.updatePrice(parameters, tariffPlanId);
            } catch (DaoException e) {
                logger.error("Exception in method updatePriceTariffPlan()", e);
                throw new ServiceException("Exception when update tariff", e);
            }
        return result;
    }

    @Override
    public boolean updateInternetConnectionSpeed(Map<String, String> parameters, Long tariffPlanId) throws ServiceException {
        boolean result;

            TariffPlanDaoImpl tariffPlanDaoImpl = TariffPlanDaoImpl.getInstance();
            try {
                result = tariffPlanDaoImpl.updateInternetConnectionSpeed(parameters, tariffPlanId);
            } catch (DaoException e) {
                logger.error("Exception in method updatePriceTariffPlan()", e);
                throw new ServiceException("Exception when update tariff", e);
            }
        return result;
    }

    @Override
    public Optional<TariffPlan> findByIdTariffPlan(Long tariffPlanId) throws ServiceException {
        TariffPlanDaoImpl tariffPlanDaoImpl = TariffPlanDaoImpl.getInstance();
        try {
            Optional<TariffPlan> tariffPlanList = tariffPlanDaoImpl.findByIdTariffPlan(tariffPlanId);
            return tariffPlanList;
        } catch (DaoException e){
            logger.error("Exception in method findByIdTariffPlan()", e);
            throw new ServiceException("Exception when find tariff", e);
        }
    }

    @Override
    public Optional<TariffPlan> findByNameTariffPlan(String nameTariffPlan) throws ServiceException {
        TariffPlanDaoImpl tariffPlanDaoImpl = TariffPlanDaoImpl.getInstance();
        try {
            Optional<TariffPlan> tariffPlanList = tariffPlanDaoImpl.findByNameTariffPlan(nameTariffPlan);
            return tariffPlanList;
        } catch (DaoException e){
            logger.error("Exception in method findByNameTariffPlan()", e);
            throw new ServiceException("Exception when find tariff", e);
        }
    }

    @Override
    public List<TariffPlan> findByPrice(BigDecimal price) throws ServiceException {
        TariffPlanDaoImpl tariffPlanDaoImpl = TariffPlanDaoImpl.getInstance();
        try {
            List<TariffPlan> tariffPlanList = tariffPlanDaoImpl.findByPrice(price);
            return tariffPlanList;
        } catch (DaoException e){
            logger.error("Exception in method findByPriceTariffPlan()", e);
            throw new ServiceException("Exception when find tariff", e);
        }
    }

    @Override
    public List<TariffPlan> findByInternetConnectionSpeed(int speed) throws ServiceException {
        TariffPlanDaoImpl tariffPlanDaoImpl = TariffPlanDaoImpl.getInstance();
        try {
            List<TariffPlan> tariffPlanList = tariffPlanDaoImpl.findByInternetConnectionSpeed(speed);
            return tariffPlanList;
        } catch (DaoException e){
            logger.error("Exception in method findByInternetConnectionSpeed()", e);
            throw new ServiceException("Exception when find tariff", e);
        }
    }

    @Override
    public List<TariffPlan> findAllTariffPlan() throws ServiceException {
        TariffPlanDaoImpl tariffPlanDaoImpl = TariffPlanDaoImpl.getInstance();
        try {
            List<TariffPlan> tariffPlanList = tariffPlanDaoImpl.findAllTariffPlan();
            return tariffPlanList;
        } catch (DaoException e){
            logger.error("Exception in method findAllTariffPlans()", e);
            throw new ServiceException("Exception when find tariff", e);
        }
    }
}

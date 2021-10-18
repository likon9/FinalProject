package by.epam.task.model.service.impl;

import by.epam.task.exception.DaoException;
import by.epam.task.exception.ServiceException;
import by.epam.task.model.dao.impl.ContractDaoImpl;
import by.epam.task.model.entity.Contract;
import by.epam.task.model.service.ContractService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ContractServiceImpl implements ContractService {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public boolean addContract(Map<String, String> parameters) throws ServiceException {
        boolean result = true;

            ContractDaoImpl contractDaoImpl = ContractDaoImpl.getInstance();
            try {
                result = contractDaoImpl.addContract(parameters);
            } catch (DaoException e) {
                logger.error("Exception in method addContract()", e);
                throw new ServiceException("Exception when add contract", e);
            }
        return result;
    }

    @Override
    public boolean updateStatusContract(Map<String, String> parameters, Long contractId) throws ServiceException {
        boolean result = true;

            ContractDaoImpl contractDaoImpl = ContractDaoImpl.getInstance();

            try {
                result = contractDaoImpl.updateStatusContract(parameters, contractId);
            } catch (DaoException e) {
                logger.error("Exception in method updateStatusContract()", e);
                throw new ServiceException("Exception when  update contract", e);
            }
        return result;
    }

    @Override
    public Optional<Contract> findByContractId(Long contractId) throws ServiceException {
        ContractDaoImpl contractDaoImpl = ContractDaoImpl.getInstance();
        try {
            Optional<Contract> contract = contractDaoImpl.findByContractId(contractId);
            return contract;
        } catch (DaoException e){
            logger.error("Exception in method findByContractId()", e);
            throw new ServiceException("Exception when find contract", e);
        }
    }

    @Override
    public List<Contract> findEffectiveContractByUserId(Long userId) throws ServiceException {
        ContractDaoImpl contractDaoImpl = ContractDaoImpl.getInstance();
        try {
            List<Contract> contract = contractDaoImpl.findEffectiveContractByUserId(userId);
            return contract;
        } catch (DaoException e){
            logger.error("Exception in method findEffectiveContractByUserId()", e);
            throw new ServiceException("Exception when find contract", e);
        }
    }

    @Override
    public List<Contract> findAllContractByUserId(Long userId) throws ServiceException {
        ContractDaoImpl contractDaoImpl = ContractDaoImpl.getInstance();
        try {
            List<Contract> contract = contractDaoImpl.findAllContractByUserId(userId);
            return contract;
        } catch (DaoException e){
            logger.error("Exception in method findAllContractByUserId()", e);
            throw new ServiceException("Exception when find contract", e);
        }
    }

    @Override
    public List<Contract> findByStatus(String status) throws ServiceException {
        ContractDaoImpl contractDaoImpl = ContractDaoImpl.getInstance();
        try {
            List<Contract> contract = contractDaoImpl.findByStatus(status);
            return contract;
        } catch (DaoException e){
            logger.error("Exception in method findByStatus()", e);
            throw new ServiceException("Exception when find contract", e);
        }
    }

    @Override
    public List<Contract> findByTariffPlanId(Long tariffPlanId) throws ServiceException {
        ContractDaoImpl contractDaoImpl = ContractDaoImpl.getInstance();
        try {
            List<Contract> contract = contractDaoImpl.findByTariffPlanId(tariffPlanId);
            return contract;
        } catch (DaoException e){
            logger.error("Exception in method findByTariffPlanId()", e);
            throw new ServiceException("Exception when find contract", e);
        }
    }

    @Override
    public List<Contract> findByTariffPlanName(String tariffPlanName) throws ServiceException {
        ContractDaoImpl contractDaoImpl = ContractDaoImpl.getInstance();
        try {
            List<Contract> contract = contractDaoImpl.findByTariffPlanName(tariffPlanName);
            return contract;
        } catch (DaoException e){
            logger.error("Exception in method findByTariffPlanName()", e);
            throw new ServiceException("Exception when find contract", e);
        }
    }

    @Override
    public List<Contract> findAll() throws ServiceException {
        ContractDaoImpl contractDaoImpl = ContractDaoImpl.getInstance();
        try {
            List<Contract> contract = contractDaoImpl.findAll();
            return contract;
        } catch (DaoException e){
            logger.error("Exception in method findAll()", e);
            throw new ServiceException("Exception when find contract", e);
        }
    }
}

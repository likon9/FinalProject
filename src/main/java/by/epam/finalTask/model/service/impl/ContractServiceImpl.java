package by.epam.finalTask.model.service.impl;

import by.epam.finalTask.exception.DaoException;
import by.epam.finalTask.exception.ServiceException;
import by.epam.finalTask.model.dao.ContractDao;
import by.epam.finalTask.model.dao.TariffPlanDao;
import by.epam.finalTask.model.dao.UserDao;
import by.epam.finalTask.model.entity.Contract;
import by.epam.finalTask.model.entity.User;
import by.epam.finalTask.model.service.ContractService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ContractServiceImpl implements ContractService {

    @Override
    public boolean addContract(Map<String, String> parameters) throws ServiceException {
        boolean result = true;
        if(result) {
            ContractDao contractDao = ContractDao.getInstance();
            try {
                result = contractDao.addContract(parameters);
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        }
        return result;
    }

    @Override
    public boolean updateStatusContract(Map<String, String> parameters, Long contractId) throws ServiceException {
        boolean result = true;
        if(result) {
            ContractDao contractDao = ContractDao.getInstance();

            try {
                result = contractDao.updateStatusContract(parameters, contractId);
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        }
        return result;
    }

    @Override
    public Optional<Contract> findByContractId(Long contractId) throws ServiceException {
        ContractDao contractDao = ContractDao.getInstance();
        try {
            Optional<Contract> contract = contractDao.findByContractId(contractId);
            return contract;
        } catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Contract> findEffectiveContractByUserId(Long userId) throws ServiceException {
        ContractDao contractDao = ContractDao.getInstance();
        try {
            List<Contract> contract = contractDao.findEffectiveContractByUserId(userId);
            return contract;
        } catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Contract> findAllContractByUserId(Long userId) throws ServiceException {
        ContractDao contractDao = ContractDao.getInstance();
        try {
            List<Contract> contract = contractDao.findAllContractByUserId(userId);
            return contract;
        } catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Contract> findByStatus(String status) throws ServiceException {
        ContractDao contractDao = ContractDao.getInstance();
        System.out.println(12);
        try {
            List<Contract> contract = contractDao.findByStatus(status);
            return contract;
        } catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Contract> findByTariffPlanId(Long tariffPlanId) throws ServiceException {
        ContractDao contractDao = ContractDao.getInstance();
        try {
            List<Contract> contract = contractDao.findByTariffPlanId(tariffPlanId);
            return contract;
        } catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Contract> findByTariffPlanName(String tariffPlanName) throws ServiceException {
        ContractDao contractDao = ContractDao.getInstance();
        try {
            List<Contract> contract = contractDao.findByTariffPlanName(tariffPlanName);
            return contract;
        } catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Contract> findAll() throws ServiceException {
        ContractDao contractDao = ContractDao.getInstance();
        try {
            List<Contract> contract = contractDao.findAll();
            return contract;
        } catch (DaoException e){
            throw new ServiceException(e);
        }
    }
}
